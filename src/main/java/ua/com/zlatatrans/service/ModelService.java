package ua.com.zlatatrans.service;

import ua.com.zlatatrans.dto.filter.ModelFilter;
import ua.com.zlatatrans.entity.Model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ModelService {
    void save(Model model);
    List<Model> findAll();
    Model findOne(int id);
    Model findOne(String name);
    void delete(int id);
    Page<Model> findAll(Pageable pageable, ModelFilter filter);
}
