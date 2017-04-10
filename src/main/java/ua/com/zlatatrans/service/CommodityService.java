package ua.com.zlatatrans.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.com.zlatatrans.dto.filter.CommodityFilter;
import ua.com.zlatatrans.dto.filter.IndexFilter;
import ua.com.zlatatrans.dto.filter.SimpleFilter;
import ua.com.zlatatrans.dto.form.CommodityForm;
import ua.com.zlatatrans.dto.form.FavoriteCommodity;
import ua.com.zlatatrans.entity.Commodity;

import java.util.List;

public interface CommodityService {
    void save(Commodity commodity);
    void save(CommodityForm commodity);
    List<Commodity> findAll();
    Commodity findOne(int id);
    void delete(int id);
    CommodityForm findForm(int id);
    FavoriteCommodity findFavorites(int id);
    Page<Commodity> findAll(CommodityFilter filter, Pageable pageable);
    Page<Commodity> findAll(IndexFilter filter, Pageable pageable);
    Page<Commodity> findAll(SimpleFilter filter, Pageable pageable);
}
