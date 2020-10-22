package com.company;

import java.util.*;

public class AnalyticsManager {
    public double overallBalanceOfAccounts(List accounts){
        double overallBalance = 0;
        for(account : accounts){
            double balanceOfAccount = account.balanceOn();
            overallBalance += balanceOfAccount;
        }
        return overallBalance;
    }

    public Set uniqueKeysOf (List accounts, KeyExtractor keyExtractor){
        Map uniqueKeys = new HashMap();
        for (account : accounts){
            uniqueKeys.putIfAbsent(keyExtractor, account);
        }
        return uniqueKeys.keySet();
    }



    public List accountsRangeFrom(List accounts, Account minAccount, Comparator comparator){
        for (account : accounts){
            int flag = comparator(account, minAccount);
            if (flag < 0){
                minAccount = account;
            }
        }
        return accounts;
    }

   // Optional<Entry> maxExpenseAmountEntryWithinInterval(List<Account> accounts, LocalDate from, LocalDate to);
}
