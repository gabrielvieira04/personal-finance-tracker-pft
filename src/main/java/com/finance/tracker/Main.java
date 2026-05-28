package com.finance.tracker;

import com.finance.tracker.model.*;
import com.finance.tracker.repository.*;
import com.finance.tracker.service.*;

public class Main {
    public static void main(String[] args) {

        TransactionRepository repository = new InMemoryTransactionRepository();
        TransactionService service = new TransactionService(repository);

        Category salary = new Category("Salario", 1, TransactionType.REVENUE);
        Category food = new Category("Alimentacao", 2, TransactionType.EXPENSES);

        Transaction salaryIn = new Transaction(1, 2500.00, "Salario Mensal", salary.getType(), salary);
        Transaction lunch = new Transaction(2, 250.50, "Compras", food.getType(), food);

        service.addTransaction(salaryIn);
        service.addTransaction(lunch);

        System.out.println("----------PFT-DEVBUILD----------");
        System.out.println("Lista de Transaçöes: ");
        for (Transaction transaction : service.getAllTransactions()) {
            System.out.println(transaction);
        }
        System.out.println("--------------------------------");
        System.out.println("Total de entradas: R$ " + service.calculateAllRevenue());
        System.out.println("Total de gastos: R$ " + service.calculateAllExpenses());
        System.out.println("Balanço Liquido: R$ " + service.calculateBalance());
    }
}
