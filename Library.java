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
        setSize(1500, 1500);
        getContentPane().setBackground(Color.YELLOW);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        JLabel label = new JLabel("LIBRARY APP");
        label.setFont(new Font("Comic Sans", Font.BOLD, 100));
        label.setForeground(Color.RED);
        label.setBounds(500, 500, 100, 100);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
        JButton login = new JButton("Login");
        JButton signup = new JButton("Sign Up");
        login.setBounds(250, 250, 50, 50);
        signup.setBounds(1000, 1000, 50, 50);
        login.setHorizontalAlignment(SwingConstants.LEFT);
        signup.setHorizontalAlignment(SwingConstants.RIGHT);
        login.setBackground(Color.BLUE);
        signup.setBackground(Color.RED);
        login.addActionListener(this);
        signup.addActionListener(this);
        add(login);
        add(signup);
    }

    public void createAccount() {
        JPanel AccountCreator = new JPanel();
        AccountCreator.setBackground(Color.YELLOW);
        AccountCreator.setVisible(true);


        boolean isAdmin = false;
        JButton admin = new JButton("Admin");
        JButton user = new JButton("User");
        admin.setBounds(100, 100, 50, 50);
        user.setBounds(150, 100, 50, 50);
        admin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        user.setFont(new Font("Times New Roman", Font.BOLD, 20));
        admin.setBackground(Color.BLUE);
        user.setBackground(Color.BLUE);
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == admin) {
                    isAdmin = true;
                }
            }
        });
        AccountCreator.add(admin);
        AccountCreator.add(user);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setBounds(200, 200, 50, 50);
        usernameLabel.setForeground(Color.BLUE);
        AccountCreator.add(usernameLabel);

        JTextField username = new JTextField();
        username.setBounds(300, 300, 150, 75);
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setBackground(Color.BLUE);
        AccountCreator.add(username);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setBounds(500, 500, 50, 50);
        idLabel.setBackground(Color.BLUE.brighter());
        AccountCreator.add(idLabel);


        JTextField enterId = new JTextField();
        enterId.setBounds(600, 600, 150, 75);
        enterId.setHorizontalAlignment(SwingConstants.CENTER);
        enterId.setBackground(Color.BLUE.brighter());
        AccountCreator.add(enterId);

        JButton SignUp = new JButton("Sign Up");
        SignUp.setFont(new Font("Times New Roman", Font.BOLD, 50));
        SignUp.setBackground(Color.GREEN);
        SignUp.setForeground(Color.YELLOW);
        SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == SignUp) {
                    if (isAdmin) {
                        if (database.createAccount(username.getText(), true) == false) {
                            JOptionPane.showMessageDialog(null, "Username already exists");
                            return;
                        };
                        JOptionPane.showMessageDialog(null, "Admin account created " +
                                "Your username is " + username.getText() + " and your ID is " + database.getAdmins().get(database.getAdmins().size() - 1).getLibraryid());
                    } else {
                        if (database.createAccount(username.getText(), false) == false) {
                            JOptionPane.showMessageDialog(null, "Username already exists");
                            return;
                        };
                        database.createAccount(username.getText(), false);
                        JOptionPane.showMessageDialog(null, "User account created " +
                                "Your username is " + username.getText() + " and your ID is " + database.getUsers().get(database.getUsers().size() - 1).getLibraryId());

                    }
                }
            }
        });
        AccountCreator.add(SignUp);


    }

    public void logAccount() {
        JPanel AccountCreator = new JPanel();
        AccountCreator.setBackground(Color.YELLOW);
        AccountCreator.setVisible(true);


        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setBounds(200, 200, 50, 50);
        usernameLabel.setBackground(Color.BLUE.brighter());
        AccountCreator.add(usernameLabel);


        JTextField username = new JTextField();
        username.setBounds(300, 300, 150, 75);
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setBackground(Color.BLUE.brighter());
        AccountCreator.add(username);


        JLabel idLabel = new JLabel("ID:");
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setBounds(500, 500, 50, 50);
        idLabel.setBackground(Color.BLUE.brighter());
        AccountCreator.add(idLabel);


        JTextField enterId = new JTextField();
        enterId.setBounds(600, 600, 150, 75);
        enterId.setHorizontalAlignment(SwingConstants.CENTER);
        enterId.setBackground(Color.BLUE.brighter());
        AccountCreator.add(enterId);

        JButton Login = new JButton("Login");
        Login.setFont(new Font("Times New Roman", Font.BOLD, 50));
        Login.setForeground(Color.YELLOW);
        Login.setBackground(Color.GREEN);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        AccountCreator.add(Login);

        add(AccountCreator);

    }

    public void AdminMenu() {

    }

    public void UserMenu() {

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
