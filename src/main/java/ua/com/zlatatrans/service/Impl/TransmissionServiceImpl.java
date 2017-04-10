package ua.com.zlatatrans.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.zlatatrans.dao.TransmissionDao;
import ua.com.zlatatrans.entity.Transmission;
import ua.com.zlatatrans.service.TransmissionService;

import java.util.List;

@Service
public class TransmissionServiceImpl implements TransmissionService {

    @Autowired
    private TransmissionDao transmissionDao;

    public void save(Transmission transmission) {
        transmissionDao.save(transmission);
    }

    public List<Transmission> findAll() {
        return transmissionDao.findAll();
    }

    public Transmission findOne(int id) {
        return transmissionDao.findOne(id);
    }

    public Transmission findOne(String name) {
        return transmissionDao.findByName(name);
    }

    public void delete(int id) {
        transmissionDao.delete(id);
    }

}
