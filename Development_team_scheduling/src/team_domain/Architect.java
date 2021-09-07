package team_domain;

import java.util.concurrent.ForkJoinPool;

public class Architect extends Designer{
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }
    @Override
    public String toString(){
        return getdetails()+"\t架构师\t"+getStatus()+"\t"+getBonus()+"\t"+getStock()+"\t"+getEquipment().getDescription();
    }

    public String getdetailsforteam(){
        return getMemberid()+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t架构师\t"+getBonus()+"\t"+getStock();
    }

}
