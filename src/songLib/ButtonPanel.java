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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == buttons[0]) //clicked add button
		{
	
		}
		else if (e.getSource() == buttons[1]){ //clicked delete button
			
		}
		else if (e.getSource() == buttons[2]){ //clicked edit button
			//give user option to [4]save or [5]cancel
			buttons[0].setEnabled(false);
			buttons[1].setEnabled(false);
			buttons[2].setEnabled(false);
			buttons[3].setEnabled(true); 
			buttons[4].setEnabled(true);
			
		}
		else if (e.getSource() == buttons[3]){ //clicked save button
			buttons[0].setEnabled(true);
			buttons[1].setEnabled(true);
			buttons[2].setEnabled(true);
			buttons[3].setEnabled(false); 
			buttons[4].setEnabled(false);
		}
		else if (e.getSource() == buttons[4]){ //clicked cancel button
			buttons[0].setEnabled(true);
			buttons[1].setEnabled(true);
			buttons[2].setEnabled(true);
			buttons[3].setEnabled(false); 
			buttons[4].setEnabled(false);
		}
		
	}
}
