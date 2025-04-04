package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Products;

public class Aplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int x,id;
		double price;
		String name;
		
		Products product = new Products();

		do {
			System.out.println();
			System.out.println("=== MENU ===");
			System.out.println("1 - Adicionar Produto");
			System.out.println("2 - Listar Produtos");
			System.out.println("3 - Remover Produtos");
			System.out.println("4 - Alterar dados do Produto");
			System.out.println("5 - Sair");
			System.out.print("Escolha uma opção: ");
			x = sc.nextInt();
			System.out.println();

			switch (x) {
			case 1:
				System.out.print("Quantos Produtos voce vai inserir? ");
				int n = sc.nextInt();
				for (int i = 1; i < n + 1; i++) {
					System.out.print("Nome do Produto " + i + ":");
					sc.nextLine();
					name = sc.nextLine();
					System.out.print("Preco do Produto " + i + ":");
					price = sc.nextDouble();
					product.addProduct(name, price);
				}
				break;
			case 2:
				product.listProducts();
				break;
			case 3:
				System.out.print("Digite o ID do produto para remover ou 0 para sair: ");
				id = sc.nextInt();

				while (!product.removeProduct(id)) { // caso o método for false ele irá inverter para true.
					if (id == 0) {
						break; // finaliza o programa
					}
					System.out.print("Tente novamente ou digite 0 para sair: ");
					id = sc.nextInt();
				}
				break;
			case 4:
				do {
					System.out.println("Qual Produto voçê deseja modificar? ");
					id = sc.nextInt();
					System.out.print("Name: ");
					sc.nextLine();
					name = sc.nextLine();
					System.out.print("Price: ");
					price = sc.nextDouble();
				} while (!product.changeProductData(id, name, price));
			break;
			}
		} while (x != 5);

		System.out.println("PROGRAMA FINALIZADO!");

		sc.close();
	}
}