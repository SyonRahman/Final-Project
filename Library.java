import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Library extends JFrame implements ActionListener, KeyListener {

    private JFrame titlescreen = new JFrame("Library App");
    private JFrame AccountCreator = new JFrame("Account Creator");
    private JFrame LogIn = new JFrame("Log In");
    private JFrame AdminMenu = new JFrame("Admin Menu");
    private JFrame UserMenu = new JFrame("User Menu");

    private ArrayList<Books> books = new ArrayList<Books>();


    LibraryDatabase database = new LibraryDatabase();

    public Library() {
        createComponents();
    }

    public void createComponents() {
        titlescreen.setSize(1500, 1500);
        titlescreen.getContentPane().setBackground(Color.YELLOW);
        titlescreen.setLocationRelativeTo(null);
        titlescreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        titlescreen.setResizable(false);
        titlescreen.setVisible(true);
        titlescreen.setBackground(Color.YELLOW);

        JLabel label = new JLabel("LIBRARY APP");
        label.setFont(new Font("Comic Sans", Font.BOLD, 100));
        label.setForeground(Color.RED);
        label.setBounds(500, 400, 100, 100);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        titlescreen.add(label);
        JButton login = new JButton("Login");
        JButton signup = new JButton("Sign Up");
        login.setBounds(350, 700, 125, 100);
        signup.setBounds(950, 700, 125, 100);
        login.setHorizontalAlignment(SwingConstants.CENTER);
        signup.setHorizontalAlignment(SwingConstants.CENTER);
        login.setForeground(Color.CYAN);
        signup.setForeground(Color.CYAN);
        login.setFont(new Font("Comic Sans", Font.BOLD, 20));
        signup.setFont(new Font("Comic Sans", Font.BOLD, 15));
        login.setBackground(Color.BLUE);
        signup.setBackground(Color.RED);
        login.addActionListener(e -> logAccount());
        signup.addActionListener(e -> createAccount());
        titlescreen.add(login);
        titlescreen.add(signup);
    }

    public void createAccount() {
        titlescreen.setVisible(false);
        AccountCreator.setSize(1500, 1500);
        AccountCreator.setVisible(true);
        AccountCreator.getContentPane().setBackground(Color.YELLOW);
        AccountCreator.setLocationRelativeTo(null);
        AccountCreator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AccountCreator.setResizable(false);
        AccountCreator.setVisible(true);
        AccountCreator.setBackground(Color.RED);

        AccountCreator.setLayout(null);

        final boolean[] isAdmin = {false};
        JButton admin = new JButton("Admin");
        JButton user = new JButton("User");
        admin.setBounds(250, 200, 100, 100);
        user.setBounds(1250, 200, 100, 100);
        admin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        user.setFont(new Font("Times New Roman", Font.BOLD, 20));
        admin.setHorizontalAlignment(SwingConstants.CENTER);
        user.setHorizontalAlignment(SwingConstants.CENTER);
        admin.addActionListener(e -> isAdmin[0] = true);
        user.addActionListener(e -> isAdmin[0] = false);
        admin.setBackground(Color.BLUE);
        user.setBackground(Color.BLUE);
        admin.setForeground(Color.WHITE);
        user.setForeground(Color.WHITE);
        admin.setBorder(new LineBorder(Color.BLACK));
        user.setBorder(new LineBorder(Color.BLACK));


        AccountCreator.add(admin);
        AccountCreator.add(user);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setBounds(600, 250, 300, 150);
        usernameLabel.setBorder(new LineBorder(Color.BLACK));
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
        usernameLabel.setForeground(Color.BLUE);
        AccountCreator.add(usernameLabel);

        JTextField username = new JTextField();
        username.setBounds(400, 400, 750, 75);
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setBackground(Color.BLUE);
        username.setForeground(Color.BLACK);
        username.setBorder(new LineBorder(Color.BLACK));
        username.setFont(new Font("Times New Roman", Font.BOLD, 20));
        AccountCreator.add(username);

        JButton SignUp = new JButton("Sign Up");
        SignUp.setFont(new Font("Times New Roman", Font.BOLD, 50));
        SignUp.setBackground(Color.GREEN);
        SignUp.setForeground(Color.YELLOW);
        SignUp.setBounds(600, 600, 300, 75);
        SignUp.setBorder(new LineBorder(Color.BLACK));
        SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == SignUp) {
                    if (username.getText().length() < 5) {
                        JOptionPane.showMessageDialog(null, "Username must be at least 5 characters long");
                        return;
                    }
                    if (isAdmin[0]) {
                        if (!database.isUsernamevalid(username.getText(), true)) {
                            JOptionPane.showMessageDialog(null, "Username already exists");
                            return;
                        }
                        database.createAccount(username.getText(), true);
                        JOptionPane.showMessageDialog(null, "Admin account created " +
                                "Your username is " + username.getText() + " and your ID is " + database.getAdmins().get(database.getAdmins().size() - 1).getLibraryid());
                        logAccount();
                    } else {
                        if (!database.isUsernamevalid(username.getText(), false)) {
                            JOptionPane.showMessageDialog(null, "Username already exists");
                            return;
                        }
                        database.createAccount(username.getText(), false);
                        JOptionPane.showMessageDialog(null, "User account created " +
                                "Your username is " + username.getText() + " and your ID is " + database.getUsers().get(database.getUsers().size() - 1).getLibraryId());
                        logAccount();

                    }
                }
            }
        });
        AccountCreator.add(SignUp);
    }

    public void logAccount() {
        LogIn.setBackground(Color.BLUE);
        LogIn.setVisible(true);
        LogIn.setSize(1500, 1500);
        LogIn.setLocationRelativeTo(null);
        LogIn.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LogIn.setResizable(false);

        LogIn.setLayout(null);


        final boolean[] isAdmin = {false};
        JButton admin = new JButton("Admin"); JButton user = new JButton("User");
        admin.setBounds(250, 100, 100, 100); user.setBounds(1250, 100, 100, 100);
        admin.setFont(new Font("Times New Roman", Font.BOLD, 20)); user.setFont(new Font("Times New Roman", Font.BOLD, 20));
        admin.setHorizontalAlignment(SwingConstants.CENTER); user.setHorizontalAlignment(SwingConstants.CENTER); admin.addActionListener(e -> isAdmin[0] = true);
        user.addActionListener(e -> isAdmin[0] = false);
        admin.setBackground(Color.BLUE); user.setBackground(Color.BLUE);
        admin.setForeground(Color.WHITE); user.setForeground(Color.WHITE);
        admin.setBorder(new LineBorder(Color.BLACK)); user.setBorder(new LineBorder(Color.BLACK));
        LogIn.add(admin); LogIn.add(user);

        JLabel label = new JLabel("Log In");
        label.setBounds(600, 50, 300, 150);
        label.setFont(new Font("Times New Roman", Font.BOLD, 50));
        label.setForeground(Color.BLUE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        LogIn.add(label);


        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setBounds(600, 350, 200, 200);
        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        usernameLabel.setForeground(Color.BLUE);
        usernameLabel.setBorder(new LineBorder(Color.BLACK));
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        LogIn.add(usernameLabel);


        JTextField username = new JTextField();
        username.setBounds(500, 500, 500, 75);
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setBackground(Color.BLUE.brighter());
        username.setForeground(Color.GREEN);
        username.setFont(new Font("Times New Roman", Font.BOLD, 20));
        LogIn.add(username);


        JLabel idLabel = new JLabel("ID:");
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setBounds(750, 600, 150, 75);
        idLabel.setBackground(Color.BLUE.brighter());
        idLabel.setForeground(Color.GREEN);
        idLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        LogIn.add(idLabel);

        JTextField enterId = new JTextField();
        enterId.setBounds(500, 750, 500, 75);
        enterId.setHorizontalAlignment(SwingConstants.CENTER);
        enterId.setBackground(Color.BLUE.brighter());
        enterId.setFont(new Font("Times New Roman", Font.BOLD, 20));
        LogIn.add(enterId);

        JButton Login = new JButton("Login");
        Login.setFont(new Font("Times New Roman", Font.BOLD, 50));
        Login.setForeground(Color.YELLOW);
        Login.setBackground(Color.GREEN);
        Login.setBounds(700, 900, 200, 100);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Login) {
                    if (isAdmin[0]) {
                        if (database.IDandUsermatch(username.getText(), Integer.parseInt(enterId.getText()), true)) {
                            AdminMenu();
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid username or ID");
                        }
                    } else {
                        if (database.IDandUsermatch(username.getText(), Integer.parseInt(enterId.getText()), false)) {
                            UserMenu();
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid username or ID");
                        }
                    }
                }
            }
        });
        LogIn.add(Login);

    }

    public void AdminMenu() {
        LogIn.setVisible(false);
        AdminMenu.setLayout(new GridLayout(2, 3));
        AdminMenu.setSize(1500, 1500);
        AdminMenu.getContentPane().setBackground(Color.YELLOW);
        AdminMenu.setLocationRelativeTo(null);
        AdminMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AdminMenu.setResizable(false);
        AdminMenu.setVisible(true);
        AdminMenu.setBackground(Color.YELLOW);

        JMenuBar menu = new JMenuBar();
        LogIn.setJMenuBar(menu);
        JMenu options = new JMenu("Settings"); menu.add(options);
        JMenuItem changePassword = new JMenuItem("Change Password"); options.add(changePassword);
        JMenuItem logOut = new JMenuItem("Log Out"); options.add(logOut);
        JMenuItem addDescription = new JMenuItem("Add Description"); options.add(addDescription);
        menu.setBorderPainted(true);
        Border newBorder = BorderFactory.createLineBorder(Color.BLACK, 2);

        JButton addBook = new JButton("Add Book");
        JButton removeBook = new JButton("Remove Book");
        JButton viewBooks = new JButton("View Books");
        JButton acceptRequest = new JButton("Accept Request");
    }

    public void UserMenu() {
        LogIn.setVisible(false);
        UserMenu.setLayout(new GridLayout(2, 3));
        UserMenu.setSize(1500, 1500);
        UserMenu.getContentPane().setBackground(Color.YELLOW);
        UserMenu.setLocationRelativeTo(null);
        UserMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        UserMenu.setResizable(false);
        UserMenu.setVisible(true);
        UserMenu.setBackground(Color.YELLOW);

        JMenuBar menu = new JMenuBar();
        LogIn.setJMenuBar(menu);
        JMenu options = new JMenu("Settings"); menu.add(options);
        JMenuItem changePassword = new JMenuItem("Change Password"); options.add(changePassword);
        JMenuItem logOut = new JMenuItem("Log Out"); options.add(logOut);
        JMenuItem addDescription = new JMenuItem("Add Description"); options.add(addDescription);
        menu.setBorderPainted(true);
        Border newBorder = BorderFactory.createLineBorder(Color.BLACK, 2);

        JButton viewBooks = new JButton("View Books");
        JButton borrowBook = new JButton("Borrow Book");
        JButton returnBook = new JButton("Return Book");
        JButton reserveBook = new JButton("Reserve Book");
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
