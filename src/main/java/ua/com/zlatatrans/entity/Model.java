package ua.com.zlatatrans.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Model extends AbstractEntity {

    @ManyToOne
    private Make make;

    @OneToMany(mappedBy = "model")
    private List<Commodity> commodities = new ArrayList<Commodity>();

    public Model() {
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }
}
