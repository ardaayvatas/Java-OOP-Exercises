import java.util.Scanner;
import java.util.InputMismatchException;
public class CheckIn implements Expense{
	Ticket ticket;
	int weightOfLuggage;
	Datetime checkInTime;
	boolean valid;
	boolean loopcontinueforweightofLuggage=true;
	public CheckIn(Ticket ticket){
		Scanner sc=new Scanner(System.in);
		
		do {
			try {
				System.out.printf("Enter your weight of luggage: ");
				weightOfLuggage=sc.nextInt();
				sc.nextLine();
				loopcontinueforweightofLuggage=false;
			}
			catch(InputMismatchException inputMismatchException) {
				System.err.println("Weight of luggage cannot be a String");
				sc.nextLine();
			}
		}while(loopcontinueforweightofLuggage);
		//System.out.printf("Enter your weight of luggage: ");
		//weightOfLuggage=sc.nextInt();
		//sc.nextLine();
		System.out.printf("Enter your check in time;");
		System.out.println();
		checkInTime= new Datetime();
		valid=false;
		this.ticket = ticket;
	}
	public void displayCheckIn() {
		System.out.println("Check-In of "+ticket.passengerinfo);
		System.out.println("Ticket No# "+ticket.ticketNo);
		System.out.println("From "+ticket.flight.originCity+" to "+ticket.flight.destinationCity);
		System.out.printf("Departure Time: %02d/%02d/%02d %02d:%02d \n",ticket.flight.departureTime.day,ticket.flight.departureTime.month,ticket.flight.departureTime.year,ticket.flight.departureTime.hour,ticket.flight.departureTime.minute);
		System.out.printf("Arrival Time: %02d/%02d/%02d %02d:%02d \n",ticket.flight.arrivalTime.day,ticket.flight.arrivalTime.month,ticket.flight.arrivalTime.year,ticket.flight.arrivalTime.hour,ticket.flight.arrivalTime.minute);
		System.out.printf("Check-In Time: %02d/%02d/%02d %02d:%02d \n",checkInTime.day,checkInTime.month,checkInTime.year,checkInTime.hour,checkInTime.minute);
		System.out.println("Luggage Weight: "+weightOfLuggage);
		System.out.println();
	}
	public void TrueValid() {
		this.valid=true;
	}
	public double computeExpense() {
		return 0;
	}
}
