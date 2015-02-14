/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

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
	private int flag;

	public SongPanel(SongLib songlib){
		this.songlib = songlib;
		setLayout(new BorderLayout());
		makeList();
	}

	public static ArrayList<Song> readFile(){
		ArrayList<Song> songArray = new ArrayList<Song>();
		BufferedReader read;
		try {
			read = new BufferedReader(new FileReader("savedSongs.txt"));
			String line = null;
			while( (line = read.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(line);
				String name = tokens.nextToken();
				String artist = tokens.nextToken();
				String album = tokens.hasMoreTokens() ? tokens.nextToken() : null;
				String year = tokens.hasMoreTokens() ? tokens.nextToken() : null;
				songArray.add(new Song(name,artist,album,year));
			} 
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchElementException e){
			e.printStackTrace();
		}

		return songArray;
	}


	public static void saveFile(){
		File f = new File("savedSongs.txt");
		String[] data = new String[4];
		try
		{
			FileWriter fw = new FileWriter(f);
			for (Song song : SongLib.songs){
				data[0] = song.name.toString();
				data[1] = song.artist.toString();
				data[2] = song.album.toString();
				data[3] = song.year.toString();
				for (int i = 0; i < data.length; i++) {
					fw.write(data[i] + " ");
				}
				fw.write("\n");
			}
			fw.close();
		}
		catch ( IOException e)
		{
			e.printStackTrace();
		}
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

	//print ErrorMsg in the textfield
	public void printError(String str){
		msg.setEditable(true);
		msg.setText(str);
		msg.setForeground(Color.red);
		msg.setEditable(false);
	}

	//clear the textfield
	public void clearMsg(){
		msg.setEditable(true);
		msg.setText("");
		msg.setEditable(false);
	}

	//call for update when a new song is selected
	public void valueChanged(ListSelectionEvent e){
		if(!e.getValueIsAdjusting()){
			songlib.buttonPanel.standardButtons();
			songlib.infoPanel.uneditable();
			if(listModel.getSize() != 0 && flag != 1){
				updateHelper();
			}else if(flag == 1){
				;
			}else{
				songlib.infoPanel.songName.setText("");
				songlib.infoPanel.songArtist.setText("");
				songlib.infoPanel.songAlbum.setText("");
				songlib.infoPanel.songYear.setText("");
			}
		}
	}

	//sorts the songlist display
	public void sortListModel(){
		Object[] newList = listModel.toArray();
		Arrays.sort(newList);
		listModel.removeAllElements();
		for (Object x: newList){
			flag = 1;
			listModel.addElement(x);
			flag = 0;
		}

	}

	//return the index of selected
	public int getSelectedIndex(){
		return songlist.getSelectedIndex();
	}

	public Object getSelected(){
		return songlist.getSelectedValue();
	}

	public void updateHelper(){
		if(getSelectedIndex() == -1)
			songlist.setSelectedIndex(0);
		songlib.infoPanel.update(SongLib.songs.get(getSelectedIndex()));
	}
	//helper method for debugging
	public void printListModel(){
		System.out.println("listModel: " + listModel.toString());
	}
	public void printSongList(){
		System.out.print("Songlist: " );
		for(int i = 0; i < SongLib.songs.size(); i++){
			System.out.print(SongLib.songs.get(i).name + ", ");
		}
	}
}
