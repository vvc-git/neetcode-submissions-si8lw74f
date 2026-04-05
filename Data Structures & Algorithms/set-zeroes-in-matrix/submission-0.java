class Solution {

    public void setColumn(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

    public void setRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j); 
                }
            }
        }

        for (int num : rows) {
            setRow(matrix, num);
        }

        for (int num : cols) {
            setColumn(matrix, num);
        }
    }
}
