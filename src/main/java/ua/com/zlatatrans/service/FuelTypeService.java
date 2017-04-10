package ua.com.zlatatrans.service;


import ua.com.zlatatrans.entity.FuelType;

import java.util.List;

public interface FuelTypeService {
    void save(FuelType fuelType);
    List<FuelType> findAll();
    FuelType findOne(int id);
    FuelType findOne(String name);
    void delete(int id);
}
