package ua.com.zlatatrans.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.zlatatrans.dao.FuelTypeDao;
import ua.com.zlatatrans.entity.FuelType;
import ua.com.zlatatrans.service.FuelTypeService;

import java.util.List;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {

    @Autowired
    private FuelTypeDao fuelTypeDao;

    public void save(FuelType fuelType) {
        fuelTypeDao.save(fuelType);
    }

    public List<FuelType> findAll() {
        return fuelTypeDao.findAll();
    }

    public FuelType findOne(int id) {
        return fuelTypeDao.findOne(id);
    }

    public FuelType findOne(String name) {
        return fuelTypeDao.findByName(name);
    }

    public void delete(int id) {
        fuelTypeDao.delete(id);
    }

}
