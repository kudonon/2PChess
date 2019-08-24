import java.lang.Math;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//board creation
		
		String[][] board = new String[8][9];
		int a = 65;
		
		for (int i = 0; i < board.length;i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = "     ";
			}
		}
		
		for (int i = 0; i < board.length;i++) {
			board[i][0] = Integer.toString(i+1) + " |";
		}
		
		//make special object
		Specialization spec = new Specialization();
		//end special object
		
		//board creation end
		
		//pieces creation
		String p = "   P ";
		String r = "   R ";
		String b = "   B ";
		String k = "   K ";
		String q = "   Q ";
		String x = "   X ";
		
		String p2 = "  -P ";
		String r2 = "  -R ";
		String b2 = "  -B ";
		String k2 = "  -K ";
		String q2 = "  -Q ";
		String x2 = "  -X ";
		
		for (int i = 1; i < board[0].length; i++) {
			board[6][i] = p;
			board[1][i] = p2;	
		}
		//R
		board[0][1] = r2;
		board[0][8] = r2;
		board[7][1] = r;
		board[7][8] = r;
		
		//K
		board[0][2] = k2;
		board[0][7] = k2;
		board[7][2] = k;
		board[7][7] = k;
		
		//B
		board[0][3] = b2;
		board[0][6] = b2;
		board[7][3] = b;
		board[7][6] = b;
		
		//Q
		board[0][4] = q2;
		board[7][5] = q;
		
		//X
		board[0][5] = x2;
		board[7][4] = x;
		
		//pieces creation end
		
	
		//Game play start
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want to play?");
		String y = scan.nextLine();
		boolean game = false;
		
		if (y.toLowerCase().equals("yes") || y.toLowerCase().equals("y") || y.toLowerCase().equals("ye") || y.toLowerCase().equals("yea")) {
			game = true;
			System.out.println("Let's Begin");
		} else {
			System.out.println("ok");
		}
		
		String name1, name2;
		
		System.out.print("Enter PLayer1 name: ");
		name1 = scan.nextLine();
		System.out.print("Enter Player2 name: ");
		name2 = scan.nextLine();
		System.out.println("\n \nThis is the board: \n");
		
		//print board
		System.out.print("  ");
		
		for (int i = 0; i < board.length; i++) {
			System.out.print("    " + Integer.toString(i+1));
		}
		
		System.out.println();
		System.out.println("  --------------------------------------------");
		
		for (int i = 0; i < board.length;i++) {
			
			for (int j = 0; j < board[i].length; j++) {
				
				System.out.print(board[i][j]);

				if (j > board.length - 1) {
					System.out.print("  | " + (i+1));
				}
			}
			
			System.out.println();
			
			if (i < board.length-1) {
				System.out.println("  |                                          |");
			}
		}
		System.out.println("  --------------------------------------------");
		System.out.print("  ");
		for (int i = 0; i < board.length; i++) {
			System.out.print("    " + Integer.toString(i+1));
		}
		System.out.println();
		//print board end
		
		System.out.println("\n You are on your side");
		System.out.println("\n Enter coordinates to navigate throught the game!");
		
		//action or game turn
		boolean over = false;
		boolean win  = false;
		boolean twowin = false;
		int counter = 0;
		
		while (over == false) {
			
			System.out.println("\nIt is turn#" + counter +"\n" + spec.turn(name1, name2, counter) + "'s turn: \n");
			//select space and destination
			System.out.println("\nEnter Selection Space: ");
			System.out.print("X-coord: ");
			int xx1 = scan.nextInt();
			System.out.print("Y-coord: ");
			int yy1 = scan.nextInt();
			
			System.out.println("\nEnter Destination Space: ");
			System.out.print("X-coord: ");
			int xx2 = scan.nextInt();
			System.out.print("Y-coord: ");
			int yy2 = scan.nextInt();
			
			String activeSpace = " ";
			boolean enemy = false;
			boolean tenemy = false;
			boolean valid = false;
			
			if (xx1 > 0 && xx1 < 9 && xx2 > 0 && xx2 < 9 && yy1 > 0 && yy1 < 9 && yy2 > 0 &&  yy2 < 9) {
				String destinationSpace = board[yy1-1][xx2];
				String temp2 = board[yy1-1][xx2];
				
				activeSpace = board[yy1-1][xx1];
				String temp1 = board[yy1-1][xx1];
				valid = true;
			} else {
				System.out.println("\nEnter Again\n");
			}
			if (valid) {
				if (spec.even(counter))
					if (board[yy2-1][xx2].equals(p2) || board[yy2-1][xx2].equals(r2) || board[yy2-1][xx2].equals(b2) || board[yy2-1][xx2].equals(k2) || board[yy2-1][xx2].equals(q2) || board[yy2-1][xx2].equals(x2)) {
						enemy = true;
						System.out.println("Enemy Present");
					} else {
						enemy = false;
					}
				else {
					if (board[yy2-1][xx2].equals(p) || board[yy2-1][xx2].equals(r) || board[yy2-1][xx2].equals(b) || board[yy2-1][xx2].equals(k) || board[yy2-1][xx2].equals(q) || board[yy2-1][xx2].equals(x)) {
						tenemy = true;
					} else {
						tenemy = false;
					}
				}
			}
			//end selection
			boolean confirm = false;
			int alow = 1;
			boolean endTurn = false;
			
			switch(counter % 2) {
			
			case 0:
				while (!endTurn) {
					
					//Pawn Moves
					if (activeSpace.equals(p)) {
						confirm = spec.pCheck(yy1-1, xx1, yy2-1, xx2, counter, enemy);
						System.out.println(confirm);
						if (confirm == true && board[yy2-1][xx2].equals("     ")||(confirm == true && enemy == true)) {
							board[yy2-1][xx2] = board[yy1-1][xx1];
							board[yy1-1][xx1] = "     ";
							endTurn = true;
						} else {
							System.out.println("\nSorry, you can not make that move\nTry Again\n");
							counter--;
							endTurn = true;
						}
						
						
					//Rook Moves
					} else if (activeSpace.equals(r)) {
						
						confirm = spec.rCheck(yy1-1, xx1, yy2-1, xx2, counter);
						System.out.println(confirm);
						
						if (confirm == true && board[yy2-1][xx2].equals("     ")||(confirm == true && enemy == true)) {
							
							if(yy2 - yy1 != 0) {
								
								for (int i = 1; i < Math.abs(yy2 - yy1) ; i++) {
									
									if (yy2 - yy1 > 0) {
										
										if (board[yy1 + i-1][xx1].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
									
									} else {
										
										if (board[yy1 - i-1][xx1].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									}
									
								}
								
								System.out.println(alow);
								
								if (alow == 1) {
									board[yy2-1][xx2] = board[yy1-1][xx1];
									board[yy1-1][xx1] = "     ";
									endTurn = true;
								}
								
							} else if (xx2 - xx1 != 0) {
								
								for (int i = 1; i < Math.abs(xx2 - xx1) ; i++) {
									
									if (xx2 - xx1 > 0) {
										
										if (board[yy1-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
									
									} else {
										
										if (board[yy1-1][xx1-i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									}
									
								}
								
								System.out.println(alow);
								
								if (alow == 1) {
									board[yy2-1][xx2] = board[yy1-1][xx1];
									board[yy1-1][xx1] = "     ";
									endTurn = true;
								} else {
									System.out.println("\nSorry, you can not make that move\nTry Again\n");
									counter--;
									endTurn = true;
								} 
								
							} else {
								System.out.println("\nSorry, you can not make that move\nTry Again\n");
								counter--;
								endTurn = true;
							}
							
						} else {
							System.out.println("\nSorry, you can not make that move\nTry Again\n");
							counter--;
							endTurn = true;
						}
						
						
					//Bishop Moves
					}else if (activeSpace.equals(b)) {
						
						confirm = spec.bCheck(yy1-1, xx1, yy2-1, xx2, counter);
						System.out.println(confirm);
						
						if (confirm == true && board[yy2-1][xx2].equals("     ")||(confirm == true && enemy == true)) {
							
								for (int i = 1; i < Math.abs(yy2 - yy1) ; i++) {
									
									if (yy2 - yy1 > 0 && xx2 - xx1 > 0) {
										
										if (board[yy1 + i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
									
									} else if (yy1 - yy2 > 0 && xx2 - xx1 > 0) {
										
										if (board[yy1-i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else if (yy1 - yy2 > 0 && xx1 - xx2 > 0) {
										
										if (board[yy1-i-1][xx1-i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else {
										
										if (board[yy1+i-1][xx1-i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									}
									
								
							}
							
								System.out.println(alow);
								
								if (alow == 1) {
									board[yy2-1][xx2] = board[yy1-1][xx1];
									board[yy1-1][xx1] = "     ";
									endTurn = true;
								} else {
									System.out.println("\nSorry, you can not make that move\nTry Again\n");
									counter--;
									endTurn = true;
								}
						} else {
							System.out.println("\nSorry, you can not make that move\nTry Again\n");
							counter--;
							endTurn = true;
						}
						
					//Knight Moves
					}else if (activeSpace.equals(k)) {
						
						confirm = spec.kCheck(yy1-1, xx1, yy2-1, xx2, counter);
						System.out.println(confirm);
						
						if (confirm == true && board[yy2-1][xx2].equals("     ")||(confirm == true && enemy == true)) {
							board[yy2-1][xx2] = board[yy2-1][xx2];
							board[yy1-1][xx1] = "     ";
						} else {
							System.out.println("\nSorry, you can not make that move\nTry Again\n");
							counter--;
							endTurn = true;
						}
						
						
					//Queen Moves
					} else if (activeSpace.equals(q)) {
						
						confirm = spec.qCheck(yy1-1, xx1, yy2-1, xx2, counter);
						System.out.println(confirm);
						
						if (confirm == true && board[yy2-1][xx2].equals("     ")||(confirm == true && enemy == true)) {
							
							for (int i = 1; i < Math.abs(yy2 - yy1) ; i++) {
								
								if (yy2 - yy1 > 0 && xx2 - xx1 > 0) {
									
									if (board[yy1 + i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
								
									} else if (yy1 - yy2 > 0 && xx2 - xx1 > 0) {
										
										if (board[yy1-i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else if (yy1 - yy2 > 0 && xx1 - xx2 > 0) {
										
										if (board[yy1-i-1][xx1-i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else if (xx2 - xx1 > 0 && yy1 == yy2) {
										
										if (board[yy1-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
									
									} else if(yy2 - yy1 != 0) {
										
										for (i = 1; i < Math.abs(yy2 - yy1) ; i++) {
											
											if (yy2 - yy1 > 0 && xx1 == xx2) {
												
												if (board[yy1 + i-1][xx1].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
											
											} else if (yy2 - yy1 < 0 && xx1 == xx2) {
												
												if (board[yy1 - i-1][xx1].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
												
											}
											
										}
										
										System.out.println(alow);
										
									} else if (xx2 - xx1 != 0) {
										
										for (i = 1; i < Math.abs(xx2 - xx1) ; i++) {
											
											if (xx2 - xx1 > 0 && yy1 == yy2) {
												
												if (board[yy1-1][xx1+i].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
											
											} else if (xx2 - xx1 < 0 && yy1 == yy2){
												
												if (board[yy1-1][xx1-i].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
												
											}
											
										}
										
										System.out.println(alow);
										
									}
								}
								if (alow == 1) {
									board[yy2-1][xx2] = board[yy1-1][xx1];
									board[yy1-1][xx1] = "     ";
									endTurn = true;
								} else {
									System.out.println("\nSorry, you can not make that move\nTry Again\n");
									counter--;
									endTurn = true;
								}
						}
						
					//King Moves
					} else if (activeSpace.equals(x)) {
						
						confirm = spec.xCheck(yy1-1, xx1, yy2-1, xx2, counter);
						System.out.println(confirm);
						
						if (confirm == true && board[yy2-1][xx2].equals("     ")||(confirm == true && enemy == true)) {
							for (int i = 1; i < Math.abs(yy2 - yy1) ; i++) {
								
								if (yy2 - yy1 > 0 && xx2 - xx1 > 0) {
									
									if (board[yy1 + i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
								
									} else if (yy1 - yy2 > 0 && xx2 - xx1 > 0) {
										
										if (board[yy1-i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else if (yy1 - yy2 > 0 && xx1 - xx2 > 0) {
										
										if (board[yy1-i-1][xx1-i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else if (xx2 - xx1 > 0 && yy1 == yy2) {
										
										if (board[yy1-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
									
									} else if(yy2 - yy1 != 0) {
										
										for (i = 1; i < Math.abs(yy2 - yy1) ; i++) {
											
											if (yy2 - yy1 > 0 && xx1 == xx2) {
												
												if (board[yy1 + i-1][xx1].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
											
											} else if (yy2 - yy1 < 0 && xx1 == xx2) {
												
												if (board[yy1 - i-1][xx1].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
												
											}
											
										}
										
										System.out.println(alow);
										
									} else if (xx2 - xx1 != 0) {
										
										for (i = 1; i < Math.abs(xx2 - xx1) ; i++) {
											
											if (xx2 - xx1 > 0 && yy1 == yy2) {
												
												if (board[yy1-1][xx1+i].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
											
											} else if (xx2 - xx1 < 0 && yy1 == yy2){
												
												if (board[yy1-1][xx1-i].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
												
											}
											
										}
										
										System.out.println(alow);
										
									}
							}
						if (alow == 1 && (Math.abs(yy2 - yy1) <= 1) && (Math.abs(xx2 - xx1) <=1)) {
							board[yy2-1][xx2] = board[yy1-1][xx1];
							board[yy1-1][xx1] = "     ";
							endTurn = true;
						} else {
							System.out.println("\nSorry, you can not make that move\nTry Again\n");
							counter--;
							endTurn = true;
						}
		
					}	
					//Default
					} else {
						
						System.out.println("\nSorry, you can not make that move\nTry Again\n");
						counter--;
						endTurn = true;
					}
				}
					break;
					
				
			case 1:	
				while (!endTurn) {
					//Pawn Moves
					if (activeSpace.equals(p2)) {
						confirm = spec.p2Check(yy1-1, xx1, yy2-1, xx2, counter, enemy);
						System.out.println(confirm);
						if ((confirm == true && board[yy2-1][xx2].equals("     "))) {
							System.out.println(confirm);
							board[yy2-1][xx2] = board[yy1-1][xx1];
							board[yy1-1][xx1] = "     ";
							endTurn = true;
						} else {
							System.out.println("\nSorry, you can not make that move\nTry Again\n");
							counter--;
							endTurn = true;
						}
						
						
					//Rook Moves
					} else if (activeSpace.equals(r2)) {
						
						confirm = spec.r2Check(yy1-1, xx1, yy2-1, xx2, counter);
						System.out.println(confirm);
						
						if (confirm == true && board[yy2-1][xx2].equals("     ")||(confirm == true && tenemy == true)) {
							
							if(yy2 - yy1 != 0) {
								
								for (int i = 1; i < Math.abs(yy2 - yy1) ; i++) {
									
									if (yy2 - yy1 > 0) {
										
										if (board[yy1 + i-1][xx1].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
									
									} else {
										
										if (board[yy1 - i-1][xx1].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									}
									
								}
								
								System.out.println(alow);
								
								if (alow == 1) {
									board[yy2-1][xx2] = board[yy1-1][xx1];
									board[yy1-1][xx1] = "     ";
									endTurn = true;
								}
								
							} else if (xx2 - xx1 != 0) {
								
								for (int i = 1; i < Math.abs(xx2 - xx1) ; i++) {
									
									if (xx2 - xx1 > 0) {
										
										if (board[yy1-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
									
									} else {
										
										if (board[yy1-1][xx1-i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									}
									
								}
								
								System.out.println(alow);
								
								if (alow == 1) {
									board[yy2-1][xx2] = board[yy1-1][xx1];
									board[yy1-1][xx1] = "     ";
									endTurn = true;
								}
								
							} else {
								System.out.println("\nSorry, you can not make that move\nTry Again\n");
								counter--;
								endTurn = true;
							}
							
						} else {
							System.out.println("\nSorry, you can not make that move\nTry Again\n");
							counter--;
							endTurn = true;
						}
						
						
					//Bishop Moves
					}else if (activeSpace.equals(b2)) {
						
						confirm = spec.b2Check(yy1-1, xx1, yy2-1, xx2, counter);
						System.out.println(confirm);
						
						if (confirm == true && board[yy2-1][xx2].equals("     ")||(confirm == true && tenemy == true)) {
							
								for (int i = 1; i < Math.abs(yy2 - yy1) ; i++) {
									
									if (yy2 - yy1 > 0 && xx2 - xx1 > 0) {
										
										if (board[yy1 + i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
									
									} else if (yy1 - yy2 > 0 && xx2 - xx1 > 0) {
										
										if (board[yy1-i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else if (yy1 - yy2 > 0 && xx1 - xx2 > 0) {
										
										if (board[yy1-i-1][xx1-i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else {
										
										if (board[yy1+i-1][xx1-i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									}
									
								
							}
							
								System.out.println(alow);
								
								if (alow == 1) {
									board[yy2-1][xx2] = board[yy1-1][xx1];
									board[yy1-1][xx1] = "     ";
									endTurn = true;
								} else {
									System.out.println("\nSorry, you can not make that move\nTry Again\n");
									counter--;
									endTurn = true;
								}
						} else {
							System.out.println("\nSorry, you can not make that move\nTry Again\n");
							counter--;
							endTurn = true;
						}
						
					//Knight Moves
					}else if (activeSpace.equals(k2)) {
						
						confirm = spec.k2Check(yy1-1, xx1, yy2-1, xx2, counter);
						System.out.println(confirm);
						
						if (confirm == true && board[yy2-1][xx2].equals("     ")||(confirm == true && tenemy == true)) {
							board[yy2-1][xx2] = board[yy2-1][xx2];
							board[yy1-1][xx1] = "     ";
							endTurn = true;
						} else {
							System.out.println("\nSorry, you can not make that move\nTry Again\n");
							counter--;
							endTurn = true;
						}
						
						
					//Queen Moves
					} else if (activeSpace.equals(q2)) {
						
						confirm = spec.q2Check(yy1-1, xx1, yy2-1, xx2, counter);
						System.out.println(confirm);
						
						if (confirm == true && board[yy2-1][xx2].equals("     ")||(confirm == true && tenemy == true)) {
							
							for (int i = 1; i < Math.abs(yy2 - yy1) ; i++) {
								
								if (yy2 - yy1 > 0 && xx2 - xx1 > 0) {
									
									if (board[yy1 + i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
								
									} else if (yy1 - yy2 > 0 && xx2 - xx1 > 0) {
										
										if (board[yy1-i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else if (yy1 - yy2 > 0 && xx1 - xx2 > 0) {
										
										if (board[yy1-i-1][xx1-i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else if (xx2 - xx1 > 0 && yy1 == yy2) {
										
										if (board[yy1-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
									
									} else if(yy2 - yy1 != 0) {
										
										for (i = 1; i < Math.abs(yy2 - yy1) ; i++) {
											
											if (yy2 - yy1 > 0 && xx1 == xx2) {
												
												if (board[yy1 + i-1][xx1].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
											
											} else if (yy2 - yy1 < 0 && xx1 == xx2) {
												
												if (board[yy1 - i-1][xx1].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
												
											}
											
										}
										
										System.out.println(alow);
										
									} else if (xx2 - xx1 != 0) {
										
										for (i = 1; i < Math.abs(xx2 - xx1) ; i++) {
											
											if (xx2 - xx1 > 0 && yy1 == yy2) {
												
												if (board[yy1-1][xx1+i].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
											
											} else if (xx2 - xx1 < 0 && yy1 == yy2){
												
												if (board[yy1-1][xx1-i].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
												
											}
											
										}
										
										System.out.println(alow);
										
									}
								}
								if (alow == 1) {
									board[yy2-1][xx2] = board[yy1-1][xx1];
									board[yy1-1][xx1] = "     ";
									endTurn = true;
								} else {
									System.out.println("\nSorry, you can not make that move\nTry Again\n");
									counter--;
									endTurn = true;
							}
						}
						
					//King Moves
					} else if (activeSpace.equals(x2)) {
						
						confirm = spec.x2Check(yy1-1, xx1, yy2-1, xx2, counter);
						System.out.println(confirm);
						
						if (confirm == true && board[yy2-1][xx2].equals("     ")||(confirm == true && tenemy == true)) {
							for (int i = 1; i < Math.abs(yy2 - yy1) ; i++) {
								
								if (yy2 - yy1 > 0 && xx2 - xx1 > 0) {
									
									if (board[yy1 + i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
								
									} else if (yy1 - yy2 > 0 && xx2 - xx1 > 0) {
										
										if (board[yy1-i-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else if (yy1 - yy2 > 0 && xx1 - xx2 > 0) {
										
										if (board[yy1-i-1][xx1-i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
										
									} else if (xx2 - xx1 > 0 && yy1 == yy2) {
										
										if (board[yy1-1][xx1+i].equals("     ")) {
											alow *= 1;
										} else {
											alow *= 0;
										}
									
									} else if(yy2 - yy1 != 0) {
										
										for (i = 1; i < Math.abs(yy2 - yy1) ; i++) {
											
											if (yy2 - yy1 > 0 && xx1 == xx2) {
												
												if (board[yy1 + i-1][xx1].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
											
											} else if (yy2 - yy1 < 0 && xx1 == xx2) {
												
												if (board[yy1 - i-1][xx1].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
												
											}
											
										}
										
										System.out.println(alow);
										
									} else if (xx2 - xx1 != 0) {
										
										for (i = 1; i < Math.abs(xx2 - xx1) ; i++) {
											
											if (xx2 - xx1 > 0 && yy1 == yy2) {
												
												if (board[yy1-1][xx1+i].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
											
											} else if (xx2 - xx1 < 0 && yy1 == yy2){
												
												if (board[yy1-1][xx1-i].equals("     ")) {
													alow *= 1;
												} else {
													alow *= 0;
												}
												
											}
											
										}
										
										System.out.println(alow);
										
									}
							}
						if (alow == 1 && (Math.abs(yy2 - yy1) <= 1) && (Math.abs(xx2 - xx1) <=1)) {
							board[yy2-1][xx2] = board[yy1-1][xx1];
							board[yy1-1][xx1] = "     ";
							endTurn = true;
						} else {
							System.out.println("\nSorry, you can not make that move\nTry Again\n");
							counter--;
							endTurn = true;
						}
		
					}	
					//Default
					} else {
						System.out.println("\nSorry, you can not make that move\nTry Again\n");
						counter--;
						endTurn = true;
					}
				}
				
				break;
			
				
		
			}
			//print board
			System.out.print("  ");
			
			for (int i = 0; i < board.length; i++) {
				System.out.print("    " + Integer.toString(i+1));
			}
			
			System.out.println();
			System.out.println("  --------------------------------------------");
			
			for (int i = 0; i < board.length;i++) {
				
				for (int j = 0; j < board[i].length; j++) {
					
					System.out.print(board[i][j]);
					
					if (j > board.length - 1) {
						System.out.print("  | " + (i+1));
					}
				}
				
				System.out.println();
				
				if (i < board.length-1) {
					
					System.out.println("  |                                          |");
				}
			}
			System.out.println("  --------------------------------------------");
			System.out.print("  ");
			for (int i = 0; i < board.length; i++) {
				System.out.print("    " + Integer.toString(i+1));
			}
			
			//print board end
			
			//Check Win
			
		    for (int i=0; i<board.length; i++) 
		    { 
		        for (int j=0; j<board[i].length; j++)
		        {

		         if (board[i][j] == x2) {
		        	 over = false;
		        	 win = false;
		        	 break;
		         } else {
		        	 over = true;
		        	 win = true;
		         }
		         
		        }
		    }
		    
		    for (int i=0; i<board.length; i++) 
		    { 
		        for (int j=0; j<board[i].length; j++)
		        {

		         if (board[i][j] == x) {
		        	 over = false;
		        	 twowin = false;
		        	 break;
		         } else {
		        	 over = true;
		        	 twowin = true;
		         }
		         
		        }
		    }
			
			
			
			counter++;
		}
		
		if (over && win) {
			System.out.println("\n\n\n GAME OVER \n\n" + name1 + "wins!");
		} else if (over && twowin) {
			System.out.println("\n\n\n GAME OVER \n\n" + name2 + "wins!");
		}
	}
}




