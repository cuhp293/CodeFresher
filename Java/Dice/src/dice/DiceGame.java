package dice;

import java.util.Random;

public class DiceGame {
	private double[] probabilities = new double[6];

	public DiceGame(int i) {
		for (int j = 0; j < 6; j++) {
			if (j + 1 == i)
				probabilities[j] = 0.2;
			else
				probabilities[j] = 0.16;
		}
	}

	public int randomOfDice() {
		Random random = new Random();
		int roll = rollDice(probabilities, random);
		return roll;
	}

	public static int rollDice(double[] probabilities, Random rand) {
		double roll = rand.nextDouble();
		double cumulativeProbability = 0.0;
		for (int i = 0; i < probabilities.length; i++) {
			cumulativeProbability += probabilities[i];
			if (roll < cumulativeProbability) {
				return i + 1;
			}
		}
		return -1;
	}
}
