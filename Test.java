public class Test {
	public static void main(String[] args){
		run();
	}
	
	public static void run(){
	CarPark park = new CarPark(10, 5);
	
	Vehicle vehicle = new Vehicle("34CSE1141", 4);
	Vehicle vehicle2 = new Vehicle("34CSE2", 2);
	Vehicle vehicle3 = new Vehicle("34CSE3", 1);
	Vehicle vehicle4 = new Vehicle("34CSE4", 2);
	Vehicle vehicle5 = new Vehicle("34CSE5", 4);
	
	java.util.Date now = new java.util.Date();
	java.util.Date nowPlusOneHour = new java.util.Date(now.getTime() + 60*60*1000);
	java.util.Date nowPlusTwoHour = new java.util.Date(nowPlusOneHour.getTime() + 60*60*1000);
	java.util.Date nowPlusThreeHour = new java.util.Date(nowPlusTwoHour.getTime() + 60*60*1000);
	java.util.Date nowPlusFourHour = new java.util.Date(nowPlusThreeHour.getTime() + 60*60*1000);
	
	Ticket ticket = park.parkVehicle(vehicle, now);
	Ticket ticket2 = park.parkVehicle(vehicle2 , nowPlusOneHour);
	Ticket ticket3 = park.parkVehicle(vehicle3 , nowPlusTwoHour);
	Ticket ticket4 = park.parkVehicle(vehicle4 , nowPlusThreeHour);
	Ticket ticket5 = park.parkVehicle(vehicle5 , nowPlusFourHour);
	
	park.printVehicleList();
	
	park.exitVehicle(ticket, nowPlusThreeHour);
	park.exitVehicle(ticket2, nowPlusThreeHour);
	
	park.printVehicleList();
	
	park.exitVehicle(ticket3, nowPlusFourHour);
	park.exitVehicle(ticket4, nowPlusFourHour);
	
	park.getTotalIncome();
	
	System.out.println(Ticket.numberOfTickets);
	
	park.printTickets();
	
	System.out.println(park.getTotalIncome());
	
	
	}
	
}
