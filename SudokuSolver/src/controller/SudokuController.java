package controller;

import model.ASudokuModel;
import model.SudokuModel4x4;
import model.SudokuModel5x5;
import model.SudokuModel9x9;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by e633828 on 7/14/2017.
 */
public class SudokuController extends AController{
    private Readable rd;
    private Appendable ap;
    static SudokuController controller = new SudokuController(new InputStreamReader(System.in), System.out);
    static ASudokuModel model;
    static String boardAsString = "";
    static int rowLength = 0;

    private SudokuController(Readable rd, Appendable ap) {
        this.rd = rd;
        this.ap = ap;
    }

    /**
     * Checks user inputted row (String) to make sure all inputs are valid.
     * @param str user input
     * @return true if no violations // false if any violation
     */
    public boolean checkRow(String str) {
        //Iterate through given string
        for(int i = 0; i < str.length(); i++) {
            String character = str.substring(i, i + 1); //choose one character from string
            if(character.matches("\\d+")) { //If character is in number form (0 - 9)
                if (Integer.parseInt(character) <= model.boardSize && Integer.parseInt(character) > 0) {
                    //Do nothing, input is good
                } else {
                    System.out.print("Input number(s) larger than " + model.boardSize + " or smaller than 1: ");
                    return false;
                }
            }
            if(character.equals("-") || character.matches("\\d+")) {
                //Do nothing, character is also good
            } else {
                System.out.print("Incorrect input: ");
                return false;
            }
        }
        return true; //All characters in string pass
    }

    /**
     * Ask user for row inputs
     */
    private void rowInput() {
        Scanner sc = new Scanner(controller.rd);
        for(int i = 0; i < model.boardSize; i++) {
            //Ask user for input
            System.out.println("Insert row number " + (i + 1) + " [\"-\" for an empty space]");
            String row = sc.next();
            if(row.length() != model.boardSize) { //User entered more or less inputs
                System.out.println("Incorrect Number of Inputs. Please Try Again.");
                System.out.println("Row length must be " + model.boardSize);
                i--;
            } else if(checkRow(row)) {
                //If it passes, add it to the board (represented as a string)
                boardAsString += row;
            } else {
                System.out.println("Please Try Again.");
                i--;
            }
        }
    }

    /**
     * Initializes the 4x4 board by asking user for input
     */
    private void initializeBoard() {
        String inputSize = "-";
        //System.out.println("Size of board? [4, 9]")
        Scanner sc = new Scanner(controller.rd);
        while(!inputSize.equals("4") && !inputSize.equals("5") && !inputSize.equals("9")) {
            System.out.println("Size of Board? [4, 5, or 9]");
            inputSize = sc.next();
            if (inputSize.equals("4") || inputSize.equals("5") || inputSize.equals("9")) {
                System.out.println("Board size is " + inputSize);
            } else {
                System.out.println("Incorrect input, must be 4, 5, or 9");
            }
        }
        if(inputSize.equals("4")) {
            model = new SudokuModel4x4();
        } else if(inputSize.equals("9")) {
            model = new SudokuModel9x9();
        } else if(inputSize.equals("5")) {
            model = new SudokuModel5x5();
        }
        model.boardSize = Integer.parseInt(inputSize); // set boardsize
        controller.rowInput(); //asks user for row input
        model.fillBoard(boardAsString);
        System.out.println(model.displayBoard(model.board));
    }

    public static void main (String[] args) {
        controller.initializeBoard();
        while(!model.checkBoard(model.board)) { //While the user's inputted board is accepted but invalid, restart initialize
            System.out.println("Error in initial board. Restarting...");
            model.board.clear();
            boardAsString = "";
            controller.initializeBoard();
        }
        System.out.println("Board successfully filled!");
        //Solve the model
        model.solve();

    }

}
