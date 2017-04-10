package ua.com.zlatatrans.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.zlatatrans.entity.FuelType;

public interface FuelTypeDao extends JpaRepository<FuelType, Integer> {
    FuelType findByName(String name);
}
