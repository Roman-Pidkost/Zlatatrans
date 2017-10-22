package ua.com.zlatatrans.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ua.com.zlatatrans.entity.Commodity;


public interface CommodityDao extends JpaRepository<Commodity, Integer>, JpaSpecificationExecutor<Commodity> {

}
