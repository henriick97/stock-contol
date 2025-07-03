package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entities.Product;
import model.exception.IdException;

public class ProductServices {
    private List<Product> list = new ArrayList<>();

    public void addProduct(String name, double price) {
        list.add(new Product(name, price));
    }

    public void idValidation(int id) {
        if (id < 1 || id > list.size()) {
            throw new IdException("ID #" + id + " inexistente!");
        }
    }

    public void removeProduct(int id) {
        idValidation(id);
        list.remove(id - 1);
    }

    public void listProducts() {
        if (list.isEmpty()) {
            System.out.println("Não há produtos adicionados!");
        } else {
            int id = 1;
            for (Product x : list) {
                System.out.printf("ID: %d | Nome: %s | Preço: %.2fR$%n", id, x.getName(), x.getPrice());
                id++;
            }
        }
    }

    public String getName(int id) {
        idValidation(id);
        return list.get(id).getName();
    }

    public double getPrice(int id) {
        idValidation(id);
        return list.get(id).getPrice();
    }

    public void printProduct(int id){
        idValidation(id);
        list.get(id-1).printProduct();
    }


    public void setName(int id, String name) {
        idValidation(id);
        list.get(id - 1).setName(name);
    }

    public void setPrice(int id, double price) {
        idValidation(id);
        list.get(id - 1).setPrice(price);

    }

}
