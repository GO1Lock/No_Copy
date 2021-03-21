
	import java.util.Arrays;
	import java.util.Random;
	import java.util.Scanner;
	class Main {
			public static void main(String[]args) {

				int Board_SIZE = 10;
				createboard();
				
			}
			// This part of the code has been taken from https://stackoverflow.com/questions/62070072/battleship-game-place-ships-randomly-in-java "until line 203 depends on the format"
				static int Board_SIZE = 10;

				static void createboard() {
					Random random = new Random();
				    int[][] board = new int[Board_SIZE][Board_SIZE];
				    
				    for (int Ships_from_2_to5 = 5; Ships_from_2_to5 > 1; Ships_from_2_to5--) {
				    	// Choose X and Y randomly according to board size length
				        int x = random.nextInt(board.length);
				        int y = random.nextInt(board.length);
				       
		                // Choose randomly if the ship is vertical or horizontal; if vertical add squares to Y; if horizontal add squares to X;
				        boolean vertical = random.nextBoolean();
				    
				        //checking if the first coordinates are on board
				        if (vertical) {

				        	//Check if we add the ships squares to Y which is random number if is lower than 10;
				            if (y + Ships_from_2_to5 > Board_SIZE) {
				            	
				            	//decreases Y until Y + Ships_from_2_to5 is lower then Board_SIZE which is 10;
				                y -= Ships_from_2_to5; 
				            }
				            
				        } else if (x + Ships_from_2_to5 > Board_SIZE) {
				            x -= Ships_from_2_to5;
				        }

				        // Find free space
				        // if it is vertical
				        boolean isFree = true;
				  
				        if (vertical) {
				            for (int m = y; m < y + Ships_from_2_to5; m++) {
				                if (board[m][x] != 0) { // if it is 0 is free but if it is not is not free
				                    isFree = false;
				                    break;
				                }
				            }
				        }

				        // if it is Horizontal
				        else  {
				            for (int n = x; n < x + Ships_from_2_to5; n++) {
				                if (board[y][n] != 0) {
				                    isFree = false;
				                    break;
				                }
				            }
				        }

				       //if there is not a free space it loops
				        
				        if (!isFree) {  // no free space found, retry
				        	Ships_from_2_to5++;
				            continue; //Loops at line "23 depends on the format"
				        }

				        
				        // this is extra function which does not let ships be close to each other 
				        if (vertical) {
				            for (int m = Math.max(0, x - 1); m < Math.min(Board_SIZE, x + 2); m++) {
				                for (int n = Math.max(0, y - 1); n < Math.min(Board_SIZE, y + Ships_from_2_to5 + 1); n++) {
				                	board[n][m] = 9;
				                }
				            }
				        } 

				        else {
				            for (int m = Math.max(0, y - 1); m < Math.min(Board_SIZE, y + 2); m++) {
				                for (int n = Math.max(0, x - 1); n < Math.min(Board_SIZE, x + Ships_from_2_to5 + 1); n++) {
				                	board[m][n] = 9;
				                }
				            }
				        }
				        
				        //Starts placing ships
				        for (int j = 0; j < Ships_from_2_to5; j++) {
				        	board[y][x] = Ships_from_2_to5;
				            if (vertical) {
				                y++;
				            } else {
				                x++;
				            }
				        
				        }
				    }
				
					//------------------------------------------------------------------------------------
				    // This is repeat function for Submarine ship because it has same squares as Destroyer and for the board map to show 6 for Submarine on "board";
					for (int Battleship = 3; Battleship > 2; Battleship--) {
						int x = random.nextInt(board.length);
				        int y = random.nextInt(board.length);
				        boolean vertical = random.nextBoolean();
						if (vertical) {
			            if (y + Battleship > Board_SIZE) {
			                y -= Battleship;
			            }
			       } else if (x + Battleship > Board_SIZE) {
			            x -= Battleship;
			        }
			        boolean isFree1 = true;
			        // check for free space
			        if (vertical) {
			            for (int m = y; m < y + Battleship; m++) {
			                if (board[m][x] != 0) {
			                   
			                    isFree1 = false;
			                    break;
			                }
			            }
			        } 
			        else {
			            for (int n = x; n < x + Battleship; n++) {
			                if (board[y][n] != 0) {
			                   
			                    isFree1 = false;
			                    break;
			                }
			            }
			        }
			        if (!isFree1) { 
			        	Battleship++;
			            continue;
			        }
			        if (vertical) {
			            for (int m = Math.max(0, x - 1); m < Math.min(Board_SIZE, x + 2); m++) {
			                for (int n = Math.max(0, y - 1); n < Math.min(Board_SIZE, y + Battleship + 1); n++) {
			                	board[n][m] = 9;
			                }
			            }
			        } 
			        else {
			            for (int m = Math.max(0, y - 1); m < Math.min(Board_SIZE, y + 2); m++) {
			                for (int n = Math.max(0, x - 1); n < Math.min(Board_SIZE, x + Battleship + 1); n++) {
			                	board[m][n] = 9;
			                }
			            }
			        }
			        for (int j = 0; j < Battleship; j++) {
			            int gjasht = 6;
						board[y][x] = gjasht ;
			            if (vertical) {
			                y++;
			            } else {
			                x++;
			            }
			        }
			    }

			    char[][] Board = new char[10][10];
			    for ( int i = 0; i < 10; i++) {
			        for ( int j = 0; j < 10; j++) {
			        	
			        	
			        	Board[i][j] = board[i][j] == 0 || board[i][j] == 9 ? '-' : '-';
			        }
			        
			    }
		       
			    int Ship2 = 0;
			    int Ship3 = 0;
			    int Ship4 = 0;
			    int Ship5 = 0;
			    int Ship6 = 0;
			    int Points = 0;
			    int Radar = 4;
			    int shoot_count = 0;
			    
			    String unShips = "[Patrol Boat] [Destroyer] [Submarine] [Battleship] [Aircraft carrier] ";
			    String Shipss = "";
			    System.out.println("⚓ ⚓ ⚓ Welcome to Battleships ⚓ ⚓ ⚓");
			    System.out.println("There are 5 ships with names and measurements, first Aircraft carrier: 5 squares long, Second Battleship: 4 squares long, third Submarine: 3 squares long, fourth Destroyer: 3 squares long, fifth Patrol Boat: 2 squares long. ");
			    System.out.println("⫸⫸⫸There are five ships, and you need to hit them and sink them");
			    System.out.println("⫸⫸⫸They will sink if you hit all squares of the ship");
			    System.out.println("⫸Message: Whenever there is a question, Yes or No, and you want to quit, write Quit");
			    System.out.println("⫸Message: You can shoot by giving coordinates X *Horizontal* and Y *Vertical*");
			    System.out.println("⫸Message: You can use radar, which shows any ship near your coordinates *1 square away*");
			    System.out.println("⫸Message: You also have a list of sunk and un-sunk ships");
			    System.out.println("There are three modes: Normal with unlimited shoots, Hard 60 shoots max and Expert 30 shoots max");
			    System.out.println("⫸⫸⫸Good luck");
			    System.out.println("⫸⫸⫸Starting game...");
			    System.out.println(" .  o ..                  \n"
			    		+ "     o . o o.o                \n"
			    		+ "          ...oo               \n"
			    		+ "            __[]__            \n"
			    		+ "         __|_o_o_o\\__         \n"
			    		+ "         \\\"\"\"\"\"\"\"\"\"\"/         \n"
			    		+ "          \\. ..  . /          \n"
			    		+ "     ^^^^^^^^^^^^^^^^^^^^ ");
			    System.out.println(" ");
			    
			    
			    System.out.println("Good luck ツ");
			    System.out.println("Starting game...");
			    System.out.println();
				System.out.println("X → → → → → → → → → →");
				System.out.println("Y ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓");
				System.out.println();
				Arrays.stream(Board)
				.forEach(m -> System.out.println(Arrays.toString(m).replace(",", "")));
                //This will be used to explain better at VIVA
				//Arrays.stream(board)
			    //.forEach(m -> System.out.println(Arrays.toString(m).replace(",", "")));
				
				System.out.println("Ships are placed...");
				System.out.println("⫸If you want Normal mode just write Normal");
				System.out.println("⫸⫸If you want Hard mode just write Hard");
				System.out.println("⫸⫸⫸If you want Expert just write Expert");
				System.out.println("If there is a mistype the game continues as a Normal game");
                System.out.println("What mode do you want to play?");
    
				Scanner scan11 = new Scanner(System.in);
				String Type_of_Game = scan11.nextLine();	 
				System.out.println("You have chosen " + Type_of_Game + " mode");
				ships_list1(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
				
				}

		        //Does the user want to quite    
				public static void ships_list1(int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count) {
				    unShips = "[Patrol Boat] [Destroyer] [Submarine] [Battleship] [Aircraft carrier] ";
				    Shipss = "";
				    inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
				}
				//Ask for the user input X
				public static void inputXY(int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count){
					System.out.println("Un-sunk ships: " + unShips);
					System.out.println("Sunk ships: " + Shipss );
					System.out.println("Please input numbers between 1 and 10");
					System.out.println("Input X:");
					Scanner scan = new Scanner(System.in);
					int Player_X = scan.nextInt(); 
					Player_X--;
					inputxy(Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
				}

				public static void inputxy(int Player_X, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count){
					if (-1 < Player_X && Player_X < 10 ){  	
						inputXY1(Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
						
					else {	 
					 System.out.println("Wrong, please input numbers between 1 and 10");      //This is not shown in design, but it would help the user know what user did wrong.
					 inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
				}
				        
				//Ask for the user input Y
				public static void inputXY1(int Player_X, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count){	
					System.out.println("Please input numbers between 1 and 10");
					System.out.println("Input Y:");
					Scanner scan1 = new Scanner(System.in);
				    int Player_Y = scan1.nextInt();
					Player_Y--;
					inputxy1(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
				}
				
				public static void inputxy1(int Player_X,int Player_Y, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count){
					if  (-1 < Player_Y && Player_Y < 10)
						Shoot_use1(Player_X, Player_Y, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
				   
					else {
						System.out.println("Wrong, please input numbers between 1 and 10");  //This is not shown in design, but it would help the user know what user did wrong.
						inputXY1(Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
				}
				
		       //does the user want to shoot
				public static void Shoot_use1(int Player_X, int Player_Y, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count) {
					System.out.println("Do you want to shoot? Yes or No");
					
					Scanner Shoot_use = new Scanner(System.in);
					String Shoot_Yes_No = Shoot_use.nextLine();

					if ((Shoot_Yes_No.equals("Yes")) || (Shoot_Yes_No.equals("Y")) || (Shoot_Yes_No.equals("yes")) || (Shoot_Yes_No.equals("y"))){
						//If the user chosen the Hard mode 
						if ((Type_of_Game.equals("Hard")) || (Type_of_Game.equals("hard"))){
							shoot_count++;
							if (shoot_count >= 60) {
								System.out.println("No more ammo");
								System.out.println("(͠≖ ͜ʖ͠≖)👌");
								End_Points(Points);
							}
						}
						//If the user chosen the Expert mode 
						if ((Type_of_Game.equals("Expert")) || (Type_of_Game.equals("expert"))) {
							shoot_count++;
							if (shoot_count >= 30) {
								System.out.println("No more ammo");
								System.out.println("(͠≖ ͜ʖ͠≖)👌");
								End_Points(Points);
							}
						}
						//If the user chosen the Hard mode 
						if ((Type_of_Game.equals("Normal")) || (Type_of_Game.equals("normal"))) {
							
						}
						//If the user chosen the Normal mode
						else {
		
						}
						//Check if the user already had inputed these coordinates for shooting
						if (Board[Player_X][Player_Y] == 'H' ||  Board[Player_X][Player_Y] == 'M') {
							System.out.println("You have already inputted these coordinates for shooting."); //English correction 
							inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							  }
                        //Checks the other board if there is a ship so it can detect the type of ship
						if (board[Player_X][Player_Y] == 2) {
							Ship2 = (Ship2 + 1);
							Points = (Points + 1);
							Ship_was_hit(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							Ship_sunk2(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
						}
						else if (board[Player_X][Player_Y] == 3) {
							Ship3 = (Ship3 + 1);
							Points = (Points + 1);
							Ship_was_hit(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							Ship_sunk3(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
						}
						else if (board[Player_X][Player_Y] == 4) {
							Ship4 = (Ship4 + 1);
							Points = (Points + 1);
							Ship_was_hit(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							Ship_sunk4(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
						}
						else if (board[Player_X][Player_Y] == 5) {
							Ship5 = (Ship5 + 1);
							Points = (Points + 1);
							Ship_was_hit(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							Ship_sunk5(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
						}
						else if (board[Player_X][Player_Y] == 6) {
							Ship6 = (Ship6 + 1);
							Points = (Points + 1);
							Ship_was_hit(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							Ship_sunk6(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
						}
									
						//Check if the player coordinates are a miss
						if ((board[Player_X][Player_Y] == 0) || (board[Player_X][Player_Y] == 9)){
							Board[Player_X][Player_Y] = 'M';
											
							Points = (Points - 1);
											
							Arrays.stream(Board)
							.forEach(m -> System.out.println(Arrays.toString(m).replace(",", "")));
							System.out.println("You missed!");
							System.out.println("Points - 1");
							System.out.println("Points = " + Points);
											
							inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
						}					
						
					}
		       		else if ((Shoot_Yes_No.equals("No")) || (Shoot_Yes_No.equals("no")) || (Shoot_Yes_No.equals("N")) || (Shoot_Yes_No.equals("n"))) {
			             Radar_use(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
		       		}
					
		    		else if ((Shoot_Yes_No.equals("Quit")) || (Shoot_Yes_No.equals("quit"))){
						End_Points(Points);
		    		}
		       		
					else {
						 Shoot_use1(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
					
		}
                //Functions if ship is hit
				public static void Ship_was_hit(int Player_Y, int Player_X, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count) {
					Board[Player_X][Player_Y] = 'H';
					Arrays.stream(Board)
					.forEach(m -> System.out.println(Arrays.toString(m).replace(",", "")));			
					System.out.println("My ship was hit!");
					System.out.println("Points + 1");
					System.out.println("Points = " + Points);	
				}

		        //does the user want to use radar
				public static void Radar_use(int Player_Y, int Player_X, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count) {
					if (Radar == 0) {
						System.out.println("No more radars");
						inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
						
					else
						if (Radar > 0) {
					
						System.out.println("Do you want to use radar? Yes or No");
						
				    	Scanner Radar_use1 = new Scanner(System.in);
					    String Radar_use_123 = Radar_use1.nextLine();
					    System.out.println("⫸⫸⫸If your input is 1 for X or Y, then it will be added 1 depending on which one is 1, or if the inputs are 10, it will be subtracted by 1");
					    if (Player_X == 0) {
					    	Player_X = Player_X + 1;
					    }
					    if (Player_X == 10) {
					    	Player_X = Player_X - 1;
					    }
					    if (Player_Y == 0) {
					    	Player_Y = Player_Y + 1;
					    }
					    if (Player_Y == 10) {
					    	Player_Y = Player_Y - 1;
					    }
						if ((Radar_use_123.equals("Yes"))|| (Radar_use_123.equals("yes")) || (Radar_use_123.equals("Y")) || (Radar_use_123.equals("y")))  {
						    
							if (((board[Player_X][Player_Y] == 0) || (board[Player_X][Player_Y] == 9)) && ((board[(Player_X - 1)][Player_Y] == 0) || (board[(Player_X - 1)][Player_Y] == 9)) && ((board[(Player_X + 1)][Player_Y] == 0) || (board[(Player_X + 1)][Player_Y] == 9)) && ((board[Player_X][(Player_Y - 1)] == 0) || (board[Player_X][(Player_Y - 1)] == 9)) && ((board[Player_X][(Player_Y + 1)] == 0) || (board[Player_X][(Player_Y + 1)] == 9)) && ((board[(Player_X + 1)][(Player_Y + 1)] == 0) || (board[(Player_X + 1)][(Player_Y + 1)] == 9)) && ((board[(Player_X - 1)][(Player_Y - 1)] == 0) || (board[(Player_X - 1)][(Player_Y - 1)] == 9)) && ((board[(Player_X - 1)][(Player_Y + 1)] == 0) || (board[(Player_X - 1)][(Player_Y + 1)] == 9)) && ((board[(Player_X + 1)][(Player_Y - 1)] == 0) || (board[(Player_X + 1)][(Player_Y - 1)] == 9))) {
						    	Arrays.stream(Board)
					            .forEach(m -> System.out.println(Arrays.toString(m).replace(",", "")));
							    Radar--;
								System.out.println("Ship has not been detected!");
							    System.out.println("Radars - 1");
							    System.out.println("Radars = " + Radar);
							    inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
							}
						
					    	else {
					    		
					    		Arrays.stream(Board)
					    	    .forEach(m -> System.out.println(Arrays.toString(m).replace(",", "")));
						    	Radar--;
						    	System.out.println("Ship has been detected!");
							    System.out.println("Radars - 1");
							    System.out.println("Radars = " + Radar);
						    	inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					    	}
						}
							
						else if ((Radar_use_123.equals("No"))|| (Radar_use_123.equals("no")) || (Radar_use_123.equals("N")) || (Radar_use_123.equals("n")))  {
			        	
						    	inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
						else if ((Radar_use_123.equals("Quit")) || (Radar_use_123.equals("quit"))){
							End_Points(Points);
			    		}
					
						else {
		    					Radar_use(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
						}
						}
				}
		        //Check if all coordinates are hit		
				public static void Ship_sunk2(int Player_Y, int Player_X, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count) {
					if (Ship2 == 2) {
						Points = Points + 4;
		    	        System.out.println("You sank my Patrol Boat!");
		    			System.out.println("Points + 4");
		    			System.out.println("Points = " + Points);
		    	
		    			String strNew = unShips.replace("[Patrol Boat]  ", ""); 
		    			unShips = strNew;
		    			String strNew1 = Shipss + "[Patrol Boat] ";
		    			Shipss = strNew1;
			   
		    	
		    			Winner(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
					  else {
					  }
				}
				
		//-----------------------------------------------------------------------------------2
				public static void Ship_sunk3(int Player_Y, int Player_X, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count) {
			
					if (Ship3 == 3) {
						Points = Points + 6;
						System.out.println("You sank my Destroyer!");
						System.out.println("Points + 6");
						System.out.println("Points = " + Points);	
		    	
						String strNew = unShips.replace("[Destroyer] ", ""); 
						unShips = strNew;
						String strNew1 = Shipss + "[Destroyer] ";
						Shipss = strNew1;
			    
						Winner(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
					  else {
					  }
				}
		//-----------------------------------------------------------------------------------3
				public static void Ship_sunk4(int Player_Y, int Player_X, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count) {
			
					if (Ship4 == 4) {
					   	Points = Points + 8;
						System.out.println("You sank my Battleship!");
						System.out.println("Points + 8");
						System.out.println("Points = " + Points);
		    	
						String strNew = unShips.replace("[Battleship] ", ""); 
						unShips = strNew;
					    String strNew1 = Shipss + "[Battleship] ";
				        Shipss = strNew1;
			    
					    Winner(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
				    else {  
				    }
			 	}
		//-----------------------------------------------------------------------------------4
				public static void Ship_sunk5(int Player_Y, int Player_X, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count) {
			
					if (Ship5 == 5) {
						Points = Points + 10;
						System.out.println("You sank my Aircraft carrier!");
						System.out.println("Points + 10");
						System.out.println("Points = " + Points);
		    	
						String strNew = unShips.replace("[Aircraft carrier] ", ""); 
					    unShips = strNew;
					    String strNew1 = Shipss + "[Aircraft carrier] ";
					    Shipss = strNew1;
			    
					    Winner(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
				    else {  
				    }
			 	}
		//-----------------------------------------------------------------------------------5
				public static void Ship_sunk6(int Player_Y, int Player_X, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count) {
			
					if (Ship6 == 3) {
						Points = Points + 6;
						System.out.println("You sank my Submarine!");
						System.out.println("Points + 6");
						System.out.println("Points = " + Points);
		    	
					 	String strNew = unShips.replace("[Submarine] ", ""); 
					    unShips = strNew;
					    String strNew1 = Shipss + "[Submarine] ";
					    Shipss = strNew1;
			    
					    Winner(Player_Y, Player_X, Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
			        else {  
			        }
				}
				
		        //Check if the user won
				public static void Winner(int Player_Y, int Player_X, int Points, char[][]Board, int[][]board, int Ship2, int Ship3, int Ship4, int Ship5, int Ship6, int Radar, String unShips, String Shipss, Scanner scan11, String Type_of_Game, int shoot_count) {
					if (Ship2 == 2 && Ship3 == 3 && Ship4 == 4 && Ship5 == 5 && Ship6 == 3) { 
				   	    System.out.println("Winner");
				   	    System.out.println("                    |\n"
				   	    		+ "                    A\n"
				   	    		+ "           |        R\n"
				   	    		+ "         |-|-|      G\n"
				   	    		+ "           |        O\n"
				   	    		+ "           | {O}    N\n"
				   	    		+ "           '--|     |\n"
				   	    		+ "             .|]_   |\n"
				   	    		+ "       _.-=.' |     |\n"
				   	    		+ "      |    |  |]_   |\n"
				   	    		+ "      |_.-='  |   __|__\n"
				   	    		+ "       _.-='  |\\   /|\\\n"
				   	    		+ "      |    |  |-'-'-'-'-.\n"
				   	    		+ "      |_.-='  '========='\n"
				   	    		+ "           `   |     |\n"
				   	    		+ "            `. |    / \\\n"
				   	    		+ "              ||   /   \\____.--=''''==--.._\n"
				   	    		+ "              ||_.'--=='    |__  __  __  _.'\n"
				   	    		+ "              ||  |    |    |\\ ||  ||  || |                        ___\n"
				   	    		+ " ____         ||__|____|____| \\||__||__||_/    __________________/|   |\n"
				   	    		+ "|    |______  |===.---. .---.========''''=-._ |     |     |     / |   |\n"
				   	    		+ "|    ||     |\\| |||   | |   |      '===' ||  \\|_____|_____|____/__|___|\n"
				   	    		+ "|-.._||_____|_\\___'---' '---'______....---===''======//=//////========|\n"
				   	    		+ "|--------------\\------------------/-----------------//-//////---------/\n"
				   	    		+ "|               \\                /                 // //////         /\n"
				   	    		+ "|                \\______________/                 // //////         /\n"
				   	    		+ "|       Well Done                         _____===//=//////=========/\n"
				   	    		+ "|=================================================================/\n"
				   	    		+ "'----------------------------------------------------------------`");
					    End_Points(Points);
					}
					else {
						inputXY(Points, Board, board, Ship2, Ship3, Ship4, Ship5, Ship6, Radar, unShips, Shipss, scan11, Type_of_Game, shoot_count);
					}
				}
				
		        //Ask if the user wants to end the game 
				public static void End_Points(int Points) {
					System.out.println("Points = " + Points);
					System.out.println("Do you want to play again? Yes or No");
					Scanner End_Points = new Scanner(System.in);
				    String End_game = End_Points.nextLine(); 
		    
					if ((End_game.equals("Yes"))|| (End_game.equals("yes")) || (End_game.equals("Y")) || (End_game.equals("y"))) {
						createboard();
					}
				    else if ((End_game.equals("No"))|| (End_game.equals("no")) || (End_game.equals("N")) || (End_game.equals("n")))  {
				    }
		            else {
		            }
				}			
		}
    
		  