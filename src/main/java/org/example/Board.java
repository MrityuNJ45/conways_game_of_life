package org.example;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Integer rows;

    private Integer columns;

    private List<List<Cell>> matrix;

    public Board(Integer rows, Integer columns) throws IllegalStateException {

        if (rows <= 0 || columns <= 0) {
            throw new IllegalStateException("Rows and Columns must be above 0");
        }

        this.rows = rows;
        this.columns = columns;
        matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Cell> list = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                list.add(new Cell(false));
            }
            matrix.add(list);
        }

    }

    public Board(Integer rows, Integer columns, List<List<Cell>> matrix) throws IllegalStateException {

        if (rows <= 0 || columns <= 0 || !(matrix instanceof List<List<Cell>>)) {
            throw new IllegalStateException("Invalid data provided...");
        }
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;

    }




    public void populate() {

        List<List<Cell>> randomMatrix = new ArrayList<>();
        for (int i = 0; i < this.rows; i++) {
            List<Cell> randomMatrixRow = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                Integer random = Math.toIntExact(Math.round(Math.random()));
                if (random == 0) {
                    randomMatrixRow.add(new Cell(false));
                    continue;
                }
                randomMatrixRow.add(new Cell(true));
            }
            randomMatrix.add(randomMatrixRow);
        }
        this.matrix = randomMatrix;

    }




    public void printBoard() {

        for (List<Cell> list : this.matrix) {
            for (Cell cell : list) {
                if (cell.isAlive())
                    System.out.print("*" + " ");
                else
                    System.out.print("_" + " ");
            }
            System.out.println();
        }

    }


    public Board boardForNextGeneration() {

        List<List<Cell>> nextMatrix = new ArrayList<>();
        for (int row = 0; row < this.rows; row++) {
            List<Cell> nextMatrixRow = new ArrayList<>();
            for (int column = 0; column < this.columns; column++) {
                 Integer noOfLiveCells = CellBoardCommuter.getNumberOfLiveNeighboursAt(row, column, this.matrix);
                 Cell nextCell = this.matrix.get(row).get(column).cellForNextGeneration(noOfLiveCells);
                 nextMatrixRow.add(nextCell);
            }
            nextMatrix.add(nextMatrixRow);
        }

        return new Board(this.rows, this.columns, nextMatrix);

    }

    public boolean equals(Board board) {

        return this.rows == board.rows && this.columns == board.columns && this.matrix.equals(board.matrix);

    }


}
