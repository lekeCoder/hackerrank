package com.test.hackerrant;

import java.util.Arrays;

public class MoveZeros {
    //Space Complexity: O(1) Time Complexity: O(n)
    static void moveZerosToLeft(int[] A) {
        if (A.length < 1) {
            return;
        }

        int writeIndex = A.length - 1;
        int readIndex = A.length - 1;

        while(readIndex >= 0) {
            if(A[readIndex] != 0) {
                A[writeIndex] = A[readIndex];
                writeIndex--;
            }
            readIndex--;
        }

        while(writeIndex >= 0) {
            A[writeIndex] = 0;
            writeIndex--;
        }
    }
    public static void main(String[] args) {
        //int[] v = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
        int[] v = new int[]{1,8,0,0,2,1,0,0,3,5,1,0,9,6};
        System.out.println("Original Array: " + Arrays.toString(v));

        moveZerosToLeft(v);

        System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
    }
}
