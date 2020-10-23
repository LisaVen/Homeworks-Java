package com.company;

import java.time.LocalDate;
import java.util.*;

public class AnalyticsManager {
    public double overallBalanceOfAccounts(List accounts){
        double overallBalance = 0;
        overallBalance = accounts.stream().mapToDouble(account -> account.balanceOn).sum();
        return overallBalance;
    }

    public Set<KeyExtractor> uniqueKeysOf (List accounts, KeyExtractor keyExtractor){
        Map<KeyExtractor, Object> uniqueKeys = new HashMap<KeyExtractor, Object>();
        accounts.stream()
                .forEach(account -> uniqueKeys.putIfAbsent(keyExtractor, account));
        return uniqueKeys.keySet();
    }

    public List accountsRangeFrom(List accounts, Account minAccount, Comparator comparator){
        accounts.stream()
                .filter(account -> account.id - minAccount.id < 0)
                .forEach(account -> accounts.sort(comparator));
        return accounts;
    }

    Optional<Entry> maxExpenseAmountEntryWithinInterval(List<Account> accounts, LocalDate from, LocalDate to) {
        double maxAmount = 0;
        /* history(from, to);
        * accounts.stream()
        *         .filter(account -> account.withdraw(double amount))
                  .sorted(new AmountComparator());
        *  сравнить их по сумме и затем взять последний аккаунт, и Entry на ту сумму соответственно.*/
        return null;
    }
}
