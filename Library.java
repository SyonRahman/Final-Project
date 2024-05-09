import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;
public class Library extends JFrame implements ActionListener, KeyListener {
    private ArrayList<Books> books = new ArrayList<Books>();


    LibraryDatabase database = new LibraryDatabase();

    public Library() {
        createComponents();
    }

    public void createComponents() {
        setTitle("Library App");
        setSize(1000, 1000);
        getContentPane().setBackground(Color.YELLOW);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        JLabel label = new JLabel("LIBRARY APP");
        label.setFont(new Font("Comic Sans", Font.BOLD, 100));
        label.setForeground(Color.RED);
        label.setBounds(500, 500, 100, 100);
        add(label);
        JButton start = new JButton("START");
        start.setBackground(Color.RED);
        start.setBounds(750, 750, 150, 150);
        start.addActionListener(e -> createAccount());
        add(start);
    }

    public void createAccount() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
