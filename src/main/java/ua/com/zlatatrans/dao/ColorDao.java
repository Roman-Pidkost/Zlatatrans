package ua.com.zlatatrans.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.zlatatrans.entity.Color;

public interface ColorDao extends JpaRepository<Color, Integer> {
    Color findByName(String name);
}

