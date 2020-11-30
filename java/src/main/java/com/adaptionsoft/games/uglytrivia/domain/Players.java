package com.adaptionsoft.games.uglytrivia.domain;

import java.util.ArrayList;

public class Players {
	public ArrayList<String> players;

	public Players() {
		this.players = new ArrayList<String>();
	}

	public int howManyPlayers() {
		return players.size();
	}
}