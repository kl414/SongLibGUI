/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/*
 * responsible for displaying the song lists
 */

public class SongPanel extends JPanel{
	
	protected SongLib lib;
	private JList songlist;
    private DefaultListModel listModel;
    
	public SongPanel(SongLib lib){
		this.lib = lib;
		makeList();
	}
	
	private void makeList(){
		//redundant code for testing
		Song song1 = new Song("song1");
		Song song2 = new Song("song2");
		Song song3 = new Song("song3");
		listModel = new DefaultListModel();
		listModel.addElement(song1.name);
		listModel.addElement(song2.name);
		listModel.addElement(song3.name);
		
		//JList doesn't have scroll
		songlist = new JList(listModel);
		songlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		songlist.setLayoutOrientation(JList.VERTICAL);
		songlist.setSelectedIndex(0);
		songlist.setVisibleRowCount(5);
		JScrollPane pane = new JScrollPane(songlist);
		setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		add(pane);
	}
}
