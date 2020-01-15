public class Ticket {
	private Vehicle vehicle;
	private java.util.Date entryDate;
	private java.util.Date exitDate;
	private double totalPrice;
	public static int numberOfTickets = 0;

	public Ticket(Vehicle vehicle, java.util.Date entryDate) {
		this.vehicle = vehicle;
		this.entryDate = entryDate;
		Ticket.numberOfTickets++;
	}

	public double calculatePrice(double hourlyPrice, java.util.Date exitDate) {
		int numberOfHours = (int) (Math.ceil((exitDate.getTime() - entryDate.getTime()) / 3600000));
		totalPrice = vehicle.getSize() * hourlyPrice * numberOfHours;
		return totalPrice;
	}

	public String getTicketInfo() {
		if (exitDate != null) {
			int numberOfHours = (int) (Math.ceil((exitDate.getTime() - entryDate.getTime()) / 3600000));
			return "Ticket Info\nPlateNumber : " + vehicle.getPlateNumber() + "\nEntry : " + entryDate.toString()
					+ "\nExit : " + exitDate.toString() + "\nHour : " + numberOfHours + "\nFee : " + totalPrice;
		} else {
			return "Ticket Info\nPlateNumber : " + vehicle.getPlateNumber() + "\nEntry : " + entryDate;
		}
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public double getPrice() {
		return totalPrice;
	}

}