package com.company;

import java.time.LocalDate;
import java.util.Collection;

public interface Account {
    double BalanceOn(); //args???
    void addEntry(Object entry);
}

public class DebitCard implements Account{
    private final long id;
    private final TransactionManager transactionManager;
    private final Entries entries;

    public DebitCard(long id, TransactionManager transactionManager) {
            this.id = id;
            this.transactionManager = transactionManager;
            this.entries = new Entries();
        }

        //Посмотреть, сколько из реализованного реально надо. И доделать. В планах переконструировать все.
        /**
         * Withdraws money from account. <b>Should use TransactionManager to manage transactions</b>
         *
         * @param amount amount of money to withdraw
         * @return true
         * if amount &gt 0 and (currentBalance - amount) &ge 0,
         * otherwise returns false
         */
        public boolean withdraw(double amount, com.company.Account beneficiary) {
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
                //currentBalance += amount  //USE TRANSACTIONMANAGER
                return true;
            } else {
                return false;
            }
        }


        public Collection<Entry> history(LocalDate from, LocalDate to) {
            //я так понимаю, тут выводятся все переводы денег с одной даты по другую
            return history(from, to);
        }


        /**
         * Finds the last transaction of the account and rollbacks it
         */
        public void rollbackLastTransaction() {
            //удалить из коллекции и энтрис, видимо (еще проверю) последнюю транзакцию
        }
    /**
     * Calculates balance on the accounting entries basis
     * @param date
     * @return balance
     */
    @Override
    public double BalanceOn() {
        //принимает дату, не выводит историю за этот день
        // history(date).containsAll();
        double balance = 100; //на основе истории вычислить баланс (не смогла придумать пока что)
        return balance;
    }

    @Override
    public void addEntry(Object entry) {
        history().add(entry);
    }
}

public class BonusAccount implements Account {
    double bonuses;
   void withdraw(double amount, Account account){
        if (account != null){
            bonuses += amount;
        }
   }

    @Override
    public double BalanceOn() {
        return bonuses;
    }

    @Override
    public void addEntry(Object entry) {
        history.add(entry);//возможно, стоит вести отдельную коллекцию с входами для начисления бонусов.
    }
}