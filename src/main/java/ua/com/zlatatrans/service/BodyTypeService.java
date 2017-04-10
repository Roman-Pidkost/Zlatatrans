package ua.com.zlatatrans.service;


import ua.com.zlatatrans.entity.BodyType;

import java.util.List;

public interface BodyTypeService {
    void save(BodyType bodyType);
    List<BodyType> findAll();
    BodyType findOne(int id);
    BodyType findOne(String name);
    void delete(int id);
}
