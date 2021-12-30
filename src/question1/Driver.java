package question1;

import java.util.Scanner;

public class Driver {
	public static void main(String a[]) {
		//import
		Scanner input = new Scanner(System.in);
		//take input of transactions size
		System.out.println("Enter the size of transactions:");
		int transactionSize = input.nextInt();
		//take input of transaction values and store in an array
		int transactionsArr[] = new int[transactionSize];
		System.out.println("Please input transaction values:");
		
		for(int i =0;i<transactionSize;i++) {
			transactionsArr[i] = input.nextInt();
		}
		//take input for number of targets to be checked
		System.out.println("Enter the total number of targets that need to be achieved: ");
		int targetSize = input.nextInt();
		
		int count = 0;
		while(count<targetSize) {
			//take input of target
			System.out.println("Enter the value of target");
			int target = input.nextInt();
			int sum =0;
			int i = 0;
			while(sum<target && i<transactionSize) {
				sum += transactionsArr[i];
				i++;
			}
			if(sum<target) {
				System.out.println("Given target is not achieved.");
			}
			else {
				System.out.println("Target achieved after " + i + " transactions");
			}
			sum =0;
			i =0;
			count++;
		}
		input.close();
	}
}
