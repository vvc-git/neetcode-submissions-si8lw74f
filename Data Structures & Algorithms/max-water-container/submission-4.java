class Solution {
    public int maxArea(int[] heights) {
        
        int size = heights.length;
        int l = 0;
        int r = size - 1;
        int result = 0; 

        while (l < r) {
            int area = (r - l) * Math.min(heights[r], heights[l]);
            result = Math.max(area, result);
            
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
