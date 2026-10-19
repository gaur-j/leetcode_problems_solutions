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

// leetcode problem 69 Sqrt(x) (E)

class leetcode_binary_search_2 {
    public int mySqrt(int x) {
        int l = 0, h = x;

        while (l <= h) {
            int m = (l + h) / 2;
            long root = (long) m * m;
            if (root == x) {
                return m;
            } else if (root < x) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return h;
    }
}

// leetcode problem First Bad Version (E)

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 0, h = n;

        while (l <= h) {
            int m = l + (h - l) / 2;
            if (isBadVersion(m) == true) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}

// leetcode problem 69 Sqrt(x) (E)

class leetcode_binary_search_4 {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = { -1, -1 };
        int l = 0, h = nums.length - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (target < nums[m]) {
                h = m - 1;
            } else {
                ans[0] = m;
                h = m - 1;
            }
        }

        if (ans[0] == -1) {
            return ans;
        }

        l = 0;
        h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (target < nums[m]) {
                h = m - 1;
            } else {
                ans[1] = m;
                l = m + 1;
            }
        }
        return ans;
    }
}