package com.finance.tracker;

import java.util.Scanner;
import java.util.List;
import com.finance.tracker.model.*;
import com.finance.tracker.repository.*;
import com.finance.tracker.service.*;

public class ConsoleApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TransactionRepository transactionRepository = new InMemoryTransactionRepository();
        TransactionService transactionService = new TransactionService(transactionRepository);
        CategoryRepository categoryRepository = new InMemoryCategoryRepository();
        CategoryService categoryService = new CategoryService(categoryRepository);

        categoryService.addCategory(new Category("Salario", 1, TransactionType.REVENUE));
        categoryService.addCategory(new Category("Alimentação", 2, TransactionType.EXPENSES));

        boolean exitMainMenu = false;
        while (!exitMainMenu) {
            int mainMenu;
            System.out.println("=== Rastreador de Finanças Pessoais ===");
            System.out.println("1. Adicionar Transação (Receita/Despesa)");
            System.out.println("2. Adicionar nova Categoria");
            System.out.println("3. Listar Todas as Transações");
            System.out.println("4. Visualizar Saldo e Resumo");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção: ");

            try {
                mainMenu = Integer.parseInt(sc.nextLine());
                if (mainMenu >= 1 && mainMenu <= 5) {
                    switch (mainMenu) {
                        case 1:
                            boolean newTransaction = false;
                            while (!newTransaction) {
                                try {
                                    System.out.println("\n--- Cadastrar Nova Transação ---");
                                    System.out.print("Digite o ID da transação: ");
                                    int id = Integer.parseInt(sc.nextLine());

                                    System.out.print("Digite o valor: R$ ");
                                    double value = Double.parseDouble(sc.nextLine());

                                    System.out.print("Digite a descrição: ");
                                    String desc = sc.nextLine();

                                    System.out.print("Qual o tipo de Transação? (1 - Receita, 2 - Despesa): ");
                                    int option = Integer.parseInt(sc.nextLine());
                                    if (option != 1 && option != 2) {
                                        throw new IllegalArgumentException(
                                                "A opção desejada não é válida. Por favor, tente novamente.");
                                    }
                                    TransactionType selectedType = (option == 1) ? TransactionType.REVENUE
                                            : TransactionType.EXPENSES;

                                    System.out.println("Escolha uma categoria para a transação.");
                                    System.out.println("Lista de Categorias Disponiveis.");

                                    List<Category> categories = categoryService.getAllCategory();
                                    for (Category c : categories) {
                                        if (c.getType() == selectedType) {
                                            System.out.println("  " + c.getId() + " - " + c.getName() + " ("
                                                    + (c.getType() == TransactionType.REVENUE ? "Receita" : "Despesa")
                                                    + ")");
                                        }

                                    }

                                    System.out.println("Digite o ID da categoria escolhida");
                                    int catId = Integer.parseInt(sc.nextLine());

                                    Category selectedCategory = null;

                                    for (Category c : categories) {
                                        if (c.getId() == catId) {
                                            selectedCategory = c;
                                            break;
                                        }
                                    }

                                    if (selectedCategory == null) {
                                        throw new IllegalArgumentException("ID DA CATEGORIA NÃO ENCONTRADO");
                                    }
                                    if (selectedCategory.getType() != selectedType) {
                                        throw new IllegalArgumentException(
                                                "A categoria escolhida não corresponde ao tipo de transação, tente novamente.");
                                    }

                                    transactionService.addTransaction(
                                            new Transaction(id, value, desc, selectedType, selectedCategory));
                                    System.out.println("A transação foi salva com sucesso!");

                                    newTransaction = true;

                                } catch (Exception e) {
                                    System.out.println("\nErro: " + e.getMessage() + " Tente novamente.");
                                }
                            }
                            break;
                        case 2:
                            boolean newCategory = false;
                            while (!newCategory) {
                                try {
                                    System.out.println("Cadastrar nova categoria: \n");
                                    System.out.println("Digite o ID da categoria: ");
                                    int catId = Integer.parseInt(sc.nextLine());

                                    System.out.println("Informe o nome da categoria: ");
                                    String catName = sc.nextLine();

                                    System.out.print("Qual o tipo de Transação? (1 - Receita, 2 - Despesa): ");
                                    int option = Integer.parseInt(sc.nextLine());
                                    if (option != 1 && option != 2) {
                                        throw new IllegalArgumentException(
                                                "A opção desejada não é válida. Por favor, tente novamente.");
                                    }
                                    TransactionType selectedType = (option == 1) ? TransactionType.REVENUE
                                            : TransactionType.EXPENSES;

                                    categoryService.addCategory(new Category(catName, catId, selectedType));
                                    System.out.println("A categoria foi salva com sucesso !");
                                    newCategory = true;
                                } catch (Exception e) {
                                    System.out.println("\nErro: " + e.getMessage() + " Tente novamente.");
                                }

                            }
                            break;
                        case 3:
                            System.out.println("\n=== Lista de Transações ===");
                            if (transactionService.getAllTransactions().isEmpty()) {
                                System.out.println("Nenhuma transação cadastrada até o momento!");
                            } else {
                                for (Transaction currentTransaction : transactionService.getAllTransactions()) {
                                    System.out.println(currentTransaction);
                                    System.out.println("--------------------------------");
                                }
                            }
                            break;
                        case 4:
                            System.out.println("\n=== Resumo de Finanças ===");
                            if (transactionService.getAllTransactions().isEmpty()) {
                                System.out.println("Nenhuma transação cadastrada até o momento!");
                            } else {
                                System.out.println("Total de Receita: " + transactionService.calculateAllRevenue());
                                System.out.println("Total de Gastos: " + transactionService.calculateAllExpenses());
                                System.out.println("Saldo Liquido: " + transactionService.calculateBalance());
                            }
                            break;
                        case 5:
                            System.out.println("Finalizando aplicação ! Agradecemos a preferencia.");
                            exitMainMenu = true;
                            break;
                    }
                } else {
                    System.out.println("Opção invalida, digite uma opção valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("A entrada não é compativel com o tipo esperado (INT)");
            }
        }

    }
}
