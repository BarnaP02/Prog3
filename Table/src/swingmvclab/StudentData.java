package swingmvclab;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/*
 * A hallgatók adatait tároló osztály.
 */
public class StudentData extends AbstractTableModel {

    /*
     * Ez a tagváltozó tárolja a hallgatói adatokat.
     * NE MÓDOSÍTSD!
     */
    List<Student> students = new ArrayList<Student>();

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> student.getName();
            case 1 -> student.getNeptun();
            case 2 -> student.hasSignature();
            default -> student.getGrade();
        };
    }
    @Override
    public String getColumnName(int column){
        switch (column){
            case 1:
                return "Neptun";
            case 2:
                return "Aláírás";
            case 3:
                return "Jegy";
            default:
                return "Név";
        }
    }
    @Override
    public Class<?> getColumnClass(int columnIndex){
        return switch (columnIndex) {
            case 0 -> String.class;
            case 1 -> String.class;
            case 2 -> Boolean.class;
            case 3 -> Integer.class;
            default -> super.getColumnClass(columnIndex);
        };
    }
    @Override
    public boolean isCellEditable(int row, int col) {
        return switch (col){
            case 2 -> true;
            case 3 ->true;
            default -> super.isCellEditable(row, col);
        };
    }
    @Override
    public void setValueAt(Object value, int row, int col){
        Student strudent = students.get(row);
        switch (col){
            case 2:
                strudent.setSignature((Boolean) value);
                break;
            case 3:
                strudent.setGrade((Integer) value);
                break;
            default:
                break;
        }
        fireTableCellUpdated(row, col);
    }
    public void addStudent(String name, String neptun){
        students.add(new Student(name, neptun, false,0));
        fireTableDataChanged();
    }
}
