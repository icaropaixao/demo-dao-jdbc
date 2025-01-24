package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {

        // exemplo usando a classe actoryDao para criar os Daos sem usar um (new etc etc etc)
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Teste 1: Insert Department === ");
        Department dep = new Department(6,"Usinagem");
        departmentDao.insert(dep);
        System.out.println("Inserido com sucesso! ID: " + dep.getId());

        System.out.println("=== Teste 2: Delete Department === ");






    }
}
