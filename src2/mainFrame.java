package songLibrary;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] buttons;
	
	public mainFrame(){
		this.setResizable(false);
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		JPanel p = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		p.setLayout(gridbag);
		//GridBagConstraints c = new GridBagConstraints();
		JLabel header = new JLabel("Song List:", JLabel.CENTER );
		//gridbag.setConstraints(header, c);
		p.add(header);
		
		JPanel songInformation = new JPanel();
		JPanel bottomHalf = new JPanel();
		
		songInformation.setLayout(new GridLayout(2,1));
		JLabel infoHeader = new JLabel("Song Information:");
		songInformation.add(infoHeader);
		
		JLabel songName = new JLabel("Song Name: ");
		JLabel songArtist = new JLabel("Song Artist: ");
		JLabel songAlbum = new JLabel("Song Album: ");
		JLabel songYear = new JLabel("Song Year: ");
		bottomHalf.add(songName);
		bottomHalf.add(songArtist);
		bottomHalf.add(songAlbum);
		bottomHalf.add(songYear);
		
		songInformation.add(bottomHalf);
		p.add(songInformation);
		
		buttons = new JButton[5];
		buttons[0] = new JButton("Add");
		buttons[1] = new JButton("Delete");
		buttons[2] = new JButton("Edit");
		buttons[3] = new JButton("Save");
		buttons[4] = new JButton("Cancel");
		JPanel panelButtons = new JPanel();
		
		panelButtons.add(buttons[0]);
		panelButtons.add(buttons[1]);
		panelButtons.add(buttons[2]);
		panelButtons.add(buttons[3]);
		panelButtons.add(buttons[4]);
		
		this.add(p);
	}
}
