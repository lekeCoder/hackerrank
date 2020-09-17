package com.test.hackerrant;

public class CountApplesAndOrangesWithinRange {
    // Complete the countApplesAndOranges function below.
//    s: integer, starting point of Sam's house location.
//    t: integer, ending location of Sam's house location.
//    a: integer, location of the Apple tree.
//    b: integer, location of the Orange tree.
//    apples: integer array, distances at which each apple falls from the tree.
//    oranges: integer array, distances at which each orange falls from the tree.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleInRange = 0, orangeInRange = 0;
        for (int apple : apples) {
            if(isRange(s,t,apple+a)) appleInRange++;
        }

        for (int orange : oranges) {
            if(isRange(s,t,orange+b)) orangeInRange++;
        }
        System.out.println(appleInRange);
        System.out.println(orangeInRange);
    }
    static boolean isRange(int lower, int upper, int number){
        if(number >= lower && number <= upper) return true;
        return false;
    }
}
