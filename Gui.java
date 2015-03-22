package org.empathy.soulsplit.smithing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9207874311091582181L;
	private JPanel contentPane;
	String[] comboTypes = { "Mithril", "Adamant", "Rune" };
	String[] smithType = { "Knifes", "Arrows", "Daggers", "Scimitars", "Platelegs", "Platebodies" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox comboTypesList = new JComboBox(comboTypes);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox smithTypeList = new JComboBox(smithType);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setTitle("ESmither");
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		// Create the combo box
		comboTypesList.setBounds(35, 116, 100, 20);
		contentPane.add(comboTypesList);

		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedIndex(e);
			}
		});
		start.setBounds(108, 223, 89, 23);
		contentPane.add(start);

		JLabel lblBarTyper = new JLabel("Bar Type", JLabel.CENTER);
		lblBarTyper.setFont(new Font("Serif", Font.ITALIC, 16));
		lblBarTyper.setBounds(10, 85, 154, 20);
		contentPane.add(lblBarTyper);

		JLabel lblWhatToSmith = new JLabel("What To Smith", SwingConstants.CENTER);
		lblWhatToSmith.setFont(new Font("Serif", Font.ITALIC, 16));
		lblWhatToSmith.setBounds(151, 85, 154, 20);
		contentPane.add(lblWhatToSmith);

		smithTypeList.setBounds(175, 116, 100, 20);
		contentPane.add(smithTypeList);

	}

	private void selectedIndex(ActionEvent e) {

		switch (comboTypesList.getSelectedIndex()) {
		case 0:// mith

			Smith.barId = 2360;

			this.dispose();
			break;
		case 1:// addy

			Smith.barId = 2362;

			this.dispose();
			break;
		case 2: // rune

			Smith.barId = 2364;

			this.dispose();
			break;

		}

		switch (smithTypeList.getSelectedIndex()) {
		case 0:// mith

			Smith.smith = SmithingData.KNIFES;

			this.dispose();
			break;
		case 1:// addy

			Smith.smith = SmithingData.ARROWS;

			this.dispose();
			break;
		case 2: // rune

			Smith.smith = SmithingData.DAGGERS;

			this.dispose();
			break;

		case 3: // rune

			Smith.smith = SmithingData.SCIM;

			this.dispose();
			break;
		case 4: // rune

			Smith.smith = SmithingData.LEGS;

			this.dispose();
			break;
		case 5: // rune

			Smith.smith = SmithingData.PLATES;

			this.dispose();
			break;

		}
	}
}
