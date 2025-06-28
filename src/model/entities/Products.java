package model.entities;

public class Products {
	private String name;
	private Double price;
	
	//construtores
	public Products() {
	}
	public Products(String name, double price) {
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
	
	@Override
	public String toString() {
		return String.format("Nome do produto: %s | Preço do produto: %2fR$",name,price);
	}

}
