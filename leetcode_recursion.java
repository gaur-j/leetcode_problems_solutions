package leetcode_problems_solutions;

// leetcode problem 509 Fibonacci numbers (E)

public class leetcode_recursion {
    public int fib(int n) {
        if (n <= 1)
            return n;

        n = fib(n - 1) + fib(n - 2);
        return n;
    }
}

// leetcode problem Climbing Stairs (E)

class leetcode_recursion_1 {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int curr = a + b;
            a = b;
            b = curr;
        }
        return b;
    }
}
