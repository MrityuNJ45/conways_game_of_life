package org.example;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Integer rows;

    private Integer columns;

    private List<List<Cell>> matrix;

    public Board(Integer rows, Integer columns){

        this.rows = rows;
        this.columns = columns;
        matrix = new ArrayList<>();
        for(int i=0; i<rows; i++){
            List<Cell> list = new ArrayList<>();
            for(int j=0; j<columns; j++){
                Integer random = Math.toIntExact(Math.round(Math.random()));
                if(random == 0){
                    list.add(new Cell(i,j,rows,columns,false));
                    continue;
                }
                list.add(new Cell(i,j,rows,columns,true));
            }
            matrix.add(list);
        }
    }

    // create a public method for random population
    public Integer getNumOfElements(){

        return this.columns * this.rows;

    }

    public void printBoard(){

        for(List<Cell> list : this.matrix){
            for(Cell cell : list){
                if(cell.isAlive())
                    System.out.print(1 + " ");
                else
                    System.out.print(0 +" ");
            }
            System.out.println();
        }


    }

    //public



}
