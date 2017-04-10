package ua.com.zlatatrans.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.zlatatrans.entity.Transmission;

public interface TransmissionDao extends JpaRepository<Transmission, Integer> {
    Transmission findByName(String name);
}
