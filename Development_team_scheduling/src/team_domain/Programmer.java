package team_domain;

import team_service.Status;

public class Programmer extends Employee{
    private int memberid;
    private Status status = Status.FREE;
    private Equipment equipment;

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer() {
        super();
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;

    }

    @Override
    public String toString(){
        return super.getdetails() + "\t程序员\t" +status+"\t\t\t\t\t"+equipment.getDescription();
    }

    public String getdetailsforteam(){
        return memberid+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t程序员";
    }
}
