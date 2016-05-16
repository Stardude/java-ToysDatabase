package com.lp.oop.frames;

import java.util.HashSet;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.lp.oop.model.Toy;

public class MyTableModel implements TableModel{
	private List<Toy> toys;

	public MyTableModel(List<Toy> toys) {
		this.toys = toys;
	}

	private HashSet<TableModelListener> listeners = new HashSet<TableModelListener>();
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
        case 0:
            return "Name";
        case 1:
            return "Price";
        case 2:
            return "FromAge";
        case 3:
            return "ToAge";
        case 4:
            return "Optional";
        }
        return "";
	}

	@Override
	public int getRowCount() {
		return toys.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Toy toy = toys.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return toy.getName();
        case 1:
            return toy.getPrice();
        case 2:
            return toy.getFromAge();
        case 3:
            return toy.getToAge();
        case 4:
        	return 1;
        }
        return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}
}
