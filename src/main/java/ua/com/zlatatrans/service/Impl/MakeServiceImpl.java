package ua.com.zlatatrans.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.zlatatrans.dao.MakeDao;
import ua.com.zlatatrans.entity.Make;
import ua.com.zlatatrans.service.MakeService;

import java.util.List;

@Service
public class MakeServiceImpl implements MakeService {

    @Autowired
    private MakeDao makeDao;

    public void save(Make make) {
        makeDao.save(make);
    }

    public List<Make> findAll() {
        return makeDao.findAll();
    }

    public Make findOne(int id) {
        return makeDao.findOne(id);
    }

    public Make findOne(String name) {
        return makeDao.findByName(name);
    }

    public void delete(int id) {
        makeDao.delete(id);
    }

    public Make findByIdFetchModel(int id) {
        return makeDao.findByIdFetchModel(id);
    }

    @Override
    public Make findByNameFetchModel(String name) {
        return makeDao.findByNameFetchModel(name);
    }

}
