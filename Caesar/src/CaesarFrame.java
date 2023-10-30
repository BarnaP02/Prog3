import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarFrame extends JPanel {
    JComboBox cb = comboBox(getAbc());
    JTextField tf = textField(true);
    JButton bt = button(new OkButtonActionListener());
    JTextField tf2 = textField(false);
    private JTextField textField(boolean isEditable){
        JTextField jtf = new JTextField(20);
        jtf.setEditable(isEditable);
        return jtf;
    }
    private JButton button(ActionListener action){
        JButton jbt = new JButton("Code!");
        jbt.addActionListener(action);
        return jbt;
    }
    private JComboBox<Object> comboBox(Object[] o){
        return new JComboBox<>(o);
    }
    CaesarFrame(){
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("SwingLab");
        window.setLayout(new BorderLayout());

        this.setDoubleBuffered(true);
        this.setFocusable(true);
        window.setPreferredSize(new Dimension(400, 110));

        JPanel panelT = new JPanel();
        JPanel panelB = new JPanel();

        panelT.add(cb);
        panelT.add(tf);
        panelT.add(bt);
        panelB.setLayout(new BorderLayout());
        JLabel lb = new JLabel("Output:");
        panelB.add(lb,BorderLayout.WEST);
        panelB.add(tf2);

        window.add(panelT,BorderLayout.NORTH);
        window.add(panelB, BorderLayout.SOUTH);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    class OkButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String code = tf.getText();
            String shift = (String)cb.getSelectedItem();
            tf2.setText(caesarCode(code,shift.charAt(0)));
        }
    }
    private String[] getAbc(){
        String[] abc = new String[26];
        for (int i = 65; i <= 90; i++) {
            abc[i-65] = "";
            abc[i-65] += (char)i;
        }
        return abc;
    }
    private static String caesarCode(String input, char offset){
        String result = "";
        int shift = (int)offset-'A';
        String[] inputArray = input.toUpperCase().split("");
        for(String s : inputArray){
            char current = s.charAt(0);
            int current_as_int = (int)current;
            result += (char)((current_as_int+shift-65)%26+65);
        }
        return result;
    }
}
