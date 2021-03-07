package solutions;
import java.util.Scanner;

public class P06_FairPassengersDivision {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int firstBus = scan.nextInt();
		int secondBus = scan.nextInt();
		int totalPassengers = firstBus + secondBus;
		int minPassengersInEachBus = totalPassengers / 3;
		int thirdBus = minPassengersInEachBus + totalPassengers % 3;
		System.out.println("First: " + minPassengersInEachBus);
		System.out.println("Second: " + minPassengersInEachBus);
		System.out.println("Third: " + thirdBus);
		scan.close();
	}
}
