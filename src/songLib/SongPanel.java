/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

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
	String name, artist, year, album;

	public SongPanel(ArrayList<Song> songs){
		this.songs = songs;
		makeList();
	}

	public static ArrayList<Song> readFile(){
		Scanner filereader;
		Song song = null;
		ArrayList<Song> songArray = new ArrayList<Song>();
		try{
			FileInputStream fstream = new FileInputStream("/Users/Petrov/Desktop/test.txt");
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
		for(int i = 0; i < songs.size(); i++){
			listModel.addElement(songs.get(i).name);
		}

		//JList doesn't have scroll
		songlist = new JList(listModel);
		songlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		songlist.setLayoutOrientation(JList.VERTICAL);
		songlist.setSelectedIndex(0);
		songlist.setVisibleRowCount(12);
		songlist.setPrototypeCellValue("111111111111111111111111111111");
		JScrollPane pane = new JScrollPane(songlist);
		add(pane);
	}
}
