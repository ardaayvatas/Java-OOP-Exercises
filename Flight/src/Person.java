import java.util.InputMismatchException;
import java.util.Scanner;
public abstract class Person implements Expense {
	String name;
	String surname;
	long id;
	String password;
	boolean loopcontunieforid=true;
	public Person() {
		Scanner sc=new Scanner(System.in);
		System.out.printf("Your Name: ");
		name=sc.nextLine();
		System.out.printf("Your Surname: ");
		surname=sc.nextLine();
		//System.out.println("ID: ");
		//id=sc.nextLong();
		//sc.nextLine();
		authenticateID();
		System.out.println("Password: ");
		password=sc.nextLine();
	}
	public abstract double computeExpense();
	public void authenticateID() {
		Scanner sc=new Scanner(System.in);
		long x1p,x2p,x3p,x4p,x5p,x6p,x7p,x8p,x9p,x10p,x11p;
		long maxten10digits=9999999999L;
		long max11digits=99999999999L;
		int x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11;
		do {
			try {
				System.out.println("ID: ");
				id=sc.nextLong();
				sc.nextLine();
				x11p=id%10;
				x11=(int)x11p;
				x10p=(id/10)%10;
				x10=(int)x10p;
				x9p=(id/100)%10;
				x9=(int)x9p;
				x8p=(id/1000)%10;
				x8=(int)x8p;
				x7p=(id/10000)%10;
				x7=(int)x7p;
				x6p=(id/100000)%10;
				x6=(int)x6p;
				x5p=(id/1000000)%10;
				x5=(int)x5p;
				x4p=(id/10000000)%10;
				x4=(int)x4p;
				x3p=(id/100000000)%10;
				x3=(int)x3p;
				x2p=(id/1000000000)%10;
				x2=(int)x2p;
				x1p=((id/1000000000)/10)%10;
				x1=(int)x1p;
				if(id > maxten10digits && id<=max11digits) {
					if(x1!=0) {
						if(x10==(7*(x1+x3+x5+x7+x9)-(x2+x4+x6+x8))%10) {
							if(x11==(x1+x2+x3+x4+x5+x6+x7+x8+x9+x10)%10) {
								loopcontunieforid=false;
							}
							else {
								throw new IDMismatchException();
							}
						}
						else {
							throw new IDMismatchException();
						}
					}
					else {
						throw new IDMismatchException();
					}
				}
				else {
					throw new IDMismatchException();
				}
			}
			catch(IDMismatchException idmismatchException) {
				System.err.println("Entered id is not correct!");
				//sc.nextLine();
			}
		}while(loopcontunieforid);
	}
}
