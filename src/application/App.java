package application;

import java.util.Locale;
import java.util.Scanner;

import model.services.ProductServices;

public class App {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int x, id;

		ProductServices product = new ProductServices();

		while (true) {
			System.out.println();
			System.out.println("    === MENU ===");
			System.out.println("1 - Adicionar Produto");
			System.out.println("2 - Listar Produtos");
			System.out.println("3 - Remover Produtos");
			System.out.println("4 - Alterar dados do Produto");
			System.out.println("5 - Sair");

			System.out.print("Escolha uma opção: ");
			x = sc.nextInt();
			if(x == 5) {
				break;
			}
			System.out.println();

			switch (x) {
			case 1:
				System.out.print("Quantos Produtos voce vai inserir? ");
				int n = sc.nextInt();
				for (int i = 1; i <= n; i++) {
					System.out.print("Nome do Produto " + i + ":");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.print("Preco do Produto " + i + ":");
					double price = sc.nextDouble();
					product.addProduct(name, price);
				}
				if (n == 1) {
					System.out.println("Produto adicionado com sucesso!");
				} else {
					System.out.println(n + " Produtos adicionado com sucesso!");
				}
				break;

			case 2:
				product.listProducts();
				break;

			case 3:
				System.out.print("Digite o ID do produto que deseja remover: ");
				id = sc.nextInt();
				if (product.removeProduct(id)) {
					System.out.println(product.getName(id) + " removido com sucesso!");
				} else {
					System.out.println("ID invalido!");
				}
				break;

			case 4:
				System.out.print("digite o ID do Produto que você deseja modificar: ");
				id = sc.nextInt();

				if (product.idValidation(id)) {
					System.out.print("O que você deseja alterar? NOME/PREÇO: ");
					String alterar = sc.next();

					if (alterar.equalsIgnoreCase("nome")) {
						System.out.print("Digite o Nome: ");
						String name = sc.next();
						product.setName(id, name);
						System.out.println("Nome do produto alterado para: " + name);
					} else if (alterar.equalsIgnoreCase("preço")) {
						System.out.print("Digite o preço: ");
						double price = sc.nextDouble();
						product.setPrice(id, price);
						System.out.printf("Preço do produto alterado para: %.2f%n", price);
					} else {
						System.out.println("Opção invalida!");
					}
				} else {
					System.out.println("ID invalido!");
				}
				break;
			}
			
		}
		System.out.println("PROGRAMA FINALIZADO!");
		sc.close();

	}
}
