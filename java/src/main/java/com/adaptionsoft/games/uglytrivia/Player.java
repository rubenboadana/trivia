package com.adaptionsoft.games.uglytrivia;

public class Player {

	public String name;
	public int place;
	public int purse;
	public boolean inPenaltyBox;

	public Player(String name, int place, int purse, boolean inPenaltyBox) {
		this.name = name;
		this.place = place;
		this.purse = purse;
		this.inPenaltyBox = inPenaltyBox;
	}
	
	public static Player initializePlayer(String playerName) {
		return new Player(playerName, 0, 0, false);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}
	
}