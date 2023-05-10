package org.example;

import java.util.*;
public class CellBoardCommunicator {


    public static Boolean isCellAliveAt(Integer rowNo, Integer columnNo,  List<List<Cell>> matrix){

        if(rowNo < 0 || columnNo < 0 || rowNo >= matrix.size() || columnNo >= matrix.get(0).size()){
            return false;
        }
        return matrix.get(rowNo).get(columnNo).isAlive();

    }

    public static Integer getNumberOfLiveNeighboursAt(Integer rowNo, Integer columnNo, List<List<Cell>> matrix){

        Integer count = 0;
        if (isCellAliveAt(rowNo + 1, columnNo, matrix)) count += 1;
        if (isCellAliveAt(rowNo - 1, columnNo, matrix)) count += 1;
        if (isCellAliveAt(rowNo, columnNo + 1, matrix)) count += 1;
        if (isCellAliveAt(rowNo, columnNo - 1, matrix)) count += 1;
        if (isCellAliveAt(rowNo + 1, columnNo + 1, matrix)) count += 1;
        if (isCellAliveAt(rowNo + 1, columnNo - 1, matrix)) count += 1;
        if (isCellAliveAt(rowNo - 1, columnNo + 1, matrix)) count += 1;
        if (isCellAliveAt(rowNo - 1, columnNo - 1, matrix)) count += 1;

        return count;


    }



}
