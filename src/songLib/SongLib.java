/*
 * Hongjie Lin
 * Edward Mamedov
 */

package songLib;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

public class SongLib extends JFrame{

	protected SongPanel songPanel;
	
	protected ButtonPanel buttonPanel;
	
	protected InfoPanel infoPanel;
	
	protected static ArrayList<Song> songs;
	
	public SongLib(String title){
		super(title);
		File file = new File("savedSongs.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		songs = SongPanel.readFile();
		
		Collections.sort(songs);
		
		songPanel = new SongPanel(this);
		
		buttonPanel = new ButtonPanel(this);
		
		infoPanel = new InfoPanel(songs.get(0));
		
		//using border layout right now just for testing other functionality
		setLayout(new BorderLayout());
		
		add(songPanel, BorderLayout.LINE_START);
		add(buttonPanel, BorderLayout.PAGE_END);
		add(infoPanel, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame songLib = new SongLib("Song Library");
		songLib.setResizable(false);
		songLib.setSize(500, 300);
		songLib.setLocationRelativeTo(null);
		songLib.setDefaultCloseOperation(EXIT_ON_CLOSE);
		songLib.addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		       //SongPanel.saveFile();
		    }
		});
		songLib.setVisible(true);
	}

}
