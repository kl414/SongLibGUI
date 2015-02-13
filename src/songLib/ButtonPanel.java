/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * responsible for performing actions like add/edit/delete/save/cancel
 */
public class ButtonPanel extends JPanel implements ActionListener{

	private JButton[] buttons;
	protected SongLib songlib;
	String nameReq, artistReq;
	int tempIndex, mode;

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

	private void standardButtons(){
		buttons[0].setEnabled(true);
		buttons[1].setEnabled(true);
		buttons[2].setEnabled(true);
		buttons[3].setEnabled(false); 
		buttons[4].setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buttons[0]) //clicked add button
		{
			System.out.println("Please enter information");
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
			
		}
		else if (e.getSource() == buttons[2]){ //clicked edit button
			//give user option to [4]save or [5]cancel
			saveCancelButtons();
			mode = 2; //edit

		}
		else if (e.getSource() == buttons[3]){ //clicked save button

			nameReq = songlib.infoPanel.songName.getText();
			artistReq = songlib.infoPanel.songArtist.getText();
			if (mode == 1){
				if (nameReq == null || artistReq == null || 
						nameReq.isEmpty() == true || artistReq.isEmpty() == true){
					System.out.println("error");
					//print error message that it cannot be empty
					standardButtons();
					songlib.infoPanel.uneditable();
					songlib.songPanel.updateHelper();
				}
				else{
					String name,artist,album,year;
					name = songlib.infoPanel.songName.getText();
					artist = songlib.infoPanel.songArtist.getText();
					album = songlib.infoPanel.songAlbum.getText();
					year = songlib.infoPanel.songYear.getText();
					SongLib.songs.add(new Song(name,artist,album,year));
					songlib.songPanel.listModel.addElement(name);
					songlib.songPanel.songlist.setSelectedIndex(SongLib.songs.size()-1);
					songlib.songPanel.songlist.ensureIndexIsVisible(SongLib.songs.size()-1);
					standardButtons();
					songlib.infoPanel.uneditable();
				}
				mode = 0;
			}
			if (mode == 2){
				//edit
			}

		}
	}
}
