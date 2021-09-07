package team_service;

import team_domain.Architect;
import team_domain.Designer;
import team_domain.Employee;
import team_domain.Programmer;

public class Team_service {
    private static int COUNTER = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total;

    public Team_service() {
    }

    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for(int i =0;i<team.length;i++){
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        //成员已满，无法添加
        if(total >= MAX_MEMBER){
            throw new TeamException("成员已满,无法添加");
        }
        //成员不是开发人员
        if(!(e instanceof Programmer)){
            throw new TeamException("该人员不是开发人员，无法添加");
        }
        //该员工已在团队中
        if(isExist(e)){
            throw new TeamException("该员工已在团队中");
        }
        //状态不是FREE
        Programmer p = (Programmer) e;
        if(p.getStatus().getNAME().equals("BUSY")){
            throw new TeamException("该员工已经是某团队成员");
        }else if("VOCATION".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工在休假");
        }
        //团队最多一个架构师,两个设计师，三个程序员
        // （先分别看看已经有几个）
        //获取已有的
        int numberofArch = 0,numberofDes =0,numberofPro = 0;
        for(int i = 0;i<total;i++){
            if(team[i] instanceof Architect){
                numberofArch++;
            }else if(team[i] instanceof Designer){
                numberofDes++;
            }else if(team[i]instanceof Programmer){
                numberofPro++;
            }
        }
        if(p instanceof Architect){
            if(numberofArch >= 1){
                throw new TeamException("团队最多一个架构师");
            }
        }else if(p instanceof Designer){
            if(numberofDes >= 2){
                throw new TeamException("团队最多两个设计师");
            }
        }else if(p instanceof Programmer){
            if(numberofPro >= 3){
                throw new TeamException("团队最多三个程序员");
            }
        }

        //p历经磨难到这了，可以添加了
        team[total] = p;
        total++;
        p.setStatus(Status.BUSY);
        p.setMemberid(COUNTER++);



    }

    private boolean isExist(Employee e) {
        for(int i=0;i<total;i++){
            return e.getId() == team[i].getId();
        }

        return false;
    }

    public void removeMember(int memberId){
        int i = 0;
        for(;i<total;i++){
            if(team[i].getMemberid() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }

        for(int j = i+1;j<total;j++){
            team[j-1] = team[j];
        }

        team[total-1] = null;
        total--;
    }


}
