package problemSolution.heapp;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RelativeRanks506 {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Max heap: {score, index}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]
        );

        // push all elements into heap
        for (int i = 0; i < n; i++) {
            maxHeap.offer(new int[]{score[i], i});
        }

        int rank = 1;

        // extract in descending order
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int idx = curr[1];

            if (rank == 1) {
                result[idx] = "Gold Medal";
            } else if (rank == 2) {
                result[idx] = "Silver Medal";
            } else if (rank == 3) {
                result[idx] = "Bronze Medal";
            } else {
                result[idx] = String.valueOf(rank);
            }

            rank++;
        }

        return result;
    }

    static void main() {
        int[] score = {10, 3, 8, 9, 4};
        var result = findRelativeRanks(score);
        Arrays.stream(result).forEach(System.out::println);
    }
}
