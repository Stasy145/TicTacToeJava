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
                System.out.println("it's a tie. the game is over");
                break;
            }


            aiTurn();
            printMap();

            if (checkWin(O_FIELD)) {
                System.out.println("Game's over. Computer's won");
                break;
            }
            if (checkDraft()){
                System.out.println("it's a tie. the game is over");
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

    public static  boolean isCellValid(int x, int y){
        if (x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE){
            return false;
        }
        if(map[x][y] != EMPTY_FIELD){
            return  false;
        }
        return  true;

    }


    public static void aiTurn(){
        int x, y;
        System.out.println("Computer's turn");
        do {
            x = (int)(Math.random() * MAP_SIZE);
            y = (int)(Math.random() * MAP_SIZE);
        } while (!isCellValid(x, y));

        map[y][x] = O_FIELD;
        System.out.println("Computer's entered "  + x + " " + y);

    }


    public static void humanTurn(){
        int x, y;
        do {
            System.out.println("Player's turn. Enter the coordinates of your turn X and Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));

        map[y][x] = X_FIELD;
        System.out.println("You entered " + x + " " + y);
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
