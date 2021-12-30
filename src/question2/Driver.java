package question2;

import java.util.Scanner;


public class Driver {
	public static void main(String a[]) {
		Scanner input = new Scanner(System.in);
		//take input of denominations size
		System.out.println("Enter the size of currency denominations");
		int denominationSize = input.nextInt();
		//take input of denomination values and store in an array
		int denominationArr[] = new int[denominationSize];
		System.out.println("Enter the currency denominations value:");
		
		for(int i =0;i<denominationSize;i++) {
			denominationArr[i] = input.nextInt();
		}
		//take input for amount to be paid:
		System.out.println("Enter the amount you want to pay ");
		int amount = input.nextInt();
		
		//Print denominations:
		for(int i =0;i<denominationSize;i++) {
			System.out.print(denominationArr[i]+" |");
		}
		System.out.println();
		if(denominationSize>1) {
			//First sort the denominations in descending order
			for(int i =0;i<denominationSize;i++) {
				for(int j =0;j<denominationSize-1;j++) {
					if(denominationArr[j]<denominationArr[j+1]) {
						int temp = denominationArr[j+1];
						denominationArr[j+1] = denominationArr[j];
						denominationArr[j] = temp;
					}
				}
			}
		}
		//just in case amount to be paid is less than the biggest denomination, find denomination equal or smaller than the amount to be paid.
		int count = 0;
		while(denominationArr[count]>amount) {
			count++;
		}
		
		int denominationsToPay[][] = new int[denominationSize][2];
		while(count<denominationSize && amount>0) {
			for(int i = count,j=0;i<denominationSize;i++) {
				if(amount / denominationArr[i]>= 1) {
					denominationsToPay[j][0] = denominationArr[i];
					denominationsToPay[j][1] = 0;
					while(amount / denominationArr[i]>= 1) {
						denominationsToPay[j][1]++;
						amount = amount - denominationArr[i];
					}
					j++;
				}
			}
		}
		
		System.out.println("Your payment approach in order to give min no of notes will be: ");
	
		for(int i =0;i<denominationsToPay.length;i++) {
			if(denominationsToPay[i][0]!= 0) {
				System.out.println(denominationsToPay[i][0]+": " + denominationsToPay[i][1]);
			}
		}
	}
}
