package com.adaptionsoft.games.uglytrivia.domain;

import java.util.ArrayList;

import com.adaptionsoft.games.uglytrivia.Player;

public class Players {
	public ArrayList<Player> list;

	public Players() {
		this.list = new ArrayList<Player>();
	}

	public int howManyPlayers() {
		return list.size();
	}

	public void add(Player player) {
		list.add(player);
	}

	public Player get(int currentPlayer) {
		return list.get(currentPlayer);
	}
}