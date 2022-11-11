package com.airline.dbconnect;

public class Airplane {
		String modelname;
		String type;
		int Usrcapacity;
		int fuelcapacity;
		private String UsrCapacity;

		public void setdetails(String x, String y, int Usrct, int fct) {
			this.modelname = x;
			this.type = y;
			this.Usrcapacity = Usrct;
			this.fuelcapacity = fct;
		}

		public void getdetails() {
			System.out.println("Airplane Model :" + modelname);
			System.out.println("Airplane Type :" + type);
			System.out.println("User Capacity :" + UsrCapacity);
			System.out.println("Fuel Capacity :" + fuelcapacity + " Litres");
			System.out.println("");
		}

	
		
}


