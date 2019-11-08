package com.appdirect;

import java.util.*;

/*
Checkpoint problem- create checkpoints on method call and return data by index and checkpoint id
 */
public class Solution1 {

    public static void main(String[] commands) {

        CheckpointArray obj = new CheckpointArray(0);
        Set<Integer> checkpoints = new HashSet<>();
        commands = new String[]{"new 4", "set 0 100", "set 1 200", "set 2 300", "set 3 400", "checkpoint", "get 1 0", "set 1 201", "checkpoint"
                , "get 1 1", "get 1 0"};

        int[] output = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            output[i] = -1;
        }

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            String[] tokens = command.split("\\s+");

            if ("new".equalsIgnoreCase(tokens[0])) {
                obj = new CheckpointArray(Integer.valueOf(tokens[1]));

            } else if ("set".equalsIgnoreCase(tokens[0])) {
                obj.set(Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]));

            } else if ("checkpoint".equalsIgnoreCase(tokens[0])) {
                output[i] = obj.checkpoint();
                checkpoints.add(output[i]);

            } else if ("get".equalsIgnoreCase(tokens[0])) {
                int cpId = Integer.valueOf(tokens[2]);
                if (checkpoints.contains(cpId)) {
                    output[i] = obj.get(Integer.valueOf(tokens[1]), cpId);
                }
            }
        }
        System.out.println(output);
        //return output;
    }
}

class CheckpointArray {

    private static Integer checkpointId = 0;
    Map<Integer, int[]> checkpoint = new HashMap<>();
    int[] arr;

    public CheckpointArray(int length) {
        arr = new int[length];
        Arrays.fill(arr, 0);
    }

    public void set(int index, int intVal) {
        arr[index] = intVal;
    }

    public int checkpoint() {
        int[] tempArr = Arrays.copyOf(arr, arr.length);
        checkpoint.put(checkpointId, tempArr);
        checkpointId++;
        return checkpointId - 1;
    }

    public int get(int index, int checkpointId) {
        int[] checkpointedArr = checkpoint.get(checkpointId);
        return checkpointedArr[index];
    }
}
