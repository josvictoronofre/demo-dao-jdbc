package application;

import java.util.List;
import java.util.Scanner;

import model_dao.DaoFactory;
import model_dao.DepartmentDao;
import model_entities.Department;

public class App2 {
    
    public static void main(String[] args) {
        
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        List<Department> list = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("-- Test 1 - Department insert --");
        Department dp = new Department(null, "Weapons");
        departmentDao.insert(dp);
        System.out.println("Department added!");

        System.out.println("-- Test 2 - Department update --");
        dp.setName("Armor");
        departmentDao.update(dp);
        System.out.println("Department updated!");

        System.out.println("-- Test 3 - Department findById");
        Department answer = new Department(dp.getId(), dp.getName());
        System.out.println(answer);

        System.out.println("-- Test 4 - Department deleteById --");
        departmentDao.deleteById(dp.getId());
        System.out.println("Department deleted!");

        System.out.println("-- Test 5 - Department findAll --");
        list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        sc.close();
    }
}
