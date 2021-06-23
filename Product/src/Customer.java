import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.InputMismatchException;
public class Customer {
	int id;
	String name;
	boolean loopcontinue = true;
	ArrayList<Product> shoppingCart = new ArrayList<Product>();
	String idx;
	Scanner sc = new Scanner(System.in);
	
	public Customer() {
		do {
			try {
				String y = JOptionPane.showInputDialog("ID:");
				//System.out.printf("%s\n", "ID:");
				//str= sc.nextLine();
				idx=y;
				//id=Integer.parseInt(y);
				if(idx.matches("^[0-9]+$")) {
					loopcontinue=false;
					id=Integer.parseInt(y);
				}
				else {
					throw new InputMismatchException();
				}
				//System.out.println("Enter ID:");
				//id=sc.nextInt();
				//sc.nextLine();
				name = JOptionPane.showInputDialog("Name:");
				
				//loopcontinue = false;
			}
			catch(InputMismatchException inputMismatchException){
				//System.err.println("Customer ID cannot be a String!");
				JOptionPane.showMessageDialog(null, "Customer ID cannot be a String!","Error",JOptionPane.ERROR_MESSAGE);
				//sc.nextLine();
			}
		}while(loopcontinue);
	}
	public void DisplayCustomerInfo() {
		int index=1;
		JOptionPane.showMessageDialog(null, "ID: "+id+"\n"+"Name: "+name,"Customer Info",JOptionPane.INFORMATION_MESSAGE);
		//System.out.println("ID: "+ id +"\n"
				//+ "Name: "+name);
		//JOptionPane.showMessageDialog(null,"Shopping Cart: ","ShoppingCart",JOptionPane.INFORMATION_MESSAGE);
		//System.out.println("Shopping Cart:");
		for(Product e:shoppingCart) {
			JOptionPane.showMessageDialog(null,"Product#"+index+"\n"+"Product id: "+e.id+"\n"+"Brand and model:" +e.getBrand()+" "+e.getModel(),"ShoppingCart",JOptionPane.INFORMATION_MESSAGE);
			//System.out.println("Product#"+index);
			index++;
			//System.out.println("Product id: "+e.id);
			//System.out.println("Brand and model: "+e.getBrand()+" "+e.getModel());
		}
	}
}
