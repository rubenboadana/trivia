package com.adaptionsoft.games.uglytrivia;

public class Game {
    public PlayerService playerService;
	public QuestionsManager questionsManager;
    
	Player currentPlayerObj;
	boolean isGettingOutOfPenaltyBox;
    
    public  Game(QuestionsManager questionsManager, PlayerService playerService){
    	this.questionsManager = questionsManager;
    	this.playerService = playerService;
    	this.currentPlayerObj = playerService.get(0);
    }

	public void roll(int roll) {
		System.out.println(currentPlayerObj + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (currentPlayerObj.inPenaltyBox) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(currentPlayerObj + " is getting out of the penalty box");
				currentPlayerObj.place = currentPlayerObj.place + roll;
				if (currentPlayerObj.place > 11) currentPlayerObj.place = currentPlayerObj.place - 12;
				
				System.out.println(currentPlayerObj
						+ "'s new location is " 
						+ currentPlayerObj.place);
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(currentPlayerObj + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
			}
			
		} else {
		
			currentPlayerObj.place = currentPlayerObj.place + roll;
			if (currentPlayerObj.place > 11) currentPlayerObj.place = currentPlayerObj.place - 12;
			
			System.out.println(currentPlayerObj
					+ "'s new location is " 
					+ currentPlayerObj.place);
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}
		
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(questionsManager.popQuestions.removeFirst());
		if (currentCategory() == "Science")
			System.out.println(questionsManager.scienceQuestions.removeFirst());
		if (currentCategory() == "Sports")
			System.out.println(questionsManager.sportsQuestions.removeFirst());
		if (currentCategory() == "Rock")
			System.out.println(questionsManager.rockQuestions.removeFirst());		
	}
	
	
	private String currentCategory() {
		if (currentPlayerObj.place == 0) return "Pop";
		if (currentPlayerObj.place == 4) return "Pop";
		if (currentPlayerObj.place == 8) return "Pop";
		if (currentPlayerObj.place == 1) return "Science";
		if (currentPlayerObj.place == 5) return "Science";
		if (currentPlayerObj.place == 9) return "Science";
		if (currentPlayerObj.place == 2) return "Sports";
		if (currentPlayerObj.place == 6) return "Sports";
		if (currentPlayerObj.place == 10) return "Sports";
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (currentPlayerObj.inPenaltyBox){
			if (isGettingOutOfPenaltyBox) {
				System.out.println("Answer was correct!!!!");
				currentPlayerObj.purse++;
				System.out.println(currentPlayerObj 
						+ " now has "
						+ currentPlayerObj.purse
						+ " Gold Coins.");
				
				boolean winner = didPlayerWin();
				playerService.currentPlayerIndex++;
				if (playerService.currentPlayerIndex == playerService.players.list.size()) playerService.currentPlayerIndex = 0;
				
				return winner;
			} else {
				playerService.currentPlayerIndex++;
				if (playerService.currentPlayerIndex == playerService.players.list.size()) playerService.currentPlayerIndex = 0;
				return true;
			}
		} else {
		
			System.out.println("Answer was corrent!!!!");
			currentPlayerObj.purse++;
			System.out.println(playerService.players.list.get(playerService.currentPlayerIndex) 
					+ " now has "
					+ currentPlayerObj.purse
					+ " Gold Coins.");
			
			boolean winner = didPlayerWin();
			playerService.currentPlayerIndex++;
			if (playerService.currentPlayerIndex == playerService.players.list.size()) playerService.currentPlayerIndex = 0;
			
			return winner;
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		return playerService.wrongAnswer();
	}

	private boolean didPlayerWin() {
		return !(currentPlayerObj.purse == 6);
	}
}
