public class CarPark {
	private int capacity;
	public ParkPlace[] parkPlaceArray = new ParkPlace[0];
	public Ticket[] ticketArray = new Ticket[0];
	private double hourlyPrice;

	public CarPark(int capacity, double hourlyPrice) {
		this.capacity = capacity;
		this.hourlyPrice = hourlyPrice;
	}

	public Ticket parkVehicle(Vehicle vehicle, java.util.Date entryDate) {
		if (vehicle.getSize() > capacity - getTotalSizeOfParkPlaces()) {
			System.out.println("Car park is full!");
			return null;
		} else {
			ParkPlace parkPlace = new ParkPlace(vehicle);
			Ticket ticket = new Ticket(vehicle, entryDate);
			addParkPlace(parkPlace);
			addTicket(ticket);
			System.out.println("The vehicle with " + vehicle.getPlateNumber() + " plate number is parked.");
			return ticket;
		}
	}

	public Vehicle exitVehicle(Ticket ticket, java.util.Date exitDate) {
		double price = ticket.calculatePrice(this.hourlyPrice, exitDate);
		Vehicle vehicle = extractParkPlace(ticket.getVehicle().getPlateNumber());
		System.out.println(
				"The price for vehicle with " + vehicle.getPlateNumber() + "plate number is:\n" + price + " TLs");
		return vehicle;
	}

	private int getTotalSizeOfParkPlaces() {
		int totalSize = 0;
		for (int i = 0; i < parkPlaceArray.length; i++) {
			totalSize += parkPlaceArray[i].getSize();
		}
		return totalSize;
	}

	private void addParkPlace(ParkPlace parkPlace) {
		int oldLength = parkPlaceArray.length;
		ParkPlace[] parkPlaceArray = new ParkPlace[oldLength + 1];
		for (int i = 0; i < oldLength; i++)
			parkPlaceArray[i] = this.parkPlaceArray[i] ;
		parkPlaceArray[oldLength] = parkPlace;
		this.parkPlaceArray = parkPlaceArray ;
	}
	
	private void addTicket(Ticket ticket) {
		int oldLength = ticketArray.length;
		Ticket[] ticketArray = new Ticket[oldLength + 1];
		for (int i = 0; i < oldLength; i++)
			ticketArray[i] = this.ticketArray[i];
		ticketArray[oldLength] = ticket;
		this.ticketArray = ticketArray;
	}

	private Vehicle extractParkPlace(String plate) {
		int oldLength = this.parkPlaceArray.length;
		ParkPlace[] parkPlaceArray = new ParkPlace[oldLength - 1];
		int count = 0;
		Vehicle vehicle = null;
		for (int i = 0; i < oldLength; i++) {
			if (!this.parkPlaceArray[i].getVehicle().getPlateNumber().equals(plate)) {
				parkPlaceArray[count] = this.parkPlaceArray[i];
				count++;
			}
			else {
				vehicle = this.parkPlaceArray[i].getVehicle();
			}
		}
		this.parkPlaceArray = parkPlaceArray;
		return vehicle;
	}

	public double getTotalIncome() {
		double totalIncome = 0;
		for (int i = 0; i < ticketArray.length; i++) {
			if (ticketArray[i].getPrice() != 0) {
				totalIncome += ticketArray[i].getPrice();
			}
		}
		return totalIncome;
	}

	public void printVehicleList() {
		System.out.println("VEHICLE LIST:");
		System.out.println("--------------");
		for (ParkPlace pp : parkPlaceArray) {
			System.out.println(pp.getVehicle().getVehicleInfo());
		}
		System.out.println("--------------");
	}

	public void printTickets() {
		System.out.println("TICKET LIST:");
		System.out.println("---------");
		for (Ticket ticket : ticketArray) {
			System.out.println(ticket.getTicketInfo());
		}
	}
	}

