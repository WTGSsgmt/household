package com.household_accounts.ks.householdaccounts;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by keisuke on 2018/04/07.
 */

public class Resources {
    private String type;
    private String amount;
    private String datetime;

    public Resources(String type,
                     String amount,
                     String datetime) {
        this.type = type;
        this.amount = amount;
        this.datetime = datetime;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> hashmap = new HashMap<>();
        hashmap.put("type", type);
        hashmap.put("amount", amount);
        hashmap.put("datetime", datetime);
        return hashmap;
    }
}
