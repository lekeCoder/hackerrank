package com.test.hackerrant;

import java.util.*;

public class FloodFillNavigable {

    /**
     * Given a matrix, a source cell, a destination cell, some cells which cannot be visited, and some valid moves,
     * check if the destination cell can be reached from the source cell. The source is cell (0,0) and the
     * destination is cell (3,4). Cells containing X cannot be visited. Let's assume there are 4 valid moves - move
     * up, move down, move left, and move right. (flood fill)
     */

    Set<Pair> visited;
    int[][] arrays;
    Pair source = new Pair(0,0);
    Pair dest = new Pair(3,4);
    int arraySize; //assuming a square array
    int labelTag = 0;
    List<Pair> blockedCells = Arrays.asList(new Pair(0,4),new Pair(1,3),new Pair(2,1),new Pair(3,0),new Pair(4,1),
            new Pair(4,3), new Pair(3,3),new Pair(2,4));

    public FloodFillNavigable(int size){
        visited = new HashSet<>();
        arrays = new int[size][size];
        arraySize = size;
    }

    //assign weights to non-X cells
    boolean assignWeights(int x, int y){
        int[] dx= { -1, 0, 1, 0 };
        int[] dy = {0, 1, 0, -1};

        //X cells equals -1
        Pair p = new Pair(x,y);
        //if(blockedCells.contains(p) || visited.contains(p)) return false;
        if(x < 0 || x >= arraySize || y < 0 || y >= arraySize || blockedCells.contains(p) || visited.contains(p)) return false;
        System.out.println(p);
        visited.add(p);
        if(p.equals(dest)) return true;
        //arrays[x][y] = labelTag;

        //System.out.println(p);
        //check neighbors
        for(int i =0; i <= 3; i++){
            //Pair p1 = new Pair(x+dx[i], y+dy[i]);
            boolean result = assignWeights(x+dx[i],y+dy[i]);
            if(result) return true;
            //if(blockedCells.contains(p1) || visited.contains(p1)) continue;
            //arrays[x][y] = labelTag + 1;
            //visited.add(p1);
        }
        //labelTag++;
//        if(x-1 >= 0)
//        assignWeights(x-1,y);
//        assignWeights(x+1,y);
//        assignWeights(x,y-1);
//        assignWeights(x+1,y+1);

        return false;

    }

    boolean isNavigable(){
        return assignWeights(source.x, source.y);
    }

    public static void main(String[] args) {
        FloodFillNavigable floodFillNavigable = new FloodFillNavigable(5);
        System.out.println("path is possible? :"+floodFillNavigable.isNavigable());
        System.out.println("######################################################");
        System.out.println("Visited: "+floodFillNavigable.visited.toString());
    }

}

