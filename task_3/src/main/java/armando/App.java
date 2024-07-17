package armando;

import java.util.Scanner;

class  App{

	public static void main(String[] args) throws Exception  {
		for (int i = 0; i < args.length - 1; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[i].equals(args[j])) {
                    System.out.println("\nERROR: DUPLICATED ARGUMENTS\nEvery argument should be different, for example:\njava Task3 a b c\nInstead of\njava Task3 a b a");
					System.exit(0);
                }
            }
        }
		if((args.length%2)!=0){
			CreateKey keyGenerator = new CreateKey();	//Generate key
			String key = keyGenerator.generate(); 

			Move moveGenerator = new Move();	//Generate computers move
			String move = moveGenerator.generateMove(args);

			CreateHMAC hmacGenerator = new CreateHMAC();	//Generate HMAC
			String hmac = hmacGenerator.getHMAC(key, move);

			System.out.println("The HMAC is: " + hmac);
			
			int selection = -1;
       		Scanner scanner = new Scanner(System.in);
        	System.out.println("Choose your move:");

			while (selection < 0 || selection > args.length) {		//Display the menu 
				int optionNum = 1;
				for (String i : args) {
					System.out.println(optionNum + "- " + i);
					optionNum++;
				}
				System.out.println("0 - exit\n? - help");
				
				String input = scanner.nextLine();
				try {
					selection = Integer.parseInt(input);
					if (selection < 0 || selection > args.length) {				//Verify valid input
						System.out.println("Invalid input, choose again");
					} else if (selection == 0) {									//Exit if 0
						System.out.println("Exiting...");
						scanner.close(); 
						System.exit (0);   
					}
				} catch (NumberFormatException e) {
					if (input.equals("?")) {
                                            TableGenerator table = new TableGenerator();
                                            table.displayRulesTable(args);
					} else {
						System.out.println("Invalid input, choose again");
					}
					selection = -1;
				}
			}
			
			String userMove = args[selection-1];
			System.out.println("Your move is: " + userMove + "\nComputer move is: " + move);
			Rules check = new Rules();
			int result = check.victoryCheck(args, move, userMove);
			
			if(result==0){
				System.out.println("\n----------------Its a tie----------------");
			}else if(result==1){
				System.out.println("\n----------------You win----------------");
			}else if(result==-1){
				System.out.println("\n----------------You lose----------------");
			}
			
			System.out.println("\nHMAC key: " + key);
			
		}else{
			System.out.println("\nERROR!!! YOU HAVE TO GIVE AN ODD NUMBER OF ARGUMENS\nHere are some examples:\njava Task3 rock paper scissors\njava Task3 1 2 3 4 5 6 7\njava Task3 a b c d e");
		}
	}
}