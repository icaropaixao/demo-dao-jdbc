package model.dao.impl;

import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;
    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {


    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }


    private Department instantieteDepartment(ResultSet rs) throws SQLException {

        Department department = new Department();
        department.setId(rs.getInt("DepartmentId")); // coluna dentro do MySQL que será pesquisada
        department.setName(rs.getString("DepName")); // colunas detro do MySQL

        return department;
    }
}
