import models.Position.Position;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {





    static int[][] matrix = {

            /* KEY SHEET
            *   0 = Wall
            *   1 = Path
            *   2 = Destination
            */

            {2, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 1}
    };


    static int current = matrix[0][2];

        static public void printMaze() {
        int row_count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                row_count++;
                System.out.print( "[ " + matrix[i][j] + " ]"); // printing each item
                if (row_count % 4 == 0) {
                    System.out.println();
                }
            }
        }
    }

        static int[] findIndex(int[][] arr, int target)
    {
        int row = 0;
        int col = arr[row].length - 1;
        while (row < arr.length && col >= 0) {
            if (arr[row][col] == target) {
                return new int[] { row, col };
            }

            // Target lies in further row
            if (arr[row][col] < target) {
                row++;
            }
            // Target lies in previous column
            else {
                col--;
            }
        }
        return new int[] { -1, -1 };
    }


    static public void move() {
        int ptr = 0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j + 1] == 0)
                    System.out.println("Moving down...");
                    matrix[i][j + 1] = -1;
                    current = 0;
                if (matrix[i][j - 1] == 0)
                    matrix[i][j] = -1;
                    current = 0;
            }
        }
        System.out.println(Arrays.toString(findIndex(matrix,-1)));
    }

    static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] args) {
        printMaze();
        Position p = new Position(3,0);

        //add = end of list
        //push= beginning of list
        path.push(p);
        path.peek();
        //System.out.println(Arrays.toString(findIndex(matrix,-1)));

        matrix[path.peek().y][path.peek().x] =  0;
    }
}