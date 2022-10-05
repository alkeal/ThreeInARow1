import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class CheckBoard {

    ArrayList<Integer> arrPlayerOne = new ArrayList<>();
    ArrayList<Integer> arrPlayerTwo = new ArrayList<>();



    char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    public String winner(){
        // inputs the different ways you can win the game on the board
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(3,5,7);

        // list for the different winning ways
        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        // loop that check for the winner and prints out a message for the winner or if it's a draw
        for(List l : winning){
            if(arrPlayerOne.containsAll(l)){
                return  " Player 1 you won!";

            } else if (arrPlayerTwo.containsAll(l)){
                return   " Player 2 you won!";

            }

        }
        //after checking all lists for win and don't find it will print Draw.
        if (arrPlayerOne.size() + arrPlayerTwo.size() ==9){
            return " Draw! ";
        }


        return "";
    }

    public void addPositionPlayerOne(int position) {
        arrPlayerOne.add(position);
    }

    public void addPositionPlayerTwo(int position) {
        arrPlayerTwo.add(position);
    }

}


