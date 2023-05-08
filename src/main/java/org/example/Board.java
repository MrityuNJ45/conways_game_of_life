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

    public Integer getNumOfElements() {

        return this.columns * this.rows;

    }


    public void populate() {

        List<List<Cell>> randomMatrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
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

    public Integer numOfLiveCells() {

        Integer liveCells = 0;
        for (List<Cell> cellList : this.matrix) {
            for (Cell cell : cellList) {
                if (cell.isAlive()) liveCells++;
            }
        }
        return liveCells;

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

    public Boolean isNeighbourAliveAt(Integer rowNo, Integer columnNo) {

        if (rowNo < 0 || columnNo < 0 || rowNo >= this.rows || columnNo >= this.columns) {
            return false;
        }

        return this.matrix.get(rowNo).get(columnNo).isAlive();

    }

    public Integer countLiveNeighbours(Integer rowNo, Integer columNo) {

        Integer count = 0;
        if (isNeighbourAliveAt(rowNo + 1, columNo)) count += 1;
        if (isNeighbourAliveAt(rowNo - 1, columNo)) count += 1;
        if (isNeighbourAliveAt(rowNo, columNo + 1)) count += 1;
        if (isNeighbourAliveAt(rowNo, columNo - 1)) count += 1;
        if (isNeighbourAliveAt(rowNo + 1, columNo + 1)) count += 1;
        if (isNeighbourAliveAt(rowNo + 1, columNo - 1)) count += 1;
        if (isNeighbourAliveAt(rowNo - 1, columNo + 1)) count += 1;
        if (isNeighbourAliveAt(rowNo - 1, columNo - 1)) count += 1;

        return count;

    }

    public Cell cellForNextGeneration(Integer rowNo, Integer columnNo) {

        Integer liveCells = countLiveNeighbours(rowNo, columnNo);
        Cell cellAtPosition = this.matrix.get(rowNo).get(columnNo);
        if (cellAtPosition.isAlive()) {
            if (liveCells >= 2 && liveCells <= 3) {
                return new Cell(true);
            }
        }
        if (liveCells == 3) {
            return new Cell(true);
        }
        return new Cell(false);

    }

    public Board boardForNextGeneration() {
        List<List<Cell>> nextMatrix = new ArrayList<>();

        for (int i = 0; i < this.rows; i++) {
            List<Cell> nextMatrixRow = new ArrayList<>();
            for (int j = 0; j < this.columns; j++) {
                Cell generatedCell = cellForNextGeneration(i, j);
                nextMatrixRow.add(generatedCell);
            }
            nextMatrix.add(nextMatrixRow);
        }

        return new Board(this.rows, this.columns, nextMatrix);
    }

    public boolean equals(Board board) {

        return this.rows == board.rows && this.columns == board.columns && this.matrix.equals(board.matrix);

    }


}
