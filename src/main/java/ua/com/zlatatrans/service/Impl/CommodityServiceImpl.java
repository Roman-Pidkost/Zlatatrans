package ua.com.zlatatrans.service.Impl;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.zlatatrans.dao.CommodityDao;
import ua.com.zlatatrans.dto.filter.CommodityFilter;
import ua.com.zlatatrans.dto.filter.IndexFilter;
import ua.com.zlatatrans.dto.filter.SimpleFilter;
import ua.com.zlatatrans.dto.form.CommodityForm;
import ua.com.zlatatrans.dto.form.FavoriteCommodity;
import ua.com.zlatatrans.entity.Commodity;
import ua.com.zlatatrans.service.CommodityService;
import ua.com.zlatatrans.service.FileWriter;
import ua.com.zlatatrans.specification.CommoditySpecification;
import ua.com.zlatatrans.specification.IndexSpecification;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Autowired
    private FileWriter fileWriter;

    public void save(Commodity commodity) {
        commodityDao.save(commodity);
    }

    public void save(CommodityForm form) {
        List<MultipartFile> files = form.getImages();
        if (form.getFullPrice().equals("")) {
            form.setFullPrice("0");
        }
        Commodity entity = commodityDao.saveAndFlush(new Commodity(form));
        if (files != null) {
            int imagesCount = fileWriter.write(entity.getId(), files, entity);
            if (imagesCount != 0) {
                entity.setImagesCount(imagesCount);
                entity.setVersion(entity.getVersion() + 1);
                entity.setIsSetMainImage(false);
                commodityDao.save(entity);
            }
        }
    }

    public List<Commodity> findAll() {
        return commodityDao.findAll();
    }

    public Commodity findOne(int id) {
        return commodityDao.findOne(id);
    }

    public void delete(int id) {
    	File pathToHome = new File(System.getProperty("catalina.home"));
    	long folderId = (id + 1) * 33;
    	File pathToFolder = new File(pathToHome, "images" + File.separator + "auto_" + String.valueOf(folderId));
        try {
            FileUtils.deleteDirectory(pathToFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        commodityDao.delete(id);
    }

    public CommodityForm findForm(int id) {
        Commodity commodity = findOne(id);
        return new CommodityForm(commodity);
    }

    public FavoriteCommodity findFavorites(int id) {
        Commodity commodity = findOne(id);
        return new FavoriteCommodity(commodity);
    }

    public Page<Commodity> findAll(CommodityFilter filter, Pageable pageable) {
        return commodityDao.findAll(new CommoditySpecification(filter), pageable);
    }

    public Page<Commodity> findAll(IndexFilter filter, Pageable pageable) {
        return commodityDao.findAll(new IndexSpecification(filter), pageable);
    }

    public Page<Commodity> findAll(SimpleFilter filter, Pageable pageable) {
        return commodityDao.findAll(findByNameLike(filter), pageable);
    }
    private Specification<Commodity> findByNameLike(SimpleFilter filter){
        return (root, query, cb)-> {
            if(filter.getSearch().isEmpty())return null;
            return cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase()+"%");
        };
    }

}
