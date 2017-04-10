package ua.com.zlatatrans.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.zlatatrans.entity.BodyType;

public interface BodyTypeDao extends JpaRepository<BodyType, Integer> {
    BodyType findByName(String name);
}
