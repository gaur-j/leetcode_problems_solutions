package leetcode_problems_solutions;

import java.util.*;

// leetcode problem 88 Merge Sorted Array (E)

class leetcode_sorting {
    static int[] mergeSort(int[] nums1, int[] nums2, int m, int n) {
        if (m < 0 || n < 0)
            throw new IllegalArgumentException("m and n must be non-negative.");

        int[] res = new int[m + n];
        int l = 0, k = 0, r = 0;

        while (l < m && r < n) {
            if (nums1[l] <= nums2[r]) {
                res[k++] = nums1[l++];
            } else {
                res[k++] = nums2[r++];
            }
        }
        while (l < m) {
            res[k++] = nums1[l++];
        }
        while (r < n) {
            res[k++] = nums2[r++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 }, nums2 = { 2, 5, 6 };
        int m = 3, n = 3;

        nums1 = mergeSort(nums1, nums2, m, n);
        System.out.println(Arrays.toString(nums1));
    }
}

// leetcode problem 1051 Height Checker (E)

class leetcode_2 {
    public static void main(String[] args) {
        int[] heights = { 1, 1, 4, 2, 1, 3 };
        int[] arr = new int[heights.length];

        arr = Arrays.copyOf(heights, heights.length);

        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            int j = i - 1;

            while (j >= 0 && heights[j] > curr) {
                heights[j + 1] = heights[j];
                j--;
            }
            heights[j + 1] = curr;
        }

        int i = 0, swap = 0;
        while (i < heights.length) {
            if (heights[i] != arr[i]) {
                swap++;
            }
            i++;
        }
        System.out.println(Arrays.toString(arr) + " " + swap + " " + Arrays.toString(heights));
    }
}

// leetcode problem 455 Assign Cookies (E)

class leetcode_3 {
    static int[] merge_sort(int[] left, int[] right) {
        int arr[] = new int[left.length + right.length];

        int l = 0, k = 0, r = 0;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                arr[k++] = left[l++];
            } else {
                arr[k++] = right[r++];
            }
        }

        while (l < left.length) {
            arr[k++] = left[l++];
        }

        while (r < right.length) {
            arr[k++] = right[r++];
        }
        return arr;
    }

    static int[] merge(int arr[]) {
        if (arr.length <= 1)
            return arr;

        int mid = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        int[] sort_left = merge(left);
        int[] sort_right = merge(right);
        return merge_sort(sort_left, sort_right);
    }

    public int findContentChildren(int[] g, int[] s) {
        g = merge(g);
        s = merge(s);

        int i = 0, j = 0;
        int max = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                max++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return max;
    }
}

// leetcode problem 912 Sort an Array (M)
class leetcode_4 {
    static int[] merge(int[] n) {
        if (n.length <= 1)
            return n;

        int mid = n.length / 2;

        int[] left = Arrays.copyOfRange(n, 0, mid);
        int[] right = Arrays.copyOfRange(n, mid, n.length);

        int[] sort_left = merge(left);
        int[] sort_right = merge(right);

        return merge_sort(sort_left, sort_right);
    }

    static int[] merge_sort(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];

        int l = 0, k = 0, r = 0;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                arr[k++] = left[l++];
            } else {
                arr[k++] = right[r++];
            }
        }

        while (l < left.length) {
            arr[k++] = left[l++];
        }
        while (r < right.length) {
            arr[k++] = right[r++];
        }
        return arr;
    }

    public int[] sortArray(int[] nums) {
        nums = merge(nums);
        return nums;
    }
}

// leetcode problem 56 Merge Intervals (M)
class leetcode_5 {
    static int[][] sort(int[][] n) {
        if (n.length <= 1)
            return n;

        int mid = n.length / 2;

        int[][] left = Arrays.copyOfRange(n, 0, mid);
        int[][] right = Arrays.copyOfRange(n, mid, n.length);

        int[][] sort_left = sort(left), sort_right = sort(right);

        return merge_sort(sort_left, sort_right);
    }

    static int[][] merge_sort(int[][] left, int[][] right) {
        int[][] arr = new int[left.length + right.length][];

        int l = 0, k = 0, r = 0;

        while (l < left.length && r < right.length) {
            if (left[l][0] <= right[r][0]) {
                arr[k++] = left[l++];
            } else {
                arr[k++] = right[r++];
            }
        }
        while (l < left.length) {
            arr[k++] = left[l++];
        }
        while (r < right.length) {
            arr[k++] = right[r++];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        intervals = sort(intervals);

        int i = 1, j = 0;
        ArrayList<int[]> res = new ArrayList<>();

        while (i < intervals.length) {
            if (intervals[i][0] <= intervals[j][1]) {
                if (intervals[i][1] < intervals[j][1]) {
                    i++;
                } else {
                    intervals[j][1] = intervals[i++][1];
                }
            } else {
                res.add(intervals[j]);
                intervals[j] = intervals[i++];
            }
        }
        res.add(intervals[j]);
        for (int[] ks : res) {
            System.out.println(Arrays.toString(ks));
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

}

// leetcode problem 147 Insertion Sort List (M)
class leetcode_6 {
    public ListNode insertionSortList(ListNode head) {
        head = new ListNode(40);
        head.next = new ListNode(10);
        head.next = new ListNode(1);
        head.next = new ListNode(30);

        ListNode curr = head;
        ListNode sorted = null;

        while (curr != null) {
            ListNode nextCard = curr.next;

            if (sorted == null || sorted.val < curr.val) {
                curr.next = curr;
                sorted = curr;
            } else {
                ListNode walker = sorted;
                while (walker != null && walker.next.val < curr.val) {
                    walker = walker.next;
                }
                curr.next = walker;
                walker.next = curr;
            }
            curr = nextCard;
        }
        return sorted;
    }
}