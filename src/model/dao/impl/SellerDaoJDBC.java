package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// IMPL (IMPLEMENTAÇÃO dos metodos)
public class SellerDaoJDBC implements SellerDao {


    // Conexaão com o banco MySQL
    private Connection conn;
    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    // Implementações
    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement  st = null;
        ResultSet rs = null;

        try {
            // codigo SQL para a consulta
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.DepartmentId = department.Id "
                    + "WHERE seller.Id = ? ");


            st.setInt(1,id);
            rs = st.executeQuery();


            // Testando se a consulta ao banco de dados retornou algum resultado
            if(rs.next()) { // Se houver pelo menos uma linha no resultado da consulta...
                Department dep = new Department();
                dep.setId(rs.getInt("DepartmentId")); // coluna dentro do MySQL que será pesquisada
                dep.setName(rs.getString("DepName")); // colunas detro do MySQL

                Seller obj = new Seller();
                obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setBaseSalary(rs.getDouble("BaseSalary"));
                obj.setBirthDate(rs.getDate("birthDate"));
                obj.setDepartment(dep);

                return obj;
            }
            return null;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            // não precisa fechar a conexão pois pode-se fazer uma nova pesquisa depois
            // deixa para fechar no programa principal
        }

    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }

}
