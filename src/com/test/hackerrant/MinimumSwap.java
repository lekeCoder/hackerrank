package com.test.hackerrant;

import java.util.Arrays;

public class MinimumSwap {
    /*
     * Complete the 'minimumSwaps' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING status as parameter.
     */

    public static int minimumSwaps(String status) {
        int swapCount = 0;
        char[] chars = status.toCharArray();
        //int size = chars.length;
        int rCnt = status.indexOf('R');
        int sCnt = status.indexOf('S');
        if(rCnt > sCnt) chars[0] = 'R';
        else chars[0] = 'S';
        //if(chars[0] != 'R' && chars[0] != 'S') return 0;
        for(int i = 1; i < chars.length; i++){
            //System.err.println("char at i: "+chars[i]+"  "+i);
            if(chars[i-1] == chars[i]){
                if(chars[i]=='R')
                    chars[i] = 'S';
                else
                    chars[i] = 'R';
                swapCount++;
            }

        }
        System.err.println("output: "+ Arrays.toString(chars));

        return swapCount;
    }
//    public static int minimumSwaps(String status) {
//        int swapCount = 0;
//        char[] chars = status.toCharArray();
//        int size = chars.length;
//        if(chars[0] != 'R' && chars[0] != 'S') return 0;
//        for(int i = 0; i < chars.length; i+=2){
//            System.err.println("char at i: "+chars[i]+"  "+i);
//            if(((i+1) < size) && chars[i] == chars[i+1]){
//                if(chars[i]=='R')
//                    chars[i+1] = 'S';
//                else
//                    chars[i+1] = 'R';
//                swapCount++;
//            }
//
//        }
//        System.err.println("output: "+ Arrays.toString(chars));
//
//        return swapCount;
//    }

    public static void main(String[] args) {
        //System.out.println("Swap Count: "+ minimumSwaps("SRRRRRSSSSSRSRS"));
        System.out.println("Swap Count: "+ minimumSwaps("RSSRRRS"));
    }
}
