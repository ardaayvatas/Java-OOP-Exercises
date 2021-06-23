import java.util.Locale;
import java.util.Scanner;

public class CheckInCounter extends Staff{
	int overTimeHours;
	double overTimeRate;
	public CheckInCounter() {
		super();
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.US);
		System.out.println("overTimeHours:");
		overTimeHours=sc.nextInt();
		sc.nextLine();
		System.out.println("overTimeRate:");
		overTimeRate=sc.nextDouble();
		sc.nextLine();
	}
	public double computeExpense() {
		return Salary+(overTimeRate*overTimeHours);
	}
}
