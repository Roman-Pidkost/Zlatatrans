package ua.com.zlatatrans.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.zlatatrans.dao.BodyTypeDao;
import ua.com.zlatatrans.entity.BodyType;
import ua.com.zlatatrans.service.BodyTypeService;

import java.util.List;

@Service
public class BodyTypeServiceImpl implements BodyTypeService {

    @Autowired
    private BodyTypeDao bodyTypeDao;

    public void save(BodyType bodyType) {
        bodyTypeDao.save(bodyType);
    }

    public List<BodyType> findAll() {
        return bodyTypeDao.findAll();
    }

    public BodyType findOne(int id) {
        return bodyTypeDao.findOne(id);
    }

    public BodyType findOne(String name) {
        return bodyTypeDao.findByName(name);
    }

    public void delete(int id) {
        bodyTypeDao.delete(id);
    }

}
