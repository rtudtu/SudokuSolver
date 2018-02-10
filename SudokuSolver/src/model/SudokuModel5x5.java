package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e633828 on 8/25/2017.
 */
public class SudokuModel5x5 extends ASudokuModel{

    /*
    //===================\\
    || -   -   5 | 1   - ||
    ||       +---+       ||
    || -   - | - | -   2 ||
    ||---+---+   +---+   ||
    || 2 | -   -   - | 4 ||
    ||   +---+   +---+---||
    || 3   - | - | -   - ||
    ||       +---+       ||
    || -   4 | 3   -   - ||
    \\===================//
    ...
    //===================\\
    || 4   2   5 | 1   3 ||
    ||       +---+       ||
    || 1   3 | 4 | 5   2 ||
    ||---+---+   +---+   ||
    || 2 | 5   1   3 | 4 ||
    ||   +---+   +---+---||
    || 3   1 | 2 | 4   5 ||
    ||       +---+       ||
    || 5   4 | 3   2   1 ||
    \\===================//

     */

    public SudokuModel5x5() {

    }

    @Override
    public String displayBoard(ArrayList<List<Character>> board) {
        String output = "";
        output += "Board: \n";
        output += "//===================\\\\\n";
        for(int i = 0; i < boardSize; i++) {
            output += "||";
            for (int j = 0; j < boardSize; j++) {
                output += " ";
                output += board.get(i).get(j);
                if (i == 0 && j == 2 || i == 1 && j == 1 || i == 1 && j == 2 || i == 2 && j == 0 || i == 2 && j == 3 ||
                        i == 3 && j == 1 || i == 3 && j == 2 || i == 4 && j == 1 || i == 0 && j == 4 ||
                        i == 1 && j == 4 || i == 2 && j == 4 || i == 3 && j == 4 || i == 4 && j == 4) {
                    output += " |";
                } else {
                    output += "  ";
                }
            }
            output += "|\n";
            if (i == 0) {
                output += "||       +---+       ||\n";
            } else if (i == 1) {
                output += "||---+---+   +---+   ||\n";
            } else if (i == 2) {
                output += "||   +---+   +---+---||\n";
            } else if (i == 3) {
                output += "||       +---+       ||\n";
            }
        }
        output += "\\\\===================//\n";
        return output;
    }

    @Override
    public boolean checkLoc(ArrayList<List<Character>> board, int x, int y) {
        ArrayList<Character> box = new ArrayList<Character>();
        ArrayList<Character> col = new ArrayList<Character>();
        ArrayList<Character> row = new ArrayList<Character>();


        //find which box x and y are in and add elements to list
        if(x == 0) {
            if(y < 3) {
                //top left box
                box = topLeftBox();
            } else {
                //top right box
                box = topRightBox();
            }
        } else if(x == 1) {
            if(y < 2) {
                //top left box
                box = topLeftBox();
            } else if(y < 3) {
                //middle box
                box = middleBox();
            } else {
                //top right box
                box = topRightBox();
            }
        } else if(x == 2) {
            if(y < 1) {
                //bottom left box
                box = bottomLeftBox();
            } else if(y < 4) {
                //middle box
                box = middleBox();
            } else {
                //top right box
                box = topRightBox();
            }
        } else if(x == 3) {
            if(y < 2) {
                //bottom left box
                box = bottomLeftBox();
            } else if(y < 3) {
                //middle box
                box = middleBox();
            } else {
                //bottom right box
                box = bottomRightBox();
            }
        } else if(x == 4) {
            if(y < 3) {
                //bottom left box=
                box = bottomLeftBox();
            } else {
                //bottom right box
                box = bottomRightBox();
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

    public ArrayList<Character> topLeftBox() {
        ArrayList<Character> boxList = new ArrayList<Character>();
        boxList.add(board.get(0).get(0));
        boxList.add(board.get(0).get(1));
        boxList.add(board.get(0).get(2));
        boxList.add(board.get(1).get(0));
        boxList.add(board.get(1).get(1));
        return boxList;
    }
    public ArrayList<Character> topRightBox() {
        ArrayList<Character> boxList = new ArrayList<Character>();
        boxList.add(board.get(0).get(3));
        boxList.add(board.get(0).get(4));
        boxList.add(board.get(1).get(3));
        boxList.add(board.get(1).get(4));
        boxList.add(board.get(2).get(4));
        return boxList;
    }
    public ArrayList<Character> middleBox() {
        ArrayList<Character> boxList = new ArrayList<Character>();
        boxList.add(board.get(1).get(2));
        boxList.add(board.get(2).get(1));
        boxList.add(board.get(2).get(2));
        boxList.add(board.get(2).get(3));
        boxList.add(board.get(3).get(2));
        return boxList;
    }
    public ArrayList<Character> bottomLeftBox() {
        ArrayList<Character> boxList = new ArrayList<Character>();
        boxList.add(board.get(2).get(0));
        boxList.add(board.get(3).get(0));
        boxList.add(board.get(3).get(1));
        boxList.add(board.get(4).get(0));
        boxList.add(board.get(4).get(1));
        return boxList;
    }
    public ArrayList<Character> bottomRightBox() {
        ArrayList<Character> boxList = new ArrayList<Character>();
        boxList.add(board.get(3).get(3));
        boxList.add(board.get(3).get(4));
        boxList.add(board.get(4).get(2));
        boxList.add(board.get(4).get(3));
        boxList.add(board.get(4).get(4));
        return boxList;
    }

    @Override
    /**
     * Checks to see if the board is in a "good" state
     * @param board lists being evaluated
     * @return true if board is good, false if board is bad
     */
    public boolean checkBoard(ArrayList<List<Character>> board) {
        ArrayList<Character> upperLeft = new ArrayList<Character>();
        upperLeft = topLeftBox();
        ArrayList<Character> upperRight = new ArrayList<Character>();
        upperRight = topRightBox();
        ArrayList<Character> center = new ArrayList<Character>();
        center = middleBox();
        ArrayList<Character> lowerLeft = new ArrayList<Character>();
        lowerLeft = bottomLeftBox();
        ArrayList<Character> lowerRight = new ArrayList<Character>();
        lowerRight = bottomRightBox();
        ArrayList<Character> col1 = new ArrayList<Character>();
        col1.add(board.get(0).get(0));
        col1.add(board.get(1).get(0));
        col1.add(board.get(2).get(0));
        col1.add(board.get(3).get(0));
        col1.add(board.get(4).get(0));
        ArrayList<Character> col2 = new ArrayList<Character>();
        col2.add(board.get(0).get(1));
        col2.add(board.get(1).get(1));
        col2.add(board.get(2).get(1));
        col2.add(board.get(3).get(1));
        col2.add(board.get(4).get(1));
        ArrayList<Character> col3 = new ArrayList<Character>();
        col3.add(board.get(0).get(2));
        col3.add(board.get(1).get(2));
        col3.add(board.get(2).get(2));
        col3.add(board.get(3).get(2));
        col3.add(board.get(4).get(2));
        ArrayList<Character> col4 = new ArrayList<Character>();
        col4.add(board.get(0).get(3));
        col4.add(board.get(1).get(3));
        col4.add(board.get(2).get(3));
        col4.add(board.get(3).get(3));
        col4.add(board.get(4).get(3));
        ArrayList<Character> col5 = new ArrayList<Character>();
        col5.add(board.get(0).get(4));
        col5.add(board.get(1).get(4));
        col5.add(board.get(2).get(4));
        col5.add(board.get(3).get(4));
        col5.add(board.get(4).get(4));
        ArrayList<Character> row1 = new ArrayList<Character>();
        row1.add(board.get(0).get(0));
        row1.add(board.get(0).get(1));
        row1.add(board.get(0).get(2));
        row1.add(board.get(0).get(3));
        row1.add(board.get(0).get(4));
        ArrayList<Character> row2 = new ArrayList<Character>();
        row2.add(board.get(1).get(0));
        row2.add(board.get(1).get(1));
        row2.add(board.get(1).get(2));
        row2.add(board.get(1).get(3));
        row2.add(board.get(1).get(4));
        ArrayList<Character> row3 = new ArrayList<Character>();
        row3.add(board.get(2).get(0));
        row3.add(board.get(2).get(1));
        row3.add(board.get(2).get(2));
        row3.add(board.get(2).get(3));
        row3.add(board.get(2).get(4));
        ArrayList<Character> row4 = new ArrayList<Character>();
        row4.add(board.get(3).get(0));
        row4.add(board.get(3).get(1));
        row4.add(board.get(3).get(2));
        row4.add(board.get(3).get(3));
        row4.add(board.get(3).get(4));
        ArrayList<Character> row5 = new ArrayList<Character>();
        row5.add(board.get(4).get(0));
        row5.add(board.get(4).get(1));
        row5.add(board.get(4).get(2));
        row5.add(board.get(4).get(3));
        row5.add(board.get(4).get(4));
        boolean boxes = checkList(upperLeft) && checkList(upperRight) && checkList(center) && checkList(lowerLeft) && checkList(lowerRight);
        boolean cols = checkList(col1) && checkList(col2) && checkList(col3) && checkList(col4) && checkList(col5);
        boolean rows = checkList(row1) && checkList(row2) && checkList(row3) && checkList(row4) && checkList(row5);
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
