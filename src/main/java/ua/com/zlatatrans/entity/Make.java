package ua.com.zlatatrans.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Make extends AbstractEntity {

    @OneToMany(mappedBy = "make", fetch = FetchType.EAGER)
    private List<Model> models = new ArrayList<Model>();


    public Make() {
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
