import java.util.Scanner;
import java.util.Random;
import java.lang.Character;
public class TicTacToe
{
	/*
	Method to create a generic players. Accepts
	a marker as an argument and returns and object
	of type player.
	*/
	public static Player createPlayer(char marker)
	{
		//create new input object
		Scanner input = new Scanner(System.in);
		//prompt for player's name
		System.out.print("Please enter the player's name: ");
		//input name
		String name = input.nextLine();
		//create player and assign marker to player
		Player newPlayer = new Player(name, marker);
		//return player
		return newPlayer;
	}
	/*
	Method to make a move on the board.  Accepts the player
	and the board as arguments.  Accepts coordinates and applies
	the marker to that location.
	*/
	public static void makeMove(Player player, Board board)
	{
		//Let whichever player's turn it is know that it's their turn
		System.out.println(player.getName() + " it's your turn!");
		//coordinate for row
		char row;
		//column coordinate
		int col = 0;
		//new input object
		Scanner input = new Scanner(System.in);
		//input validation loop to make sure coordinates supplied
		//are of an actual coordinate
		while(true)
		{
			//prompt for row coordinate
			System.out.print("Please enter the row you would like to mark: ");
			//trim coordinate, only first character counts
			row = input.nextLine().trim().charAt(0);
			//input validation loop for column coordinate
			while(true)
			{
				//input column
				System.out.print("Please enter the column you would like to mark: ");
				//make sure its an integer
				if (input.hasNextInt())
				{
					//store integer
					col = input.nextInt();
					//break out of loop
					break;
				}
				else
				{
					//re-prompt if error
					System.out.println("ERROR: That is not an integer.");
				}
			}
			//If its a proper coordinate move on
			if ((Character.toLowerCase(row) == 'a' 
				|| Character.toLowerCase(row) == 'b' 
				|| Character.toLowerCase(row) == 'c') &&
				(col == 1 || col == 2 || col == 3))
			{
				//exit outer while loop
				break;
			}
			else
			{
				//otherwise re-prompt
				System.out.println("ERROR: Enter a valid square.");
			}
		}
		//to assign a numerical value to the row letter
		int rowInt = 0;
		//if a make it 1
		if (Character.toLowerCase(row) == 'a')
		{
			rowInt = 1;
		}
		//if b make it 2
		else if (Character.toLowerCase(row) == 'b')
		{
			rowInt = 2;
		}
		//if c make it 3
		else
		{
			rowInt = 3;
		}
		//call on makeMove method in player class given coordinates
		player.makeMove(rowInt, col, board);
		//print the updated board
		board.display();
	}
	public static void main(String[] args)
	{
		//create players
		System.out.println("Creating Player 1...");
		Player player1 = createPlayer('X');
		System.out.println("Creating Player 2...");
		Player player2 = createPlayer('O');

		//create the board
		Board board = new Board();
		//print empty board
		board.display();

		//randomly generate which player gets the first turn
		System.out.println("Generating First Turn...");
		Random generator = new Random();
		//a number 1 or 2
		int firstTurn = (int) Math.round(generator.nextDouble() + 1);
		boolean turn;
		//if true player 1 gets the first turn
		if (firstTurn == 1)
		{
			turn = true;
		}
		//otherwise player 2 gets it
		else
		{
			turn = false;
		}
		/*
		Loop and play the game until either a winner is declared
		or the board is full and its a tie
		*/
		while (!board.winner()  && !(board.full()))
		{
			//if turn is true its player 1's turn
			if (turn)
			{
				//make a move using method above
				makeMove(player1, board);
				//switch turn to player 2
				turn = false;
			}
			else
			{
				//make a move using method above
				makeMove(player2, board);
				//switch turn to player 1
				turn = true;
			}
		}
		//if player 2 went last and the board has a winner
		if (turn  && board.winner())
		{
			//player 2 wins
			System.out.println(player2.getName() + " wins");
		}
		//if player 1 went last and the board has a winner
		else if (!turn && board.winner())
		{
			//player 1 wins
			System.out.println(player1.getName() + " wins");
		}
		else
		{
			//its a tie
			System.out.println("\nIt is a tie!");
		}

	}
}