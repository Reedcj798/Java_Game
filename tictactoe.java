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

    void placePiece(String p,String board[]){
        Scanner myObj = new Scanner(System.in);
        System.out.print(p + ", please input tile choice(a1,a2,b3...etc.):\n");
        String place = myObj.nextLine();
        place = place.toLowerCase().replaceAll("\\s", "");
        // System.out.print(place);
        // if (place.equals("a1")){
        //     System.out.print("a1");
        // }
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
        }else if (place.equals("a1")||place.equals("b1")||place.equals("c1")||place.equals("a2")||place.equals("b2")||place.equals("c2")||place.equals("a3")||place.equals("b3")||place.equals("c3")){
            System.out.print("Please choose a valid EMPTY space\n");
            printBoard(board);
            placePiece(p, board);
        }else{
            System.out.print("Please input a valid space code(i.e. a1, a2, b3...etc)\n");
            printBoard(board);
            placePiece(p, board);
        }
    }
    
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

    void gameRound(String p,String board[]){
        printBoard(board);
        placePiece(p, board);
    }

    public static void main(String args[]){
        String[] board = {" "," "," "," "," "," "," "," "," "};
        boolean game = true;
        int rounds = 0;
        String p = "X"; 
        tictactoe game_1 = new tictactoe();
        while (game){
            game_1.gameRound(p,board);
            rounds += 1;
            game = winTest(p,board);
            if (rounds == 9){
                game = false;
                game_1.printBoard(board);
                System.out.print("Game over! You tie!\n");
            }else if (game == false){
                game_1.printBoard(board);
                System.out.print("Game over! " + p + " wins!\n");
            }else if (p.equals("X")){
                p = "O";
            }else if (p.equals("O")){
                p = "X";
            }
        }
    }
}