package model.dao;

import model.entities.Seller;

import java.util.List;

public interface SellerDao{

    void insert(Seller obj); // inserir um Seller
    void update(Seller obj); // atualizar um Seller
    void deleteById(Integer id); // deletar um  Id
    Seller findById(Integer id); // buscar um Seller pelo id
    List<Seller> findAll(); // buscar todos


}
