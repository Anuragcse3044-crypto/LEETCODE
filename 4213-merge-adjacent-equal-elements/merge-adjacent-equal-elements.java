
import java.util.*;

class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> stack = new ArrayList<>();

        for (int num : nums) {
            long curr = num;

            while (!stack.isEmpty()
                    && stack.get(stack.size() - 1) == curr) {
                stack.remove(stack.size() - 1);
                curr *= 2;
            }

            stack.add(curr);
        }

        return stack;
    }
}
