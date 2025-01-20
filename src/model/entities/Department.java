package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

    // constructors
    public Department() {
    }
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }


    // get sets
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    // hash equals para fazer comparações entre os objetos
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    // toString
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
