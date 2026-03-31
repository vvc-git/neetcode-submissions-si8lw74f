class Solution {
    public void dfs(char[][] grid, int row, int column) {
        int limitOnXAxis = grid.length;
        int limitOnYAxis = grid[0].length;
    
        if (row < 0 || column < 0|| row >= limitOnXAxis || column >= limitOnYAxis) {
            return;
        }

        char cur = grid[row][column];
        if (cur == '0')
            return;

        grid[row][column] = '0';
        dfs(grid, row, column + 1); 
        dfs(grid, row - 1 , column);
        dfs(grid, row, column - 1);
        dfs(grid, row + 1, column);
        return;
    }


    public int numIslands(char[][] grid) {
        int limitOnXAxis = grid.length;
        int limitOnYAxis = grid[0].length;
        int result = 0;


        // Iterate the grid to find island
        for (int i = 0; i < limitOnXAxis; i++) {
            for (int j = 0; j < limitOnYAxis; j++) {
                char cur = grid[i][j];
                if (cur == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
        
    }
}
