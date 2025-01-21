package model.dao;


import db.DB;
import model.dao.impl.SellerDaoJDBC;

// Operações estaticas para instanciar e criar  os Daos na classe Program principal
public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }
}
