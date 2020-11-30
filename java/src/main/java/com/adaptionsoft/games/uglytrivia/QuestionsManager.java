package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class QuestionsManager {
	public LinkedList popQuestions;
	public LinkedList scienceQuestions;
	public LinkedList sportsQuestions;
	public LinkedList rockQuestions;

	public QuestionsManager(LinkedList popQuestions, LinkedList scienceQuestions, LinkedList sportsQuestions,
			LinkedList rockQuestions) {
		this.popQuestions = popQuestions;
		this.scienceQuestions = scienceQuestions;
		this.sportsQuestions = sportsQuestions;
		this.rockQuestions = rockQuestions;
		
		initializeQuestions();
	}

	private void initializeQuestions() {
		for (int i = 0; i < 50; i++) {
			popQuestions.addLast(createQuestion("Pop", i));
			scienceQuestions.addLast(createQuestion("Science",i));
			sportsQuestions.addLast(createQuestion("Sports",i));
			rockQuestions.addLast(createQuestion("Rock", i));
		}
	}

	private String createQuestion(String questionType, int index) {
		return questionType + " Question " + index;
	}
}