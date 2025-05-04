package object;

import java.util.ArrayList;

import dice.DiceGame;

public class Referee {
	
	public static void nextPlayer(ArrayList<Player> players, ArrayList<DiceGame> dices) {
		int currentIndex = 0;
		
		do {
			Player currentPlayer = players.get(currentIndex);
			DiceGame currentDice = dices.get(currentIndex);
			System.out.print(currentPlayer.toString());
			int randomNumber = currentDice.randomOfDice();
			System.out.println("Number of dice: " + randomNumber);
			currentPlayer.setScore(currentPlayer.getScore() + randomNumber);
			System.out.println(currentPlayer.toString());
			
			if (currentPlayer.getScore() > 21) {
				currentPlayer.setScore(0);
			} else if (currentPlayer.getScore() == 21) {
				VirtualPlayer.virtualLose(players, currentIndex + 1);
				System.out.println("Winner: " + currentPlayer.getName());
			}
			
			currentIndex = (currentIndex + 1 ) % 4;
		} while (players.get(currentIndex - 1).getScore() != 21);
		
	}
	
	
}
