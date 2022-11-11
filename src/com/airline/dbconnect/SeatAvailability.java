package com.airline.dbconnect;
import java.util.Random;
import java.util.Scanner;

public class SeatAvailability {
	public static void main(String []args) {
		public static int[] SeatAvailability() {
			Random rand = new Random();
			try (Scanner sc = new Scanner(System.in)) {
				int[] seat = new int[3];
				int bookedEconomyclass, bookedFirstclass;

				int totalSeats = (int) (Math.random() * (31) + 30);
				int EconomySeats = (int) (totalSeats * 0.7);
				int FirstclassSeats = totalSeats - EconomySeats;
				int freeEconomySeats = rand.nextInt(EconomySeats);
				int freeFirstclassSeats = rand.nextInt(FirstclassSeats);
				int totalfreeSeats = freeEconomySeats + freeFirstclassSeats;
				System.out.println("\n\nTotal Available Seats are : " + totalfreeSeats);
				System.out.println("Available  Economy Seats are : " + freeEconomySeats);
				System.out.println("Available First Class Seats are : " + freeFirstclassSeats);

				System.out.println("\nTo book an Economy class Ticket Enter 0 or");
				System.out.println("To book a First class Ticket Enter 1 : ");
				int choice = sc.nextInt();
				if (choice == 0) {
					System.out.print("\n\nHow many Tickets do you want to book : ");
					int tnum1 = sc.nextInt();
					if (tnum1 > 0 && tnum1 <= freeEconomySeats) {
						bookedEconomyclass = tnum1;
						System.out.println("Booked Economy Seats are : " + bookedEconomyclass);
						seat[0] = bookedEconomyclass;
						seat[1] = 0;
						seat[2] = 1;

					} else {
						System.out.println("Enter Valid Number Of Tickets!!");
					}

				} else if (choice == 1) {
					System.out.print("\nHow many Tickets do you want to book : ");
					int tnum2 = sc.nextInt();
					if (tnum2 > 0 && tnum2 <= freeFirstclassSeats) {
						bookedFirstclass = tnum2;
						System.out.println("Booked First class Seats are : " + bookedFirstclass);
						seat[0] = bookedFirstclass;
						seat[1] = 1;
						seat[2] = 1;
					} else {
						System.out.println("Enter Valid Number Of Tickets!!");
					}
				} else {
					System.out.println("Enter Valid Choice!!");
				}

				return;
			}

		}
    }

}
