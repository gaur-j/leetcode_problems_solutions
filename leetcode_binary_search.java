package leetcode_problems_solutions;

import java.util.*;

// leetcode problem 704 Binary Search (E) 

class leetcode_binary_search {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        int index = -1;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] == target) {
                index = mid;
                return index;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return index;
    }
}

// leetcode problem 35 Search Insert Position (E)

class leetcode_binary_search_1 {
    public int searchInsert(int[] arr, int target) {
        int l = 0, h = arr.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return h + 1;
    }
}