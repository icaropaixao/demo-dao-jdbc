package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // exemplo usando a classe actoryDao para criar os Daos sem usar um (new etc etc etc)
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();


        System.out.println("\n=== Teste 1: Department findById ===");
        Department department = departmentDao.findById(2); // Passando apenas o ID
        if (department != null) {
            System.out.println("Departamento encontrado: " + department.getName());
        } else {
            System.out.println("Departamento não encontrado.");
        }

        System.out.println("\n=== Teste 2: Insert Department === ");
        Department dep = new Department(7, "Logistics");
        departmentDao.insert(dep);
        System.out.println("Inserido com sucesso! ID: " + dep.getId());

        System.out.println("\n=== Teste 3: Delete Department === ");
        System.out.println("Digite o ID que deseja excluir: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deletado com sucesso! ID: " + id);


        System.out.println("\n=== Teste 4: Update Department === ");
        department = departmentDao.findById(3);
        department.setName("Cientistas");
        departmentDao.update(department);
        System.out.println("Atualizado com sucesso! ID: " + department.getId());


        System.out.println("\n=== Teste 5: Department findAll ===");
        List<Department> departments = departmentDao.findAll();
        departments = departmentDao.findAll();
        for (Department s : departments) {

            System.out.println(s);

        }
    }
}
