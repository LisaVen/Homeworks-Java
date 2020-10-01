package com.company;
import org.w3c.dom.html.HTMLImageElement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Account {
    private final long id;
    private final TransactionManager transactionManager;
    private final Entries entries;

    public Account(long id, TransactionManager transactionManager) {
        this.id = id;
        this.transactionManager = transactionManager;
        this.entries = new Entries();
    }

    /**
     * Withdraws money from account. <b>Should use TransactionManager to manage transactions</b>
     *
     * @param amount amount of money to withdraw
     * @return true
     * if amount &gt 0 and (currentBalance - amount) &ge 0,
     * otherwise returns false
     */
    public boolean withdraw(double amount, Account beneficiary) {
        if (amount > 0 & (currentBalance - amount) >= 0){
            //delete amount from currentBalance whatever it is
            entries.addEntry(beneficiary);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Withdraws cash money from account. <b>Should use TransactionManager to manage transactions</b>
     *
     * @param amount amount of money to withdraw
     * @return true
     * if amount &gt 0 and (currentBalance - amount) &ge 0,
     * otherwise returns false
     */
    public boolean withdrawCash(double amount) {
        if (amount > 0 & (currentBalance - amount) >= 0){
            //delete amount from currentBalance whatever it is
            //I should use TransactionManager
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds cash money to account. <b>Should use TransactionManager to manage transactions</b>
     *
     * @param amount amount of money to add
     * @return true
     * if amount &gt 0,
     * otherwise returns false
     */
    public boolean addCash(double amount) {
        // write your code here
        if (amount > 0){
            //currentBalance += amount //BABY USE TRANSACTIONMANAGER
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds money to account. <b>Should use TransactionManager to manage transactions</b>
     *
     * @param amount amount of money to add
     * @return true
     * if amount &gt 0,
     * otherwise returns false
     */
    public boolean add(double amount) {
        if (amount > 0){
            Transaction createTransaction(amount);
            entries.addEntry(originator); //originator??????
            //currentBalance += amount BABY USE TRANSACTIONMANAGER
            return true;
        } else {
            return false;
        }
    }


    public Collection<Entry> history(LocalDate from, LocalDate to) {

        //я так понимаю, тут выводятся все переводы деняк с одной даты по другую
        return history(from, to);
    }

    /**
     * Calculates balance on the accounting entries basis
     * @param date
     * @return balance
     */
    public double balanceOn(LocalDate date) {
        //принимает дату, не выводит историю за этот день
       // history(date, date).containsAll();
        double balance = 100; //на основе истории вычислить баланс
        return balance;
    }

    /**
     * Finds the last transaction of the account and rollbacks it
     */
    public void rollbackLastTransaction() {
        //удалить из коллекции и энтрис, видимо (еще проверю) последнюю транзакцию
    }
}

public class Transaction {
    private final long id;
    private final double amount;
    private final Account originator;
    private final Account beneficiary;
    private final boolean executed;
    private final boolean rolledBack;
//странное мероприятие с объявлениями переменных, но ладно.
    public Transaction(long id, double amount, Account originator, Account beneficiary, boolean executed, boolean rolledBack) {
        this.id = id;
        this.amount = amount;
        this.originator = originator;
        this.beneficiary = beneficiary;
        this.executed = executed;
        this.rolledBack = rolledBack;
    }

    /**
     * Adding entries to both accounts
     * @throws IllegalStateException when was already executed
     */
    public Transaction execute() {
        // write your code here
        Entries entries;
        if (originator == null){ //прописать условия
            entries.addEntry(originator); //на самом деле здесь добавить вход, надо посмотреть, как к конкретному аккаунту добавить его.
            entries.addEntry(beneficiary);
        } else {
            //throw IllegalStateException("It was already executed");
            return null; //сверху ошибка, надо почитать, как выкидывать исключения
        }
        return execute();
    }

    /**
     * Removes all entries of current transaction from originator and beneficiary
     * @throws IllegalStateException when was already rolled back
     */
    public Transaction rollback() {
        // write your code here
        if (originator == null){ //прописать условия
            history(originator).removeAll; //на самом деле здесь удалить вход, я думаю, а там посмотрим.
            history(beneficiary).removeAll;
        } else {
            //throw IllegalStateException("It was already rolled back");
            return null; //сверху ошибка, надо почитать, как выкидывать исключения
        }
        return rollback();
    }
}


public class AnalyticsManager {
    private final TransactionManager transactionManager;

    public AnalyticsManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public Account mostFrequentBeneficiaryOfAccount(Account account) {
        // write your code here
        Account mostAccount = null;
        long maxB = 0;
        if (Entry.contains(account)){ //ну вы поняли как-то это прописать
            if (transactionManager.findAllTransactionsByAccount(account).size() > maxB) {
                maxB = transactionManager.findAllTransactionsByAccount(account).size();
                mostAccount = account;
            }
        };
        return mostAccount;
        //вывести самый часто встречающийся бенефишиари
    }

    public Collection<Transaction> topTenExpensivePurchases(Account account) {
        findAllTransactionsByAccount(account).toArray().sorted;
        findAllTransactionsByAccount(account).subList(-10, -1);
        return topTenExpensivePurchases(account);
    }
}

