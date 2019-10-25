package com.company;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /*write a program to rotate a string and to find the minimum no. of iterations to get max suffix
        that is same for the strings.
         */

        System.out.println("Enter string 1:");
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        System.out.println("Enter string 2:");
        String s2 = scanner.nextLine();
        scanner.close();


        char[] e = new char[s2.length()];


           // To store the iteration number and the count value in map.
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<Integer, Integer>();

        for (int p = 0; p <= s2.length() - 1; p++) {
            for (int n = 0; n <= s2.length() - 2; n++) {
                e[n] = s2.charAt(n + 1);
                e[s2.length() - 1] = s2.charAt(0);
            }

            s2 = String.valueOf(e);
            int x = Math.min(s2.length(), s1.length());

            int counter = 0;
            try {
                for (int l= 0; l <= x; l++) {
                    if (s2.charAt(l) == s1.charAt(l)) {
                        counter = counter + 1;
                    }else{
                        break;  //to break out of loop and only increment counter for consequtive values.
                    }

                }
            }catch (StringIndexOutOfBoundsException e1){}

            map.put(p+1,counter);

        }

        LinkedHashMap<Integer,Integer> last_map=new LinkedHashMap<Integer, Integer>();
        int d=0;
        for (int n:map.keySet()
             ) {
            d=Math.max(map.get(n),d);
        }
        for (int u:map.keySet()){
            if (map.get(u)==d){
                last_map.put(u,d);
            }
        }

        int x=10000;
        for (int g:last_map.keySet()){
            x=Math.min(g,x);
        }

        int v=0; //for checking if no iteration satisfies
        for (int fc:last_map.keySet()){
            v=last_map.get(fc)+v;
        }

        int iterations=(v==0)? -1:x;
        // -1 means no iteration can satisfy




        System.out.println(map);
        System.out.println(last_map);
        System.out.println(iterations);
    }
}






