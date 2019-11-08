package com.bnymellon;

import java.util.ArrayList;
import java.util.List;

/*
Shortest path problem- Find shortest path value from one song to another in a playlist
 */
public class Solution2 {
    public static void main(String[] args) {
        List<String> songs = new ArrayList<>();
        songs.add("abc");
        songs.add("xyz");
        songs.add("pqr");
        songs.add("yfshli");
        songs.add("dfg");
        songs.add("lmn");
        songs.add("jhgdzj");
        songs.add("dfg");
        playlist(songs, 1, "dfg");
    }

    public static int playlist(List<String> songs, int k, String q) {
        // Write your code here
        int firstSearchSongIdx = songs.indexOf(q);
        int lastSearchSongIdx = songs.lastIndexOf(q);
        int size = songs.size();
        int minSteps = k;
        if (firstSearchSongIdx != -1) {
            int temp = firstSearchSongIdx - k;
            int temp2 = (size - lastSearchSongIdx + k);
            minSteps = Math.min(temp, temp2);
        }
        return minSteps;
    }
}
