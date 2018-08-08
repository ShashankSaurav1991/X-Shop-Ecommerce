package com.neu.shopping.dao;

import com.neu.shopping.entity.Account;

public interface AccountDAO {
 
    public Account findAccount(String userName );
    public void register(Account user);
    
}
