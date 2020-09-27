package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

class CustomerTest extends Assert {
    private Customer customer;
    private final String name;
    private final String lastName;
    private final long id;
    private Account account;

    CustomerTest(String name, String lastName, long id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    @Before
    public void initTest() {
        customer = new Customer(name, lastName);
        account = new Account(id);
    }

    @After
    public void afterTest() {
        customer = null;
        account = null;
    }

    @Test
    public void testOpenAccount() {
        assertFalse(customer.openAccount(1));
        assertTrue(customer.openAccount(1));
        assertTrue(customer.openAccount(id));
    }

    @Test
    public void testCloseAccount() {
        assertTrue(customer.closeAccount());
        assertFalse(customer.closeAccount());
    }

    @Test
    public void testFullName() {
        assertSame("Customer has invalid name", customer.fullName());
        assertSame(name+lastName, customer.fullName());
    }

    @Test
    public void testWithdrawFromCurrentAccount() {
        assertTrue(customer.withdrawFromCurrentAccount(5));
        assertTrue(customer.withdrawFromCurrentAccount(500));
        assertFalse(customer.withdrawFromCurrentAccount(0));
        assertFalse(customer.withdrawFromCurrentAccount(-10));
    }

    @Test
    public void testAddMoneyToCurrentAccount() {
        assertTrue(customer.addMoneyToCurrentAccount(500));
        assertFalse(customer.addMoneyToCurrentAccount(0));
        assertFalse(customer.addMoneyToCurrentAccount(-10));
    }
}