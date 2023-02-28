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

            {0, 1, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 0, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 1},
            {1, 1, 0, 1},
            {0, 2, 0, 1},

    };

        static public void printMaze() {
            System.out.printf("%nHere is the maze!%n");
            System.out.println("-----------------");
        int row_count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
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

        System.out.println("Okay! Lets find the way out!");
        System.out.println("----------------------------");

        while(true){

            int x = path.peek().x;
            int y = path.peek().y;

            matrix[y][x] =  0;

            //down
            if (isValid(y+1,x)){
                if (matrix[y+1][x] == 2) {
                    System.out.printf("Moved down. %nThe destination is found!");
                    return;
                } else if (matrix[y+1][x] == 1) {
                    System.out.println("Moved down");
                    path.push(new Position(y+1,x));
                    //go-to next iteration of the loop
                    continue;
                }
            }

            //left
            if (isValid(y,x-1)){
                if (matrix[y][x-1] == 2) {
                    System.out.printf("Moved left. %nThe destination is found!");
                    return;
                } else if (matrix[y][x-1] == 1) {
                    System.out.println("Moved left");
                    path.push(new Position(y,x-1));
                    //go-to next iteration of the loop
                    continue;
                }
            }


            //right
            if (isValid(y,x+1)){
                if (matrix[y][x+1] == 2) {
                    System.out.printf("Moved right. %nThe destination is found!");
                    return;
                } else if (matrix[y][x+1] == 1) {
                    System.out.println("Moved right");
                    path.push(new Position(y,x+1));
                    //go-to next iteration of the loop
                    continue;
                }
            }


            //up
            if (isValid(y-1,x)){
                if (matrix[y-1][x] == 2) {
                    System.out.printf("Moved up. %nThe destination is found!");
                    return;
                } else if (matrix[y-1][x] == 1) {
                    System.out.println("Moved up");
                    path.push(new Position(y-1,x));
                    //go-to next iteration of the loop
                    continue;
                }
            }

            path.pop();
            System.out.println("Oops...No way out. Going back!");
            if (path.size() <= 0 ) {
                System.out.println("Sorry...looks like there's no path!");
                return;
            }
        }
    }

    public static boolean isValid(int y, int x){
            if      (y < 0 ||
                    y >= matrix.length ||
                    x < 0 ||
                    x>= matrix[y].length)
            {
                return false;
            }

            return true;
    }

    static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] args) {
        printMaze();

        Position p = new Position(0,3);

        //add = end of list
        //push= beginning of list
        path.push(p);

        System.out.println();
        move();
    }
}