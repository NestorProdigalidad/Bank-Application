package com.atmApp;

import java.util.HashMap;

public class Database {
    HashMap<Integer,Account> accountDatabase = new HashMap<Integer,Account>();

    transactionHistory transactionHistory;
    public Database(){
    }

    public Account newAccount(Account newAccount){
        Account account = newAccount;
        accountDatabase.put(account.getId(),account);
        return account;
    }

}
