package panel;

import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import java.awt.TextField;
import java.awt.Label;
import java.awt.Choice;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.FlowLayout;
import java.awt.List;


public class ModifiationReservation extends JPanel {
	private JDateChooser dtA = new JDateChooser();
	/**
	 * Create the panel.
	 */
	public ModifiationReservation() {
		setLayout(null);
		
		TextField textField = new TextField();
		textField.setBounds(52, 122, 248, 22);
		add(textField);
		
		Label label = new Label("Mots cl\u00E9s de recherche");
		label.setBounds(52, 94, 123, 22);
		add(label);
		
		Choice choice = new Choice();
		choice.setBounds(52, 68, 172, 20);
		add(choice);
		choice.add("test");
		
		Button button = new Button("Recherche");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(230, 68, 70, 22);
		add(button);
		
		Label label_1 = new Label("Champ de recherche");
		label_1.setBounds(52, 40, 172, 22);
		add(label_1);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(355, 150, 230, 22);
		add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(355, 220, 230, 22);
		add(textField_2);
		
		Label label_2 = new Label("Nom du client");
		label_2.setBounds(355, 122, 70, 22);
		add(label_2);
		
		Label label_3 = new Label("V\u00E9hicule r\u00E9server");
		label_3.setBounds(355, 192, 94, 22);
		add(label_3);
		
		Label label_4 = new Label("New label");
		label_4.setBounds(355, 248, 62, 22);
		add(label_4);
		
		List list = new List();
		list.setBounds(52, 154, 248, 232);
		add(list);

	}
}
