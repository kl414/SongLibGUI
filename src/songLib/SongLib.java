/*
 * Hongjie Lin
 * Edward Mamedov
 */

package songLib;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class SongLib extends JFrame{

	protected SongPanel songPanel;
	
	protected ButtonPanel buttonPanel;
	
	protected InfoPanel infoPanel;
	
	protected ArrayList<Song> songs;
	
	public SongLib(String title){
		super(title);
		
		songs = SongPanel.readFile();
		
		songPanel = new SongPanel(songs);
		
		buttonPanel = new ButtonPanel(this);
		
		infoPanel = new InfoPanel(songs.get(0));
		
		//using border layout right now just for testing other functionality
		setLayout(new BorderLayout());
		
		add(songPanel, BorderLayout.LINE_START);
		add(buttonPanel, BorderLayout.PAGE_END);
		add(infoPanel, BorderLayout.CENTER);
		
	}
	
	//helper method for testing
	public void makesongs(){
		songs = new ArrayList();
		songs.add(new Song("song1", "artist1", "year1", "album1"));
		songs.add(new Song("song2", "artist2", "year2", "album2"));
		songs.add(new Song("song3", "artist3", "year3", "album3"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame songLib = new SongLib("Song Library");
		songLib.setResizable(false);
		songLib.setSize(500, 300);
		songLib.setLocationRelativeTo(null);
		songLib.setDefaultCloseOperation(EXIT_ON_CLOSE);
		songLib.setVisible(true);
	}

}
