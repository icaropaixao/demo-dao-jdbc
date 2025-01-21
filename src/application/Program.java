package application;

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

public class Program {
    public static void main(String[] args) {

        Department department = new Department(1,"Books");

        Seller seller = new Seller("Icaro",1,10.0,"email",new Date());

        System.out.println(seller);
        System.out.println(department);


        // exemplo usando a classe FactoryDao para criar os Daos sem usar um (new etc etc etc)
        SellerDao sellerDao = DaoFactory.createSellerDao();



    }
}
