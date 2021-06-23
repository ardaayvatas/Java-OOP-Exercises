import java.util.Scanner;
import javax.swing.JOptionPane;
class FullTimeEmployee extends Employee{
	double salary;
	FullTimeEmployee(){
		super();
		Scanner sc=new Scanner(System.in);
		str = JOptionPane.showInputDialog("Salary:");
		//System.out.println("Salary:");
		salary= Double.parseDouble(str);
	}
	@Override
	public void displayEmployeeInfo() {
		JOptionPane.showMessageDialog(null, "ID: "+id+"\n"+"Name: "+name+"\n"+"Department: "+department+"\n"+startDate.toString()+"\n"+"Total Payment: "+calculatePayment()+"\n","Full Time Employee Info",JOptionPane.INFORMATION_MESSAGE);
		/*System.out.println("ID: "+id+"\n"+ 
				"Name: "+name+"\n"+
				"Department: "+department+"\n"+
				startDate.toString()+"\n"+
				"Total Payment: "+calculatePayment()+"\n");*/
	}
	public double calculatePayment() {
		if(super.department.equals("Tech")) {
			insuranceRate=20;
		}
		else if(super.department.equals("Finance")) {
			insuranceRate=10;
		}
		else {
			insuranceRate=5;
		}
		return salary+(salary*insuranceRate/100);
	}
}
