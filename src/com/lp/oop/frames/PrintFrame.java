package com.lp.oop.frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.lp.oop.model.Ball;
import com.lp.oop.model.Barby;
import com.lp.oop.model.Constructor;
import com.lp.oop.model.Squares;
import com.lp.oop.model.Toy;

final class PrintFrame extends MainFrame {
	JFrame frame = new JFrame("Toys");
	JPanel centerPanel = new JPanel(new GridLayout(1, 1, 5, 5));

	public PrintFrame() {
		super('.');
		List<Toy> toys = new ArrayList<>();
		try {
			String line;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while((line = br.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(line, ".");
				Toy toy = null;
				String buf;
				while (st.hasMoreTokens()) {
					buf = st.nextToken();
					switch (buf.charAt(0)) {
					case 'B':
						Barby by = new Barby();
						by.setSize(Float.parseFloat(buf.substring(1)));
						by.setName(st.nextToken());
						by.setPrice(Double.parseDouble(st.nextToken()));
						by.setFromAge(Integer.parseInt(st.nextToken()));
						by.setToAge(Integer.parseInt(st.nextToken()));
						toys.add(by);
						break;
					case 'C':
						Constructor cs = new Constructor();
						cs.setNumberOfConstructs(Integer.parseInt(buf.substring(1)));
						cs.setName(st.nextToken());
						cs.setPrice(Double.parseDouble(st.nextToken()));
						cs.setFromAge(Integer.parseInt(st.nextToken()));
						cs.setToAge(Integer.parseInt(st.nextToken()));
						toys.add(cs);
						break;
					case 'L':
						Ball bl = new Ball();
						bl.setWeight(Double.parseDouble(buf.substring(1)));
						bl.setName(st.nextToken());
						bl.setPrice(Double.parseDouble(st.nextToken()));
						bl.setFromAge(Integer.parseInt(st.nextToken()));
						bl.setToAge(Integer.parseInt(st.nextToken()));
						toys.add(bl);
						break;
					case 'S':
						Squares sr = new Squares();
						sr.setCount(Integer.parseInt(buf.substring(1)));
						sr.setName(st.nextToken());
						sr.setPrice(Double.parseDouble(st.nextToken()));
						sr.setFromAge(Integer.parseInt(st.nextToken()));
						sr.setToAge(Integer.parseInt(st.nextToken()));
						toys.add(sr);
						break;
					}
				}
			}
			br.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		frame.setLayout(new BorderLayout());
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JTable table = new JTable(new MyTableModel(toys));
		centerPanel.add(table);
	}
}
