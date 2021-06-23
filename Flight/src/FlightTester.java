import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class FlightTester {
	public static void main(String[] args) {
		ArrayList<Flight> flightfordate = new ArrayList<Flight>();
		int select;
		int subselect,subsubselect;
		int Findex=0,Tindex=0,Cindex=0;
		boolean check=false;
		int flightnohold,ticketnohold;
		int calculate=0,hold=0,deptimecalculate=0,checktimecalculate=0;
		long idholder;
		String passwordholder;
		ArrayList<Expense> exp = new ArrayList<Expense>();
		int exitcontroller=1;
		Scanner sc= new Scanner(System.in);
		while(exitcontroller==1) {
			for(MainMenu mm: MainMenu.values()) {
				System.out.println(""+mm.mmmenudisplay());
			}
			System.out.printf("Your choice: ");
			select=sc.nextInt();
			sc.nextLine();
			if(select==1) {
				System.out.println("(1) Add Admin \n"+
						"(2) Add Check-in Counter");
				System.out.printf("Your choice: ");
				subselect=sc.nextInt();
				sc.nextLine();
				if(subselect==1) {
					exp.add(new Admin());
				}
				else if(subselect==2) {
					exp.add(new CheckInCounter());
				}
			}
			else if(select==2) {
				System.out.println("(1) Add Classic Passenger \n"+
						"(2) Add Elite Passenger \n"+
						"(3) Add Elite Plus Passenger");
				System.out.printf("Your choice: ");
				subselect=sc.nextInt();
				sc.nextLine();
				if(subselect==1) {
					exp.add(new Classic());
					System.out.println();
				}
				else if(subselect==2) {
					exp.add(new Elite());
					System.out.println();
				}
				else if(subselect==3) {
					exp.add(new ElitePlus());
					System.out.println();
				}
			}
			else if(select==3) {
				System.out.println("Enter your ID:");
				idholder=sc.nextLong();
				sc.nextLine();
				System.out.println("Enter your password:");
				passwordholder=sc.nextLine();
				for(int i=0;i<exp.size();i++) {
					if (exp.get(i) != null){
						if(exp.get(i) instanceof Admin) {
							Admin a= (Admin) exp.get(i);
							if(a.id==idholder && a.password.equals(passwordholder)) {
								while(true) {
									for(AdminMenu ad: AdminMenu.values()) {
										System.out.println(""+ad.admenudisplay());
									}
									System.out.printf("Your choice: ");
									subselect=sc.nextInt();
									sc.nextLine();
									if(subselect==1) {
										System.out.println("");
										for(Submenu s: Submenu.values()) {
											System.out.println(""+s.submenudisplay());
										}
										System.out.printf("Your choice: ");
										subsubselect=sc.nextInt();
										sc.nextLine();
										if(subsubselect==1) {
											exp.add(new OneLegFlight());
											Findex++;
										}
										else if(subsubselect==2) {
											exp.add(new TwoLegFlight());
											Findex++;
											}
										else if(subsubselect==3) {
											exp.add(new ThreeLegFlight());
											Findex++;
										}
									}
									else if(subselect==2) {
										for (i = 0; i<=exp.size()-1; i++) {
											if (exp.get(i) != null) {
												if(exp.get(i) instanceof Flight) {
													Flight f=(Flight) exp.get(i);
													flightfordate.add(f);
												}
											}
										}
										Collections.sort(flightfordate);
										for(Flight fff:flightfordate) {
											fff.displayFlightInformation();
										}
									}
									else if(subselect==3) {
										System.out.printf("Enter flightNo: ");
										flightnohold=sc.nextInt();
										sc.nextLine();
										System.out.println();
										for(int x=0;x<exp.size();x++) {
											if(exp.get(x) != null){
												if(exp.get(x) instanceof CheckIn) {
													CheckIn c= (CheckIn) exp.get(x);
													if(c.ticket.flight.flightNo==flightnohold && c.valid==true) {
														calculate=calculate+c.weightOfLuggage+80;
														hold=c.ticket.flight.maxLoadOfPlane;
													}
												}
											}
										}
									}
									else if(subselect==4) {
										double totalexpenses=0;
										for (int x = 0; x<=exp.size()-1; x++) {
											if(exp.get(x) != null) {
												if(exp.get(x) instanceof Admin) {
													Admin ad = (Admin) exp.get(x);
													totalexpenses=totalexpenses+ad.computeExpense();
												}
												else if(exp.get(x) instanceof CheckInCounter) {
													CheckInCounter c = (CheckInCounter) exp.get(x);
													totalexpenses=totalexpenses+c.computeExpense();
												}
												else if(exp.get(x) instanceof Classic) {
													Classic cl = (Classic) exp.get(x);
													totalexpenses=totalexpenses+cl.computeExpense();
												}
												else if(exp.get(x) instanceof Elite) {
													Elite e = (Elite) exp.get(x);
													totalexpenses=totalexpenses+e.computeExpense();
												}
												else if(exp.get(x) instanceof ElitePlus) {
													ElitePlus ep = (ElitePlus) exp.get(x);
													totalexpenses=totalexpenses+ep.computeExpense();
												}
												else if(exp.get(x) instanceof OneLegFlight) {
													OneLegFlight one = (OneLegFlight) exp.get(x);
													totalexpenses=totalexpenses+one.computeExpense();
												}
												else if(exp.get(x) instanceof TwoLegFlight) {
													TwoLegFlight two = (TwoLegFlight) exp.get(x);
													totalexpenses=totalexpenses+two.computeExpense();
												}
												else if(exp.get(x) instanceof ThreeLegFlight) {
													ThreeLegFlight three = (ThreeLegFlight) exp.get(x);
													totalexpenses=totalexpenses+three.computeExpense();
												}
											}
										}
										System.out.println("Total Expenses:"+(int)totalexpenses+"\n");
									}
									else if(subselect==5) {
										break;
									}
									else if(subselect==6) {
										exitcontroller=0;
										break;
									}
								}
							}
						}
						else if(exp.get(i) instanceof CheckInCounter) {
							CheckInCounter cc= (CheckInCounter) exp.get(i);
							if(cc.id==idholder && cc.password.equals(passwordholder)) {
								while(true) {
									for(CheckInCounterMenu ccc: CheckInCounterMenu.values()) {
										System.out.println(""+ccc.cccmenudisplay());
									}
									System.out.printf("Your choice: ");
									subselect=sc.nextInt();
									sc.nextLine();
									if(subselect==1) {
										for (i = 0; i<=exp.size()-1; i++) {
											if (exp.get(i) != null) {
												if(exp.get(i) instanceof Flight) {
													Flight f=(Flight) exp.get(i);
													flightfordate.add(f);
												}
											}
										}
										Collections.sort(flightfordate);
										for(Flight fff:flightfordate) {
											fff.displayFlightInformation();
										}
									}
									else if(subselect==2) {
										System.out.println();
										System.out.printf("Enter ticket no: ");
										ticketnohold=sc.nextInt();
										sc.nextLine();
										for(i=0;i<exp.size();i++) {
											if (exp.get(i) != null){
												if(exp.get(i) instanceof CheckIn) {
													CheckIn c= (CheckIn) exp.get(i);
													if(c.ticket.ticketNo==ticketnohold) {
														if((c.ticket.flight.departureTime.year)>(c.checkInTime.year)){
															c.valid=true;
															System.out.println();
														}
														else if((c.ticket.flight.departureTime.year)==(c.checkInTime.year)){
															if((c.ticket.flight.departureTime.month)>(c.checkInTime.month)){
																c.valid=true;
																System.out.println();
															}
															else if((c.ticket.flight.departureTime.month)==(c.checkInTime.month)){
																if((c.ticket.flight.departureTime.day)>(c.checkInTime.day)){
																	c.valid=true;
																	System.out.println();
																}
																else if((c.ticket.flight.departureTime.day)==(c.checkInTime.day)){
																	deptimecalculate=(60*(c.ticket.flight.departureTime.hour))+c.ticket.flight.departureTime.minute;
																	checktimecalculate=(60*(c.checkInTime.hour))+c.checkInTime.minute;
																	if(deptimecalculate >= checktimecalculate+30) {
																		c.valid=true;
																		System.out.println();
																	}
																	else {
																		System.out.println("Check is declined!!");
																		System.out.println("");
																	}
																}
																else {
																	System.out.println("Check is declined!!");
																	System.out.println();
																}
															}
															else {
																System.out.println("Check is declined!!");
																System.out.println();
															}
														}
														else {
															System.out.println("Check is declined!!");
															System.out.println();
														}
													}
												}
											}
										}
									}
									else if(subselect==3) {
										for(i=0;i<exp.size();i++) {
											if(exp.get(i) != null){
												if(exp.get(i) instanceof CheckIn) {
													CheckIn c= (CheckIn) exp.get(i);
													if(c.valid==true) {
														c.displayCheckIn();
														System.out.println();
													}
												}
											}
										}
									}
									else if(subselect==4) {
										break;
									}
									else if(subselect==5) {
										exitcontroller=0;
										break;
									}
								}
							}
						}
					}
				}
			}
			else if(select==4) {
				System.out.println("Enter your ID:");
				idholder=sc.nextLong();
				sc.nextLine();
				System.out.println("Enter your password:");
				passwordholder=sc.nextLine();
				for(int i=0;i<exp.size();i++) {
					if (exp.get(i) != null){
						if(exp.get(i) instanceof Classic) {
							Classic cl= (Classic) exp.get(i);
							if(cl.id==idholder && cl.password.equals(passwordholder)) {
								while(true) {
									for(PassengerMenu pm: PassengerMenu.values()) {
										System.out.println(""+pm.pasmenudisplay());
									}
									System.out.printf("Your choice: ");
									subselect=sc.nextInt();
									sc.nextLine();
									if(subselect==1) {
										for (i = 0; i<=exp.size()-1; i++) {
											if (exp.get(i) != null) {
												if(exp.get(i) instanceof Flight) {
													Flight f=(Flight) exp.get(i);
													flightfordate.add(f);
												}
											}
										}
										Collections.sort(flightfordate);
										for(Flight fff:flightfordate) {
											fff.displayFlightInformation();
										}
									}
									else if(subselect==2) {
										System.out.printf("Enter the Flight No: ");
										flightnohold=sc.nextInt();
										sc.nextLine();
										for(i=0;i<exp.size();i++) {
											if (exp.get(i) != null){
												if(exp.get(i) instanceof Flight) {
													Flight f= (Flight) exp.get(i);
													if(f.flightNo==flightnohold) {
														check = true;
														exp.add(new Ticket(Tindex+1,f));
														Tindex++;
														break;
													}
												}
											}
										}
										if(!check) {
											System.out.println("No such flight is found");
											System.out.println();
										}
										check=false;
									}
									else if(subselect==3) {
										System.out.println();
										System.out.printf("Enter your ticket no: ");
										ticketnohold=sc.nextInt();
										sc.nextLine();
										for(i=0;i<exp.size();i++) {
											if(exp.get(i) != null){
												if(exp.get(i) instanceof Ticket) {
													Ticket t= (Ticket) exp.get(i);
													if(t.ticketNo==ticketnohold) {
														check=true;
														exp.add(new CheckIn(t));
														Cindex++;
														System.out.println("");
														break;
													}
												}
											}
										}
										if(!check) {
											System.out.println("No such ticket");
											System.out.println();
										}
										check=false;
									}
									else if(subselect==4) {
										break;
									}
									else if(subselect==5) {
										exitcontroller=0;
										break;
									}
								}
							}
						}
						else if(exp.get(i) instanceof Elite) {
							Elite elit= (Elite) exp.get(i);
							if(elit.id==idholder && elit.password.equals(passwordholder)) {
								while(true) {
									for(PassengerMenu pm: PassengerMenu.values()) {
										System.out.println(""+pm.pasmenudisplay());
									}
									System.out.printf("Your choice: ");
									subselect=sc.nextInt();
									sc.nextLine();
									if(subselect==1) {
										for (i = 0; i<=exp.size()-1; i++) {
											if (exp.get(i) != null) {
												if(exp.get(i) instanceof Flight) {
													Flight f=(Flight) exp.get(i);
													flightfordate.add(f);
												}
											}
										}
										Collections.sort(flightfordate);
										for(Flight fff:flightfordate) {
											fff.displayFlightInformation();
										}
									}
									else if(subselect==2) {
										System.out.printf("Enter the Flight No: ");
										flightnohold=sc.nextInt();
										sc.nextLine();
										for(i=0;i<exp.size();i++) {
											if (exp.get(i) != null){
												if(exp.get(i) instanceof Flight) {
													Flight f= (Flight) exp.get(i);
													if(f.flightNo==flightnohold) {
														check = true;
														exp.add(new Ticket(Tindex+1,f));
														Tindex++;
														break;
													}
												}
											}
										}
										if(!check) {
											System.out.println("No such flight is found");
											System.out.println();
										}
										check=false;
									}
									else if(subselect==3) {
										System.out.println();
										System.out.printf("Enter your ticket no: ");
										ticketnohold=sc.nextInt();
										sc.nextLine();
										for(i=0;i<exp.size();i++) {
											if(exp.get(i) != null){
												if(exp.get(i) instanceof Ticket) {
													Ticket t= (Ticket) exp.get(i);
													if(t.ticketNo==ticketnohold) {
														check=true;
														exp.add(new CheckIn(t));
														Cindex++;
														System.out.println("");
														break;
													}
												}
											}
										}
										if(!check) {
											System.out.println("No such ticket");
											System.out.println();
										}
										check=false;
									}
									else if(subselect==4) {
										break;
									}
									else if(subselect==5) {
										exitcontroller=0;
										break;
									}
								}
							}
						}
						else if(exp.get(i) instanceof ElitePlus) {
							ElitePlus elitp= (ElitePlus) exp.get(i);
							if(elitp.id==idholder && elitp.password.equals(passwordholder)) {
								while(true) {
									for(PassengerMenu pm: PassengerMenu.values()) {
										System.out.println(""+pm.pasmenudisplay());
									}
									System.out.printf("Your choice: ");
									subselect=sc.nextInt();
									sc.nextLine();
									if(subselect==1) {
										for (i = 0; i<=exp.size()-1; i++) {
											if (exp.get(i) != null) {
												if(exp.get(i) instanceof Flight) {
													Flight f=(Flight) exp.get(i);
													flightfordate.add(f);
												}
											}
										}
										Collections.sort(flightfordate);
										for(Flight fff:flightfordate) {
											fff.displayFlightInformation();
										}
									}
									else if(subselect==2) {
										System.out.printf("Enter the Flight No: ");
										flightnohold=sc.nextInt();
										sc.nextLine();
										for(i=0;i<exp.size();i++) {
											if (exp.get(i) != null){
												if(exp.get(i) instanceof Flight) {
													Flight f= (Flight) exp.get(i);
													if(f.flightNo==flightnohold) {
														check = true;
														exp.add(new Ticket(Tindex+1,f));
														Tindex++;
														break;
													}
												}
											}
										}
										if(!check) {
											System.out.println("No such flight is found");
											System.out.println();
										}
										check=false;
									}
									else if(subselect==3) {
										System.out.println();
										System.out.printf("Enter your ticket no: ");
										ticketnohold=sc.nextInt();
										sc.nextLine();
										for(i=0;i<exp.size();i++) {
											if(exp.get(i) != null){
												if(exp.get(i) instanceof Ticket) {
													Ticket t= (Ticket) exp.get(i);
													if(t.ticketNo==ticketnohold) {
														check=true;
														exp.add(new CheckIn(t));
														Cindex++;
														System.out.println("");
														break;
													}
												}
											}
										}
										if(!check) {
											System.out.println("No such ticket");
											System.out.println();
										}
										check=false;
									}
									else if(subselect==4) {
										break;
									}
									else if(subselect==5) {
										exitcontroller=0;
										break;
									}
								}
							}
						}
					}
				}
			}
			else if(select==5) {
				exitcontroller=0;
				break;
			}
		}
	}
}
