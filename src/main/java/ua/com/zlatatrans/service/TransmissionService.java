package ua.com.zlatatrans.service;

import ua.com.zlatatrans.entity.Transmission;

import java.util.List;

public interface TransmissionService {
    void save(Transmission transmission);
    List<Transmission> findAll();
    Transmission findOne(int id);
    Transmission findOne(String name);
    void delete(int id);
}
