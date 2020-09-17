package com.test.hackerrant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        //System.out.println(sockMerchant(9,new int[]{10,20,20,10,10,30,50,10,20}));
        moveZerosToLeft(new int[]{1,8,0,0,2,1,0,0,3,5,1,0,9,6});
    }

    //Given an integer array, move all elements that are equal to 0 to the left while   maintaining the order of other elements in the array.
    //Space Complexity: O(n) Time Complexity: O(n)
    static void moveZerosToLeft(int[] arr) {
        //iterate to know indexes of zeros
        List<Integer> zeroIndexes = new ArrayList<>();
        int j = 0;
        int firstNonZeroIndex = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0 && firstNonZeroIndex == -1) firstNonZeroIndex = i;
            if(arr[i] == 0) zeroIndexes.add(i);
        }
        System.out.println("firstNonZeroIndex: "+firstNonZeroIndex);
        for(int z : zeroIndexes){
            int z_copy = z;
           while(z_copy > firstNonZeroIndex){
               arr[z_copy] = arr[--z_copy];
           }
           if(z > firstNonZeroIndex) {
               arr[firstNonZeroIndex] = 0;
               firstNonZeroIndex++;
           }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Complete the countingValleys function below.
//    static int countingValleys(int n, String s) {
//
//
//    }

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pair = 0;
        List<Integer> colors = new ArrayList<>();
        for(int color : ar){
            if(colors.contains(color)){
                ++pair;
                colors.remove(Integer.valueOf(color));
            }
            else {
                colors.add(color);
            }
        }
        return pair;
    }

}
