/**
 * @program: JavaProgromming
 * @description: This program handles the data management for an on-line music store  where we manage an inventory of albums as well as individual flyTunesSongs.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-12 14:37
 */

import acm.program.*;

import java.util.*;

public class FlyTunesStore extends ConsoleProgram {
    public void run() {
        while (true) {
            int selection = getSelection();
            if (selection == QUIT) break;
            switch (selection) {
                case LIST_SONGS:
                    listSongs();
                    break;
                case LIST_ALBUMS:
                    listAlbums();
                    break;
                case ADD_SONG:
                    addSong();
                    break;
                case ADD_ALBUM:
                    addAlbum();
                    break;
                case LIST_SONGS_ON_ALBUM:
                    listSongsOnAlbum();
                    break;
                case UPDATE_SONG_PRICE:
                    updateSongPrice();
                    break;
                default:
                    println("Invalid selection");
                    break;
            }
        }
    }

    /**
     * Prompts the user to pick a selection from a menu
     * of options. Returns the users selection. Note that
     * there is no bounds checking done on the users selection.
     */
    private int getSelection() {
        println();
        println("Please make a selection (0 to quit):");
        println("1. List all flyTunesSongs");
        println("2. List all albums");
        println("3. Add a song");
        println("4. Add an album");
        println("5. List flyTunesSongs on an album");
        println("6. Update song price");
        int choice = readInt("Selection: ");
        return choice;
    }

    /**
     * Lists all the flyTunesSongs carried by the store
     */
    private void listSongs() {
        println("All flyTunesSongs carried by the store:");
        for (int i = 0; i < flyTunesSongs.size(); i++) {
            println(flyTunesSongs.get(i).toString());
        }
    }

    /**
     * Lists all the albums carried by the store
     */
    private void listAlbums() {
        println("All albums carried by the store:");
        Iterator<String> albumIt = albums.keySet().iterator();
        while (albumIt.hasNext()) {
            println(albums.get(albumIt.next()).toString());
        }
    }

    /**
     * Checks to see if the song (defined by its name and
     * the band that performs it) is already in the store, It
     * returns the index of the song in the store's song list
     * if it already exists and -1 otherwise.
     */
    private int findSong(String name, String band) {
        int index = -1;
        for (int i = 0; i < flyTunesSongs.size(); i++) {
            if (flyTunesSongs.get(i).getSongName().equals(name)
                    && flyTunesSongs.get(i).getBandName().equals(band)) {
                index = i;
                break;  // don't need to finish the loop
            }
        }
        return index;
    }

    /**
     * Adds a new song to the store's inventory and returns that * song to the caller. If the song already exists in the
     * store, it returns the existing song from the inventory.
     * Otherwise it returns the new song that was just added to * the inventory. The method may return null if the user
     * decides not to enter a song (i.e., user just presses
     * Enter when asked for the song name).
     */
    private FlyTunesSong addSong() {
        String name = readLine("FlyTunesSong name (Enter to quit): ");
        if (name.equals("")) return null;
        String band = readLine("Band name: ");
        int songIndex = findSong(name, band);
        if (songIndex != -1) {
            println("That song is already in the store.");
            return flyTunesSongs.get(songIndex);
        } else {
            double price = readDouble("Price: ");
            FlyTunesSong flyTunesSong = new FlyTunesSong(name, band, price);
            flyTunesSongs.add(flyTunesSong);
            println("New flyTunesSong added to the store.");
            return flyTunesSong;
        }
    }

    /**
     * Adds a new album to the store's inventory. If the album
     * already exists in the store, then the inventory is
     * unchanged. Otherwise a new album and any new flyTunesSongs it
     * contains are added to the store's inventory.
     */

    private void addAlbum() {
        String name = readLine("Album name: ");
        if (albums.containsKey(name)) {
            println("That album is already in the store.");
        } else {
            String band = readLine("Band name: ");
            FlyTunesAlbum album = new FlyTunesAlbum(name, band);
            albums.put(name, album);
            while (true) {
                FlyTunesSong flyTunesSong = addSong();
                if (flyTunesSong == null) break;
                album.addSong(flyTunesSong);
            }
            println("New album added to the store.");
        }
    }

    /**
     * Lists all the flyTunesSongs on a single album in the inventory.
     */
    private void listSongsOnAlbum() {
        String name = readLine("Album name: ");
        if (albums.containsKey(name)) {
            Iterator<FlyTunesSong> it = albums.get(name).getSongs();
            println(name + " contains the following flyTunesSongs:");
            while (it.hasNext()) {
                FlyTunesSong flyTunesSong = it.next();
                println(flyTunesSong.toString());
            }
        } else {
            println("No album by that name in the store.");
        }
    }

    /**
     * Updates the price of a song in the store's inventory.
     * Note that this price update will also affect all albums  that contain this song.
     */
    private void updateSongPrice() {
        String name = readLine("FlyTunesSong name: ");
        String band = readLine("Band name: ");
        int songIndex = findSong(name, band);
        if (songIndex == -1) {
            println("That song is not in the store.");
        } else {
            double price = readDouble("New price: ");
            flyTunesSongs.get(songIndex).setPrice(price);
            println("Price for " + name + " updated.");
        }
    }

    /* Constants */
    private static final int QUIT = 0;
    private static final int LIST_SONGS = 1;
    private static final int LIST_ALBUMS = 2;
    private static final int ADD_SONG = 3;
    private static final int ADD_ALBUM = 4;
    private static final int LIST_SONGS_ON_ALBUM = 5;
    private static final int UPDATE_SONG_PRICE = 6;

    /* Private instance variables */
    // Inventory all the albums carried by the store
    private HashMap<String, FlyTunesAlbum> albums =
            new HashMap<String, FlyTunesAlbum>();
    // Inventory of all the flyTunesSongs carried by the store
    private ArrayList<FlyTunesSong> flyTunesSongs = new ArrayList<FlyTunesSong>();

}


