// The assumptions:
// Player is the first one to make a move
// Player's move is marked by X
// Computer's move is marked by 0
// Computer chooses randomly



import java.util.Scanner;

public class TicTacToeApp {
    static Scanner scanner;

    static char[][] map;
    static final int MAP_SIZE = 3;

    static final char EMPTY_FIELD = '*';
    static final char X_FIELD = 'X';
    static final char O_FIELD = '0';



    public static void main(String[] args){
        init();
        printMap();
        while (true) {
            humanTurn();
            printMap();

            if (checkWin(X_FIELD)) {
                System.out.println("Game's over. Player's won");
                break;
            }
            if (checkDraft()){
                System.out.println("it's a tie. The game is over");
                break;
            }


            computerTurn();
            printMap();

            if (checkWin(O_FIELD)) {
                System.out.println("Game's over. Computer's won");
                break;
            }
            if (checkDraft()){
                System.out.println("it's a tie. The game is over");
                break;
            }

        }

    }

    public static boolean checkWin(char playerField){
        if(map[0][0] == playerField && map[0][1] == playerField && map[0][2] == playerField) return true;
        if(map[1][0] == playerField && map[1][1] == playerField && map[1][2] == playerField) return true;
        if(map[2][0] == playerField && map[2][1] == playerField && map[2][2] == playerField) return true;

        if(map[0][0] == playerField && map[1][0] == playerField && map[2][0] == playerField) return true;
        if(map[0][1] == playerField && map[1][1] == playerField && map[2][1] == playerField) return true;
        if(map[0][2] == playerField && map[1][2] == playerField && map[2][2] == playerField) return true;

        if(map[0][0] == playerField && map[1][1] == playerField && map[2][2] == playerField) return true;
        if(map[0][2] == playerField && map[1][1] == playerField && map[2][0] == playerField) return true;

        return  false;
    }

    public static boolean checkDraft(){
        for(int row = 0; row < MAP_SIZE; row ++ ){
            for(int col = 0; col < MAP_SIZE; col ++){
                if (map[row][col] ==EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }

    public static  boolean isCellValid(int row, int col){
        if (row < 0 || col < 0 || row >= MAP_SIZE || col >= MAP_SIZE){
            return false;
        }
        if(map[row][col] != EMPTY_FIELD){
            return  false;
        }
        return  true;

    }


    public static void computerTurn(){
        int row, col;
        System.out.println("Computer's turn");
        do {
            row = (int)(Math.random() * MAP_SIZE);
            col = (int)(Math.random() * MAP_SIZE);
        } while (!isCellValid(row, col));

        map[col][row] = O_FIELD;
        System.out.println("Computer's entered "  + row + " " + col);

    }


    public static void humanTurn(){
        int row, col;
        do {
            System.out.println("Player's turn. Enter the coordinates  X and Y. Use the space between");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isCellValid(row, col));

        map[col][row] = X_FIELD;
        System.out.println("You entered " + row + " " + col);
    }

    public static void printMap(){
        for(int row = 0; row <= MAP_SIZE; row ++) {
            System.out.print(row + " ");
        }
        System.out.println();
        for(int row = 0; row < MAP_SIZE; row ++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < MAP_SIZE; col++) {
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void init(){
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int row = 0; row < MAP_SIZE; row ++) {
            for (int col = 0; col < MAP_SIZE; col ++){
                map[row][col] = EMPTY_FIELD;
            }
        }
        scanner = new Scanner(System.in);
    }
}
