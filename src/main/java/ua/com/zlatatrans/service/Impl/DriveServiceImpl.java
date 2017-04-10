package ua.com.zlatatrans.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.zlatatrans.dao.DriveDao;
import ua.com.zlatatrans.entity.Drive;
import ua.com.zlatatrans.service.DriveService;

import java.util.List;

@Service
public class DriveServiceImpl implements DriveService {

    @Autowired
    private DriveDao driveDao;

    public void save(Drive drive) {
        driveDao.save(drive);
    }

    public List<Drive> findAll() {
        return driveDao.findAll();
    }

    public Drive findOne(int id) {
        return driveDao.findOne(id);
    }

    public Drive findOne(String name) {
        return driveDao.findByName(name);
    }

    public void delete(int id) {
        driveDao.delete(id);
    }

}