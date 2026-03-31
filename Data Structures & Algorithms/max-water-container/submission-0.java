class Solution {
    public int maxArea(int[] heights) {
        
        int size = heights.length;
        int result = 0;

        for (int l = 0; l < size; l++) {
            for (int r = 0; r < size; r++) {
                int width = r - l;
                int height = Math.min(heights[r], heights[l]);
                int area = width * height;
                if (area > result) {
                    result = area;
                }
            }
        }
        return result;
    }
}
