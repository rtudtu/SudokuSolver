package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e633828 on 7/14/2017.
 */
public class SudokuModel4x4 extends ASudokuModel {
/*
    //===============\\
    || - | 1 | 3 | - ||
    || 2 | - | - | - ||
    ||-------+-------||
    || - | - | - | 3 ||
    || - | 2 | 1 | - ||
    \\===============//
    ...
    //===============\\
    || 4 | 1 | 3 | 2 ||
    || 2 | 3 | 4 | 1 ||
    ||-------+-------||
    || 1 | 4 | 2 | 3 ||
    || 3 | 2 | 1 | 4 ||
    \\===============//

    //===============\\
    || 3 | - | 2 | - ||
    || - | - | - | - ||
    ||-------+-------||
    || - | - | - | - ||
    || - | 1 | - | 4 ||
    \\===============//
    ...
    //===============\\
    || 3 | 4 | 2 | 1 ||
    || 1 | 2 | 4 | 3 ||
    ||-------+-------||
    || 4 | 3 | 1 | 2 ||
    || 2 | 1 | 3 | 4 ||
    \\===============//

    //===============\\
    || - | - | 1 | 3 ||
    || 4 | 2 | - | - ||
    ||-------+-------||
    || - | - | 2 | - ||
    || - | - | - | - ||
    \\===============//
    ...
    Impossible to solve - [0,1] cannot be 1, 2, 3, or 4 with given input
*/


    public SudokuModel4x4() {

    }

    @Override
    public String displayBoard(ArrayList<List<Character>> board) {
        String output = "";
        output += "Board: \n";
        output += "//===============\\\\\n";
        for(int i = 0; i < boardSize; i++) {
            output += "||";
            for(int j = 0; j < boardSize; j++) {
                output += " ";
                output += board.get(i).get(j);
                output += " |";
            }
            if(i == (boardSize / 2) - 1) {
                output += "|\n" +
                        "||-------+-------||\n";
            } else {
                output += "|\n";
            }
        }
        output += "\\\\===============//\n";
        return output;
    }

    @Override
    public boolean checkLoc(ArrayList<List<Character>> board, int x, int y) {
        ArrayList<Character> box = new ArrayList<Character>();
        ArrayList<Character> col = new ArrayList<Character>();
        ArrayList<Character> row = new ArrayList<Character>();

        //find which box x and y are in and add elements to list
        if(x < boardSize / 2) {
            if(y < boardSize / 2) {
                //top left box
                box.add(board.get(0).get(0));
                box.add(board.get(0).get(1));
                box.add(board.get(1).get(0));
                box.add(board.get(1).get(1));
            } else {
                //top right box
                box.add(board.get(0).get(2));
                box.add(board.get(0).get(3));
                box.add(board.get(1).get(2));
                box.add(board.get(1).get(3));
            }

        } else if(x >= boardSize / 2) {
            if(y < boardSize / 2) {
                //bottom left box
                box.add(board.get(2).get(0));
                box.add(board.get(2).get(1));
                box.add(board.get(3).get(0));
                box.add(board.get(3).get(1));
            } else {
                //bottom right box
                box.add(board.get(2).get(2));
                box.add(board.get(2).get(3));
                box.add(board.get(3).get(2));
                box.add(board.get(3).get(3));
            }
        }

        //find which column and add elements to list
        for(int i = 0; i < boardSize; i++) {
            col.add(board.get(i).get(y));
        }

        //find which row and and add elements to list
        for(int i = 0; i < boardSize; i++) {
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
        ArrayList<Character> upperLeft = new ArrayList<Character>();
        upperLeft.add(board.get(0).get(0));
        upperLeft.add(board.get(0).get(1));
        upperLeft.add(board.get(1).get(0));
        upperLeft.add(board.get(1).get(1));
        ArrayList<Character> upperRight = new ArrayList<Character>();
        upperRight.add(board.get(0).get(2));
        upperRight.add(board.get(0).get(3));
        upperRight.add(board.get(1).get(2));
        upperRight.add(board.get(1).get(3));
        ArrayList<Character> lowerLeft = new ArrayList<Character>();
        lowerLeft.add(board.get(2).get(0));
        lowerLeft.add(board.get(2).get(1));
        lowerLeft.add(board.get(3).get(0));
        lowerLeft.add(board.get(3).get(1));
        ArrayList<Character> lowerRight = new ArrayList<Character>();
        lowerRight.add(board.get(2).get(2));
        lowerRight.add(board.get(2).get(3));
        lowerRight.add(board.get(3).get(2));
        lowerRight.add(board.get(3).get(3));
        ArrayList<Character> col1 = new ArrayList<Character>();
        col1.add(board.get(0).get(0));
        col1.add(board.get(1).get(0));
        col1.add(board.get(2).get(0));
        col1.add(board.get(3).get(0));
        ArrayList<Character> col2 = new ArrayList<Character>();
        col2.add(board.get(0).get(1));
        col2.add(board.get(1).get(1));
        col2.add(board.get(2).get(1));
        col2.add(board.get(3).get(1));
        ArrayList<Character> col3 = new ArrayList<Character>();
        col3.add(board.get(0).get(2));
        col3.add(board.get(1).get(2));
        col3.add(board.get(2).get(2));
        col3.add(board.get(3).get(2));
        ArrayList<Character> col4 = new ArrayList<Character>();
        col4.add(board.get(0).get(3));
        col4.add(board.get(1).get(3));
        col4.add(board.get(2).get(3));
        col4.add(board.get(3).get(3));
        ArrayList<Character> row1 = new ArrayList<Character>();
        row1.add(board.get(0).get(0));
        row1.add(board.get(0).get(1));
        row1.add(board.get(0).get(2));
        row1.add(board.get(0).get(3));
        ArrayList<Character> row2 = new ArrayList<Character>();
        row2.add(board.get(1).get(0));
        row2.add(board.get(1).get(1));
        row2.add(board.get(1).get(2));
        row2.add(board.get(1).get(3));
        ArrayList<Character> row3 = new ArrayList<Character>();
        row3.add(board.get(2).get(0));
        row3.add(board.get(2).get(1));
        row3.add(board.get(2).get(2));
        row3.add(board.get(2).get(3));
        ArrayList<Character> row4 = new ArrayList<Character>();
        row4.add(board.get(3).get(0));
        row4.add(board.get(3).get(1));
        row4.add(board.get(3).get(2));
        row4.add(board.get(3).get(3));
        boolean boxes = checkList(upperLeft) && checkList(upperRight) && checkList(lowerLeft) && checkList(lowerRight);
        boolean cols = checkList(col1) && checkList(col2) && checkList(col3) && checkList(col4);
        boolean rows = checkList(row1) && checkList(row2) && checkList(row3) && checkList(row4);
        //System.out.println(boxes);
        //System.out.println(cols);
        //System.out.println(rows);
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
        return boxes && cols && rows;
    }
}