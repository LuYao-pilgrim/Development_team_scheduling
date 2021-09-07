package team_domain;

public class Designer extends Programmer{
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }



    @Override
    public String toString(){
        return getdetails()+"\t设计师\t"+getStatus()+"\t"+getBonus()+"\t\t\t"+getEquipment().getDescription();
    }

    public String getdetailsforteam(){
        return getMemberid()+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t设计师\t"+getBonus();
    }
}
