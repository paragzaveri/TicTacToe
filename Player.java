/*
Class for creating a Player
*/

public class Player
{
	//instance variables to hold player name and marker value
	private String playerName;
	private char playerMarker;

	/**
	*Default Constructor
	*Sets name to empty string and marker to null.
	*/
	public Player()
	{
		playerName = "";
		playerMarker = '\u0000';
	}
	/**
	*Argument Constructor
	*@param name The name of the player
	*@param marker The choice of x or o for the marker to be played with.
	*/
	public Player(String name, char marker)
	{
		playerName = name;
		playerMarker = marker;
	}
	/**
	*Copy Constructor
	*@param copy The player to copy and create a new object of.
	*/
	public Player(Player copy)
	{
		this(copy.getName(), copy.getMarker());
	}
	/**
	*Accessor for name of the players
	*@return playerName The name of the player in the object.
	*/
	public String getName()
	{
		return playerName;
	}
	/**
	*Accessor for the marker of the player.
	*@return playerMarker The marker of the player in the object.
	*/
	public char getMarker()
	{
		return playerMarker;
	}
	/**
	*Mutator for the name of the player.
	*@param name The name of the player.
	*/
	public void setName(String name)
	{
		playerName = name;
	}
	/**
	*Mutator for the marker the player is using
	*@param marker The marker to be used
	*/
	public void setMarker(char marker)
	{
		playerMarker = marker;
	}
	/**
	*Method for a player to make a move on the board.
	*Uses the setElement() method of the Board class
	*@param row The row coordinate.
	*@param column The column coordinate.
	*@param game The board to be played on.
	*/
	public void makeMove(int row, int column, Board game)
	{
		game.setElement(row, column, this.getMarker());
	}
	/**
	*A method for printing the name and choice of marker for each player.
	*/
	public void display()
	{
		System.out.println("Player Name: " + playerName);
		System.out.println("Player Marker: " + playerMarker);
	}
}