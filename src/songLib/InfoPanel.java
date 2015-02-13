/*
 * Hongjie Lin
 * Edward Mamedov
 */

package songLib;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionListener;

/**
 * @param the selected Song Object
 * displaying the song's detail
 */
public class InfoPanel extends JPanel {
	protected Song song;
	
	JTextField songName;
	JTextField songArtist;
	JTextField songAlbum;
	JTextField songYear;
	
	public InfoPanel(Song song){
		this.song = song;
		
		setLayout(new GridLayout(4, 2));
		
		JLabel nameLabel = new JLabel("Song Name: ");
		
		JLabel artistLabel = new JLabel("Song Artist: ");
		
		JLabel albumLabel = new JLabel("Song Album: ");
		
		JLabel yearLabel = new JLabel("Song Year: ");
		
		if(song != null){
			songName = new JTextField(song.name);
			songArtist = new JTextField(song.artist);
			songAlbum = new JTextField(song.album);
			songYear = new JTextField(song.year);
		}else{
			songName = new JTextField("");
			songArtist = new JTextField("");
			songAlbum = new JTextField("");
			songYear = new JTextField("");
		}
		
		uneditable();
		
		add(nameLabel);
		add(songName);
		add(artistLabel);
		add(songArtist);
		add(albumLabel);
		add(songAlbum);
		add(yearLabel);
		add(songYear);
		
	}
	
	/**
	 * set the info to be uneditable
	 */
	public void uneditable(){
		songName.setEditable(false);
		songArtist.setEditable(false);
		songAlbum.setEditable(false);
		songYear.setEditable(false);
	}
	
	/**
	 * set the info to be editable
	 */
	public void editable(){
		songName.setEditable(true);
		songArtist.setEditable(true);
		songAlbum.setEditable(true);
		songYear.setEditable(true);
	}
	
	/**
	 * update the infoPanel
	 */
	public void update(Song song){
		songName.setText(song.name);
		songArtist.setText(song.artist);
		songAlbum.setText(song.album);
		songYear.setText(song.year);
	}
}
