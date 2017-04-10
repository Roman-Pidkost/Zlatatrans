package ua.com.zlatatrans.service;

import ua.com.zlatatrans.entity.Make;

import java.util.List;

public interface MakeService {
    void save(Make make);
    List<Make> findAll();
    Make findOne(int id);
    Make findOne(String name);
    void delete(int id);
    Make findByIdFetchModel(int id);
    Make findByNameFetchModel(String name);
}
