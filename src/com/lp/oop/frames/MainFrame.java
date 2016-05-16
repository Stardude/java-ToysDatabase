package com.lp.oop.frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame {
	protected static File file;
	protected static JLabel lbFile = new JLabel("");
	
	private JFrame mainFrame;
	private JPanel northPanel = new JPanel(new GridLayout(2, 3, 10, 10));
	private JButton btnCreateNewDatabase = new JButton("Create database");
	private JButton btnOpenDatabase = new JButton("Open database");
	private JButton btnDeleteDatabase = new JButton("Delete database");
	private JButton btnAddToyToDatabase = new JButton("Add new toy");
	private JButton btnPrintAllToys = new JButton("Print all toys");
		
	private CreateFrame cf;
	private PrintFrame pf;
	private AddFrame af;
	
	public MainFrame(char c){}
	public MainFrame() {
		mainFrame = new JFrame("Toys Database");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BorderLayout(10, 10));
		mainFrame.setVisible(true);
		mainFrame.setSize(400, 150);
		mainFrame.add(northPanel, BorderLayout.CENTER);
		
		northPanel.add(btnCreateNewDatabase);
		northPanel.add(btnOpenDatabase);
		northPanel.add(btnAddToyToDatabase);
		northPanel.add(btnDeleteDatabase);
		northPanel.add(btnPrintAllToys);
		northPanel.add(lbFile);
		
		btnCreateNewDatabase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cf = new CreateFrame();
			}
		});
		
		btnOpenDatabase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fch = new JFileChooser();
				fch.setCurrentDirectory(new File("D:\\JavaProjects\\ToysDatabase"));
				if(fch.showOpenDialog(mainFrame) == JFileChooser.APPROVE_OPTION)
				{
					file = fch.getSelectedFile();
					lbFile.setText(file.getName());
				}
			}
		});

		btnDeleteDatabase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (file != null) {
					file.delete();
					file = null;
					lbFile.setText("");
					JOptionPane.showMessageDialog(mainFrame, "Success...");
				} else
					JOptionPane.showMessageDialog(mainFrame, "There is no database to delete...");
			}
		});

		btnAddToyToDatabase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (file != null)
					af = new AddFrame();
				else
					JOptionPane.showMessageDialog(mainFrame, "Please, open or create a file...");
			}
		});
		
		btnPrintAllToys.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (file != null)
					pf = new PrintFrame();
				else
					JOptionPane.showMessageDialog(mainFrame, "Please, open or create a file...");
			}
		});
	}
}
