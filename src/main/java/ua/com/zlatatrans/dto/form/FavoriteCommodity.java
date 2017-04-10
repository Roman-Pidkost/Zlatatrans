package ua.com.zlatatrans.dto.form;

import ua.com.zlatatrans.entity.Commodity;

public class FavoriteCommodity {

	private String name;

	private String model;

	private String make;

	private int id;
	
	private int year;
	
	private int price;
	
	private String transmission;
	
	private String fuelType;
	
	private int odometer;
	
	private double capacity;
	
	private boolean isSetMainImage;

	private int version;

	public FavoriteCommodity() {
	}

	public FavoriteCommodity(Commodity commodity) {
		this.year = commodity.getYear();
		this.price = commodity.getPrice();
		this.transmission = commodity.getTransmission().getName();
		this.fuelType = commodity.getFuelType().getName();
		this.odometer = commodity.getKilometrage();
		this.capacity = commodity.getCapacity();
		this.id = commodity.getId();
		this.make = commodity.getModel().getMake().getName();
		this.model = commodity.getModel().getName();
		this.isSetMainImage = commodity.getIsSetMainImage();
		this.version = commodity.getVersion();
		this.name = commodity.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getOdometer() {
		return odometer;
	}

	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getIsSetMainImage() {
		return isSetMainImage;
	}

	public void setIsSetMainImage(boolean setMainImage) {
		isSetMainImage = setMainImage;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
