package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import utils.DatePicker;

public final class winPickDate {
	
    /** return la date selectioner
	 * 
	 * @param model will construct the table
	 * @param Title will name the window
	 * @return the row selected or 0 if clause without selection
	 */
	public final static void pickDate(JFrame window , JTextField TBox){
		DatePicker dp = new DatePicker();
    	dp.addPopupListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TBox.setText(dp.getFormattedDate());
                dp.popupHide();
            }
        });
        dp.popupShow(window);
	}
}