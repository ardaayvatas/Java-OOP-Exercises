import java.util.Scanner;
import javax.swing.JOptionPane;
public class HourlyEmployee extends Employee{
	int workHour;
	double payment;
	HourlyEmployee(){
		super();
		Scanner sc=new Scanner(System.in);
		str = JOptionPane.showInputDialog("Payment:");
		//System.out.println("Payment:");
		payment=Double.parseDouble(str);
		str = JOptionPane.showInputDialog("Work Hours:");
		workHour=Integer.parseInt(str);
		//System.out.println("Work Hours:");
		//workHour=sc.nextInt();
		//sc.nextLine();
	}
	@Override
	public void displayEmployeeInfo() {
		JOptionPane.showMessageDialog(null, "ID: "+id+"\n"+"Name: "+name+"\n"+"Department: "+department+"\n"+startDate.toString()+"\n"+"Work hours :"+workHour+"\n"+"Daily Payment: "+calculatePayment()+"\n","Hourly Employee Info",JOptionPane.INFORMATION_MESSAGE);
		//System.out.println("ID: "+id+"\n"+ 
			//	"Name: "+name+"\n"+
				//"Department: "+department+"\n"+
				//startDate.toString()+"\n"+
				//"Work hours: "+ workHour+"\n"+
				//"Daily payment: "+calculatePayment()+"\n");
	}
	public double calculatePayment() {
		if(department.equals("Tech")) {
			insuranceRate=20;
		}
		else if(department.equals("Finance")) {
			insuranceRate=10;
		}
		else {
			insuranceRate=5;
		}
		return (workHour*payment)+(workHour*payment*insuranceRate/100);
	}
}
