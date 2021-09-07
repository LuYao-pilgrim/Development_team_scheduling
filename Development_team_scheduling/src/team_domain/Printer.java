package team_domain;

public class Printer implements Equipment{
    private String type;
    private String name;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Printer() {
    }

    public Printer(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
