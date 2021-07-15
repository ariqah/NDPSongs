package sg.edu.rp.c346.id20023243.ndpsongs;

import java.io.Serializable;

public class Song implements Serializable {

    private int _id;
    private String title;
    private String singers;
    private int year;
    private int star;

    public Song(String title, String singers, int year, int star) {
        this.title = title;
        this.singers = singers;
        this.year = year;
        this.star = star;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYear() {
        return year;
    }

    public int getStar() {
        return star;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSingers(String singers) {
        this.singers = singers;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String toString() {
        String astrid = "";
        if (star == 1) {
            astrid = "*";
        }
        else if (star == 2) {
            astrid = "**";
        }
        else if (star == 3) {
            astrid = "***";
        }
        else if (star == 4) {
            astrid = "****";
        }
        else if (star == 5) {
            astrid = "*****";
        }

        return title + "\n" + singers + " - " + year + "\n" + astrid;

    }
}
