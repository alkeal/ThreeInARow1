import java.util.Scanner;
import java.util.ArrayList;

public class Main {


    static CheckBoard checkboard = new CheckBoard();

    public static void main(String[] args) {

        // starting message for the game
        System.out.println("*============================*");
        System.out.println("*============================*");
        System.out.println("*=Welcome to Three in a Row!=*");
        System.out.println("*============================*");
        System.out.println("*============================*");
        // gives the user options to add his name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1 enter name: ");
        String p1 = scanner.nextLine();
        System.out.println("Player 2 enter name:");
        String p2 = scanner.nextLine();




        {


        }
        printGameBoard();

        Scanner scan = new Scanner(System.in);

        String result = "";


        while (true) {

            // resets the board when you have a winner/draw and lets you play again
            if (result.length() > 0){

                System.out.println("*============================*");
                System.out.println("*============================*");
                System.out.println("*=Welcome to Three in a Row!=*");
                System.out.println("*============================*");
                System.out.println("*============================*");
                // new game new choice for player names
                scanner = new Scanner(System.in);

                System.out.println("Player 1 enter name: ");
                p1 = scanner.nextLine();
                System.out.println("Player 2 enter name:");
                p2 = scanner.nextLine();

                // new checkboard for a new game
                checkboard = new CheckBoard();

            }

            // user input gives you the choices on the board
            System.out.println(p1 + " enter your placement (1-9):");
            int inputPos1 = scan.nextInt();
            //checks if your move is valid and not occupied by the other player
            while (checkboard.arrPlayerOne.contains(inputPos1) || checkboard.arrPlayerTwo.contains(inputPos1)) {
                System.out.println(" Position is taken! ");
                inputPos1 = scan.nextInt();
            }

            placePiece(inputPos1, "player1");
            printGameBoard();


            //checks the board for winner and prints out the result from the checkBoard class
            result = checkboard.winner();
            if (result.length() > 0) {
                System.out.println(  result);
                continue;

            }
            // user input gives you the choices on the board
            System.out.println(p2 + " enter your placement (1-9):");
            int inputPos2 = scan.nextInt();
            //checks if your move is valid and not occupied by the other player
            while (checkboard.arrPlayerTwo.contains(inputPos2) || checkboard.arrPlayerOne.contains(inputPos2)){
                System.out.println(" Position is taken! ");
                inputPos2 = scan.nextInt();
            }



            placePiece( inputPos2, "player2");
            printGameBoard();


            //checks the board for winner and prints out the result from the checkBoard class
            result = checkboard.winner();
            if (result.length() > 0) {
                System.out.println( result);




            }



        }


    }



    public static void placePiece(int pos, String user) {

        //gives the user a symbol for the game
        char symbol = ' ';

        if (user.equals("player1")) {
            symbol = 'X';
            checkboard.addPositionPlayerOne(pos);
            System.out.println(checkboard.arrPlayerOne);
        } else if (user.equals("player2")) {
            symbol = '0';
            checkboard.addPositionPlayerTwo(pos);
            System.out.println(checkboard.arrPlayerTwo);
        }

        // switch for the different pos for the symbols on the board
        switch (pos) {
            case 1 -> checkboard.gameBoard[0][0] = symbol;
            case 2 -> checkboard.gameBoard[0][2] = symbol;
            case 3 -> checkboard.gameBoard[0][4] = symbol;
            case 4 -> checkboard.gameBoard[2][0] = symbol;
            case 5 -> checkboard.gameBoard[2][2] = symbol;
            case 6 -> checkboard.gameBoard[2][4] = symbol;
            case 7 -> checkboard.gameBoard[4][0] = symbol;
            case 8 -> checkboard.gameBoard[4][2] = symbol;
            case 9 -> checkboard.gameBoard[4][4] = symbol;
            default -> {
            }
        }

    }

    public static void printGameBoard() {
        for (char[] row : checkboard.gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}