package ie.tudublin;

public class Note {

    private char note;
    private int duration;

    public Note(char n, int d) {
        note = n;
        duration = d;
    }

    /*
     * @Override public String toString(Note n) {
     * 
     * }
     */

    public char getNote() {
        return note;
    }

    public int getDuration() {
        return duration;
    }

}
