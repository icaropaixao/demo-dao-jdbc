package model.dao;


import model.entities.Department;

import java.util.List;

//CLASSE PARA LIDAR COM A PARTE DE BANCO DE DADOS
public interface DepartmentDao {

    void insert(Department department); // inserir um departamento
    void update(Department department); // atualizar um departamento
    void deleteById(Integer id); // deletar um department Id
    Department findById(Integer id); // buscar um Department pelo id
    List<Department> findAll(); // listar todos os departamentos


}
