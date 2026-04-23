class Solution {
    int ROWS;
    int COLS;

    public void rotate(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        int[][] rotated = new int[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                rotated[j][ROWS-1-i] = matrix[i][j];
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }

        
        
    }
}
