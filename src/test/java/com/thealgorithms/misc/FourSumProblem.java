package com.thealgorithms.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public final class FourSumProblem {
    private FourSumProblem() {
    }

    /**
     * The function "fourSum" takes an array of integers and a target integer as input, and returns
     * a list of unique quadruplets such that their sum is equal to the target.
     * 
     * More details on the Four Sum problem can be found at:
     * https://www.interviewkickstart.com/blogs/problems/4sum
     * 
     * 
     * @param nums An array of integers.
     * @param target The target sum that we are trying to find using four numbers from the given array.
     * @return A list of unique quadruplets where the sum of elements equals the target.
     * @author Yashwant Singh (https://github.com/yashwantS2)
     */

    public static List<List<Integer>> fourSum(final int[] nums, final int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // Skip duplicates for the third element
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        // Skip duplicates for the fourth element
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
