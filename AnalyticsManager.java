package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        //не успеваю, но как задача: необходимо вывести уникальные ключи.
    }

    public List accountsRangeFrom(List accounts, Account minAccount, Comparator comparator){
        //задача: через компаратор отсортировать аккаунты от меньшего к большему по значению.
    }
}
