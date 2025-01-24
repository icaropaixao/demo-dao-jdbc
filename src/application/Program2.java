package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // exemplo usando a classe actoryDao para criar os Daos sem usar um (new etc etc etc)
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Teste 1: Insert Department === ");
        Department dep = new Department(6, "Usinagem");
        departmentDao.insert(dep);
        System.out.println("Inserido com sucesso! ID: " + dep.getId());

        System.out.println("=== Teste 2: Delete Department === ");
        System.out.println("Digite o ID que deseja excluir: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deletado com sucesso! ID: " + id);






    }
}
