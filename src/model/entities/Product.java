package model.entities;

public class Product {
    //atributos
    private String name;
    private Double price;

    //construtores
    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void printProduct(){
        System.out.println("Nome do produto: "+getName()+" | Preço do produto: "+String.format("%.2f",getPrice()));
    }


    //toString
    @Override
    public String toString() {
        return String.format("Nome do produto: %s | Preço do produto: %2fR$", getName(), getPrice());
    }

}
