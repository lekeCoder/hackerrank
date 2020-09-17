package com.test.hackerrant;

import java.util.ArrayList;
import java.util.List;

public class BalancePartitionedDirectories {
    /*
     * Complete the 'mostBalancedPartition' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY parent
     *  2. INTEGER_ARRAY files_size
     */

    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
        // Write your code here
//        //sort
//        parent.sort(Integer::compareTo);
        int diffSize = 0;
        List<List<Integer>> partitions = new ArrayList<>();
        List<Integer> parentDirectory = new ArrayList<>();
        int topDir = 0;
        for(int i =0; i < parent.size();i++){
            if(parent.get(i) == -1){
                //parent directory
                //parentDirectory.add(i);
                //partitions.add(parentDirectory);
                continue;
            }
            if(parent.get(i) == 0){
                //new directory
                List<Integer> newParentDir = new ArrayList<>();
                newParentDir.add(0);
                newParentDir.add(i);
                partitions.add(newParentDir);
                topDir++;
                continue;
            }

            //appends to list based on parent path
            partitions.get(parent.get(i)).add(i);
        }

        //sum of file sizes by path
        List<Integer> listOfSumsofDir = new ArrayList<>();
        for(List<Integer> dir : partitions){
            int sum = 0;
            for(int index: dir){
                sum += files_size.get(index);
            }
            listOfSumsofDir.add(sum);
        }
        //spliting by sizes
        if(listOfSumsofDir.size()>2){

        }
        else{
            diffSize = Math.abs(listOfSumsofDir.get(0) - listOfSumsofDir.get(1));
        }

        return diffSize;

    }
}
