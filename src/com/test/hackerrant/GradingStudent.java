package com.test.hackerrant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradingStudent {
    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // upgrade to next multiple of 5 if the difference is less than 3
        List<Integer>  result = new ArrayList<>();
        for(int grade : grades){
            if(grade < 38) result.add(grade);
            else {
                int prin = grade/5;
                int nx_mul_5 = prin*5+5;
                if(nx_mul_5 - grade < 3) result.add(nx_mul_5);
                else result.add(grade);

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] grades = {73 ,67 ,38 ,33};
        List<Integer> resp = gradingStudents(Arrays.asList(grades));
        System.out.println(resp);
    }
}
