import java.util.Scanner;

public abstract class Staff extends Person{
	int Salary;
	public Staff(){
		super();
		Scanner sc=new Scanner(System.in);
		System.out.println("Salary:");
		Salary=sc.nextInt();
		sc.nextLine();
	}
	public abstract double computeExpense();
}
