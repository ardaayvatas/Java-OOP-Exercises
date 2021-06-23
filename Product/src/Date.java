import java.util.Scanner;
import javax.swing.JOptionPane;
public class Date {
	int day;
	int month;
	int year;
	int hour;
	int minute;
	String str;
	Scanner sc = new Scanner(System.in);
	public Date(){
		str = JOptionPane.showInputDialog("Enter day:");
		//System.out.println("Enter day:");
		//str= sc.nextLine();
		day =Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Enter month:");
		//System.out.println("Enter month:");
		//str= sc.nextLine();
		month =Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Enter year:");
		//System.out.println("Enter year:");
		//str= sc.nextLine();
		year =Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Enter hour:");
		//System.out.println("Enter hour:");
		//str= sc.nextLine();
		hour =Integer.parseInt(str);
		str = JOptionPane.showInputDialog("Enter minute:");
		//System.out.println("Enter minute:");
		//str= sc.nextLine();
		minute =Integer.parseInt(str);
	}
	public String toString() {
		return String.format("Start Date: %02d/%02d/%02d  %02d:%02d",day,month,year,hour,minute);
	}
}
