package team_domain;

public class NoteBook implements Equipment{
    private String model;
    private double price;

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }


    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
