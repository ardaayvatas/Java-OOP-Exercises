import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
abstract class Employee implements Payable,Comparable <Employee>{

	int id;
	String name;
	String department="Tech";
	Date startDate;
	double insuranceRate;
	String str;
	Scanner sc = new Scanner(System.in);
	boolean loopcontroller=true;
	String s;
	Employee(){
		str = JOptionPane.showInputDialog("ID:");
		//System.out.printf("%s\n", "ID:");
		//str= sc.nextLine();
		id =Integer.parseInt(str);
		do {
			try {
				name = JOptionPane.showInputDialog("Enter name");
				//System.out.printf("%s\n", "Enter name");
				//name = sc.nextLine();
				s=name;
				if(s.matches("^[a-zA-Z ]+$")) {
					loopcontroller=false;
				}
				else {
					throw new InputMismatchException();
				}
			}
			catch(InputMismatchException inputmismatchexception){
				JOptionPane.showMessageDialog(null, "Name cannot any numbers!","Error",JOptionPane.ERROR_MESSAGE);
				//System.err.println("Name cannot contain any numbers!");
			}
		}while(loopcontroller);
		
		startDate = new Date();
	
	}
	
	public Employee(String department){
		this();
		this.department=department;
	}
	
	public void displayEmployeeInfo(){
		System.out.println("ID: "+id+"\n"+ 
				"Name: "+name+"\n"+
				"Department: "+department+"\n"+
				startDate.toString()+"\n");
	}
	public abstract double calculatePayment();
	public int compareTo(Employee em) {
		int startdateyeartomonth,emstartdateyeartomonth,startdateextra,emstartdateextra;
		startdateyeartomonth=(startDate.year*12)+startDate.month;
		emstartdateyeartomonth=(em.startDate.year*12)+em.startDate.month;
		startdateextra=(startDate.day*24*60)+(startDate.hour*60)+startDate.minute;
		emstartdateextra=(em.startDate.day*24*60)+(em.startDate.hour*60)+em.startDate.minute;
		if(startdateyeartomonth==emstartdateyeartomonth) {
			if(startdateextra==emstartdateextra)
				return 0;
			else if(startdateextra>emstartdateextra)
				return 1;
			else
				return 0;
		}
		else if(startdateyeartomonth>emstartdateyeartomonth) {
			return 1;
		}
		else
			return -1;
	}
}
