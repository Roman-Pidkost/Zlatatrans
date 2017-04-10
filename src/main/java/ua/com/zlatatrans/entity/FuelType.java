package ua.com.zlatatrans.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FuelType extends AbstractEntity {

    @OneToMany(mappedBy = "fuelType")
    private List<Commodity> commodities = new ArrayList<Commodity>();

    public FuelType() {
    }

    public List<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<Commodity> commodities) {
        this.commodities = commodities;
    }
}
