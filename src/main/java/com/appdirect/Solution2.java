package com.appdirect;

/*
Card problem- find card suit and rank from a random set of cards at the given index
 */
public class Solution2 {
    public static void main(String[] args) {
        String[] suits = new String[]{"clubs", "diamonds", "hearts", "spades"};
        String[] ranks = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int k = 32;
        System.out.println(solution(suits, ranks, k));
    }

    public static String solution(String[] suits, String[] ranks, long k) {
        // Type your solution here
        int indexSuits = 0;
        while (ranks.length < k) {
            indexSuits++;
            k = k - ranks.length;
        }

        if (ranks.length > k) {
            return ranks[(int) k] + "-of-" + suits[indexSuits];
        }
        return String.valueOf(0);
    }
}
