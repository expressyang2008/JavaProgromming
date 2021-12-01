/**
 * @program: JavaProgromming
 * @description: This program handles the data management for a music
 * shop, showing which albums are carried and how many copies
 * are in stock. The program handles dynamic resizing of the program window.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-28 10:44
 */
import acm.program.Program;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class MusicShop extends Program {
    // Set up initial display with interactors and canvas
    public void init(){
        label =new JLabel("Album Name");
        albumName = new JTextField(20);
        add(label,SOUTH);
        add(albumName,SOUTH);

        canvas = new MusicShopDisplay();
        add(canvas);

        loadInventory();

        addActionListeners();
        albumName.addActionListener(this);
    }
    // Read file to get inventory information on all albums
    private void loadInventory() {
        try {
            BufferedReader rd = new BufferedReader(new FileReader("files/music-data.txt"));
            while (true) {
                String line = rd.readLine();
                if (line == null) break;
                Album album = parseLine(line);
                inventory.put(album.getAlbumName(), album);

            }
            rd.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Parse a single line from inventory file and returns an Album
    //object that contains the information from the line.
    private Album parseLine(String line) {
        int albumNumStart = line.indexOf("[") + 1;
        int albumNameEnd = line.indexOf("]");
        String albumName = line.substring(albumNumStart, albumNameEnd);

        int bandNumStart = line.indexOf("[", albumNameEnd + 1) + 1;
        int bandNameEnd = line.indexOf("]", albumNameEnd + 1);
        String bandName = line.substring(bandNumStart, bandNameEnd);

        int numStockedStart = line.indexOf(" ", bandNameEnd + 1) + 1;
        int numStocked = Integer.parseInt(line.substring(numStockedStart));

        return (new Album(albumName, bandName, numStocked));

    }
    //Update the display whenever the user enters a new album name
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == albumName){
            canvas.displayInventory(inventory.get(albumName.getText()));
        }
    }
    
    HashMap<String, Album> inventory = new HashMap<String, Album>();
    private JLabel label;
    private JTextField albumName;
    private MusicShopDisplay canvas;
}
