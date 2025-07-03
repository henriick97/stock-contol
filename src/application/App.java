package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.exception.IdException;
import model.service.ProductServices;

public class App {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int id,alterar;

        ProductServices product = new ProductServices();

        // Loop principal do programa: exibe o menu e trata as opções
        while (true) {
            System.out.println();
            System.out.println("    === MENU ===");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Remover Produtos");
            System.out.println("4 - Alterar dados do Produto");
            System.out.println("5 - Sair");

            System.out.print("Escolha uma opção: ");
            int x = sc.nextInt();

            if (x == 5) {
                break;//Encerra o programa
            }
            System.out.println();

            //Executa a opção desejada pelo cliente e retorna ao menu novamente.
            switch (x) {
                case 1:
                    System.out.print("Quantos Produtos voce vai inserir? ");
                    //Repete ação até o produto ser adicionado com sucesso.
                    while (true) {
                        //Informa erro ao usuario e repete codigo se houver excessão.
                        try {
                            int n = sc.nextInt();

                            for (int i = 1; i <= n; i++) {
                                System.out.print("Nome do Produto " + i + ":");
                                sc.nextLine();
                                String name = sc.nextLine().toUpperCase();
                                System.out.print("Preco do Produto " + i + ":");
                                double price = sc.nextDouble();
                                product.addProduct(name, price);
                            }

                            if (n == 1) {
                                System.out.println("Produto adicionado com sucesso!");
                            } else {
                                System.out.println(n + " Produtos adicionado com sucesso!");
                            }
                            break;//Interrompe while do Case 1.

                        } catch (InputMismatchException e) {
                            System.out.print("INVALIDO! Tente novamente: ");
                            sc.nextLine();
                        }
                    }
                    break;//Quebra case 1

                case 2:
                    product.listProducts();
                    break;

                case 3:
                    System.out.print("Digite o ID do produto que deseja remover: ");
                    //Repete lógica até o produto ser removido.
                    while (true) {
                        try {
                            id = sc.nextInt();
                            product.removeProduct(id);
                            System.out.println("Produto removido");
                            break;
                        } catch (IdException e) {
                            System.out.print(e.getMessage() + " Tente novamente: ");
                            sc.nextLine();
                        }
                    }
                    break;

                case 4:
                    System.out.print("Digite o ID do Produto que deseja modificar ou 0 para Sair: ");


                    while (true) {
                        try {
                            id = sc.nextInt();
                            if (id == 0) {
                                break;//Fecha o while.
                            }
                            //Valida se há excessão no ID digitado, se sim, trata excessão.
                            product.idValidation(id);


                            System.out.println("O que você deseja alterar? ");
                            //Repete e trata erro enquanto entrada invalida.
                            while (true) {
                                try {
                                    System.out.println("1-Nome");
                                    System.out.println("2-Preço");
                                    System.out.println("0-Sair");
                                    alterar = sc.nextInt();
                                    break;//Quebra while e cai em switch.


                                } catch (InputMismatchException e) {
                                    System.out.println("ERRO! Digite 1 Opção numerica:");
                                    sc.nextLine();

                                }
                            }

                            //Altera Opção desejada acima.
                            switch (alterar) {
                                case 1:
                                    System.out.print("Digite o Nome: ");
                                    sc.nextLine();
                                    String name = sc.nextLine().toUpperCase();
                                    product.setName(id, name);
                                    product.printProduct(id);
                                    break;

                                case 2:
                                    System.out.print("Digite o preço: ");
                                    double price = sc.nextDouble();
                                    product.setPrice(id, price);
                                    product.printProduct(id);
                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("Opção invalida!");
                                    break;
                            }
                            break;//Quebra o while e volta ao Menu.


                        } catch (IdException e) {
                            System.out.print(e.getMessage() + " Tente novamente:");
                            sc.nextLine();
                        }
                    }
                    break;
            }

        }
        System.out.println("PROGRAMA FINALIZADO!");
        sc.close();

    }
}
