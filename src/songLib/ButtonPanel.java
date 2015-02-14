/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * responsible for performing actions like add/edit/delete/save/cancel
 */
public class ButtonPanel extends JPanel implements ActionListener{

	private JButton[] buttons;
	protected SongLib songlib;
	String nameReq, artistReq;
	int tempIndex;
	int mode = 0;
	String name,artist,album,year;

	public ButtonPanel(SongLib songlib){
		this.songlib = songlib;
		buttons = new JButton[5];
		buttons[0] = new JButton("Add");
		buttons[1] = new JButton("Delete");
		buttons[2] = new JButton("Edit");
		buttons[3] = new JButton("Save");
		buttons[4] = new JButton("Cancel");

		// gray out Save and Cancel buttons (default)
		buttons[3].setEnabled(false);
		buttons[4].setEnabled(false);

		add(buttons[0]);
		add(buttons[1]);
		add(buttons[2]);
		add(buttons[3]);
		add(buttons[4]);
		buttons[0].addActionListener(this);
		buttons[1].addActionListener(this);
		buttons[2].addActionListener(this);
		buttons[3].addActionListener(this);
		buttons[4].addActionListener(this);

	}

	private void saveCancelButtons(){
		buttons[0].setEnabled(false);
		buttons[1].setEnabled(false);
		buttons[2].setEnabled(false);
		buttons[3].setEnabled(true); 
		buttons[4].setEnabled(true);
	}

	protected void standardButtons(){
		buttons[0].setEnabled(true);
		buttons[1].setEnabled(true);
		buttons[2].setEnabled(true);
		buttons[3].setEnabled(false); 
		buttons[4].setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//clear the error msg when any button is clicked
		songlib.songPanel.clearMsg();
		int flag = 0;
		if (e.getSource() == buttons[0]) //clicked add button
		{
			songlib.infoPanel.songName.setText("");
			songlib.infoPanel.songArtist.setText("");
			songlib.infoPanel.songAlbum.setText("");
			songlib.infoPanel.songYear.setText("");
			songlib.infoPanel.editable();
			mode = 1; //add
			saveCancelButtons();
		}
		if (e.getSource() == buttons[4]){//cancel button, will return to the selected song's info
			standardButtons();
			songlib.infoPanel.uneditable();
			songlib.songPanel.updateHelper();
		}
		else if (e.getSource() == buttons[1]){ //clicked delete button
			if(SongLib.songs.size() != 0){
				int index = songlib.songPanel.getSelectedIndex();
				if(index != 0)
					songlib.songPanel.songlist.setSelectedIndex(0);
				else
					songlib.songPanel.songlist.setSelectedIndex(1);
				songlib.songPanel.listModel.remove(index);
				SongLib.songs.remove(index);
				if(SongLib.songs.size() != index)
					songlib.infoPanel.update(SongLib.songs.get(0));
			}
			//System.out.println(SongLib.songs.get(0));
			//SongLib.songs.remove(songlib.songPanel.listModel.getSelectedIndex());
		}
		else if (e.getSource() == buttons[2]){ //clicked edit button
			//give user option to [4]save or [5]cancel
			if(songlib.songPanel.getSelected() != null){
				songlib.infoPanel.editable();
				saveCancelButtons();
				mode = 2; //edit
				Collections.sort(SongLib.songs);
			}
		}
		else if (e.getSource() == buttons[3]){ //clicked save button

			name = songlib.infoPanel.songName.getText();
			artist = songlib.infoPanel.songArtist.getText();

			if (name == null || artist == null || 
					name.isEmpty() == true || artist.isEmpty() == true){
				
				//print error message that it cannot be empty
				songlib.songPanel.printError("The name and artist is required!");
				standardButtons();
				songlib.infoPanel.uneditable();
				songlib.songPanel.updateHelper();
				mode = 0;
			}
			
			if (mode == 1){
				//checking for same name & artist
				for(int i = 0; i < SongLib.songs.size(); i++){
					Song song = SongLib.songs.get(i);
					if(name.equalsIgnoreCase(song.name) && artist.equalsIgnoreCase(song.artist)){
						songlib.songPanel.printError("The song name & artist exist!");
						standardButtons();
						songlib.infoPanel.uneditable();
						songlib.songPanel.updateHelper();
						mode = 0;
						flag = 1;
					}
				}
				if(flag == 0){
					album = songlib.infoPanel.songAlbum.getText();
					year = songlib.infoPanel.songYear.getText();
					Song newSong = new Song(name,artist,album,year);
					SongLib.songs.add(newSong);
					songlib.songPanel.listModel.addElement(name);
					
					//sort the ArrayList and ListModel
					Collections.sort(SongLib.songs);
					songlib.songPanel.sortListModel();
					songlib.songPanel.songlist.setSelectedValue(newSong.name, true);
					//songlib.songPanel.songlist.ensureIndexIsVisible(SongLib.songs.size()-1);

					//print lists for testing
					/*
					songlib.songPanel.printListModel();
					songlib.songPanel.printSongList();
					*/
					
					standardButtons();
					mode = 0;
					songlib.infoPanel.uneditable();
				}
			}
			if (mode == 2){
				for(int i = 0; i < SongLib.songs.size(); i++){
					Song song = SongLib.songs.get(i);
					if(song.name.equalsIgnoreCase((String) songlib.songPanel.getSelected())
							&& song.artist.equalsIgnoreCase(SongLib.songs.get(songlib.songPanel.getSelectedIndex()).artist));
					else if(name.equalsIgnoreCase(song.name) 
							&& artist.equalsIgnoreCase(song.artist)){
						songlib.songPanel.printError("The song name & artist exist!");
						standardButtons();
						songlib.infoPanel.uneditable();
						songlib.songPanel.updateHelper();
						mode = 0;
						flag = 1;
					}
				}
				if(flag == 0){
					name = songlib.infoPanel.songName.getText();
					artist = songlib.infoPanel.songArtist.getText();
					album = songlib.infoPanel.songAlbum.getText();
					year = songlib.infoPanel.songYear.getText();
					Song newSong = new Song(name,artist,album,year);
					SongLib.songs.set(songlib.songPanel.songlist.getSelectedIndex(), newSong);
					songlib.songPanel.listModel.set(songlib.songPanel.songlist.getSelectedIndex(), name);
					
					//sort the ArrayList and ListModel
					Collections.sort(SongLib.songs);
					songlib.songPanel.sortListModel();
					songlib.songPanel.songlist.setSelectedValue(newSong.name, true);
					standardButtons();
					songlib.infoPanel.uneditable();//double check
					mode = 0;
				}
			}

		}
	}
}
