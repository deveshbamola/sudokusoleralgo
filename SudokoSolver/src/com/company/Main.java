package com.company;

 class SudokuSolver {


    public static void main(String[] args) {

        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        if(sudokusolved(grid))
            printgird(grid);

        else
            System.out.println("solution dont exist");


    }

    private static boolean sudokusolved(int[][] grid) {

        if(allfilled(grid))
        {
            return true;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {


                if(grid[i][j]==0)
                {
                    for (int z = 1; z <=9; z++)
                    {
                        if(issafe(grid,i,j,z))
                        {
                            grid[i][j]=z;

                            if(sudokusolved(grid))
                            {
                                return true;
                            }
                            grid[i][j]=0;
                        }
                    }
                    return false;
                }

            }

        }

        return false;
    }


    private static boolean issafe(int[][] grid, int j, int z, int i) {

        for (int  k= 0; k < 9; k++) {

            if(grid[j][k]==i)
                return false;

        }
        for (int k = 0; k < 9; k++) {
            if(grid[k][z]==i)
                return false;
        }
        for (int k = 0; k < 3; k++) {
            if(grid[(j-(j%3)+k)][(z-(z%3)+k)]==i)
            {
                return false;
            }
        }
        return true;
    }

    private static boolean allfilled(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(grid[i][j]==0)
                    return false;
            }
        }
        return true;

    }

    private static void printgird(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}
