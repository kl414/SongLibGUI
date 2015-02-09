/*
 * Hongjie Lin
 * Edward Mamedov
 */

package songLib;

import javax.swing.JFrame;

public class SongLib extends JFrame{

	protected SongPanel songPanel;
	
	protected ActionPanel actionPanel;
	
	public SongLib(String title){
		super(title);
		
		songPanel = new SongPanel(this);
		
		actionPanel = new ActionPanel(this);
		
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
