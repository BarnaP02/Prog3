package swingmvclab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.*;

/*
 * A megjelen�tend� ablakunk oszt�lya.
 */
public class StudentFrame extends JFrame {
    
    /*
     * Ebben az objektumban vannak a hallgat�i adatok.
     * A program indul�s ut�n bet�lti az adatokat f�jlb�l, bez�r�skor pedig kimenti oda.
     * 
     * NE M�DOS�TSD!
     */
    private StudentData data;
    
    /*
     * Itt hozzuk l�tre �s adjuk hozz� az ablakunkhoz a k�l�nb�z� komponenseket
     * (t�bl�zat, beviteli mez�, gomb).
     */
    private void initComponents() {
        this.setLayout(new BorderLayout());
        JTable table = new JTable(data);
        table.setFillsViewportHeight(true);
        JScrollPane scrolP = new JScrollPane(table);
        this.add(scrolP,BorderLayout.CENTER);

        JPanel hozzaadPanel = new JPanel();
        JLabel nameLabel = new JLabel("N�v:");
        JTextField nameField = new JTextField(20);
        JLabel neptunLabel = new JLabel("Neptun k�d:");
        JTextField neptunField = new JTextField(6);
        JButton addButton = new JButton("Felvesz");

        hozzaadPanel.add(nameLabel);
        hozzaadPanel.add(nameField);
        hozzaadPanel.add(neptunLabel);
        hozzaadPanel.add(neptunField);
        hozzaadPanel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String na = nameField.getText();
                String ne = neptunField.getText();
                data.addStudent(na, ne);
                nameField.setText("");
                neptunField.setText("");
            }
        });

        this.add(hozzaadPanel, BorderLayout.SOUTH);
        this.pack();
        // ...
    }

    /*
     * Az ablak konstruktora.
     * 
     * NE M�DOS�TSD!
     */
    @SuppressWarnings("unchecked")
    public StudentFrame() {
        super("Hallgat�i nyilv�ntart�s");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Indul�skor bet�ltj�k az adatokat
        try {
            data = new StudentData();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
            data.students = (List<Student>)ois.readObject();
            ois.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        // Bez�r�skor mentj�k az adatokat
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
                    oos.writeObject(data.students);
                    oos.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Fel�p�tj�k az ablakot
        setMinimumSize(new Dimension(500, 200));
        initComponents();
    }

    /*
     * A program bel�p�si pontja.
     * 
     * NE M�DOS�TSD!
     */
    public static void main(String[] args) {
        // Megjelen�tj�k az ablakot
        StudentFrame sf = new StudentFrame();
        sf.setVisible(true);
    }
}
