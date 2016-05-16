package com.lp.oop.frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

final class CreateFrame extends MainFrame{
	JFrame frame = new JFrame("Create database");
	JPanel northPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	JPanel southPanel = new JPanel(new GridLayout(1, 2, 5, 5));
	JTextField txbNewDatabase = new JTextField();
	JButton btnCreate = new JButton("Create");
	JButton btnCancel = new JButton("Cancel");
	JLabel lbTitle = new JLabel("Enter name for a new database:");

	public CreateFrame() {
		super('.');
		frame.setLayout(new BorderLayout());
		frame.setSize(300, 120);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(northPanel, BorderLayout.NORTH);
		frame.add(southPanel, BorderLayout.SOUTH);
		northPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		southPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		northPanel.add(lbTitle);
		northPanel.add(txbNewDatabase);
		southPanel.add(btnCreate);
		southPanel.add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});

		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(txbNewDatabase.getText().equals(""))
					JOptionPane.showMessageDialog(frame, "Enter the file...");
				else
				{
					file = new File(txbNewDatabase.getText());
					if(!file.exists())
					{
						lbFile.setText(file.getName());
						try {
							file.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
						frame.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "This file already exists...");
					}
				}
			}
		});
	}
}
