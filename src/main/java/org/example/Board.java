package org.example;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Integer rows;

    private Integer columns;

    private List<List<Cell>> matrix;

    public Board(Integer rows, Integer columns) throws IllegalStateException{

        if(rows <= 0 || columns <= 0){
            throw new IllegalStateException("Rows and Columns must be above 0");
        }

        this.rows = rows;
        this.columns = columns;
        matrix = new ArrayList<>();
        for(int i=0; i<rows; i++){
            List<Cell> list = new ArrayList<>();
            for(int j=0; j<columns; j++){
                list.add(new Cell(false));
            }
            matrix.add(list);
        }

    }

    // NOTE : Just for testing purpose not to be used.
    public Board(List<List<Cell>> matrix){
        this.rows = matrix.size();
        this.columns = matrix.get(0).size();
        this.matrix = matrix;
    }




    public Integer getNumOfElements(){

        return this.columns * this.rows;

    }


    public void populate(){

        List<List<Cell>> randomMatrix = new ArrayList<>();
        for(int i=0; i<rows; i++){
            List<Cell> randomMatrixRow = new ArrayList<>();
            for(int j=0; j<columns; j++){
                Integer random = Math.toIntExact(Math.round(Math.random()));
                if(random == 0){
                    randomMatrixRow.add(new Cell(false));
                    continue;
                }
                randomMatrixRow.add(new Cell(true));
            }
            randomMatrix.add(randomMatrixRow);
        }
        this.matrix = randomMatrix;

    }

    public Integer numOfLiveCells(){

        Integer liveCells = 0;
        for(List<Cell> cellList : this.matrix){
            for(Cell cell : cellList){
                if(cell.isAlive()) liveCells++;
            }
        }
        return liveCells;

    }

//    public void printBoard(){
//
//        for(List<Cell> list : this.matrix){
//            for(Cell cell : list){
//                if(cell.isAlive())
//                    System.out.print(1 + " ");
//                else
//                    System.out.print(0 +" ");
//            }
//            System.out.println();
//        }
//
//
//    }

    public Boolean checkNeighbourAt(Integer rowNo, Integer columnNo){

        if(rowNo < 0 || columnNo < 0 || rowNo >= this.rows || columnNo >= this.columns){
            return false;
        }

        return this.matrix.get(rowNo).get(columnNo).isAlive();

    }

    public Integer countLiveNeighbours(Integer rowNo, Integer columNo){

        Integer count = 0;
        if(checkNeighbourAt(rowNo + 1,columNo)) count += 1;
        if(checkNeighbourAt(rowNo - 1,columNo)) count += 1;
        if(checkNeighbourAt(rowNo,columNo + 1)) count += 1;
        if(checkNeighbourAt(rowNo,columNo - 1)) count += 1;
        if(checkNeighbourAt(rowNo + 1,columNo +1)) count += 1;
        if(checkNeighbourAt(rowNo + 1,columNo -1)) count += 1;
        if(checkNeighbourAt(rowNo - 1,columNo +1)) count += 1;
        if(checkNeighbourAt(rowNo - 1,columNo -1)) count += 1;

        return count;


    }



}
