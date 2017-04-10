package ua.com.zlatatrans.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.zlatatrans.dao.ColorDao;
import ua.com.zlatatrans.entity.Color;
import ua.com.zlatatrans.service.ColorService;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService{

    @Autowired
    ColorDao colorDao;

    public void save(Color color) {
        colorDao.save(color);
    }

    public List<Color> findAll() {
        return colorDao.findAll();
    }

    public Color findOne(int id) {
        return colorDao.findOne(id);
    }

    public void delete(int id) {
        colorDao.delete(id);
    }

    public Color findOne(String name) {
        return colorDao.findByName(name);
    }

}
