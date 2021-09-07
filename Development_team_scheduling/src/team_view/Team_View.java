package team_view;

import team_domain.Employee;
import team_domain.Programmer;
import team_service.NameListService;
import team_service.TeamException;
import team_service.Team_service;

public class Team_View {
    private NameListService listSVC = new NameListService();
    private Team_service teamSVC = new Team_service();

    public void enterMainMenu(){
        boolean loopflag = true;
        char key = 0;

        do{
            if(key != '1'){
                listAllEmployee();
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");
            key = TSUtility.readMenuSelection();
            System.out.println();
            switch (key){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = TSUtility.readConfirmationSelection();
                    if(isExit == 'Y'){
                        loopflag = false;
                    }
                    break;
            }
        }while(loopflag);
    }

    private void listAllEmployee(){
        System.out.println("---------------开发团队调度软件---------------");
        Employee[] employees = listSVC.getAllEmployee();
        if(employees == null || employees.length==0){
            System.out.println("公司没有任何员工信息！");
        }else{
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
            for(int i = 0;i < employees.length;i++){
                System.out.println(employees[i]);
            }
        }
        System.out.println("------------------------------");
    }
    private void getTeam(){
        System.out.println("---------------团队成员列表---------------");
        Programmer[] team = teamSVC.getTeam();
        if(team == null || team.length == 0){
            System.out.println("开发团队没有成员.");
        }else{
            System.out.println("TID/TD\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
            for(int i = 0;i < team.length;i++){
                System.out.println(team[i].getdetailsforteam());
            }
        }
        System.out.println("------------------------------");
    }
    private void addMember(){
        System.out.println("----------------添加成员---------------");
        System.out.println("请输入添加成员的ID:");
        int id = TSUtility.readInt();
        try{
            Employee emp = listSVC.getEmployee(id);
            teamSVC.addMember(emp);
            System.out.println("添加成功");
        }catch (TeamException e){
            System.out.println("添加失败，原因："+e.getMessage());
        }

        TSUtility.readReturn();



    }
    private void deleteMember(){
        System.out.println("---------------删除成员---------------");
        System.out.println("请输入要删除员工的TID：");
        int memberId = TSUtility.readInt();

        System.out.println("确认是否删除(Y/N):");
        char isDelete = TSUtility.readConfirmationSelection();
        if(isDelete == 'N'){
            return;
        }
        teamSVC.removeMember(memberId);

    }

    public static void main(String[] args) {
        Team_View team_view = new Team_View();
        team_view.enterMainMenu();

    }
}
