package rp.zut.lab05.dao;

import rp.zut.lab05.components.Car;

import java.util.List;

public interface CarDao {
    List<Car> findAll();
    Car findCarByName(String carName);
    void inspect(Car car);
    void update(Car car);
    void delete(Car car);
}
