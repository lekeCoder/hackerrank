package com.test.hackerrant.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SherlockAndAnagram {
    private static List<String> stringPermutation = new ArrayList<>();
    private static StringBuilder output = new StringBuilder();
    private static String inputstring;
    

//    public SherlockAndAnagram(String inputstring) {
//        this.inputstring = inputstring;
//    }

    // Function to print all the permutations of str
    static void getStringPermutation(String str, String ans)
    {
        // If string is empty
        if (str.length() == 0) {
            //System.out.print(ans + " ");
            if(!stringPermutation.contains(ans)) stringPermutation.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            // ith character of str
            char ch = str.charAt(i);
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) + str.substring(i + 1);
            // Recurvise call
            getStringPermutation(ros, ans + ch);
        }
    }
    //breaks a string into different bits
    private static void combine(int start ){
        for( int i = start; i < inputstring.length(); ++i ){
            output.append( inputstring.charAt(i) );
            //System.out.println( output );
            if(!output.toString().equals(inputstring)  && !stringPermutation.contains(output.toString())) stringPermutation.add(output.toString());
            if ( i < inputstring.length() )
                combine( i + 1);
            output.setLength( output.length() - 1 );
        }
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        if(s == null || s.length() == 0) return 0;
        int pairs = 0;
        inputstring = s;
        combine(0);
        //getStringPermutation(s, "");
        System.out.println(stringPermutation.toString());
        for(int i = 0; i < stringPermutation.size(); i++){
            for(int j = 0; j < stringPermutation.size(); j++){
                //if the same index and word then skip
                if(stringPermutation.get(i).equals(stringPermutation.get(j))) {
                    continue;
                }
                char[] strArr1 = stringPermutation.get(i).toCharArray();
                char[] strArr2 = stringPermutation.get(j).toCharArray();

                if(strArr1.length != strArr2.length) continue;
                //check if chars are the same
                if(areAnagram(strArr1,strArr2)) ++pairs;

            }
        }
        output = new StringBuilder();
        stringPermutation.clear();
        return pairs;
    }

    static boolean areAnagram(char[] c1, char[] c2){
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i = 0; i < c1.length; i++){
            if(c1[i] != c2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Number of Anagrams: "+ sherlockAndAnagrams("abba"));
        //System.out.println("Number of Anagrams: "+ sherlockAndAnagrams("mom"));
        System.out.println("Number of Anagrams: "+ sherlockAndAnagrams("abcd"));
        System.out.println("Number of Anagrams: "+ sherlockAndAnagrams("cdcd"));
        System.out.println("Number of Anagrams: "+ sherlockAndAnagrams("kkkk"));
    }
}
