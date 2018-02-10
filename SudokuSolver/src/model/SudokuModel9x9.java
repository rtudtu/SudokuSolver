package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e633828 on 8/24/2017.
 */
public class SudokuModel9x9 extends ASudokuModel {
/*
    //===================================\\
    || 5 | 3 | - | - | 7 | - | - | - | - ||
    || 6 | - | - | 1 | 9 | 5 | - | - | - ||
    || - | 9 | 8 | - | - | - | - | 6 | - ||
    ||-----------+-----------+-----------||
    || 8 | - | - | - | 6 | - | - | - | 3 ||
    || 4 | - | - | 8 | - | 3 | - | - | 1 ||
    || 7 | - | - | - | 2 | - | - | - | 6 ||
    ||-----------+-----------+-----------||
    || - | 6 | - | - | - | - | 2 | 8 | - ||
    || - | - | - | 4 | 1 | 9 | - | - | 5 ||
    || - | - | - | - | 8 | - | - | 7 | 9 ||
    \\===================================//
*/

    public SudokuModel9x9() {

    }

    @Override
    public String displayBoard(ArrayList<List<Character>> board) {
        String output = "";
        output += "Board: \n";
        output += "//===================================\\\\\n";
        for (int i = 0; i < boardSize; i++) {
            output += "||";
            for (int j = 0; j < boardSize; j++) {
                output += " ";
                output += board.get(i).get(j);
                output += " |";
            }
            if (i == (boardSize / 3) - 1 || i == ((boardSize / 3) * 2) - 1) {
                output += "|\n" +
                        "||-----------+-----------+-----------||\n";
            } else {
                output += "|\n";
            }
        }
        output += "\\\\===================================//\n";
        return output;
    }

    @Override
    public boolean checkLoc(ArrayList<List<Character>> board, int x, int y) {
        ArrayList<Character> box = new ArrayList<Character>();
        ArrayList<Character> col = new ArrayList<Character>();
        ArrayList<Character> row = new ArrayList<Character>();

        //find which box x and y are in and add elements to list
        if (x < 3) {
            if (y < 3) {
                //top left box
                box.add(board.get(0).get(0));
                box.add(board.get(0).get(1));
                box.add(board.get(0).get(2));
                box.add(board.get(1).get(0));
                box.add(board.get(1).get(1));
                box.add(board.get(1).get(2));
                box.add(board.get(2).get(0));
                box.add(board.get(2).get(1));
                box.add(board.get(2).get(2));
            } else if (y < 6) {
                //top middle box
                box.add(board.get(0).get(3));
                box.add(board.get(0).get(4));
                box.add(board.get(0).get(5));
                box.add(board.get(1).get(3));
                box.add(board.get(1).get(4));
                box.add(board.get(1).get(5));
                box.add(board.get(2).get(3));
                box.add(board.get(2).get(4));
                box.add(board.get(2).get(5));
            } else {
                //top right box
                box.add(board.get(0).get(6));
                box.add(board.get(0).get(7));
                box.add(board.get(0).get(8));
                box.add(board.get(1).get(6));
                box.add(board.get(1).get(7));
                box.add(board.get(1).get(8));
                box.add(board.get(2).get(6));
                box.add(board.get(2).get(7));
                box.add(board.get(2).get(8));
            }
        } else if (x < 6) {
            if (y < 3) {
                //middle left box
                box.add(board.get(3).get(0));
                box.add(board.get(3).get(1));
                box.add(board.get(3).get(2));
                box.add(board.get(4).get(0));
                box.add(board.get(4).get(1));
                box.add(board.get(4).get(2));
                box.add(board.get(5).get(0));
                box.add(board.get(5).get(1));
                box.add(board.get(5).get(2));
            } else if (y < 6) {
                //middle middle box
                box.add(board.get(3).get(3));
                box.add(board.get(3).get(4));
                box.add(board.get(3).get(5));
                box.add(board.get(4).get(3));
                box.add(board.get(4).get(4));
                box.add(board.get(4).get(5));
                box.add(board.get(5).get(3));
                box.add(board.get(5).get(4));
                box.add(board.get(5).get(5));
            } else {
                //middle right box
                box.add(board.get(3).get(6));
                box.add(board.get(3).get(7));
                box.add(board.get(3).get(8));
                box.add(board.get(4).get(6));
                box.add(board.get(4).get(7));
                box.add(board.get(4).get(8));
                box.add(board.get(5).get(6));
                box.add(board.get(5).get(7));
                box.add(board.get(5).get(8));
            }
        } else if (x < 9) {
            if (y < 3) {
                //bottom left box
                box.add(board.get(6).get(0));
                box.add(board.get(6).get(1));
                box.add(board.get(6).get(2));
                box.add(board.get(7).get(0));
                box.add(board.get(7).get(1));
                box.add(board.get(7).get(2));
                box.add(board.get(8).get(0));
                box.add(board.get(8).get(1));
                box.add(board.get(8).get(2));
            } else if (y < 6) {
                //bottom middle box
                box.add(board.get(6).get(3));
                box.add(board.get(6).get(4));
                box.add(board.get(6).get(5));
                box.add(board.get(7).get(3));
                box.add(board.get(7).get(4));
                box.add(board.get(7).get(5));
                box.add(board.get(8).get(3));
                box.add(board.get(8).get(4));
                box.add(board.get(8).get(5));
            } else {
                //bottom right box
                box.add(board.get(6).get(6));
                box.add(board.get(6).get(7));
                box.add(board.get(6).get(8));
                box.add(board.get(7).get(6));
                box.add(board.get(7).get(7));
                box.add(board.get(7).get(8));
                box.add(board.get(8).get(6));
                box.add(board.get(8).get(7));
                box.add(board.get(8).get(8));
            }
        }

        //find which column and add elements to list
        for (int i = 0; i < boardSize; i++) {
            col.add(board.get(i).get(y));
        }

        //find which row and and add elements to list
        for (int i = 0; i < boardSize; i++) {
            row.add(board.get(x).get(i));
        }
        return checkList(box) && checkList(col) && checkList(row);
    }

    @Override
    /**
     * Checks to see if the board is in a "good" state
     * @param board lists being evaluated
     * @return true if board is good, false if board is bad
     */
    public boolean checkBoard(ArrayList<List<Character>> board) {
        //Add boxes
        ArrayList<Character> upperLeft = new ArrayList<Character>();
        upperLeft.add(board.get(0).get(0));
        upperLeft.add(board.get(0).get(1));
        upperLeft.add(board.get(0).get(2));
        upperLeft.add(board.get(1).get(0));
        upperLeft.add(board.get(1).get(1));
        upperLeft.add(board.get(1).get(2));
        upperLeft.add(board.get(2).get(0));
        upperLeft.add(board.get(2).get(1));
        upperLeft.add(board.get(2).get(2));
        ArrayList<Character> upperMiddle = new ArrayList<Character>();
        upperMiddle.add(board.get(0).get(3));
        upperMiddle.add(board.get(0).get(4));
        upperMiddle.add(board.get(0).get(5));
        upperMiddle.add(board.get(1).get(3));
        upperMiddle.add(board.get(1).get(4));
        upperMiddle.add(board.get(1).get(5));
        upperMiddle.add(board.get(2).get(3));
        upperMiddle.add(board.get(2).get(4));
        upperMiddle.add(board.get(2).get(5));
        ArrayList<Character> upperRight = new ArrayList<Character>();
        upperRight.add(board.get(0).get(6));
        upperRight.add(board.get(0).get(7));
        upperRight.add(board.get(0).get(8));
        upperRight.add(board.get(1).get(6));
        upperRight.add(board.get(1).get(7));
        upperRight.add(board.get(1).get(8));
        upperRight.add(board.get(2).get(6));
        upperRight.add(board.get(2).get(7));
        upperRight.add(board.get(2).get(8));
        ArrayList<Character> centerLeft = new ArrayList<Character>();
        centerLeft.add(board.get(3).get(0));
        centerLeft.add(board.get(3).get(1));
        centerLeft.add(board.get(3).get(2));
        centerLeft.add(board.get(4).get(0));
        centerLeft.add(board.get(4).get(1));
        centerLeft.add(board.get(4).get(2));
        centerLeft.add(board.get(5).get(0));
        centerLeft.add(board.get(5).get(1));
        centerLeft.add(board.get(5).get(2));
        ArrayList<Character> centerMiddle = new ArrayList<Character>();
        centerMiddle.add(board.get(3).get(3));
        centerMiddle.add(board.get(3).get(4));
        centerMiddle.add(board.get(3).get(5));
        centerMiddle.add(board.get(4).get(3));
        centerMiddle.add(board.get(4).get(4));
        centerMiddle.add(board.get(4).get(5));
        centerMiddle.add(board.get(5).get(3));
        centerMiddle.add(board.get(5).get(4));
        centerMiddle.add(board.get(5).get(5));
        ArrayList<Character> centerRight = new ArrayList<Character>();
        centerRight.add(board.get(3).get(6));
        centerRight.add(board.get(3).get(7));
        centerRight.add(board.get(3).get(8));
        centerRight.add(board.get(4).get(6));
        centerRight.add(board.get(4).get(7));
        centerRight.add(board.get(4).get(8));
        centerRight.add(board.get(5).get(6));
        centerRight.add(board.get(5).get(7));
        centerRight.add(board.get(5).get(8));
        ArrayList<Character> lowerLeft = new ArrayList<Character>();
        lowerLeft.add(board.get(6).get(0));
        lowerLeft.add(board.get(6).get(1));
        lowerLeft.add(board.get(6).get(2));
        lowerLeft.add(board.get(7).get(0));
        lowerLeft.add(board.get(7).get(1));
        lowerLeft.add(board.get(7).get(2));
        lowerLeft.add(board.get(8).get(0));
        lowerLeft.add(board.get(8).get(1));
        lowerLeft.add(board.get(8).get(2));
        ArrayList<Character> lowerMiddle = new ArrayList<Character>();
        lowerMiddle.add(board.get(6).get(3));
        lowerMiddle.add(board.get(6).get(4));
        lowerMiddle.add(board.get(6).get(5));
        lowerMiddle.add(board.get(7).get(3));
        lowerMiddle.add(board.get(7).get(4));
        lowerMiddle.add(board.get(7).get(5));
        lowerMiddle.add(board.get(8).get(3));
        lowerMiddle.add(board.get(8).get(4));
        lowerMiddle.add(board.get(8).get(5));
        ArrayList<Character> lowerRight = new ArrayList<Character>();
        lowerRight.add(board.get(6).get(6));
        lowerRight.add(board.get(6).get(7));
        lowerRight.add(board.get(6).get(8));
        lowerRight.add(board.get(7).get(6));
        lowerRight.add(board.get(7).get(7));
        lowerRight.add(board.get(7).get(8));
        lowerRight.add(board.get(8).get(6));
        lowerRight.add(board.get(8).get(7));
        lowerRight.add(board.get(8).get(8));
        //Add columns
        ArrayList<Character> col1 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            col1.add(board.get(i).get(0));
        }
        ArrayList<Character> col2 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            col2.add(board.get(i).get(1));
        }
        ArrayList<Character> col3 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            col3.add(board.get(i).get(2));
        }
        ArrayList<Character> col4 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            col4.add(board.get(i).get(3));
        }
        ArrayList<Character> col5 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            col5.add(board.get(i).get(4));
        }
        ArrayList<Character> col6 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            col6.add(board.get(i).get(5));
        }
        ArrayList<Character> col7 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            col7.add(board.get(i).get(6));
        }
        ArrayList<Character> col8 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            col8.add(board.get(i).get(7));
        }
        ArrayList<Character> col9 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            col9.add(board.get(i).get(8));
        }
        //Add rows
        ArrayList<Character> row1 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            row1.add(board.get(0).get(i));
        }
        ArrayList<Character> row2 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            row2.add(board.get(1).get(i));
        }
        ArrayList<Character> row3 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            row3.add(board.get(2).get(i));
        }
        ArrayList<Character> row4 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            row4.add(board.get(3).get(i));
        }
        ArrayList<Character> row5 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            row5.add(board.get(4).get(i));
        }
        ArrayList<Character> row6 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            row6.add(board.get(5).get(i));
        }
        ArrayList<Character> row7 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            row7.add(board.get(6).get(i));
        }
        ArrayList<Character> row8 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            row8.add(board.get(7).get(i));
        }
        ArrayList<Character> row9 = new ArrayList<Character>();
        for(int i = 0; i < boardSize; i++) {
            row9.add(board.get(8).get(i));
        }
        //Check boxes/cols/rows
        boolean boxes = checkList(upperLeft) && checkList(upperMiddle) && checkList(upperRight) &&
                checkList(centerLeft) && checkList(centerMiddle) && checkList(centerRight) &&
                checkList(lowerLeft) && checkList(lowerMiddle) && checkList(lowerRight);
        boolean cols = checkList(col1) && checkList(col2) && checkList(col3) && checkList(col4) && checkList(col5) &&
                checkList(col6) && checkList(col7) && checkList(col8) && checkList(col9);
        boolean rows = checkList(row1) && checkList(row2) && checkList(row3) && checkList(row4) && checkList(row5) &&
                checkList(row6) && checkList(row7) && checkList(row8) && checkList(row9);
        //Print failures
        if(!boxes) {
            System.out.println("A box is not acceptable");
        }
        if(!cols) {
            System.out.println("A column is not acceptable");
        }
        if(!rows) {
            System.out.println("A row is not acceptable");
        }
//        if(!checkList(upperLeft)) {
//            System.out.println("upperLeft");
//        }
//        if(!checkList(centerLeft)) {
//            System.out.println("centerLeft");
//        }
//        if(!checkList(lowerLeft)) {
//            System.out.println("lowerLeft");
//        }
//        if(!checkList(upperMiddle)) {
//            System.out.println("upperMiddle");
//        }
//        if(!checkList(centerMiddle)) {
//            System.out.println("centerMiddle");
//        }
//        if(!checkList(lowerMiddle)) {
//            System.out.println("lowerMiddle");
//        }
//        if(!checkList(upperRight)) {
//            System.out.println("upperRight");
//        }
//        if(!checkList(centerRight)) {
//            System.out.println("centerRight");
//        }
//        if(!checkList(lowerRight)) {
//            System.out.println("lowerRight");
//        }
        return boxes && cols && rows;
    }
}
