import java.util.*;

public class STICKS 
{
	public static void main(String[] args) 
	{
		//Intro - # of sticks and Turn system
		Scanner input = new Scanner(System.in);
		int sticks = (int)(Math.random()*10) + 21;	//random integer from 0-9
		System.out.println("WELCOME TO THE REALM HUMAN WE WILL DECIDE YOUR FATE WITH A GAME OF STICKS. YOU HAVE " + sticks + " STICKS.");
		System.out.println("WILL YOU DECIDE TO STEP FIRST HUMAN? OR WILL YOU GO SECOND? TYPE 1 OR 2");
		boolean turn;						//lol if it's the guy's turn
		if (input.nextInt() == 1)
			turn = true;					//if it is their turn
		else
			turn = false;					//if it is not their turn
		
		
		//The Game
		while(sticks > 0) {
			if(turn)
				sticks = playerMove(sticks, input);
			else
				sticks = computerMove(sticks);
			System.out.println("THERE ARE " + sticks + " LEFT.");
			if (sticks == 0 && turn)
				System.out.println("HUMAN WILL NOT BE BOILED IN A HOT POT FOR US TO CONSUME");
			if (sticks == 0 && !turn)
				System.out.println("HUMAN WILL BE BOILED IN A HOT POT FOR US TO CONSUME");
			turn != turn;	//Basically switches turn between human/computer
		}
	}
	
	public static int playerMove(int sticks, Scanner input) {		//this method returns a value while void does not
		System.out.println("HOW MANY STICKS WILL YOU TAKE?");
		int take = input.nextInt();
		if (take < 1)		//sets boundaries. If player puts in less than 1, it will be 1
			take = 1;
		if (take > 3)		//same here, if player puts in bigger than 3, it will be 3
			take = 3;
		else if(take > sticks)		//if there is like 1-2 sticks left and you say 3, then it'll just take how many sticks are actually left
			take = sticks;
		System.out.println("YOU TOOK " + take + " STICKS YOU FILTHY HUMAN.");
		return sticks - take;
	}
	
	public static int computerMove(int sticks) {
		int take;
		if (sticks % 4 != 0)
			take = sticks % 4;
		else
			take = (int)(Math.random()*3) + 1;
		System.out.println("WE HAVE TOOK " + take + " STICKS YOU FILTHY HUMAN.");
		return sticks - take;
	}
}
