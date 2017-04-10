package ua.com.zlatatrans.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BodyType extends AbstractEntity {

    @OneToMany(mappedBy = "bodyType")
    private List<Commodity> commodities = new ArrayList<Commodity>();

    public BodyType() {
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }
}
