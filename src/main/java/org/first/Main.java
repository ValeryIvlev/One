package org.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        //System.out.println(singleNumber(new int[]{2,2,1}));

        //System.out.println(sumIntAndDouble(20));

        //byte a = 100;

        //byte b = 200 + a;

        }

    // leetcode 136. Single Number
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i: nums){
            dict.put(i, dict.getOrDefault(i,0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (dict.get(nums[i]).equals(1)){
                return nums[i];
            }
        }
        return 0;
    }
    public static ArrayList<Double> sumIntAndDouble(int countSum){
        Random random = new Random();
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < countSum; i++) {
            list.add(random.nextInt() + random.nextDouble());
        }
        return list;
    }
}
