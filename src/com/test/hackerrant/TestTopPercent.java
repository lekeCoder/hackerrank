package com.test.hackerrant;

import java.util.*;
import java.util.stream.Collectors;

public class TestTopPercent {

    /*
     * Complete the 'mostActive' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY customers as parameter.
     *
     *
     */

    public static List<String> mostActive(List<String> customers) {
        // Write your code here
        Map<String, Integer> custMap = new HashMap<>();
        for(String customer:customers){
            if(custMap.containsKey(customer)){
                //update count
                custMap.put(customer, custMap.get(customer)+1);
            }
            else {
                custMap.put(customer, 1);
            }
        }
        double five_percent = ((double)5/100)*customers.size();
        TreeSet<String> top5CustSet = new TreeSet<>();
        for(Map.Entry<String, Integer> entry :  custMap.entrySet()){
            if(entry.getValue() >= Math.ceil(five_percent)){
                top5CustSet.add(entry.getKey());
            }
        }
        System.out.println("Top5: "+top5CustSet.toString());
        return new ArrayList<>(top5CustSet);

    }

}
