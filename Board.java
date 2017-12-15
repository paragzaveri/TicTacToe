/*
Class for creating a Tic Tac Toe Board
*/
public class Board
{
	//instance variable for 2D array to store game board
	private char[][] board;
	//tictactoe will always be same size and these are consts
	public static final int ROWS = 4;
	public static final int COLUMNS = 4;

	/**
	*Default Constructor
	*Constructs a blank 4x4 board with letters and
	*numbers on the tops and sides for coordinates
	*and number
	*/
	public Board()
	{
		//create new 2d array object
		board = new char[ROWS][COLUMNS];
		//set every value to null
		//uses enhanced loops
		for(char[] row : board)
		{
			for (char element : row)
			{
				//uses null encoding
				element = '\u0000';
			}
		}
		/*
		Set the top row and far left row to 
		numbers and letter to allow for coordinates
		*/
		board[0][1] = '1';
		board[0][2] = '2';
		board[0][3] = '3';

		board[1][0] = 'a';
		board[2][0] = 'b';
		board[3][0] = 'c';

		board[0][0] = '+';
	}
	/**
	*Argument Constructor
	*Constructs a blank 4x4 board with letters and
	*numbers on the tops and sides for coordinates
	*and number
	*Ignores arguments because board is the same
	*size, but allows them to be entered
	*in case caller forgets.
	*@param rows The number of rows for the board
	*@param coumns The number of columns for the board
	*/
	public Board(int rows, int columns)
	{
		//create a new 2D array object
		board = new char[ROWS][COLUMNS];

		//use two enhanced for loops to set
		//every element to the null character
		for(char[] row : board)
		{
			for (char element : row)
			{
				element = '\u0000';
			}
		}

		/*
		Give coordinates to the top row and far
		left column.
		*/
		board[0][1] = '1';
		board[0][2] = '2';
		board[0][3] = '3';

		board[1][0] = 'a';
		board[2][0] = 'b';
		board[3][0] = 'c';

		board[0][0] = '+';
	}
	/**
	*Copy Constructor
	*Uses two for loops to copy every element
	*of parameter into a new board object
	*@param copy The board to copy.
	*/
	public Board(Board copy)
	{
		//create a new board object
		board = new char[ROWS][COLUMNS];
		for(int i = 0; i < copy.getBoard().length; i++)
		{
			for (int j = 0; j < copy.getBoard()[i].length; j++)
			{
				board[i][j] = copy.getBoard()[i][j];
			}
		}
	}
	/**
	*Accessor for the board array itself
	*@return board The 2D Array which holds the board
	*/
	public char[][] getBoard()
	{
		return board;
	}
	/**
	*Accessor for an individual element on the board.
	*@return element A char value indicating the marker on the board.
	*/
	public char getElement(int row, int column)
	{
		return board[row][column];
	}
	/**
	*Mutator for an individual element on the board.
	*@param row The coordinate of the row.
	*@param column The coordinate of the column
	*@param element The element to store in to that board position
	*/
	public void setElement(int row, int column, char element)
	{
		board[row][column] = element;
	}
	/**
	*A method for printing the board.
	*Uses two enhanced for loops to print out each
	*element on the board with a tab space between
	*them.  Each row is given two newlines and additional
	*spacing.
	*/
	public void display()
	{

		//iterate through board
		for(char[] row : board)
		{
			for (char element : row)
			{
				//print tab character
				System.out.print(element + "\t");

			}
			//print two new lines
			System.out.println("\n");
			//additional spacing
			for (int i = 0; i < 5; i++)
			{
				System.out.print(" ");
			}
			//final between rows
			System.out.println();
		}
	}
	/**
	*Method for checking if the board has a 
	*winning combination on it.
	*This can be across or down in any
	*row or column and diagonal.
	*Uses a long if else branch to check
	*if all the values in these combinations
	*are the same.
	*/
	public boolean winner()
	{
		//boolean to return if winner is true
		boolean isWinner;
		/*
		Notice that each checks that the null character is
		not present, in case there is a false positve when
		all null characters are equal to each other.
		*/
		//top row
		if ((board[1][1] == board[1][2] && 
			board[1][2] == board[1][3]) 
			&& board[1][1] != '\u0000')
		{
			isWinner = true;
		}
		//second row
		else if	((board[2][1] == board[2][2] &&
				board[2][2] == board[2][3])
				&& board[2][1] != '\u0000')
		{
			isWinner = true;
		}
		//third row
		else if ((board[3][1] == board[3][2] &&
			board[3][2] == board[3][3])
			&& board[3][1] != '\u0000')
		{
			isWinner = true;
		}
		//first column
		else if ((board[1][1] == board[2][1] &&
			board[2][1] == board[3][1])
			&& board[1][1] != '\u0000')
		{
			isWinner = true;
		}
		//second column
		else if ((board[1][2] == board[2][2] &&
			board[2][2] == board[3][2])
			&& board[1][2] != '\u0000')
		{
			isWinner = true;
		}
		//third column
		else if ((board[1][3] == board[2][3] &&
			board[2][3] == board[3][3])
			&& board[1][3] != '\u0000')
		{
			isWinner = true;
		}
		//diagonal 1
		else if (((board[1][1] == board[2][2]) &&
			(board[2][2] == board[3][3]))
			&& board[1][1] != '\u0000')
		{
			isWinner = true;
		}
		//diagonal 2
		else if (((board[3][1] == board[2][2]) &&
			(board[2][2] == board[1][3]))
			&& board[3][1] != '\u0000')		
		{
			isWinner = true;
		}
		//if not a winning combination return false
		else
		{
			isWinner = false;
		}
		return isWinner;
	}
	/**
	*Method for determining if the board is full
	*Checks that all elements in the array have a 
	*value that is not null.
	*/
	public boolean full()
	{
		//boolean to return
		boolean isFull = true;
		//two enhanced loops to iterate through array
		for (char[] row : board)
		{
			for(char element : row)
			{
				//if anything is null
				if(element == '\u0000')
				{
					//return false
					isFull = false;
				}
			}
		}
		//if true then the board is full
		return isFull;
	}
}


