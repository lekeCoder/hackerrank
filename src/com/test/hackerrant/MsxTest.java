package com.test.hackerrant;

import java.util.*;
import java.util.Comparator;

public class MsxTest {

    public static int addNumbers(float a, float b) {
        // Write your code here
        double sum = a + b;
        return (int) Math.floor(sum);
    }
    /*
     * Complete the 'winner' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING erica
     *  2. STRING bob
     */

    public static String winner(String erica, String bob) {
        // Write your code here
        int ericaScore = 0, bobScore = 0;
        if(!erica.isEmpty()){
            for(char diff: erica.toCharArray()){
                ericaScore += getPoints(diff);
            }
        }

        if(!bob.isEmpty()){
            for(char diff: bob.toCharArray()){
                bobScore += getPoints(diff);
            }
        }

        if(ericaScore > bobScore) return "Erica";
        if(bobScore > ericaScore) return "Bob";
        return "Tie";
    }

    public static int getPoints(char difficult){
        switch(difficult){
            case 'E': return 1;
            case 'M': return 3;
            case 'H': return 5;
            default: return 0;
        }
    }
}

/*
 * Create the Circle, Square, Rectangle and ShapeFactory class.
 */
interface ShapeAction {
    void drawShape();
}

class Shape implements ShapeAction {

    @Override
    public void drawShape() {
        //System.out.println("Drawing a Square");
    }
}
class Square extends Shape {

    @Override
    public void drawShape() {
        System.out.println("Drawing a Square.");
    }
}

class Circle extends Shape {

    @Override
    public void drawShape() {
        System.out.println("Drawing a Circle.");
    }
}

class Rectangle extends Shape {

    @Override
    public void drawShape() {
        System.out.println("Drawing a Rectangle.");
    }
}

class ShapeFactory {

    Shape mShape;
    public void drawShape(String type) {
        switch (type){
            case "Circle":
                mShape = new Circle();
                mShape.drawShape();
                break;
            case "Rectangle":
                mShape = new Rectangle();
                mShape.drawShape();
                break;
            case "Square":
                mShape = new Square();
                mShape.drawShape();
                break;
            default:
                System.out.println("Drawing "+type+" is not supported");
        }
    }
}

class CountPairsEqualToK {

    /*
     * Complete the 'countPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY numbers
     *  2. INTEGER k
     */

    public static int countPairs(List<Integer> numbers, int k) {
        // Write your code here
        Set<List<Integer>> distinctPair = new HashSet<>();
        for(int i=0; i < numbers.size(); i++){
            for(int j=1; j < numbers.size(); j++){
                if((numbers.get(i) + k) ==  numbers.get(j)) {
                        List<Integer> newPair = Arrays.asList(numbers.get(i), numbers.get(j));
                        distinctPair.add(newPair);
                        break;
                }
            }
        }

        return distinctPair.size();

    }

    public static void main(String[] args) {
       // Integer numbers[] = {1, 2, 3, 4, 5, 6 };
        //Integer numbers[] = {1, 1, 2, 2, 3, 3 };
        Integer numbers[] = {1, 2, 5, 6, 9, 10 };
        int result = countPairs(Arrays.asList(numbers), 2);
        System.out.println("Count Pairs: k= "+2+ " is "+result);
    }

    /*
     * Complete the 'fetchItemsToDisplay' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY items
     *  2. INTEGER sortParameter
     *  3. INTEGER sortOrder
     *  4. INTEGER itemsPerPage
     *  5. INTEGER pageNumber
     */

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        // Write your code here
        items.sort(new TreeComp(sortParameter,sortOrder));
        List<String> itemList = new ArrayList<>();
        int pageIndex = pageNumber == 0 ? 0 : itemsPerPage * pageNumber-1;
        for(int i = 0; i < items.size(); i++){
            int cnt = itemsPerPage;
            if(i >= pageIndex){
                if(cnt > 0){
                    itemList.add(items.get(i).get(0));
                }
            }
        }


        return itemList;

    }

    static class TreeComp implements Comparator<List<String>> {

        int compField = 0;
        boolean sortAsc = true;

        public TreeComp(int compField, int sortOrder) {
            this.compField = compField;
            this.sortAsc = sortOrder == 0;
        }

        @Override
        public int compare(List<String> o1, List<String> o2) {
            if(compField == 0){
                return sortAsc ? o1.get(0).compareTo(o2.get(0)) : o2.get(0).compareTo(o1.get(0));
            }
            if(compField == 1){
                return sortAsc ? o1.get(1).compareTo(o2.get(1)) : o2.get(1).compareTo(o1.get(1));
            }
            return sortAsc ? o1.get(2).compareTo(o2.get(2)) : o2.get(2).compareTo(o1.get(2));
        }
    }

}
