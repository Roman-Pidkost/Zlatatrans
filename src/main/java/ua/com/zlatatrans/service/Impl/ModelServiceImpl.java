package ua.com.zlatatrans.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.com.zlatatrans.dao.ModelDao;
import ua.com.zlatatrans.dto.filter.ModelFilter;
import ua.com.zlatatrans.entity.Model;
import ua.com.zlatatrans.service.ModelService;
import ua.com.zlatatrans.specification.ModelSpecification;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelDao modelDao;

    public void save(Model model) {
        modelDao.save(model);
    }

    public List<Model> findAll() {
        return modelDao.findAll();
    }

    public Model findOne(int id) {
        return modelDao.findOne(id);
    }

    public Model findOne(String name) {
        return modelDao.findByName(name);
    }

    public void delete(int id) {
        modelDao.delete(id);
    }

	@Override
	public Page<Model> findAll(Pageable pageable, ModelFilter filter) {
		return modelDao.findAll(new ModelSpecification(filter), pageable);
	}
}
