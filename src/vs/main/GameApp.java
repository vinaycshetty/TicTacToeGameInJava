package vs.main;

import java.util.Random;
import java.util.Scanner;

/**
 * Created By : Vinay Shetty
 * on : 29/01/22  at 10:42 AM
 **/
public class GameApp {
    public static void main(String[] args) {
        System.out.println("************* WELCOME TO TIC TAC TOE GAME ****************************");
        Scanner scanner = new Scanner(System.in);
        char[][] board = { {' ',' ',' '},
                           {' ',' ',' '},
                           {' ',' ',' '}};
        printBoard(board);
        while (true){
            playerTurn(scanner, board);
            if (isGameOver(board)){
                break;
            }
            computerTurn(board);
            if (isGameOver(board)){
                break;
            }
            printBoard(board);
        }

    }

    private static boolean isGameOver(char[][] board){

        if (whoWon(board,'X')){
            printBoard(board);
            System.out.println("Player has Won!!");
            return true;
        } else if (whoWon(board,'O')){
            printBoard(board);
            System.out.println("Computer has Won!!");
            return true;
        }

        for(int i = 0; i<board.length ; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("It's a Tie @@@@@###$$");
        return true;
    }

    private static boolean whoWon(char[][] board, char symbol) {
        if(board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol ||
                board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol ||
                board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol ||

                board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol ||
                board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol ||
                board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol ||

                board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol ||
                board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol ){
            return true;
        }
        return false;
    }

    private static void computerTurn(char[][] board) {
        Random random = new Random();
        int computerInput;
        while(true){
            computerInput = random.nextInt(9) + 1;
            if (isValidPosition(board, Integer.toString(computerInput))){
                break;
            }
        }
        System.out.println("Computer selected "+computerInput+ " position");
        placeMove(board,Integer.toString(computerInput), 'O');
    }

    private static boolean isValidPosition(char[][] board, String position){
        switch(position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    private static void playerTurn(Scanner scanner, char[][] board) {
        String userInput;
        while (true){
            System.out.println("Please enter at which position you want to play (1-9");
            userInput = scanner.nextLine();
            if (isValidPosition(board,userInput)){
                break;
            } else {
                System.out.println(" your input " + userInput + " is not valid");
            }
        }
        System.out.println( "You selected "+ userInput+" position");
        placeMove(board, userInput, 'X');
    }

    private static void placeMove(char[][] board, String userInput, char symbol) {
        switch(userInput){
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("enter valid input");
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] +"|"+ board[0][1] +"|"+ board[0][2]);
        System.out.println("-----");
        System.out.println(board[1][0] +"|"+ board[1][1] +"|"+ board[1][2]);
        System.out.println("-----");
        System.out.println(board[2][0] +"|"+ board[2][1] +"|"+ board[2][2]);
    }
}
