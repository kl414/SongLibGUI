/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import javax.swing.JPanel;

/*
 * responsible for displaying the song lists and details
 */

public class SongPanel extends JPanel{
	
	protected SongLib lib;
	
	public SongPanel(SongLib lib){
		this.lib = lib;
	}
}
