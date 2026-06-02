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

        while (true) {
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
                                    TransactionType type = (option == 1) ? TransactionType.REVENUE
                                            : TransactionType.EXPENSES;
                                } catch (Exception e) {
                                    System.out.println("\nErro: " + e.getMessage() + " Tente novamente.");
                                }
                            }
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
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
