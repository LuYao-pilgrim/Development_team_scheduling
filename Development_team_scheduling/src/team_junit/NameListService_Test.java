package team_junit;

import org.junit.Test;
import team_domain.Employee;
import team_service.NameListService;
import team_service.TeamException;

public class NameListService_Test {

    @Test
    public void testGetAllEmployees(){
        NameListService service = new NameListService();
        Employee[] employees= service.getAllEmployee();
        for (int i = 0;i < employees.length;i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id =1;
        try{
            Employee employee= service.getEmployee(1);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
    }
}
