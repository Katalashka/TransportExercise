package com.company;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		NotMain NotMain = new NotMain();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Поочередно укажите сначала количество поставщиков, а затем количество складов");
		NotMain.setMatrix(scanner.nextInt() + 1,scanner.nextInt() + 1);
//+1 Тк матрица должна хранить стоимость перевозки для каждого склада и перевозимого товара вместе с
//количеством места в них
		System.out.println("Поочередно указывайте размеры складов:");
		NotMain.setSizeWarehouse();

		System.out.println("Поочередно указывайте размеры поставщиков:");
		NotMain.setSizeGoods();

		NotMain.getCheckCloseTask();

		System.out.println("Поочередно указывайте цены на доставку:");
		NotMain.setCost();

		NotMain.getMatrix();

		System.out.println("Стоимость перевозок будет составлять: " + NotMain.getResult());
	}
}