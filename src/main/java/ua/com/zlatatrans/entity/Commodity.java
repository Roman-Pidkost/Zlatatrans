package ua.com.zlatatrans.entity;

import org.hibernate.validator.constraints.Length;
import ua.com.zlatatrans.dto.form.CommodityForm;

import javax.persistence.*;

@Entity
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double capacity;

    private int kilometrage;

    private int power;

    private int year;

    private int doorsCount;

    private int seatsCount;

    private int price;

    private int fullPrice;

    private boolean hasAbs;

    private boolean hasEsp;

    private boolean hasAirbag;

    private boolean hasConditioner;

    private boolean hasClimateControl;

    private boolean hasHeatedSeats;

    private boolean hasHeatedMirrors;

    private boolean hasHeatedSteeringWheel;

    private boolean hasLeather;

    private boolean hasHatch;

    private boolean hasParktronic;

    private boolean hasGlassHoist;

    private boolean hasElectricMirrors;

    private boolean hasElectricSeats;

    private boolean hasDamaged;

    private int imagesCount;

    private int version;

    private boolean isSetMainImage;

    @Length(max = 511)
    private String description;

    @ManyToOne
    private Model model;

    @ManyToOne
    private FuelType fuelType;

    @ManyToOne
    private Transmission transmission;

    @ManyToOne
    private Drive drive;

    @ManyToOne
    private BodyType bodyType;

    @ManyToOne
    private Color color;

    public Commodity() {
    }

    public Commodity(CommodityForm o) {
        this.id = o.getId();
        this.name = o.getName();
        this.capacity = Double.valueOf(o.getCapacity().replace(',', '.'));
        this.kilometrage = Integer.valueOf(o.getKilometrage());
        this.power = Integer.valueOf(o.getPower());
        this.year = Integer.valueOf(o.getYear());
        this.doorsCount = Integer.valueOf(o.getDoorsCount());
        this.seatsCount = Integer.valueOf(o.getSeatsCount());
        this.price = Integer.valueOf(o.getPrice());
        this.fullPrice = Integer.valueOf(o.getFullPrice());
        this.model = o.getModel();
        this.fuelType = o.getFuelType();
        this.transmission = o.getTransmission();
        this.drive = o.getDrive();
        this.bodyType = o.getBodyType();
        this.color = o.getColor();
        this.imagesCount = o.getImagesCount();
        this.version = o.getVersion();
        this.isSetMainImage = o.getIsSetMainImage();
        this.description = o.getDescription();

        this.hasAbs = o.getHasAbs();
        this.hasEsp = o.getHasEsp();
        this.hasAirbag = o.getHasAirbag();
        this.hasConditioner = o.getHasConditioner();
        this.hasClimateControl = o.getHasClimateControl();
        this.hasHeatedSeats = o.getHasHeatedSeats();
        this.hasHeatedMirrors = o.getHasHeatedMirrors();
        this.hasHeatedSteeringWheel = o.getHasHeatedSteeringWheel();
        this.hasLeather = o.getHasLeather();
        this.hasHatch = o.getHasHatch();
        this.hasParktronic = o.getHasParktronic();
        this.hasGlassHoist = o.getHasGlassHoist();
        this.hasElectricMirrors = o.getHasElectricMirrors();
        this.hasElectricSeats = o.getHasElectricSeats();
        this.hasDamaged = o.getHasDamaged();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public int getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(int doorsCount) {
        this.doorsCount = doorsCount;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getHasAbs() {
        return hasAbs;
    }

    public void setHasAbs(boolean hasAbs) {
        this.hasAbs = hasAbs;
    }

    public boolean getHasEsp() {
        return hasEsp;
    }

    public void setHasEsp(boolean hasEsp) {
        this.hasEsp = hasEsp;
    }

    public boolean getHasAirbag() {
        return hasAirbag;
    }

    public void setHasAirbag(boolean hasAirbag) {
        this.hasAirbag = hasAirbag;
    }

    public boolean getHasConditioner() {
        return hasConditioner;
    }

    public void setHasConditioner(boolean hasConditioner) {
        this.hasConditioner = hasConditioner;
    }

    public boolean getHasClimateControl() {
        return hasClimateControl;
    }

    public void setHasClimateControl(boolean hasClimateControl) {
        this.hasClimateControl = hasClimateControl;
    }

    public boolean getHasHeatedSeats() {
        return hasHeatedSeats;
    }

    public void setHasHeatedSeats(boolean hasHeatedSeats) {
        this.hasHeatedSeats = hasHeatedSeats;
    }

    public boolean getHasHeatedMirrors() {
        return hasHeatedMirrors;
    }

    public void setHasHeatedMirrors(boolean hasHeatedMirrors) {
        this.hasHeatedMirrors = hasHeatedMirrors;
    }

    public boolean getHasHeatedSteeringWheel() {
        return hasHeatedSteeringWheel;
    }

    public void setHasHeatedSteeringWheel(boolean hasHeatedSteeringWheel) {
        this.hasHeatedSteeringWheel = hasHeatedSteeringWheel;
    }

    public boolean getHasLeather() {
        return hasLeather;
    }

    public void setHasLeather(boolean hasLeather) {
        this.hasLeather = hasLeather;
    }

    public boolean getHasHatch() {
        return hasHatch;
    }

    public void setHasHatch(boolean hasHatch) {
        this.hasHatch = hasHatch;
    }

    public boolean getHasParktronic() {
        return hasParktronic;
    }

    public void setHasParktronic(boolean hasParktronic) {
        this.hasParktronic = hasParktronic;
    }

    public boolean getHasGlassHoist() {
        return hasGlassHoist;
    }

    public void setHasGlassHoist(boolean hasGlassHoist) {
        this.hasGlassHoist = hasGlassHoist;
    }

    public boolean getHasElectricMirrors() {
        return hasElectricMirrors;
    }

    public void setHasElectricMirrors(boolean hasElectricMirrors) {
        this.hasElectricMirrors = hasElectricMirrors;
    }

    public boolean getHasElectricSeats() {
        return hasElectricSeats;
    }

    public void setHasElectricSeats(boolean hasElectricSeats) {
        this.hasElectricSeats = hasElectricSeats;
    }

    public boolean getHasDamaged() {
        return hasDamaged;
    }

    public void setHasDamaged(boolean hasDamaged) {
        this.hasDamaged = hasDamaged;
    }

    public int getImagesCount() {
        return imagesCount;
    }

    public void setImagesCount(int imagesCount) {
        this.imagesCount = imagesCount;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean getIsSetMainImage() {
        return isSetMainImage;
    }

    public void setIsSetMainImage(boolean isSetMainImage) {
        this.isSetMainImage = isSetMainImage;
    }
}
