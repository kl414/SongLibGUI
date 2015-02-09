/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/*
 * responsible for performing actions like add/edit/delete
 */
public class ActionPanel extends JPanel implements ActionListener{

	protected SongLib lib;
	
	public ActionPanel(SongLib lib){
		this.lib = lib;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
