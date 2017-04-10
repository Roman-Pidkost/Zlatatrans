package ua.com.zlatatrans.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ua.com.zlatatrans.entity.Model;


public interface ModelDao extends JpaRepository<Model, Integer>, JpaSpecificationExecutor<Model> {
    Model findByName(String name);
}
