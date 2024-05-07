public class Sudoku {
public static void main(String[] args) {
    int[][] sudoku = new int[9][9];
    sudoku[0][0] = 3;
    sudoku[0][6] = 1;
    sudoku[1][1] = 2;
    sudoku[1][2] = 9;
    sudoku[1][3] = 3;
    sudoku[1][4] = 6;
    sudoku[2][1] = 6;
    sudoku[2][4] = 2;
    sudoku[2][8] = 8;

    print2DArray(sudoku);
    System.out.println("\n\n");

    int[][] sudoku2D = {
    	{0, 1, 2, 3, 0, 0, 6, 7, 0},
        {0, 0, 0, 0, 0, 7, 1, 0, 5},
        {5, 0, 0, 2, 0, 0, 0, 0, 0}
        };
    print2DArray(sudoku2D);

}    

public static void print2DArray(int [][] arrayToPrint)
{
    for(int row = 0; row < arrayToPrint.length; row++){
        for(int col = 0; col < arrayToPrint[row].length; col++) { 
            	System.out.print(arrayToPrint[row][col] + "  ");
            }	
        System.out.println();
    }
}
}