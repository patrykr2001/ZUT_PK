package rp.zut.lab05.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import rp.zut.lab05.components.Car;
import rp.zut.lab05.components.Engine;
import rp.zut.lab05.components.Oil;
import rp.zut.lab05.components.Transmission;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Component
public class CarDaoImpl implements CarDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Car> findAll() {
        String sql = "SELECT * FROM Car";
        return jdbcTemplate.query(sql, new CarRowMapper());
    }

    @Override
    public Car findCarByName(String carName) {
        String sql = "SELECT * FROM Car WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{carName}, new CarRowMapper());
    }

    @Override
    public void inspect(Car car) {
        // Implement inspection logic if needed
        log.info("Inspecting car: " + car.getName());
        if (car.getEngine().getFuelConsumption() > 10) {
            log.warn("High fuel consumption detected for car: " + car.getName());
        }
        if (car.getTransmission().getTransmissionBeltLength() < 1) {
            log.warn("Transmission belt length is too short for car: " + car.getName());
        }
        if (car.getEngine().getOil() == null) {
            log.warn("No oil detected in engine for car: " + car.getName());
        }
    }

    @Override
    public void update(Car car) {
        // Update related tables
        updateOil(car.getEngine().getOil());
        updateEngine(car.getEngine());
        updateTransmission(car.getTransmission());

        String sql = "INSERT INTO Car (id, engine_id, transmission_id, name, roadFuelConsumption, routeLength) VALUES (?, ?, ?, ?, ?, ?) " +
                "ON CONFLICT (id) DO UPDATE SET engine_id = EXCLUDED.engine_id, transmission_id = EXCLUDED.transmission_id, name = EXCLUDED.name, roadFuelConsumption = EXCLUDED.roadFuelConsumption, routeLength = EXCLUDED.routeLength";
        jdbcTemplate.update(sql, car.getId(), car.getEngine().getId(), car.getTransmission().getId(), car.getName(), car.getRoadFuelConsumption(), car.getRouteLength());
    }

    @Override
    public void delete(Car car) {
        String sql = "DELETE FROM Car WHERE id = ?";
        jdbcTemplate.update(sql, car.getId());

        // Delete from related tables
        deleteEngine(car.getEngine());
        deleteTransmission(car.getTransmission());
        deleteOil(car.getEngine().getOil());
    }

    private void updateEngine(Engine engine) {
        String sql = "INSERT INTO Engine (id, fuelConsumption, oil_id) VALUES (?, ?, ?) " +
                "ON CONFLICT (id) DO UPDATE SET fuelConsumption = EXCLUDED.fuelConsumption, oil_id = EXCLUDED.oil_id";
        jdbcTemplate.update(sql, engine.getId(), engine.getFuelConsumption(), engine.getOil().getId());
    }

    private void updateTransmission(Transmission transmission) {
        String sql = "INSERT INTO Transmission (id, transmissionBeltLength) VALUES (?, ?) " +
                "ON CONFLICT (id) DO UPDATE SET transmissionBeltLength = EXCLUDED.transmissionBeltLength";
        jdbcTemplate.update(sql, transmission.getId(), transmission.getTransmissionBeltLength());
    }

    private void deleteEngine(Engine engine) {
        String sql = "DELETE FROM Engine WHERE id = ?";
        jdbcTemplate.update(sql, engine.getId());
    }

    private void deleteTransmission(Transmission transmission) {
        String sql = "DELETE FROM Transmission WHERE id = ?";
        jdbcTemplate.update(sql, transmission.getId());
    }

    private void updateOil(Oil oil) {
        String sql = "INSERT INTO Oil (id, name) VALUES (?, ?) " +
                "ON CONFLICT (id) DO UPDATE SET name = EXCLUDED.name";
        jdbcTemplate.update(sql, oil.getId(), oil.getName());
    }

    private void deleteOil(Oil oil) {
        String sql = "DELETE FROM Oil WHERE id = ?";
        jdbcTemplate.update(sql, oil.getId());
    }

    private final class CarRowMapper implements RowMapper<Car> {
        @Override
        public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
            // Fetch and set Engine
            int engineId = rs.getInt("engine_id");
            Engine engine = jdbcTemplate.queryForObject("SELECT * FROM Engine WHERE id = ?", new Object[]{engineId}, new EngineRowMapper());

            // Fetch and set Transmission
            int transmissionId = rs.getInt("transmission_id");
            Transmission transmission = jdbcTemplate.queryForObject("SELECT * FROM Transmission WHERE id = ?", new Object[]{transmissionId}, new TransmissionRowMapper());

            Car car = new Car(engine, transmission, rs.getString("name"));
            car.setId(rs.getInt("id"));
            car.setRoadFuelConsumption(rs.getDouble("roadFuelConsumption"));
            car.setRouteLength(rs.getInt("routeLength"));
            return car;
        }
    }

    private final class EngineRowMapper implements RowMapper<Engine> {
        @Override
        public Engine mapRow(ResultSet rs, int rowNum) throws SQLException {
            Engine engine = new Engine();
            engine.setId(rs.getInt("id"));
            engine.setFuelConsumption(rs.getDouble("fuelConsumption"));

            // Fetch and set Oil
            int oilId = rs.getInt("oil_id");
            Oil oil = jdbcTemplate.queryForObject("SELECT * FROM Oil WHERE id = ?", new Object[]{oilId}, new OilRowMapper());
            engine.setOil(oil);

            return engine;
        }
    }

    private final class TransmissionRowMapper implements RowMapper<Transmission> {
        @Override
        public Transmission mapRow(ResultSet rs, int rowNum) throws SQLException {
            Transmission transmission = new Transmission();
            transmission.setId(rs.getInt("id"));
            transmission.setTransmissionBeltLength(rs.getDouble("transmissionBeltLength"));
            // Set other properties if needed
            return transmission;
        }
    }

    private final class OilRowMapper implements RowMapper<Oil> {
        @Override
        public Oil mapRow(ResultSet rs, int rowNum) throws SQLException {
            Oil oil = new Oil();
            oil.setId(rs.getInt("id"));
            // Set other properties if needed
            return oil;
        }
    }
}
