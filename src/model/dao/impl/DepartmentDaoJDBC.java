package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;
    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            // codigo SQL
            st = conn.prepareStatement(
                    "INSERT INTO department "
                      + "(Id, Name) "
                      + "VALUES "
                      + "(?, ?)",
                      Statement.RETURN_GENERATED_KEYS);


            st.setInt(1,department.getId());
            st.setString(2,department.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    department.setId(id);
                }
            }
            else {
                throw new DbException("Inserção falhou ao registrar");
            }

        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;


        try{
            // codigo SQL
            st = conn.prepareStatement(
                    "DELETE FROM department "
                       + "WHERE Id = ? ");

            st.setInt(1,id);

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }


    @Override
    public void update(Department department) {

        PreparedStatement st = null;

        try{
            st = conn.prepareStatement(

                    "UPDATE department "
                       +"SET  Name = ? "
                       +"WHERE Id = ? ");


            st.setNString(1,department.getName());
            st.setInt(2,department.getId());

            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
        }

    }


    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT Id, Name FROM department WHERE Id = ?"
            );
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                // Cria e retorna o departamento a partir dos dados obtidos do ResultSet
                Department department = instantieteDepartment(rs);
                return department;
            }
            return null; // Se não encontrar nenhum departamento, retorna null
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }


    @Override
    public List<Department> findAll() {
        return List.of();
    }


    private Department instantieteDepartment(ResultSet rs) throws SQLException {

        Department department = new Department();
        department.setId(rs.getInt("Id")); // coluna dentro do MySQL que será pesquisada
        department.setName(rs.getString("Name")); // colunas detro do MySQL

        return department;
    }
}
