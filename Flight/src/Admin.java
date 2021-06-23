import java.util.Scanner;

public class Admin extends Staff{
	int bonusSalary;
	public Admin() {
		super();
		Scanner sc=new Scanner(System.in);
		System.out.println("Bonus Salary:");
		bonusSalary=sc.nextInt();
		sc.nextLine();
	}
	public double computeExpense() {
		return Salary+bonusSalary;
	}
}
