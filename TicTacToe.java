import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // GameBoard Creation :3
   static char[][] gameboard = {
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
    };

    static ArrayList<Integer> PlayPosition = new ArrayList<>();
    static ArrayList<Integer> cpuPosition = new ArrayList<>();
    // Print it shall we ?
public static void PrintGameBoard (char [][] gameboard){
    for (char[] row : gameboard) {
        for (char c : row) {
            System.out.print(c);
        }
        System.out.println();  
    }   
}

public static void PlacePiece(char[][] gameboard , String user , int pos){
    char Symbol = ' ';

    if (user.equals("player")) {
        Symbol = 'X';   
        PlayPosition.add(pos);

    }
    else if (user.equals("cpu")) {
        Symbol = 'O';
        cpuPosition.add(pos);
    } 

    switch (pos) {

        case 1: gameboard[0][0] = Symbol;
        break;
        case 2: gameboard[0][2] = Symbol;
        break;
        case 3: gameboard[0][4] = Symbol;
        break;
        case 4: gameboard[2][0] = Symbol;
        break;
        case 5: gameboard[2][2] = Symbol;
        break;
        case 6: gameboard[2][4] = Symbol;
        break;
        case 7 : gameboard[4][0] = Symbol;
        break;
        case 8: gameboard[4][2] = Symbol;
        break;
        case 9: gameboard[4][4] = Symbol;
        break;
        default :
            break;
    }
}
// We need to check for the winning condition else we'll have an infinit replacement alr !
public static String Checkwinner (){
    List<Integer> TopRow = Arrays.asList(1,2,3);
    List<Integer> MidRow = Arrays.asList(4,5,6);
    List<Integer> BotRow = Arrays.asList(7,8,9);
    List<Integer> TopCol = Arrays.asList(1,4,7);
    List<Integer> MidCol = Arrays.asList(2,5,8);
    List<Integer> BotCol = Arrays.asList(3,6,9);
    List<Integer> Diagon1 = Arrays.asList(1,5,9);
    List<Integer> Diagon2 = Arrays.asList(7,5,3);

    List<List> winning = new ArrayList<List>();
    winning.add(TopRow);
    winning.add(MidRow);
    winning.add(BotRow);
    winning.add(TopCol);
    winning.add(MidCol);
    winning.add(BotCol);
    winning.add(Diagon1);
    winning.add(Diagon2);

    for (List l : winning) {
        if (PlayPosition.containsAll(l)) {
            return "CONGRAATS YOOHOOO ";
        }
        else if (cpuPosition.containsAll(l)) {
            return " uh ohh dummy :( ur pc wins ";
        } 
        else if (PlayPosition.size() + cpuPosition.size() == 9) {
            return "It's a Tie ! , try again :3";
            
        }
        }
        
    

    return "";
}
        
    
   


    public static void main(String[] args) {
        PrintGameBoard(gameboard);
        System.out.println("Enter your placement (1-9): ");
        
        while (true) {
            Scanner scan = new Scanner(System.in);
            int PlayerPos = scan.nextInt();
            // cpu was taking over our placement , we need to fix it 
            while (PlayPosition.contains(PlayerPos)|| cpuPosition.contains(PlayPosition)) {
                System.out.println("Position taken , try with another one ");
                PlayerPos = scan.nextInt(); 
                
            }

            PlacePiece(gameboard, "player", PlayerPos);
            String result = Checkwinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            Random r = new Random();
            int cpuPos = r.nextInt(9)+1 ;
            while (PlayPosition.contains(cpuPos)|| cpuPosition.contains(cpuPos)) {
                cpuPos = r.nextInt(9)+1 ;
                
            }
            PlacePiece(gameboard, "cpu", cpuPos);
            PrintGameBoard(gameboard);
             result = Checkwinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        

        }
       
        
        
        
        
 }





}
