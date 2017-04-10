package ua.com.zlatatrans.mail;

public class MailOrder {

    private String make;

    private String model;

    private String year;

    private String mainOptions;

    private String otherOptions;

    private String contacts;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMainOptions() {
        return mainOptions;
    }

    public void setMainOptions(String mainOptions) {
        this.mainOptions = mainOptions;
    }

    public String getOtherOptions() {
        return otherOptions;
    }

    public void setOtherOptions(String otherOptions) {
        this.otherOptions = otherOptions;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
