package com.test.hackerrant;

import java.util.ArrayList;



class MergeIntervals{
    static class Pair{
        public int first;
        public int second;

        public Pair(int x, int y){
            this.first = x;
            this.second = y;
        }
    }
    static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {
        ArrayList<Pair> result = new ArrayList<>();
        // write your code here
        int start = Integer.MIN_VALUE, end = Integer.MAX_VALUE;
        for(Pair p : v){
            if(start == Integer.MIN_VALUE && end == Integer.MAX_VALUE) {
                start = p.first;
                end = p.second;
                continue;
            }
            if(p.first <= end){
                if(p.second > end)
                    end = p.second;
            }
            else {
                result.add(new Pair(start,end));
                start = p.first; end = p.second;

            }

        }
        result.add(new Pair(start,end));
        return result;
    }

    //https://www.educative.io/m/merge-overlapping-intervals
    static ArrayList<Pair> mergeIntervals2(ArrayList<Pair> v) {

        if(v == null || v.size() == 0) {
            return null;
        }

        ArrayList<Pair> result = new ArrayList<Pair>();

        result.add(new Pair(v.get(0).first, v.get(0).second));

        for(int i = 1 ; i < v.size(); i++) {
            int x1 = v.get(i).first;
            int y1 = v.get(i).second;
            int x2 = result.get(result.size() - 1).first;
            int y2 = result.get(result.size() - 1).second;

            if(y2 >= x1) {
                result.get(result.size() - 1).second = Math.max(y1, y2);
            } else {
                result.add(new Pair(x1, y1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Pair> v = new ArrayList<>();

        v.add(new Pair(1, 5));
        v.add(new Pair(3, 7));
        v.add(new Pair(4, 6));
        v.add(new Pair(6, 8));
        v.add(new Pair(10, 12));
        v.add(new Pair(11, 15));
        v.add(new Pair(15, 25));
        v.add(new Pair(30, 45));

        ArrayList<Pair> result = mergeIntervals(v);

        for(int i=0; i<result.size(); i++){
            System.out.print(String.format("[%d, %d] ", result.get(i).first, result.get(i).second));
        }
    }
}
