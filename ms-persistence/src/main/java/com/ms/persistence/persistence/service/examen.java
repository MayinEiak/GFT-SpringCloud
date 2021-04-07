package com.ms.persistence.persistence.service;

import java.util.*;
import java.util.stream.IntStream;

public class examen {

    public static int solution(int[] A){
        int res = 0;
        List<Integer> arr = new ArrayList<Integer>();
        int min = IntStream.of(A).min().getAsInt();
        BitSet b = new BitSet();
        for (int i : A)
            b.set(i - min);
        int i = 0;
        while ((i = b.nextClearBit(i + 1)) < b.length()) {
            arr.add(i + min);
        }

        if( arr.size() > 0){
            if(arr.get(0) <= 0 )
                res = 1;
            else
                res = arr.get(0);
        }

        if( arr.size() == 0 && A.length > 0){
            res = A[A.length-1]+1;
        }

        return res;
    }


    public static void main(String args[]){
        System.out.println("Hola");
        /*int res = solution(new int[]{ 4, 2, 4, 5 });
        System.out.println("res: " + res);*/
        try {
            test2(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("res2: " + find_min(new int[]{ 10, 11, 12, 13 }));


    }

    public static int[] test2 (int N) throws Exception {
        int[] arr = new int[N];
        int low = 1;
        int high = 1000;

        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(high-low) + low;
        }

        return arr;
    }

    public static int find_min(int[] A){
        System.out.println("find_min");
        int ans = 0;
        for (int i = 1; i< A.length; i ++){
            if(ans>A[i]){
                ans = A[i];
            }
        }
        return ans;
    }


}
