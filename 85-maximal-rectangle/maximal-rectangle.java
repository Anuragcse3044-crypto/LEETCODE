class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n];
        int top = -1;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (top >= 0 &&
                   heights[stack[top]] > currHeight) {

                int height = heights[stack[top--]];

                int width;
                if (top == -1) {
                    width = i;
                } else {
                    width = i - stack[top] - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            if (i < n) {
                stack[++top] = i;
            }
        }

        return maxArea;
    }
}