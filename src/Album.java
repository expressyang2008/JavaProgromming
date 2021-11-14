/**
 * @program: JavaProgromming
 * @description:
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-28 10:04
 */
public class Album {
    //Constructor
    public Album(String album, String band, int stock) {
        albumName = album;
        bandName = band;
        numStocked = stock;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getNumStocked() {
        return numStocked;
    }

    public void setNumStocked(int numStocked) {
        this.numStocked = numStocked;
    }


    public String toString() {
        return ("\"" + albumName + "\" by " + bandName + ":" + numStocked + " in stock");
    }

    /*private instance  variables*/
    private String albumName;
    private String bandName;
    private int numStocked;
}
