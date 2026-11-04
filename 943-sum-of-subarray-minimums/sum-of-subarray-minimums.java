
import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1000000007L;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()
                    && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty()
                    && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long l = i - left[i];
            long r = right[i] - i;

            long contribution = arr[i] * l * r;

            sum = (sum + contribution) % mod;
        }

        return (int) sum;
    }
}
