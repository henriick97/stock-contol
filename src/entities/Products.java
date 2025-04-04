package entities;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private String name;
	private double price;

	List<Products> product = new ArrayList<>();

	public Products() {

	}

	public Products(String name, double price) {
		this.name = name;
		this.price = price;
	}

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

	public void addProduct(String name, double price) {
		product.add(new Products(name, price));
	}

	public void listProducts() {
		if (product.size() == 0) {
			System.out.println("Não há produtos adicionados!");
		} else {
			int id = 1;
			for (Products x : product) {
				System.out.printf("ID: "+id+" | Name: "+ x.name +" | Price: %.2fR$%n",x.price);
				id++;
			}
		}
	}

	public boolean removeProduct(int id) {
		if (id > 0 && id <= product.size()) {
			product.remove(id-1);
			System.out.println("Produto removido com sucesso!");
			return true;  //obs: o método será sempre finalizado ao 1 valor boolean retornar verdadeiro.
		}return false; 
	}
	
	public boolean changeProductData(int id, String name, double price) {
		if(id > 0 && id <= product.size()) {
		Products p = product.get(id-1);
		p.setName(name);
		p.setPrice(price);
		System.out.println("Produto alterado com sucesso!");
		return true;
		}
		System.out.println("Id invalido, tente novamente!");
		return false;
	}

	@Override
	public String toString() {
		return "Name: " + name + " | Price: " + price;
	}

}
