package rp.zut.lab07.dao;

import rp.zut.lab07.components.Car;

import java.util.List;

public interface CarDao {
    List<Car> findAll();
    Car findCarByName(String carName);
    void inspect(Car car);
    void update(Car car);
    void delete(Car car);
}
