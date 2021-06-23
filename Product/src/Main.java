import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
public class Main {
	public static void main(String args[]) {
		ArrayList<Payable> pay = new ArrayList<Payable>();
		Scanner sc = new Scanner(System.in);
		int choice;
		String department;
		CategoryForProducts cat;
		String str;
		
		int Cindex=0,idno,idcheck=0,productidno=0;
		Customer[] CustomerArray= new Customer[10];
		
		int subchoice;
		ArrayList<Employee> elfordate = new ArrayList<Employee>();
		ArrayList<Employee> elforname = new ArrayList<Employee>();
		HashMap<Customer,ArrayList<Product>> mymap = new HashMap <Customer,ArrayList<Product>>();
		while(true) {
			str =JOptionPane.showInputDialog("1. Create a new Product \n" 
										+"2. Create a new Product with Category \n"
										+"3. Create a new Employee \n" 
										+"4. Create a new Employee with department \n" 
										+"5. Display Product information \n"
										+"6. Display Employee information \n" 
										+"7. Display number of Products \n" 
										+"8. Calculate Total Payment \n"  
										+"9. Create a Customer \n"  
										+"10. Buy Products \n" 
										+"11. Display Customer Information \n"  
										+"0.Exit\n");
			
			/*System.out.println("1. Create a new Product \n"
					+"2. Create a new Product with Category \n"
					+"3. Create a new Employee \n"
					+"4. Create a new Employee with department \n"
					+"5. Display Product information \n"
					+"6. Display Employee information \n"
					+"7. Display number of Products \n"
					+"8. Calculate Total Payment \n"
					+"9. Create a Customer \n"
					+"10. Buy Products \n"
					+"11. Display Customer Information \n"
					+"0.Exit");*/
			
			//str= sc.nextLine();
			choice =Integer.parseInt(str);
			if(choice == 0) {
				sc.close();
				break;
			}

			else if(choice == 1) {
				pay.add(new Product());
			}
			
			else if(choice == 2) {
				String categoryselect = JOptionPane.showInputDialog("Enter Category:");
				//System.out.println("Enter Category:");
				//String categoryselect = sc.nextLine();
				categoryselect=categoryselect.toUpperCase();
				cat=CategoryForProducts.valueOf(categoryselect);
				pay.add(new Product(cat));
			}

			else if(choice == 3) {
				str = JOptionPane.showInputDialog("1. Create a new Full Time Employee \n" 
											+"2. Create a new Hourly Employee");
				//System.out.println("1.Create a new Full Time Employee \n"
					//	+"2.Create a new Hourly Employee");
				//str= sc.nextLine();
				subchoice =Integer.parseInt(str);
				if(subchoice==1) {
					pay.add(new FullTimeEmployee());
				}
				else if(subchoice==2) {
					pay.add(new HourlyEmployee());
				}
			}

			else if(choice == 4) {
				str = JOptionPane.showInputDialog("1.Create a new Full Time Employee \n"+"2.Create a new Hourly Employee \n");
				//System.out.println("1.Create a new Full Time Employee \n"
					//	+"2.Create a new Hourly Employee \n");
				//str= sc.nextLine();
				subchoice =Integer.parseInt(str);
				if(subchoice==1) {
					department = JOptionPane.showInputDialog("Department:");
					//System.out.println("Department:");
					//department=sc.nextLine();
					pay.add(new FullTimeEmployee());
					if(pay.get(pay.size()-1) instanceof FullTimeEmployee) {
						FullTimeEmployee fte=(FullTimeEmployee) pay.get(pay.size()-1);
						fte.department=department;
					}
				}
				else if(subchoice==2) {
					department = JOptionPane.showInputDialog("Department:");
					//System.out.println("Department:");
					//department=sc.nextLine();
					pay.add(new HourlyEmployee());
					if(pay.get(pay.size()-1) instanceof HourlyEmployee) {
						HourlyEmployee he=(HourlyEmployee) pay.get(pay.size()-1);
						he.department=department;
					}
				}
			}

			else if(choice == 5) {
				String x = JOptionPane.showInputDialog("Enter product id");
				//System.out.println("Enter product id");
				//int id = sc.nextInt();
				//sc.nextLine();
				int id=Integer.parseInt(x);
				boolean found = false;
				for (int i=0; i<=pay.size(); i++) {
					if (pay.get(i) != null){
						if(pay.get(i) instanceof Product) {
							Product p= (Product) pay.get(i);
							if(p.getId()== id) {
								found = true;
								p.displayProductInfo();
								break;
							}
						}
					}
				}
				if(!found)
				System.out.println("Product with the given id is not found.");
			}

			else if(choice == 6) {
				//System.out.println("1.Sorted by start date");
				//System.out.println("2.Sorted by name");
				str = JOptionPane.showInputDialog("1.Sorted by start date \n" 
						+"2.Sorted by name");
				//subchoice = sc.nextInt();
				//sc.nextLine();
				subchoice = Integer.parseInt(str);
				if(subchoice==1) {
					for (int i = 0; i<=pay.size()-1; i++) {
						if (pay.get(i) != null) {
							if(pay.get(i) instanceof Employee) {
								Employee e=(Employee) pay.get(i);
								elfordate.add(e);
							}
						}
					}
					Collections.sort(elfordate);
					for(Employee em:elfordate) {
						em.displayEmployeeInfo();
					}
				}
				else if(subchoice==2) {
					for (int i = 0; i<=pay.size()-1; i++) {
						if (pay.get(i) != null) {
							if(pay.get(i) instanceof Employee) {
								Employee e=(Employee) pay.get(i);
								elforname.add(e);
							}
						}
					}
					NameCompare nameC= new NameCompare();
					Collections.sort(elforname, nameC);
					for(Employee em:elforname) {
						em.displayEmployeeInfo();
					}
				}
			}
			else if(choice == 7) {
				JOptionPane.showMessageDialog(null, "Number of Products:"+Product.productCount,"Display Number of Products",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Number of Products:"+Product.productCount);
			}
			else if(choice == 8) {
				double totalpayment=0;
				for (int i = 0; i<=pay.size()-1; i++) {
					if(pay.get(i) != null) {
						if(pay.get(i) instanceof Product) {
							Product p = (Product) pay.get(i);
							totalpayment=totalpayment+p.calculatePayment();
						}
						else if(pay.get(i) instanceof FullTimeEmployee) {
							FullTimeEmployee fte = (FullTimeEmployee) pay.get(i);
							totalpayment=totalpayment + fte.calculatePayment();
						}
						else if(pay.get(i) instanceof HourlyEmployee) {
							HourlyEmployee he=(HourlyEmployee) pay.get(i);
							totalpayment=totalpayment+he.calculatePayment();
						}
					}
				}
				JOptionPane.showMessageDialog(null, "Total Payment:"+totalpayment,"Display Total Payment",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("Total Payment:"+totalpayment+"\n");
			}
			else if(choice == 9) {
				CustomerArray[Cindex] = new Customer();
				mymap.put(CustomerArray[Cindex], CustomerArray[Cindex].shoppingCart);
				Cindex++;
			}
			else if(choice == 10) {
				productidno=0;
				while(productidno!=-1) {
				//System.out.println("Enter customer id");
				str = JOptionPane.showInputDialog("Enter customer id\n");
				//idno=sc.nextInt();
				//sc.nextLine();
				idno= Integer.parseInt(str);
				for(Customer e:mymap.keySet()) {
					if(e.id== idno) {
						idcheck=1;
						//System.out.println("Enter product id that you want to buy");
						str = JOptionPane.showInputDialog("Enter product id that you want to buy");
						//productidno=sc.nextInt();
						//sc.nextLine();
						productidno=Integer.parseInt(str);
						while(productidno!=-1) {
							for (int x=0; x<=pay.size()-1; x++) {
								if (pay.get(x) != null){
									if(pay.get(x) instanceof Product) {
										Product p= (Product) pay.get(x);
										if(p.getId()== productidno) {
											e.shoppingCart.add(p);						
											//System.out.println("Product with "+productidno+" is added to cart");
											JOptionPane.showMessageDialog(null,"Product with "+productidno+" is added to cart","ADDED",JOptionPane.INFORMATION_MESSAGE);
											break;
										}
										else if(x==pay.size()-1 && p.getId()!=productidno) {
											//System.out.println("Product with the given id is not found");
											JOptionPane.showMessageDialog(null,"Product with the given id is not found","NOT FOUND",JOptionPane.WARNING_MESSAGE);
										}
									}
								}
							}
							//System.out.println("Enter product id that you want to buy");
							str = JOptionPane.showInputDialog("Enter product id that you want to buy");
							//productidno=sc.nextInt();
							//sc.nextLine();
							productidno=Integer.parseInt(str);
						}
						if(productidno==-1) {
							break;
						}
					}
				}
				if(idcheck==0) {
					//System.out.println("Customer with the given id is not found");
					JOptionPane.showMessageDialog(null,"Customer with the given id is not found","NOT FOUND",JOptionPane.WARNING_MESSAGE);
				}
				}
			}
			else if(choice == 11) {
				for(Customer cus:mymap.keySet()) {
					cus.DisplayCustomerInfo();
				}
			}
		}
	}
}
