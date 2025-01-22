package application;

import com.sun.security.jgss.GSSUtil;
import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        // exemplo usando a classe FactoryDao para criar os Daos sem usar um (new etc etc etc)
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Teste 1: Seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Teste 2: Department findById ===");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller s : list) {// Percorre a lista de vendedores retornada e imprime as informações de cada vendedor
            // Imprime as informações do vendedor
            System.out.println(s);
        }





    }
}
