package ua.com.zlatatrans.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.zlatatrans.entity.Drive;

public interface DriveDao extends JpaRepository<Drive, Integer> {
    Drive findByName(String name);
}
