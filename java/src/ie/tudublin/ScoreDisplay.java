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
		// white background
		background(255);
		// draw 5 lines
		for (int i = 0; i < 5; i++) {
			// height of stave
			int staveHeight = height - 175;
			int staveWidth = width - 20;
			// draw
			strokeWeight(3);
			line(20, staveHeight - i * 20, staveWidth, staveHeight - i * 20);
		}
		drawNotes();

	}

	void drawNotes() {
		// height of stave
		int staveHeight = height - 175;
		int i = 1;
		for (Note n : notes) {
			char noteTemp = n.getNote();
			int noteVal;
			switch (noteTemp) {
			case 'D':
				noteVal = 1;
				break;

			case 'E':
				noteVal = 2;
				break;

			case 'F':
				noteVal = 3;
				break;

			case 'G':
				noteVal = 4;
				break;

			case 'A':
				noteVal = 5;
				break;

			case 'B':
				noteVal = 6;
				break;

			case 'c':
				noteVal = 7;
				break;

			case 'd':
				noteVal = 8;
				break;

			default:
				noteVal = 0;
				break;

			}

			int noteLocation = (staveHeight + 20) - 10 * noteVal;
			strokeWeight(5);
			line(40 * i, noteLocation, 40 * i, noteLocation - 50);
			i++;
		}
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
