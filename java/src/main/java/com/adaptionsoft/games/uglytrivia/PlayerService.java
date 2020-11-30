package com.adaptionsoft.games.uglytrivia;

import com.adaptionsoft.games.uglytrivia.domain.Players;

public class PlayerService {
	public Players players;
	int currentPlayerIndex = 0;

	public PlayerService() {
		this.players = new Players();
	}

	public boolean add(String playerName) {
		Player player = Player.initializePlayer(playerName);
	    players.add(player);
	    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.list.size());
		return true;
	}

	public Player get(int currentPlayer) {
		return players.get(currentPlayer);
	}

	boolean wrongAnswer() {
		Player currentPlayer = players.get(currentPlayerIndex);
		System.out.println(currentPlayer + " was sent to the penalty box");
		currentPlayer.inPenaltyBox = true;
		
		currentPlayerIndex++;
		if (currentPlayerIndex == players.list.size()) currentPlayerIndex = 0;
		return true;
	}
}