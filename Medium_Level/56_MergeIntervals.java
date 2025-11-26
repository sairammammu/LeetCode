package Medium_Level;

import java.util.*;

/**
 * Solution for LeetCode Problem 56: Merge Intervals.
 *
 * Approach:
 * 1. Sort the intervals by their start time.
 * 2. Iterate through the sorted intervals and merge overlapping intervals into
 *    a running "current" interval; otherwise start a new one.
 * 3. Collect merged intervals in a list and convert to an array for the
 *    returned result.
 */
class Solution {

    /**
     * Sorts the 2D intervals array in-place by the start value (first column).
     * This uses a simple bubble sort for clarity. For large inputs a more
     * efficient sort (Arrays.sort with a comparator) would be preferable.
     *
     *  The intervals to sort in-place, where each subarray is
     *            [start, end].
     */
    static void sortingArray(int arr[][]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j][0] > arr[j + 1][0]) {
                    int[] temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    /**
     * Merge overlapping intervals.
     *
     *  Input intervals represented as a 2D array where each
     *                  element is [start, end].
     *  A 2D array containing merged non-overlapping intervals.
     */
    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) return intervals;

        // Sort the intervals by their starting times.
        sortingArray(intervals);

        // Use a list to store the merged intervals as we build them.
        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        list.add(current);

        // Iterate through each interval and either merge it with the current
        // interval (if they overlap) or append it as a new current interval.
        for (int[] interval : intervals) {
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // If intervals overlap, update the end of current to the max end.
            if (currentEnd >= nextStart) {
                int max = Math.max(nextEnd, currentEnd);
                current[1] = max;
            } else {
                // No overlap: move to the next interval and append it to list.
                current = interval;
                list.add(current);
            }
        }

        // Convert the result list into a 2D array matching the method signature.
        return list.toArray(new int[list.size()][]);
    }
}