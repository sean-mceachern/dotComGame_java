import java.util.*;


/*
Notes: 
This class does three things:
1. sets locations of doctoms 
2. stores locations of dotcoms
3. checks user guesses against locations of dot coms. tracks hit/kills

*/

public class DotCom {
	// instance variables:
	private ArrayList<String> locationCells; /* array list of cell locations */
	private String name; /* name for each dot com */

	// methods:
	/*
	this method updates the instance variable with the locs generated from the GameHelper function
	*/
	public void setLocationCells(ArrayList<String> locs) {
		locationCells = locs; /* updates the location instance variable */
	}
	
	/*
	this method sets the name for the dot com
	*/
	public void setName(String n) {
		name = n;
	}

	/*
	this method
	*/
	public String checkYourself(String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput); /* searches the list of locationCells for the userInput and returns the index */
		if (index >= 0) {
			locationCells.remove(index); /* removes the index of the userInput if it was a hit in the list (hit) */
			if(locationCells.isEmpty()) { /* if all cells are empty then the dot coms have all been destroyed */ 
				result = "kill";
			} else {
				result = "hit";
			}
		}
		return result;
	}
}