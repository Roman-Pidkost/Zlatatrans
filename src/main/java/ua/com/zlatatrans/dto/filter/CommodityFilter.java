package ua.com.zlatatrans.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class CommodityFilter {

    private String minYearStr = "";

    private String maxYearStr = "";

    private Integer minYear;

    private Integer maxYear;

    private String maxCapacityStr = "";

    private String minCapacityStr = "";

    private Double minCapacity;

    private Double maxCapacity;

    private String minPriceStr = "";

    private String maxPriceStr = "";

    private Integer minPrice;

    private Integer maxPrice;

    private List<Integer> modelId = new ArrayList<>();

    private List<Integer> makeId = new ArrayList<>();

    private List<Integer> fuelTypeId = new ArrayList<>();

    private List<Integer> transmissionId = new ArrayList<>();

    private List<Integer> bodyTypeId = new ArrayList<>();

    public String getMinYearStr() {
        return minYearStr;
    }

    public void setMinYearStr(String minYearStr) {
        this.minYearStr = minYearStr;
    }

    public String getMaxYearStr() {
        return maxYearStr;
    }

    public void setMaxYearStr(String maxYearStr) {
        this.maxYearStr = maxYearStr;
    }

    public Integer getMinYear() {
        return minYear;
    }

    public void setMinYear(Integer minYear) {
        this.minYear = minYear;
    }

    public Integer getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Integer maxYear) {
        this.maxYear = maxYear;
    }

    public String getMinCapacityStr() {
        return minCapacityStr;
    }

    public void setMinCapacityStr(String minCapacityStr) {
        this.minCapacityStr = minCapacityStr;
    }

    public String getMaxCapacityStr() {
        return maxCapacityStr;
    }

    public void setMaxCapacityStr(String maxCapacityStr) {
        this.maxCapacityStr = maxCapacityStr;
    }

    public Double getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(Double minCapacity) {
        this.minCapacity = minCapacity;
    }

    public Double getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getMinPriceStr() {
        return minPriceStr;
    }

    public void setMinPriceStr(String minPriceStr) {
        this.minPriceStr = minPriceStr;
    }

    public String getMaxPriceStr() {
        return maxPriceStr;
    }

    public void setMaxPriceStr(String maxPriceStr) {
        this.maxPriceStr = maxPriceStr;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<Integer> getModelId() {
        return modelId;
    }

    public void setModelId(List<Integer> modelId) {
        this.modelId = modelId;
    }

    public List<Integer> getMakeId() {
        return makeId;
    }

    public void setMakeId(List<Integer> makeId) {
        this.makeId = makeId;
    }

    public List<Integer> getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(List<Integer> fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public List<Integer> getTransmissionId() {
        return transmissionId;
    }

    public void setTransmissionId(List<Integer> transmissionId) {
        this.transmissionId = transmissionId;
    }

    public List<Integer> getBodyTypeId() {
        return bodyTypeId;
    }

    public void setBodyTypeId(List<Integer> bodyTypeId) {
        this.bodyTypeId = bodyTypeId;
    }
}
