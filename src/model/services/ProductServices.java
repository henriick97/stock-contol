package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Products;

public class ProductServices {
	private List<Products> list = new ArrayList<>();

	public void addProduct(String name, double price) {
		list.add(new Products(name, price));
	}

	public boolean idValidation(int id) {
		if (id > 0 && id <= list.size()) {
			return true;
		}
		return false;
	}

	public boolean setName(int id, String name) {
		boolean isValid = idValidation(id);
		if (isValid) {
			list.get(id - 1).setName(name);
		}
		return isValid;
	}

	public boolean setPrice(int id, double price) {
		boolean isValid = idValidation(id);
		if (isValid) {
			list.get(id - 1).setPrice(price);
		}
		return isValid;
	}

	public boolean removeProduct(int id) {
		boolean isValid = idValidation(id);
		if (isValid) {
			list.remove(id - 1);
		}
		return isValid;
	}

	public void listProducts() {
		if (list.isEmpty()) {
			System.out.println("Não há produtos adicionados!");
		} else {
			int id = 1;
			for (Products x : list) {
				System.out.printf("ID: %d | Name: %s | Price: %.2fR$%n", id, x.getName(), x.getPrice());// usando
																										// especificadores
				id++;
			}
		}
	}
	
	public String getName(int id) {
		return list.get(id).getName();
	}
	
	public double getPrice(int id) {
		return list.get(id).getPrice();
	}

}
