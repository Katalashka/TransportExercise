package com.company;
import java.util.Scanner;

public class NotMain {

    private int amountGoods;
    private int amountWarehouse;
    private int matrix[][];
    private int checkCloseTask = 0;
    private int numColumn;
    private int minCost = Integer.MAX_VALUE;
    private int result;
    Scanner in = new Scanner(System.in);

    public void setMatrix(int amountWarehouse, int amountGoods) {
        this.matrix = new int [amountWarehouse][amountGoods];

        this.amountWarehouse = amountWarehouse ;
        this.amountGoods = amountGoods;
        matrix[0][0] = 99;//Нужно инициализировать, иначе вывод не сработает
    }

    public void getMatrix (){
        for (int indexLine = 0; indexLine < amountWarehouse; indexLine++) {
            for (int indexColumn = 0; indexColumn < amountGoods;     indexColumn++) {
                System.out.print(matrix[indexLine][indexColumn] + "\t");
            }
            System.out.println();
        }

    }

    public void getCheckCloseTask() {
        if (checkCloseTask != 0){
            System.out.println("Количества товаров и места в складах не совпадает.");
        }
    }

    public void setSizeWarehouse(){
        for(int indexLine = 1; indexLine < amountWarehouse; indexLine++){
            matrix[indexLine][0] = in.nextInt();
            this.checkCloseTask += matrix[indexLine][0];
        }
    }

    public void setSizeGoods(){
        for(int indexColumn = 1; indexColumn < amountWarehouse; indexColumn++){
            matrix[0][indexColumn] = in.nextInt();
            this.checkCloseTask += matrix[0][indexColumn];
        }
    }

    public void setCost(){
        for (int indexLine = 1; indexLine < amountWarehouse; indexLine++) {
            for (int indexColumn = 1; indexColumn < amountGoods; indexColumn++) {
                matrix[indexLine][indexColumn] = (in.nextInt());
            }
        }
    }

    public void searchMinPrice(int indexLine){
        for (int indexColumn = 1; indexColumn < amountGoods; indexColumn++) {
            if (minCost > matrix[indexLine][indexColumn]) {
                minCost = matrix[indexLine][indexColumn];
                numColumn = indexColumn;
            }
        }
    }

    public void functionPositiveValueWarehouse(int indexLine){
        matrix[indexLine][0] -= matrix[0][numColumn];
        result += (matrix[0][numColumn] * minCost);
        matrix[0][numColumn] = 0;
    }

    public int getResult(){
        for (int indexLine = 1; indexLine < amountWarehouse; indexLine++) {

            searchMinPrice(indexLine);

            matrix[indexLine][numColumn] = Integer.MAX_VALUE;
            while(matrix[indexLine][0] > matrix[0][numColumn]){
                functionPositiveValueWarehouse(indexLine);
                minCost = Integer.MAX_VALUE;

                searchMinPrice(indexLine);

                matrix[indexLine][numColumn] = Integer.MAX_VALUE;
            }
            if (matrix[indexLine][0] < matrix[0][numColumn]) {
                matrix[0][numColumn] -= matrix[indexLine][0];
                result += (matrix[indexLine][0] * minCost);
                matrix[indexLine][0] = 0;
            }
            if (matrix[indexLine][0] == matrix[0][numColumn]) {
                functionPositiveValueWarehouse(indexLine);
            }
            minCost = Integer.MAX_VALUE;
        }
        return result;
    }
}
