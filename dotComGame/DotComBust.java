import java.util.*;

/*
Note: 
a dot com is the object on the board (similar to the ship in battlship). each takes up 3 consecutive spaces on the 
gameboard (2d Array).
1. This class contains the driver main. 
2. starts the game by creating new dotcoms.
3. promtps user to enter guess until game is over.
4. tells the user if guess is hit or miss.
5. tells the user how the did when the game ends.
*/

public class DotComBust {
	// instance variables:
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	// class methods:
	/*
	this method creates 3 dot coms and adds them to the list of dot coms
	*/
	private void setUpGame() {
		// create three Dot Coms
		DotCom one = new DotCom();
		one.setName("Pets.com");
		dotComsList.add(one);
		DotCom two = new DotCom();
		two.setName("Pirates.com");
		dotComsList.add(two);
		DotCom three = new DotCom();
		three.setName("ballers.com");
		dotComsList.add(three);
		// set up the game for the user
		System.out.println("your goal is to sink three dot coms");
		System.out.println("Pets.com" + ", " + "Pirates.com" + ", " + "ballers.com");
		System.out.println("try to sink them all in the fewest number of guesses");
		// uses the gameHelper to place the three dot coms
		for(DotCom dotComToSet : dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}

	/*
	this method runs the game while there are still dot coms left on the board
	*/
	private void startPlaying() {
		// prompt user to guess, check user guesses, until all dot coms are destroyed, end game.
		while(!dotComsList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}

	/* 
	this method tracks the number of guesses the user has made, iterates through the locations of the dot coms
	and checks if each guess is a hit on a location. Then removes each of the hits from the Array of locations.
	*/
	private void checkUserGuess(String userGuess){
		// checks the guesses on the dot coms
		numOfGuesses++;
		String result = "miss";

		for(int x = 0; x < dotComsList.size(); x++) {
			result = dotComsList.get(x).checkYourself(userGuess); /* check if each iteration on the dotComsList is a hit/kill */
			if(result == "hit") {
				break;
			}
			if(result == "kill") {
				dotComsList.remove(x); /* remove the dotCom if it has been killed */
				break;
			}
		}
		System.out.println(result);
	}
	/*
	this method tells the user if they won or if they exceeded the max number of guesses 18
	*/
	private void finishGame() {
		System.out.println("All Dot Coms Are Dead! Your Stock Is Now Worthless.");
		if(numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println("You got out before your options sank.");
		} else {
			System.out.println("Took you long enough. " + numOfGuesses + "guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}
	/*
	This method drives the game
	*/
	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}














