/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
	
	protected JList songlist;
    protected DefaultListModel listModel;
    protected ArrayList<String> names;
    protected JTextField msg;
    protected SongLib songlib;
	String name, artist, year, album;
	

	public SongPanel(SongLib songlib){
		this.songlib = songlib;
		setLayout(new BorderLayout());
		makeList();
	}

	public static ArrayList<Song> readFile(){
		ArrayList<Song> songArray = new ArrayList<Song>();
		try{
			FileInputStream fstream = new FileInputStream("songs.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				String[] tokens = strLine.split(" ");
				if (tokens[2] == null){
					tokens[2] = "";
				}
				if (tokens[3] == null){
					tokens[3] = "";
				}
				songArray.add(new Song(tokens[0],tokens[1],tokens[2],tokens[3]));
			}
			in.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}

		return songArray;
	}

	private void makeList(){
		
		listModel = new DefaultListModel();
		for(int i = 0; i < SongLib.songs.size(); i++){
			listModel.addElement(SongLib.songs.get(i).name);
		}
		
		//JList doesn't have scroll
		songlist = new JList(listModel);
		songlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		songlist.setLayoutOrientation(JList.VERTICAL);
		songlist.setSelectedIndex(0);
		songlist.setVisibleRowCount(12);
		JScrollPane pane = new JScrollPane(songlist);
		pane.setPreferredSize(new Dimension(200, 200));
		add(pane, BorderLayout.PAGE_START);
		songlist.addListSelectionListener(this);
		
		//error msg on add/edit
		msg = new JTextField();
		msg.setEditable(false);
		add(msg, BorderLayout.PAGE_END);
		
	}
	
	//call for update when a new song is selected
	public void valueChanged(ListSelectionEvent e){
		if(!e.getValueIsAdjusting()){
			if(listModel.getSize() != 0)
				updateHelper();
			else{
				songlib.infoPanel.songName.setText("");
				songlib.infoPanel.songArtist.setText("");
				songlib.infoPanel.songAlbum.setText("");
				songlib.infoPanel.songYear.setText("");
			}
		}
	}
	//return the index of selected
	public int getSelectedIndex(){
		return listModel.indexOf(songlist.getSelectedValue());
	}
	public Object getSelected(){
		return songlist.getSelectedValue();
	}
	
	public void updateHelper(){
		songlib.infoPanel.update(SongLib.songs.get(getSelectedIndex()));
	}
	//helper method for debugging
	public void printListModel(){
		for(int i = 0; i < listModel.getSize(); i++){
			System.out.println(listModel.get(i));
		}
	}
	public void printSongList(){
		for(int i = 0; i < SongLib.songs.size(); i++){
			System.out.println(SongLib.songs.get(i).name);
		}
	}
}
