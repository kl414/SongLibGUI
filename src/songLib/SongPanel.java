/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * responsible for displaying the song lists
 */

public class SongPanel extends JPanel implements ListSelectionListener{
	
	private JList songlist;
    private DefaultListModel listModel;
    private ArrayList<Song> songs;
    protected JTextField msg;
    
	public SongPanel(ArrayList<Song> songs){
		this.songs = songs;
		setLayout(new BorderLayout());
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
		songlist.setVisibleRowCount(10);
		JScrollPane pane = new JScrollPane(songlist);
		pane.setPreferredSize(new Dimension(200, 200));
		add(pane, BorderLayout.PAGE_START);
		songlist.addListSelectionListener(this);
		//error msg on add/edit
		msg = new JTextField();
		msg.setEditable(false);
		add(msg, BorderLayout.PAGE_END);
		
	}
	
	public void valueChanged(ListSelectionEvent e){
		System.out.println(songlist.getSelectedValue());
	}
}
