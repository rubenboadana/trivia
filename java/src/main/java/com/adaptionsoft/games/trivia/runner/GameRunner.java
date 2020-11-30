
package com.adaptionsoft.games.trivia.runner;
import java.util.LinkedList;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.PlayerService;
import com.adaptionsoft.games.uglytrivia.QuestionsManager;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		QuestionsManager questionsManager = new QuestionsManager(new LinkedList(), new LinkedList(), new LinkedList(),
				new LinkedList());
		
		PlayerService playerService = new PlayerService();
		
		playerService.add("Chet");
		playerService.add("Pat");
		playerService.add("Sue");
		
		Game aGame = new Game(questionsManager, playerService);
		
		Random rand = new Random();
	
		do {
			
			aGame.roll(rand.nextInt(5) + 1);
			
			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}
			
			
			
		} while (notAWinner);
		
	}
}
