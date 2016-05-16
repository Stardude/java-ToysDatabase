package com.lp.oop.frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.lp.oop.model.Ball;
import com.lp.oop.model.Barby;
import com.lp.oop.model.Constructor;
import com.lp.oop.model.Squares;
import com.lp.oop.model.Toy;

final class AddFrame extends MainFrame {
	JFrame frame = new JFrame("Add new toy");
	JPanel westPanel = new JPanel(new GridLayout(4, 1, 5, 5));
	JPanel centerPanel = new JPanel(new GridLayout(4, 4, 5, 5));
	JPanel eastPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	JRadioButton jrb1 = new JRadioButton("Barby", true);
	JRadioButton jrb2 = new JRadioButton("Constructor");
	JRadioButton jrb3 = new JRadioButton("Ball");
	JRadioButton jrb4 = new JRadioButton("Squares");
	ButtonGroup btnGroup = new ButtonGroup();
	JTextField txbName = new JTextField();
	JTextField txbPrice = new JTextField();
	JTextField txbFromAge = new JTextField();
	JTextField txbToAge = new JTextField();
	JLabel lbName = new JLabel("Name:");
	JLabel lbPrice = new JLabel("Price:");
	JLabel lbFromAge = new JLabel("From age:");
	JLabel lbToAge = new JLabel("To age:");
	JButton btnAdd = new JButton("Add");
	JButton btnCancel = new JButton("Cancel");
	String choice = "Barby";
	ActionListener jrbListener;

	public AddFrame() {
		super('.');
		frame.setLayout(new BorderLayout());
		frame.setSize(450, 150);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(westPanel, BorderLayout.WEST);
		frame.add(centerPanel, BorderLayout.CENTER);
		frame.add(eastPanel, BorderLayout.EAST);
		westPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		eastPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		jrbListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choice = e.getActionCommand();
			}
		};

		btnGroup.add(jrb1);
		btnGroup.add(jrb2);
		btnGroup.add(jrb3);
		btnGroup.add(jrb4);
		jrb1.setActionCommand("Barby");
		jrb2.setActionCommand("Constructor");
		jrb3.setActionCommand("Ball");
		jrb4.setActionCommand("Squares");
		jrb1.addActionListener(jrbListener);
		jrb2.addActionListener(jrbListener);
		jrb3.addActionListener(jrbListener);
		jrb4.addActionListener(jrbListener);
		westPanel.add(jrb1);
		westPanel.add(jrb2);
		westPanel.add(jrb3);
		westPanel.add(jrb4);
		centerPanel.add(lbName);
		centerPanel.add(lbPrice);
		centerPanel.add(txbName);
		centerPanel.add(txbPrice);
		centerPanel.add(lbFromAge);
		centerPanel.add(lbToAge);
		centerPanel.add(txbFromAge);
		centerPanel.add(txbToAge);
		eastPanel.add(btnAdd);
		eastPanel.add(btnCancel);

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txbName.getText().equals("") || txbPrice.getText().equals("") || txbFromAge.getText().equals("")
						|| txbToAge.getText().equals(""))
					JOptionPane.showMessageDialog(frame, "Fill all textfields...");
				else {
					Toy toy = null;
					String additionalField = null;
					switch (choice) {
					case "Barby":
						additionalField = JOptionPane.showInputDialog("Enter the size:");
						toy = new Barby(txbName.getText(), Double.parseDouble(txbPrice.getText()),
								Integer.parseInt(txbFromAge.getText()), Integer.parseInt(txbToAge.getText()),
								Float.parseFloat(additionalField));
						additionalField = "B" + additionalField;
						break;
					case "Constructor":
						additionalField = JOptionPane.showInputDialog("Enter the number of avaible constructions:");
						toy = new Constructor(txbName.getText(), Double.parseDouble(txbPrice.getText()),
								Integer.parseInt(txbFromAge.getText()), Integer.parseInt(txbToAge.getText()),
								Integer.parseInt(additionalField));
						additionalField = "C" + additionalField;
						break;
					case "Ball":
						additionalField = JOptionPane.showInputDialog("Enter the weight:");
						toy = new Ball(txbName.getText(), Double.parseDouble(txbPrice.getText()),
								Integer.parseInt(txbFromAge.getText()), Integer.parseInt(txbToAge.getText()),
								Double.parseDouble(additionalField));
						additionalField = "L" + additionalField;
						break;
					case "Squares":
						additionalField = JOptionPane.showInputDialog("Enter the number of squares:");
						toy = new Squares(txbName.getText(), Double.parseDouble(txbPrice.getText()),
								Integer.parseInt(txbFromAge.getText()), Integer.parseInt(txbToAge.getText()),
								Integer.parseInt(additionalField));
						additionalField = "S" + additionalField;
						break;
					}
					try {
						OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file, true));
						osw.write(additionalField + "." + toy.getName() + "." + toy.getPrice() + "." +
								toy.getFromAge() + "." + toy.getToAge() + "\n");
						osw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					frame.dispose();
				}
			}
		});
	}
}
