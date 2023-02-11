import java.util.Scanner;
public class tictactoe {
    void printBoard(String[] board){
        System.out.print("\n    a | b | c \n" +
                         "  -------------\n" + 
                         "1 | " + board[0] + " | " + board[1] + " | " + board[2] + " |\n" +
                         "  |-----------|\n" + 
                         "2 | " + board[3] + " | " + board[4] + " | " + board[5] + " |\n" +
                         "  |-----------|\n" + 
                         "3 | " + board[6] + " | " + board[7] + " | " + board[8] + " |\n" + 
                         "  -------------\n");
    }

    // Method for placing either an X or an O on the board in designated position
    void placePiece(String p,String board[]){
        Scanner myObj = new Scanner(System.in); // Scanner for recieving inputs
        System.out.print(p + ", please input tile choice(a1,a2,b3...etc.):\n");
        String place = myObj.nextLine(); // Grabs string
        place = place.toLowerCase().replaceAll("\\s", ""); // forces lowercase and removes spaces for code integrity and simplicity
        // NOTE: test code kept for future development
        // System.out.print(place);
        // if (place.equals("a1")){
        //     System.out.print("a1");
        // }
        // tests space and if its empty then places apropriate player piece
        if (place.equals("a1") & board[0].equals(" ")){
            board[0] = p;
        }else if (place.equals("b1") & board[1].equals(" ")){
            board[1] = p;
        }else if (place.equals("c1") & board[2].equals(" ")){
            board[2] = p;
        }else if (place.equals("a2") & board[3].equals(" ")){
            board[3] = p;
        }else if (place.equals("b2") & board[4].equals(" ")){
            board[4] = p;
        }else if (place.equals("c2") & board[5].equals(" ")){
            board[5] = p;
        }else if (place.equals("a3") & board[6].equals(" ")){
            board[6] = p;
        }else if (place.equals("b3") & board[7].equals(" ")){
            board[7] = p;
        }else if (place.equals("c3") & board[8].equals(" ")){
            board[8] = p;
        }else if (place.equals("a1")||place.equals("b1")||place.equals("c1")||place.equals("a2")||place.equals("b2")||place.equals("c2")||place.equals("a3")||place.equals("b3")||place.equals("c3")){ // tests f input was valid but not empty
            System.out.print("Please choose a valid EMPTY space\n");
            gameRound(p, board); // Reruns without changing player
        }else{ // Prints standard error for incorrect input
            System.out.print("Please input a valid space code(i.e. a1, a2, b3...etc)\n");
            gameRound(p, board); // Reruns without changing players
        }
    }
    
    // Tests all possible win conditions
    static boolean winTest(String p, String board[]){
        if (board[0].equals(" ") == false & board[0].equals(board[1]) & board[0].equals(board[2])){
            return false;
        }else if (board[3].equals(" ") == false & board[3].equals(board[4]) & board[3].equals(board[5])){
            return false;
        }else if (board[6].equals(" ") == false & board[6].equals(board[7]) & board[6].equals(board[8])){
            return false;
        }else if (board[1].equals(" ") == false & board[1].equals(board[4]) & board[1].equals(board[7])){
            return false;
        }else if (board[2].equals(" ") == false & board[2].equals(board[5]) & board[2].equals(board[8])){
            return false;
        }else if (board[0].equals(" ") == false & board[0].equals(board[4]) & board[0].equals(board[8])){
            return false;
        }else if (board[2].equals(" ") == false & board[2].equals(board[4]) & board[2].equals(board[6])){
            return false;
        }
        return true;
    }

    // underutilizd method for current development though could be more useful in future itterations and versions
    void gameRound(String p,String board[]){
        printBoard(board);
        placePiece(p, board);
    }

    public static void main(String args[]){
        String[] board = {" "," "," "," "," "," "," "," "," "}; // all board spaces need to maintain certain spacing
        boolean game = true; // game is running tester
        int rounds = 0; // chescker for if the game has reeched maximum possible moves
        String p = "X"; // establishes player
        tictactoe game_1 = new tictactoe(); // innitialize game
        while (game){
            game_1.gameRound(p,board);
            rounds += 1;
            game = winTest(p,board);
            if (rounds == 9){ // Tie testing
                game = false;
                game_1.printBoard(board);
                System.out.print("Game over! You tie!\n");
            }else if (game == false){ // win message
                game_1.printBoard(board);
                System.out.print("Game over! " + p + " wins!\n");
            }else if (p.equals("X")){ // shifts player
                p = "O";
            }else if (p.equals("O")){
                p = "X";
            }
        }
    }
}