package application;

import db.DB;
import model.entities.Department;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {

        Department department = new Department(1,"Books");

        System.out.println(department);


    }
}
