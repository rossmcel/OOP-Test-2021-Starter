package ie.tudublin;

public class Note {

    private char note;
    private int duration;

    public Note(char n, int d) {
        note = n;
        duration = d;
    }

    @Override
    public String toString() {
        String rhythm;
        if (duration == 1) {
            rhythm = "Quaver";
        } else {
            rhythm = "Crotchet";
        }
        return note + "\t" + duration + "\t" + rhythm;
    }

    public char getNote() {
        return note;
    }

    public int getDuration() {
        return duration;
    }

}
