package com.airline.dbconnect;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class AirlineTicketReservationSystem {
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Random rand = new Random();
		 try  {
			LocalDate dt = LocalDate.now();
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String pdate = dt.format(df);

			int op = 1, cnf, pmt, id = 0, flag = 0;

			String section = new String();
			String[] city = new String[] { "Banglore", "Hyderabad", "Chennai", "Mumbai" };
			String[] airporttype = new String[] { "Single", "Multihop" };
			int[] arr = new int[2];
			int[] mark = new int[2];
		

			System.out.println("\n---------------------------------------------------------------------");
			System.out.println("--------WELCOME TO  AIRLINE TICKET RESERVATION CENTER--------");
			System.out.println("---------------------------------------------------------------------");
			System.out.println("For Flight Booking of : Banglore-Hyderabad-Chennai-Mumbai");
			System.out.println("Book your tickets");

			Route[] flt = new Route[20];
			Airplane[] apft = new Airplane[5];
			ticket[] tck = new ticket[10];

			for (int i = 0; i < 20; i++)
				flt[i] = new Route();
			for (int i = 0; i < 5; i++)
				apft[i] = new Airplane();
			for (int i = 0; i < 10; i++) {
				tck[i] = new ticket();
				tck[i].ticket = 111;
			}

			apft[0].setdetails("Spicejet A320-200", "passenger", 121, 180);
			apft[1].setdetails("Indigo 737-700", "passenger", 647, 203);
			apft[2].setdetails("Kingfisher A330-900neo", "passenger", 283, 658);
			apft[3].setdetails("Indigo 737-900", "passenger", 126, 403);
			apft[4].setdetails("Kingfisher A340-300F", "passenger", 982, 916);

			// Mumbai-Chennai = 1025km
			// Mumbai-Banglore = 1166km
			// Mumbai-kolkata = 1664km
			// Chennai-Hyderabad = 1304km
			// Hyderabad-chennai = 1757km
			// Banglore-chennai = 1363km

			flt[0].setroute("moderate", 4531, "Banglore", "Mumbai", "11:00-AM", 4450, 5);
			flt[1].setroute("moderate", 1328, "Hyderabad", "Mumbai", "04:30-PM", 4000, 5);
			flt[2].setroute("busy", 5214, "Mumbai", "Chennai", "10:45-AM", 5100, 4);
			flt[3].setroute("busy", 4589, "Mumbai", "Hyderabad", "03:00-PM", 4100, 6);
			flt[4].setroute("low", 7842, "Hyderabad", "Chennai", "11:45-AM", 9000, 6);
			flt[5].setroute("low", 1310, "Banglore", "Chennai", "06:00-PM", 9310, 7);
			flt[6].setroute("low", 8659, "Chennai", "Mumbai", "10:00-PM", 8420, 4);
			flt[7].setroute("moderate", 3162, "Hyderabad", "Chennai", "10:30-AM", 5560, 5);
			flt[8].setroute("low", 7159, "Hyderabad", "Banglore", "09:50-AM", 6120, 5);
			flt[9].setroute("moderate", 5214, "Mumbai", "Banglore", "12:00-AM", 5700, 6);
			flt[10].setroute("moderate", 1159, "Mumbai", "Chennai", "07:00-PM", 6100, 4);
			flt[11].setroute("busy", 5326, "Hyderabad", "Mumbai", "02:00-PM", 5990, 7);
			flt[12].setroute("busy", 8832, "Banglore", "Mumbai", "09:00-PM", 6150, 4);
			flt[13].setroute("busy", 5214, "Mumbai", "Chennai", "08:00-AM", 4090, 5);
			flt[14].setroute("moderate", 1453, "Mumbai", "Chennai", "10:00-PM", 5130, 5);
			flt[15].setroute("low", 6432, "Chennai", "Mumbai", "01:00-PM", 9150, 7);
			flt[16].setroute("low", 8937, "Chennai", "Mumbai", "11:35-PM", 8430, 5);
			flt[17].setroute("busy", 8659, "Chennai", "Banglore", "10:00-AM", 4520, 6);
			flt[18].setroute("moderate", 8659, "Chennai", "Hyderabad", "09:00-PM", 4130, 4);
			flt[19].setroute("low", 5326, "Banglore", "Chennai", "02:00-PM", 5990, 6);

			do {
				System.out.println("1.Flight Booking\t\t2.Cancellation of Ticket\t\t3.To check details of Reserved Ticket");
				System.out.print("Enter your choice : ");
				int ch = sc.nextInt();
				switch (ch) {
					case 1:
						System.out.println("\n0.Banglore\t\t1");
						System.out.println("\n1.Hyderabad\t\t2");
						System.out.println("\n2.Chennai\t\t3");
						System.out.println("\n3.Mumbai");
						System.out.print("Select your Departure city : ");
						int depr = sc.nextInt();
						System.out.print("Select your Arrival city : ");
						int arvl = sc.nextInt();

						if (depr >= 0 && depr < 4 && arvl >= 0 && arvl < 4 && depr != arvl) {
							System.out.print("Enter date of travel[DD-MM-YYYY] : ");
							String date =sc.next();
							System.out.printf("\n-----------------Available Flights :------------------\n\n");
							for (int i = 0; i < 20; i++) {
								if ((flt[i].src.compareTo(city[depr]) == 0) && (flt[i].dst.compareTo(city[arvl]) == 0)) {
									System.out.println("Press  " + i);
									flt[i].getroute();
									apft[i % 5].getdetails();
									System.out.println("\n\n");
									mark[i % 2] = i;
								}
							}
							System.out.println("Please be careful while Entering Flight choice : ");
							int tkt = sc.nextInt();

							if (tkt != mark[0] && tkt != mark[1]) {
								System.out.println("Enter valid choice!!");
								break;
							} else {
								System.out.println("\nSelected Flight :");
								flt[tkt].getroute();
								arr = seatAvailability();
								if (arr[2] == 1) {
									if (arr[1] == 0) {
										section = "Economy Class";
									} else if (arr[1] == 1) {
										section = "First Class";
									}
									System.out.println("\nPress 1 to confirm selected flight else press 0 : ");
									cnf = sc.nextInt();
									if (cnf == 1) {
										System.out.println("press 1 to make payment and book ticket else press 0 : ");
										pmt = sc.nextInt();
										if (pmt == 1) {
											System.out.println("\nTicket booked sucessfully!!\n");
											System.out.println("\n----------------Your Ticket Details--------------");
											tck[id].setticket(id, date, section, arr[0], tkt);
											if (arr[1] == 1)
												flt[id].fare *= 2;
											tck[id].getticket();
											flt[tkt].getroute();
											id++;
										}
									}
								}
							}
						}

						else if (depr == arvl)
							System.out.println("\n\nError! You have entered same Departure and Arrival city!!");
						else
							System.out.println("\nError! Please enter a Valid City Choice!!");
						break;

					case 2:
						System.out.print("Enter your Ticket Id : ");
						int del = sc.nextInt();
						flag = 0;
						for (int i = 0; i < 10; i++) {
							if (del == tck[i].ticket) {
								System.out.println("\n----------------Your Ticket Details--------------");
								tck[del].getticket();
								flt[tck[del].code].getroute();
								System.out.println("Press 1 to confirm Cancellation of Your Ticket else press 0 : ");
								int d = sc.nextInt();
								flag = 1;
								if (d == 1) {

									tck[del].ticket = 111;
									System.out.println("\nYour Ticket has been cancelled Successfully.");
									System.out.println("You will get Refund Amount within two days.\n\n");
								}
								break;
							}
						}
						if (flag == 0)
							System.out.println("No such ticket exist of your entered Ticket Id!");
						break;

					case 3:
						System.out.print("Enter your Ticket Id : ");
						int find = sc.nextInt();
						int temp1 = rand.nextInt(2);
						int temp2 = rand.nextInt(2);
						flag = 0;
						for (int i = 0; i < 10; i++) {
							if (find == tck[i].ticket) {
								System.out.println();
								System.out.println();
								System.out.println();
								System.out.print("Your flight will take off from " + flt[tck[find].code].src);
								System.out.println(" airport which is a " + airporttype[temp1] + " runway airport.");
								System.out.print("Your flight will land on " + flt[tck[find].code].dst);
								System.out.println(" airport which is a " + airporttype[temp2] + " runway airport.");
								System.out.println("\n----------------Your Ticket Details--------------");
								tck[find].getticket();
								System.out.println();
								flt[tck[find].code].getroute();
								apft[tck[find].code % 5].getdetails();
								flag = 1;
								break;
							}
						}
						if (flag == 0) {
							System.out.println("No such ticket exist of your entered Ticket Id!!");
						}
						break;

					default:
						System.out.println("Error! Please enter a valid choice!");
				}

				System.out.println("\nDo you want to continue? press 1 if 'yes' and press 0 if 'no': ");
				op = sc.nextInt();
			} while (op != 0);
		}
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }

		System.out.println("\n\n--------------------------------------------------------------------");
		System.out.println("------------------------THANK YOU FOR VISITING----------------------");
		System.out.println("------------------- AIRLINE  RESERVATION CENTER---------------------");
		System.out.println("--------------------------------------------------------------------");
	}

	public static int[] seatAvailability() {
		Random rand = new Random();
		int[] seat = null;
		try {
			seat = new int[3];
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

			
		}
		catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
		return seat;

	}

}





