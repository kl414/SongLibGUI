/*
 * Hongjie Lin
 * Edward Mamedov
 */

package songLib;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

public class SongLib extends JFrame{

	protected SongPanel songPanel;
	
	protected ButtonPanel buttonPanel;
	
	protected InfoPanel infoPanel;
	
	public SongLib(String title){
		super(title);
		
		songPanel = new SongPanel(this);
		
		//buttonPanel = new ButtonPanel(this);
		
		//infoPanel = new InfoPanel("whatever");
		
		add(songPanel);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame songLib = new SongLib("Song Library");
		songLib.setResizable(false);
		songLib.setSize(500, 300);
		songLib.setLocationRelativeTo(null);
		songLib.setDefaultCloseOperation(EXIT_ON_CLOSE);
		songLib.setVisible(true);
	}

}
