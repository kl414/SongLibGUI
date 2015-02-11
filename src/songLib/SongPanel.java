/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/*
 * responsible for displaying the song lists
 */

public class SongPanel extends JPanel{
	
	private JList songlist;
    private DefaultListModel listModel;
    private ArrayList<Song> songs;
    
	public SongPanel(ArrayList<Song> songs){
		this.songs = songs;
		makeList();
	}
	
	private void makeList(){
		
		listModel = new DefaultListModel();
		for(int i = 0; i < songs.size(); i++){
			listModel.addElement(songs.get(i).name);
		}
		
		//JList doesn't have scroll
		songlist = new JList(listModel);
		songlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		songlist.setLayoutOrientation(JList.VERTICAL);
		songlist.setSelectedIndex(0);
		songlist.setVisibleRowCount(5);
		JScrollPane pane = new JScrollPane(songlist);
		add(pane);
	}
}
