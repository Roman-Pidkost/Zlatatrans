package ua.com.zlatatrans.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Color extends AbstractEntity{

    @OneToMany(mappedBy = "color")
    private List<Commodity> commodities = new ArrayList<Commodity>();

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }
}
