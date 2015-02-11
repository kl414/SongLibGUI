/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/*
 * responsible for performing actions like add/edit/delete/save/cancel
 */
public class ButtonPanel extends JPanel implements ActionListener{

	protected SongLib lib;
	
	public ButtonPanel(SongLib lib){
		this.lib = lib;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
