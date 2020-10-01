package com.company;

import java.util.Collection;

/**
 * Manages all transactions within the application
 */
public class TransactionManager {
    /**
     * Creates and stores transactions
     *
     * @param amount
     * @param originator
     * @param beneficiary
     * @return created Transaction
     */
    public Transaction createTransaction(double amount,
                                         Account originator,
                                         Account beneficiary) {
        Transaction transaction = createTransaction(amount, originator, beneficiary);
        return transaction;
    }

    public Collection<Transaction> findAllTransactionsByAccount(Account account) {
        if (Entry.account == account){
            findAllTransactionsByAccount(account).add(transaction);
        }
        return findAllTransactionsByAccount(account);
    }


    public void rollbackTransaction(Transaction transaction) {
        transaction.rollback();
    }

    public void executeTransaction(Transaction transaction) {
        transaction.execute();
    }
}
