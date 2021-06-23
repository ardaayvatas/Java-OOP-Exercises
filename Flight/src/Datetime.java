import java.util.InputMismatchException;
import java.util.Scanner;
public class Datetime {
	int day;
	int month;
	int year;
	int hour;
	int minute;
	boolean loopcontinueforday=true;
	boolean loopcontinueformonth=true;
	boolean loopcontinueforyear=true;
	boolean loopcontinueforhour=true;
	boolean loopcontinueforminute=true;
	public Datetime() {
		Scanner sc=new Scanner(System.in);
		do {
			try {
				System.out.printf("Year: ");
				year=sc.nextInt();
				sc.nextLine();
				loopcontinueforyear=false;
			}
			catch(InputMismatchException inputMismatchException) {
				System.err.println("Year cannot be a String");
				sc.nextLine();
			}
		}while(loopcontinueforyear);
		//System.out.printf("Year: ");
		//year=sc.nextInt();
		//sc.nextLine();
		do {
			try {
				System.out.printf("Month: ");
				month=sc.nextInt();
				sc.nextLine();
				loopcontinueformonth=false;
			}
			catch(InputMismatchException inputMismatchException) {
				System.err.println("Month cannot be a String");
				sc.nextLine();
			}
		}while(loopcontinueformonth);
		//System.out.printf("Month: ");
		//month=sc.nextInt();
		//sc.nextLine();
		do {
			try {
				System.out.printf("Day: ");
				day=sc.nextInt();
				sc.nextLine();
				loopcontinueforday=false;
			}
			catch(InputMismatchException inputMismatchException) {
				System.err.println("Day cannot be a String");
				sc.nextLine();
			}
		}while(loopcontinueforday);
		//System.out.printf("Day: ");
		//day=sc.nextInt();
		//sc.nextLine();
		do {
			try {
				System.out.printf("Hour: ");
				hour=sc.nextInt();
				sc.nextLine();
				loopcontinueforhour=false;
			}
			catch(InputMismatchException inputMismatchException) {
				System.err.println("Hour cannot be a String");
				sc.nextLine();
			}
		}while(loopcontinueforhour);
		//System.out.printf("Hour: ");
		//hour=sc.nextInt();
		//sc.nextLine();
		do {
			try {
				System.out.printf("Minute: ");
				minute=sc.nextInt();
				sc.nextLine();
				loopcontinueforminute=false;
			}
			catch(InputMismatchException inputMismatchException) {
				System.err.println("Minute cannot be a String");
				sc.nextLine();
			}
		}while(loopcontinueforminute);
		//System.out.printf("Minute: ");
		//minute=sc.nextInt();
		//sc.nextLine();
	}
	public String toString() {
		return String.format("%02d/%02d/%02d  %02d:%02d:00",day,month,year,hour,minute);
	}
}
