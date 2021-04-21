package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet {
	ArrayList<Note> notes = new ArrayList<Note>();

	// String score = "DEFGABcd";
	// String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	public void settings() {
		size(1000, 500);
	}

	public void setup() {
		loadScore();
		printScores();
	}

	public void draw() {
		background(255);

	}

	void drawNotes() {
	}

	public void loadScore() {
		// iterate through each characters of score string
		for (int i = 0; i < score.length(); i++) {
			// score.charAt(i) = current character in string
			char nextChar = score.charAt(i + 1);
			if (Character.isDigit(nextChar)) {
				int duration = nextChar - '0';
				Note note = new Note(score.charAt(i), duration);
				notes.add(note);
				i++;
			} else {
				int duration = 1;
				Note note = new Note(score.charAt(i), duration);
				notes.add(note);
			}
		}

	}

	public void printScores() {
		for (Note n : notes) {
			print(n.getNote());
			print("\t");
			int duration = n.getDuration();
			print(duration);
			print("\t");
			if (duration == 1) {
				System.out.println("Quaver");
			} else {
				System.out.println("Crotchet");
			}
		}
	}
}
