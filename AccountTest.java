package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class AccountTest extends Assert{
    private Account account;
    private final long id;
    private double balance;

    public AccountTest(long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    @Before
    public void initTest() {
        account = new Account(id);
    }

    @After
    public void afterTest() {
        account = null;
    }

    @Test
    public void testWithdraw() {
        assertTrue(account.withdraw(5));
        assertTrue(account.withdraw(500));
        assertFalse(account.withdraw(0));
        assertFalse(account.withdraw(-10));
    }

    @Test
    public void testAdd() {
        assertTrue(account.add(500));
        assertFalse(account.add(0));
        assertFalse(account.add(-10));
    }
}