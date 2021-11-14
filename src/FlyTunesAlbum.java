/**
 * @program: JavaProgromming
 * @description: Keeps track of all the information for one album  in the music shop, including its name, the band that its by, and the list of flyTunesSongs it contains.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-13 11:26
 */

import java.util.*;

public class FlyTunesAlbum {
    /**
     * Constructor
     * Note that the album name and band name are immutable
     * once the album is created.
     */
    public FlyTunesAlbum(String albumName, String bandName) {
        title = albumName;
        band = bandName;
    }

    public String getAlbumName() {
        return title;
    }

    public String getBandName() {
        return band;
    }

    /**
     * Adds a flyTunesSong to this album.  There is no duplicate
     * checking for flyTunesSongs that are added.
     */
    public void addSong(FlyTunesSong flyTunesSong) {
        flyTunesSongs.add(flyTunesSong);
    }

    /**
     * Returns an iterator over all
     * on this album.
     */


    public Iterator<FlyTunesSong> getSongs() {
        return flyTunesSongs.iterator();
    }

    /**
     * Returns a string representation of an album, listing * the album name and the band name.
     */
    public String toString() {
        return ("\"" + title + "\" by " + band);
    }

    /* private instance variables */
    private String title;
    private String band;
    private ArrayList<FlyTunesSong> flyTunesSongs = new ArrayList<FlyTunesSong>();
}
