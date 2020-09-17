package com.test.hackerrant;

public class KangarooRacc {
    // Complete the kangaroo function below.
    //0,3,4,2
    static String kangaroo(int x1, int v1, int x2, int v2) {
//        int firstKangarooJump = x1 + v1;
//        int secondKangarooJump = x2 + v2;
//        if(firstKangarooJump == secondKangarooJump) return "YES";
//        int diff_1 = Math.abs(firstKangarooJump - secondKangarooJump);
//        int diff_2 = Math.abs((firstKangarooJump += (4 * v1)) - (secondKangarooJump += (4 * v2)));
//        if(diff_2 > diff_1) //if difference increases with speed, then they can meet
//            return "NO";
//        return "YES";
        if((v1 -v2) != 0 && (x1 - x2)%(v1 - v2) == 0 && v1 > v2 ) return "YES";
        return "NO";

    }

    public static void main(String[] args) {
        System.out.println(kangaroo(43, 2, 70, 2));
        System.out.println(kangaroo(0,3,4,2));
        System.out.println(kangaroo(21, 6, 47, 3));
    }

}
