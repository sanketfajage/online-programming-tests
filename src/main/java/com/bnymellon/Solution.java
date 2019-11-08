package com.bnymellon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Array element pairs problem- Count no of array element pairs that sums to given number
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(7);
        arr.add(9);
        arr.add(13);
        arr.add(11);
        arr.add(6);
        arr.add(6);
        arr.add(3);
        arr.add(3);

        List<Integer> arr2 = new ArrayList<>();
        arr2.add(6);
        arr2.add(12);
        arr2.add(3);
        arr2.add(9);
        arr2.add(3);
        arr2.add(5);
        arr2.add(1);

        countPairs(arr, 12);
        countPairs(arr2, 12);
    }

    public static int countPairs(List<Integer> arr, long k) {
        // Write your code here
        arr = arr.stream().sorted().collect(Collectors.toList());
        Map<String, Long> map = new HashMap<>();
        for (Integer i : arr) {
            if (i <= k && i <= (k - i) && arr.contains((int) k - i)) {
                map.put(i + "_" + (k - i), (long) (i + (i + 1)));
            }
        }
        return map.size();
    }
}
