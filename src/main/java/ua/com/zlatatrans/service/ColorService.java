package ua.com.zlatatrans.service;

import ua.com.zlatatrans.entity.Color;

import java.util.List;

public interface ColorService {
    void save(Color color);
    List<Color> findAll();
    Color findOne(int id);
    void delete(int id);
    Color findOne(String name);
}
