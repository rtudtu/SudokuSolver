package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for implementation of the model
 */
public class ASudokuModel implements IModel{
    public ArrayList<List<Character>> board = new ArrayList<List<Character>>(4); //Board represented in arraylists of arraylists
    public ArrayList<List<Integer>> blanks = new ArrayList<List<Integer>>(); //Keep track of filled in spots so we know where to go back to
    public int boardSize; //Size of board in terms of nxn

    /**
     * Populate board (ArrayLists) with numbers and blanks
     * @param str user inputted board
     */
    public void fillBoard(String str) {
        for(int i = 0; i < boardSize; i++) {
            List<Character> list = new ArrayList<Character>();
            for(int j = 0; j < boardSize; j++) {
                list.add(str.charAt((i * boardSize + j))); //get position of next 4 digits in string
            }
            board.add(list); //adds rows 1-[boardSize]
        }
    }

    /**
     * Displays the board
     * @param board Arraylist(s) to be displayed
     * @return The current state of the board represented by a String
     */
    public String displayBoard(ArrayList<List<Character>> board) {
        String output = "";
        return output;
    }

    /**
     * Checks to see if the board is in a "good" state
     * @param board lists being evaluated
     * @return true if board is good, false if board is bad
     */
    public boolean checkBoard(ArrayList<List<Character>> board) {
        return true;
    }

    /**
     * Checks that the board is still in a stable state after the addition of a number at (x,y)
     * @param board lists being evaluated
     * @param x x position of added number
     * @param y y position of added number
     * @return Boolean on whether board is in a stable state or not
     */
    public boolean checkLoc(ArrayList<List<Character>> board, int x, int y) {
        return true;
    }

    /**
     * Helper for checkBoard and checkLoc
     * Checks a single list to see if it is sound (no repeats)
     * @param list list being checked
     * @return true if list is good, false if list is bad
     */
    public boolean checkList(List<Character> list) {
        ArrayList<Character> compList = new ArrayList<Character>(); //list that is compared to - stores already inputted numbers
        for(int i = 0; i < list.size(); i++) {
            if(!list.get(i).equals('-')) {
                //If compList already has the given element, return false
                if (compList.contains(list.get(i))) {
                    return false;
                } else {
                    //Else add to compList
                    compList.add(list.get(i));
                }
            }
        }
        return true;
    }

    /**
     * Run the current game board through a BRUTE FORCE styled algorithm to find the solution
     */
    public void solve() {
        mainLoop:
        for(int i = 0; i < board.size(); i++) {         //column number
            for(int j = 0; j < board.size(); j++) {     //row number
                boolean back = false; //flag for whether or not to backtrack
                boolean exit = true;  //flag for exiting backtracking
                if(board.get(i).get(j).equals('-')) { //If the spot on the board is a dash, we need to fill it in with a number
                    ArrayList<Integer> coords = new ArrayList<Integer>(); //keep track of coordinates of dashes
                    coords.add(i);
                    coords.add(j);
                    blanks.add(coords); //keep track of coords to go back to
                    board.get(i).remove(j);
                    board.get(i).add(j, '1');
                    Character tempChar = board.get(i).get(j); //store char that we are testing to see if it will pass with the given board
                    while (!checkLoc(board, i, j)) {    //While board is not in "good" state, try numbers 1 -> [boardSize]
                        if (tempChar.equals(Character.forDigit(boardSize, 10))) { //If this spot is unable to take in 1, 2, 3, or 4, then we want to backtrack to change previous spots
                            board.get(i).remove(j);
                            board.get(i).add(j, '-');
                            back = true;
                            break;
                        }
                        tempChar = (char) (Character.valueOf(tempChar) + 1);
                        board.get(i).remove(j);
                        board.get(i).add(j, tempChar);
                    }
                    //The board is unsolvable if we are unable to put any number from 1 - 4 onto the first spot on the board
                    if(board.get(blanks.get(0).get(0)).get(blanks.get(0).get(1)) == '-') {
                        //Board is impossible to solve! If first box cannot be 1, 2, 3, or 4
                        System.out.println("Board is impossible to solve!");
                        break mainLoop;
                    }
                    //If we want to backtrack
                    while(back) {
                        List<Integer> list = blanks.get(blanks.indexOf(coords) - 1); //keep track of current coords we are working on
                        blanks.remove(blanks.indexOf(coords)); //remove the coords for the spot that is unable to hold numbers 1-4
                        int k = list.get(0);
                        int l = list.get(1);
                        //move coords back
                        coords.clear();
                        coords.add(k);
                        coords.add(l);
                        Character tempChar2 = board.get(k).get(l);
                        do {
                            if (tempChar2.equals(Character.forDigit(boardSize, 10))) {
                                board.get(k).remove(l);
                                board.get(k).add(l, '-');
                                back = true;
                                exit = false; //If numbers 1-4 don't work, do not exit backloop
                                break;
                            }
                            tempChar2 = (char) (Character.valueOf(tempChar2) + 1);
                            board.get(k).remove(l);
                            board.get(k).add(l, tempChar2);
                            exit = true; //If a number worked, exit
                        } while(!checkLoc(board, k, l));
                        //If the board is "good", and permitted to exit, then exit
                        if(checkLoc(board, k, l) && exit) {
                            back = false;
                            i = k; //set i back
                            j = l; //set j back
                        }
                    }

                    System.out.println(displayBoard(board)); //display board for user
                }
                //For the last iteration, Print "Final Board:" for user
                if(i == board.size() - 1 && j == board.size() - 1) {
                    System.out.print("Final ");
                    System.out.println(displayBoard(board));
                }
            }
        }
    }
}