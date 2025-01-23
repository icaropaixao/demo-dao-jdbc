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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// IMPL (IMPLEMENTAÇÃO dos metodos)
public class SellerDaoJDBC implements SellerDao {


    // Conexaão com o banco MySQL
    private Connection conn;
    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    // Implementações
    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

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
            rs = st.executeQuery(); // Resultado da execução das linhas SQL sendo armazenado aqui


            // Testando se a consulta ao banco de dados retornou algum resultado
            if(rs.next()) { // Se houver pelo menos uma linha no resultado da consulta...
                Department department = instantieteDepartment(rs);
                Seller seller = instantieteSeller(rs,department);
                return seller;
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
        PreparedStatement  st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(

                    "SELECT seller.*,department.Name as DepName "
                            +"FROM seller INNER JOIN department "
                            +"ON seller.DepartmentId = department.Id "
                            +"ORDER BY Name ");


            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();

            // Mapa para armazenar objetos Department já criados, evitando duplicação
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()){

                // verificação se o dep ja existe
                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instantieteDepartment(rs);
                    map.put(rs.getInt("DepartmentId"),dep);
                }

                Seller seller = instantieteSeller(rs,dep);
                list.add(seller);

            }
            return list;
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
    public List<Seller> findByDepartment(Department department) {

        PreparedStatement  st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(

                    "SELECT seller.*,department.Name as DepName "
                    +"FROM seller INNER JOIN department "
                    +"ON seller.DepartmentId = department.Id "
                    +"WHERE DepartmentId = ? "
                    +"ORDER BY Name ");

            st.setInt(1,department.getId());
            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()){

                // verificação se o dep ja existe
                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null) {
                   dep = instantieteDepartment(rs);
                   map.put(rs.getInt("DepartmentId"),dep);
                }

                Seller seller = instantieteSeller(rs,dep);
                list.add(seller);

            }
            return list;
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


    // INSTANCIANDO UM DEPARTAMENTO E UM SELLER
    private Department instantieteDepartment(ResultSet rs)  throws SQLException {
        
        Department department = new Department();
        department.setId(rs.getInt("DepartmentId")); // coluna dentro do MySQL que será pesquisada
        department.setName(rs.getString("DepName")); // colunas detro do MySQL

        return department;
    }
    private Seller instantieteSeller(ResultSet rs, Department department) throws SQLException {
        Seller seller = new Seller();

        seller.setId(rs.getInt("Id"));
        seller.setName(rs.getString("Name"));
        seller.setEmail(rs.getString("Email"));
        seller.setBaseSalary(rs.getDouble("BaseSalary"));
        seller.setBirthDate(rs.getDate("birthDate"));
        seller.setDepartment(department);

        return seller;
        
    }
    

}
