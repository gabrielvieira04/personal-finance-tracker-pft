package com.finance.tracker;

import java.util.Scanner;
import com.finance.tracker.model.*;
import com.finance.tracker.repository.*;
import com.finance.tracker.service.*;

public class ConsoleApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TransactionRepository transactionRepository = new InMemoryTransactionRepository();
        TransactionService transactionService = new TransactionService(transactionRepository);
        CategoryRepository categoryRepository = new InMemoryCategoryRepository();

        while (true) {
            int mainMenu;
            System.out.println("=== Rastreador de Finanças Pessoais ===");
            System.out.println("1. Adicionar Transação (Receita/Despesa)");
            System.out.println("2. Listar Todas as Transações");
            System.out.println("3. Visualizar Saldo e Resumo");
            System.out.println("4. Sair");
            System.out.println("Escolha uma opção: ");

            try {
                mainMenu = Integer.parseInt(sc.nextLine());
                if (mainMenu >= 1 && mainMenu <= 4) {
                    switch (mainMenu) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
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
