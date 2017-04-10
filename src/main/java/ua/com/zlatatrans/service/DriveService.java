package ua.com.zlatatrans.service;

import ua.com.zlatatrans.entity.Drive;

import java.util.List;

 public interface DriveService {
    void save(Drive drive);
    List<Drive> findAll();
    Drive findOne(int id);
    Drive findOne(String name);
    void delete(int id);
}
