/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModelClass;

import ClassBdd.Student;
import java.io.Serializable;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author demontvalon.cdi02
 */
public class TableModelStudent extends AbstractTableModel implements Serializable {
    
    private final String[] title = {"Prénom", "Nom", "Mail", "Age", "N° Tel", "Retards", "Suppr.", "Modif."};
    private final List<Student> listStudent;
            
            
            
    public TableModelStudent(List<Student> listStudent) {
        this.listStudent = listStudent;
    }

    @Override
    public int getRowCount() {
        return this.listStudent.size();
    }

    @Override
    public int getColumnCount() {
        return this.title.length;
    }
    @Override
    public String getColumnName(int column) {
        return title[column];
    }
    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
        case 0:
            return listStudent.get(row).getStudentFirstName();
        case 1:
            return listStudent.get(row).getStudentLastName();
        case 2:
            return listStudent.get(row).getStudentMail();
        case 3:
            return listStudent.get(row).getStudentAge();
        case 4:
            return listStudent.get(row).getStudentTelephonNumber();
        case 5:
            return listStudent.get(row).getStudentRetard();
        case 6:
            return "1";
        case 7:
            return "2";
        default:
            return "";
        }
    }
    
}
