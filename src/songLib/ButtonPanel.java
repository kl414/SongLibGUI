/*
 * Hongjie Lin
 * Edward Mamedov
 */
package songLib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * responsible for performing actions like add/edit/delete/save/cancel
 */
public class ButtonPanel extends JPanel implements ActionListener{

	protected SongLib lib;
	private JButton[] buttons;
	
	public ButtonPanel(SongLib lib){
		this.lib = lib;
		
		buttons = new JButton[5];
		buttons[0] = new JButton("Add");
		buttons[1] = new JButton("Delete");
		buttons[2] = new JButton("Edit");
		buttons[3] = new JButton("Save");
		buttons[4] = new JButton("Cancel");
		
		add(buttons[0]);
		add(buttons[1]);
		add(buttons[2]);
		add(buttons[3]);
		add(buttons[4]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
