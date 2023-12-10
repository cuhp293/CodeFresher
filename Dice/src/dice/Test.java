package dice;

import java.util.ArrayList;
import java.util.Scanner;

import object.Player;
import object.Referee;

public class Test {
	
	Scanner scanner = new Scanner(System.in);
	static ArrayList<Player> players = new ArrayList<>();
	static ArrayList<DiceGame> dices = new ArrayList<DiceGame>();

	public static void main(String[] args) {
		Player.player(players, dices);
		Referee.nextPlayer(players, dices);
	}

}
