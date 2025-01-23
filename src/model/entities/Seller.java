package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer id;
    private Double baseSalary;
    private String email;
    private Date birthDate;

    // associação 1 seller possui -> 1 departament
    private Department department;

    // construtores
    public Seller(){

    }
    public Seller(String name, Integer id, Double baseSalary, String email, Date birthDate,Department department) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
        this.email = email;
        this.birthDate = birthDate;
        this.department = department;
    }


    // gets sets
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    // hash equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //toString
    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", baseSalary=" + baseSalary +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", department=" + department +
                '}';
    }
}
