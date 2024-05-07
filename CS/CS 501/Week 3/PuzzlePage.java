import java.util.Scanner;

/**********************************
 * PuzzlePage.java
 * Creates word puzzles for the Triangle
 * @author Tammy Pirmann
 * @version 20210407
 *********************************/
public class PuzzlePage {
  public static void main(String args[]){
    
    Scanner keyboard = new Scanner(System.in);
    WordScramble puzzle = new WordScramble();
    

    System.out.print("Enter the solution word: ");
    String solution = keyboard.nextLine();

    System.out.printf("Your puzzle is: %s", puzzle.scramble(solution));
  }
}