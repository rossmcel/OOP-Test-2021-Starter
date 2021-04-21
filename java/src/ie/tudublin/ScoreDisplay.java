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
			// main line
			line(55 * i, noteLocation, 55 * i, noteLocation - 50);
			// diagonal line
			line(55 * i, noteLocation - 50, 55 * i + 15, noteLocation - 40);

			strokeWeight(1);

			// width of circle section of note
			int circleWidth = 16;

			// highlight note red if mouse on it, if not make it black
			if (mouseX > 55 * i - circleWidth / 2 && mouseX < 55 * i + circleWidth) {
				fill(255, 0, 0);
			} else {
				fill(0, 0, 0);
			}

			// main body of note (circular part)
			circle(55 * i - circleWidth / 2, noteLocation, circleWidth);

			// draw names of notes
			textSize(24);
			text(noteTemp, 55 * i - circleWidth + 2, staveHeight - 175);

			i++;
		}
	}

	public void loadScore() {
		// iterate through each character of score string
		for (int i = 0; i < score.length(); i++) {
			// score.charAt(i) = current character in string
			if (i != score.length() - 1) {
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
			} else {
				int duration = 1;
				Note note = new Note(score.charAt(i), duration);
				notes.add(note);
			}
		}

	}

	public void printScores() {
		for (Note n : notes) {
			System.out.println(n);
		}
	}
}
