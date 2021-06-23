import java.util.Scanner;
public class Ticket implements Expense{
	int ticketNo;
	Flight flight;
	int passengerinfo;
	String seat;
	String clas;
	
	public Ticket(int ticketNo,Flight flight) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Passenger Information;");
		System.out.println("ID:");
		passengerinfo=sc.nextInt();
		sc.nextLine();
		System.out.printf("Enter your Seat number: ");
		seat=sc.nextLine();
		System.out.printf("Enter your Class: ");
		clas=sc.nextLine();
		this.ticketNo=ticketNo;
		System.out.printf("Your ticket no is: "+ ticketNo);
		System.out.println();
		System.out.println();
		this.flight=flight;
	}
	public double computeExpense() {
		return 0;
	}
}
