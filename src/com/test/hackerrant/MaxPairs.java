package com.test.hackerrant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxPairs {

    /*
     * Complete the 'maxPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY skillLevel
     *  2. INTEGER minDiff
     */

    public static int maxPairs(List<Integer> skillLevel, int minDiff) {
        // Write your code here
        //sort
        skillLevel = skillLevel.stream().sorted().collect(Collectors.toList());
        int maxPairCount = 0;
        for(int i = 0; i < skillLevel.size(); i++){
            for(int j = i+1; j < skillLevel.size(); j++ ){
                int diff = Math.abs(skillLevel.get(i) - skillLevel.get(j));
                if(diff >= minDiff){

                    maxPairCount++;
                    System.err.print("["+skillLevel.get(i)+","+skillLevel.get(j)+"] , ");
                    skillLevel.remove(j);
                    break;
                }
            }
        }
        return maxPairCount;
    }

    public static int maxPairs2(List<Integer> skillLevel, int minDiff) {
        // Write your code here
        //sort
        skillLevel = skillLevel.stream().sorted().collect(Collectors.toList());
        int maxPairCount = 0;
        for(int i = 0; i < skillLevel.size(); i++){
            for(int j = i+1; j < skillLevel.size(); j++ ){
                int diff = Math.abs(skillLevel.get(i) - skillLevel.get(j));
                if(diff >= minDiff){

                    maxPairCount++;
                    System.err.print("["+skillLevel.get(i)+","+skillLevel.get(j)+"] , ");
                    skillLevel.remove(j);
                    skillLevel.remove(i);
                    break;
                }
            }
        }
        return maxPairCount;
    }

    public static void main(String[] args) {
        Integer[] players = {1,2,3,4,5,6};
        System.out.println(maxPairs2(Arrays.asList(players), 4));
    }

}
