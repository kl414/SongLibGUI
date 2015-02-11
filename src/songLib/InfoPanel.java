/*
 * Hongjie Lin
 * Edward Mamedov
 */

package songLib;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @param a list of the Song Object
 * displaying the song's detail
 */
public class InfoPanel extends JPanel{
	protected ArrayList<Song> songs;
	
	public InfoPanel(ArrayList<Song> songs){
		this.songs = songs;
		
		JLabel songName = new JLabel("Song Name: ");
		JLabel songArtist = new JLabel("Song Artist: ");
		JLabel songAlbum = new JLabel("Song Album: ");
		JLabel songYear = new JLabel("Song Year: ");
		add(songName);
		add(songArtist);
		add(songAlbum);
		add(songYear);
	}
}
