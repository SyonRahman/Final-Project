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
    private JFrame AdminMenu = new JFrame("Admin Menu");
    private JFrame UserMenu = new JFrame("User Menu");

    private ArrayList<Books> books = new ArrayList<Books>();


    LibraryDatabase database = new LibraryDatabase();

    public Library(String test) {
        AdminMenu();
    }
    public Library() {
        createComponents();
    }

    public void createComponents() {
        titlescreen.setSize(800, 550);
        titlescreen.setLocationRelativeTo(null);
        titlescreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        titlescreen.setResizable(false);
        titlescreen.setVisible(true);


        JPanel leftside = new JPanel();
        leftside.setBackground(new Color(102, 255, 178));
        leftside.setBounds(0, 0, 400, 550);
        leftside.setLayout(null);
        titlescreen.add(leftside);


        JPanel information = new JPanel();
        information.setBackground(Color.WHITE);
        information.setBounds(400, 0, 400, 550);
        information.setLayout(null);
        titlescreen.add(information);


        ImageIcon book = new ImageIcon("Bluebook.png");
        Image modified = book.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        ImageIcon newbook = new ImageIcon(modified);
        JLabel bookimage = new JLabel(newbook);
        bookimage.setBounds(150, 100, 100, 100);
        leftside.add(bookimage);

        JLabel BTLibrary = new JLabel("BT Library");
        BTLibrary.setBounds(125, 200, 400, 100);
        BTLibrary.setHorizontalAlignment(SwingConstants.LEFT);
        BTLibrary.setFont(new Font("Calibri", Font.BOLD, 40));
        BTLibrary.setForeground(Color.MAGENTA);
        leftside.add(BTLibrary);

        ImageIcon cartoon = new ImageIcon("CartoonBooks.png");
        Image cartoonmodified = cartoon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        ImageIcon newcartoon = new ImageIcon(cartoonmodified);
        JLabel cartoonimage = new JLabel(newcartoon);
        cartoonimage.setBounds(150, 300, 100, 100);
        leftside.add(cartoonimage);

        JButton createAccount = new JButton("Create Account");
        createAccount.setBounds(450, 100, 300, 75);
        createAccount.setFont(new Font("Calibri", Font.BOLD, 20));
        createAccount.setBackground(Color.GREEN);
        createAccount.setForeground(Color.BLACK);
        createAccount.setBorder(new LineBorder(Color.BLACK));
        createAccount.setHorizontalAlignment(SwingConstants.CENTER);
        createAccount.addActionListener(e -> createAccount());
        information.add(createAccount);

        JButton LogIn = new JButton("Log In");
        LogIn.setBounds(450, 300, 300, 75);
        LogIn.setFont(new Font("Calibri", Font.BOLD, 20));
        LogIn.setBackground(Color.GREEN);
        LogIn.setForeground(Color.BLACK);
        LogIn.setBorder(new LineBorder(Color.BLACK));
        LogIn.setHorizontalAlignment(SwingConstants.CENTER);
        LogIn.addActionListener(e -> logAccount());
        information.add(LogIn);


        titlescreen.revalidate();
        titlescreen.repaint();



    }

    public void createAccount() {
        titlescreen.getContentPane().removeAll();
        titlescreen.setTitle("Create Account");
        titlescreen.setLayout(null);

        JLabel title = new JLabel("Create Library Account");
        title.setBounds(200, 25, 400, 50);
        title.setFont(new Font("Calibri", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        titlescreen.add(title);

        final boolean[] isAdmin = {false};
        JButton admin = new JButton("Admin");
        JButton user = new JButton("User");
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin.setBackground(Color.BLUE);
                admin.setForeground(Color.WHITE);
                user.setBackground(Color.WHITE);
                user.setForeground(Color.BLUE);
                isAdmin[0] = true;
            }
        });
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setBackground(Color.BLUE);
                user.setForeground(Color.WHITE);
                admin.setBackground(Color.WHITE);
                admin.setForeground(Color.BLUE);
                isAdmin[0] = false;
            }
        });

        admin.setBounds(200, 75, 200, 50);
        user.setBounds(400, 75, 200, 50);
        admin.setForeground(Color.BLUE); user.setForeground(Color.BLUE);
        admin.setBackground(Color.WHITE); user.setBackground(Color.WHITE);
        admin.setFont(new Font("Calibri", Font.BOLD, 20));
        user.setFont(new Font("Calibri", Font.BOLD, 20));

        titlescreen.add(admin);
        titlescreen.add(user);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        usernameLabel.setForeground(Color.BLUE);
        usernameLabel.setBounds(150, 125, 100, 50);
        titlescreen.add(usernameLabel);

        JTextField username = new JTextField();
        username.setBounds(200, 175, 400, 50);
        username.setFont(new Font("Calibri", Font.BOLD, 20));
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setForeground(Color.BLACK);
        titlescreen.add(username);

        JLabel firstname = new JLabel("First Name:");
        firstname.setFont(new Font("Calibri", Font.BOLD, 20));
        firstname.setForeground(Color.BLUE);
        firstname.setBounds(150, 225, 100, 50);
        titlescreen.add(firstname);

        JTextField first = new JTextField();
        first.setBounds(200, 275, 400, 50);
        first.setFont(new Font("Calibri", Font.BOLD, 20));
        first.setHorizontalAlignment(SwingConstants.CENTER);
        first.setForeground(Color.BLACK);
        titlescreen.add(first);

        JLabel lastname = new JLabel("Last Name:");
        lastname.setFont(new Font("Calibri", Font.BOLD, 20));
        lastname.setForeground(Color.BLUE);
        lastname.setBounds(150, 325, 100, 50);
        titlescreen.add(lastname);

        JTextField last = new JTextField();
        last.setBounds(200, 375, 400, 50);
        last.setFont(new Font("Calibri", Font.BOLD, 20));
        last.setHorizontalAlignment(SwingConstants.CENTER);
        last.setForeground(Color.BLACK);
        titlescreen.add(last);


        JButton SignUp = new JButton("Create Account");
        SignUp.setFont(new Font("Calibri", Font.BOLD, 30));
        SignUp.setBackground(Color.BLUE);
        SignUp.setForeground(Color.WHITE);
        SignUp.setBounds(250, 450, 300, 40);
        SignUp.setBorder(new LineBorder(Color.BLACK));
        SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == SignUp) {
                    if (username.getText().length() < 5) {
                        JOptionPane.showMessageDialog(null, "Username must be at least 5 characters long");
                        return;
                    }
                    if (first.getText().length() < 3) {
                        JOptionPane.showMessageDialog(null, "First name must be at least 3 characters long");
                        return;
                    }
                    if (last.getText().length() < 3) {
                        JOptionPane.showMessageDialog(null, "Last name must be at least 3 characters long");
                        return;
                    }
                    if (isAdmin[0]) {
                        if (database.isUsernamevalid(username.getText(), true)) {
                            JOptionPane.showMessageDialog(null, "Username already exists");
                            return;
                        }
                        database.createAccount(username.getText(), true, first.getText(), last.getText());
                        JOptionPane.showMessageDialog(null, "Admin account created " +
                                "Your username is " + username.getText() + " and your ID is " + database.getAdmins().get(database.getAdmins().size() - 1).getLibraryid());
                        createComponents();
                    } else {
                        if (database.isUsernamevalid(username.getText(), false)) {
                            JOptionPane.showMessageDialog(null, "Username already exists");
                            return;
                        }
                        database.createAccount(username.getText(), false, first.getText(), last.getText());
                        JOptionPane.showMessageDialog(null, "User account created " +
                                "Your username is " + username.getText() + " and your ID is " + database.getUsers().get(database.getUsers().size() - 1).getLibraryId());
                        createComponents();

                    }
                }
            }
        });
        titlescreen.add(SignUp);

        titlescreen.revalidate();
        titlescreen.repaint();
    }

    public void logAccount() {
        titlescreen.getContentPane().removeAll();
        titlescreen.setTitle("Log In");
        titlescreen.setLayout(null);

        JLabel title = new JLabel("Log In");
        title.setBounds(200, 25, 400, 50);
        title.setFont(new Font("Calibri", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        titlescreen.add(title);

        final boolean[] isAdmin = {false};
        JButton admin = new JButton("Admin");
        JButton user = new JButton("User");
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin.setBackground(Color.BLUE);
                admin.setForeground(Color.WHITE);
                user.setBackground(Color.WHITE);
                user.setForeground(Color.BLUE);
                isAdmin[0] = true;
            }
        });
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setBackground(Color.BLUE);
                user.setForeground(Color.WHITE);
                admin.setBackground(Color.WHITE);
                admin.setForeground(Color.BLUE);
                isAdmin[0] = false;
            }
        });

        admin.setBounds(200, 75, 200, 50);
        user.setBounds(400, 75, 200, 50);
        admin.setForeground(Color.BLUE); user.setForeground(Color.BLUE);
        admin.setBackground(Color.WHITE); user.setBackground(Color.WHITE);
        admin.setFont(new Font("Calibri", Font.BOLD, 20));
        user.setFont(new Font("Calibri", Font.BOLD, 20));
        titlescreen.add(admin);
        titlescreen.add(user);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        usernameLabel.setForeground(Color.BLUE);
        usernameLabel.setBounds(150, 150, 100, 50);
        titlescreen.add(usernameLabel);

        JTextField username = new JTextField();
        username.setBounds(200, 200, 400, 50);
        username.setFont(new Font("Calibri", Font.BOLD, 20));
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setForeground(Color.BLACK);
        titlescreen.add(username);

        JLabel id = new JLabel("ID:");
        id.setFont(new Font("Calibri", Font.BOLD, 20));
        id.setForeground(Color.BLUE);
        id.setBounds(165, 250, 100, 50);
        titlescreen.add(id);

        JTextField idLabel = new JTextField();
        idLabel.setBounds(200, 300, 400, 50);
        idLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        idLabel.setHorizontalAlignment(SwingConstants.CENTER);
        idLabel.setForeground(Color.BLACK);
        titlescreen.add(idLabel);


        JButton Login = new JButton("Login");
        Login.setFont(new Font("Calibri", Font.BOLD, 30));
        Login.setForeground(Color.WHITE);
        Login.setBackground(Color.BLUE);
        Login.setBounds(300, 400, 200, 40);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Login) {
                    if (isAdmin[0]) {
                        if (username.getText().length() < 5) {
                            JOptionPane.showMessageDialog(null, "Username must be at least 5 characters long");
                            return;
                        }
                        if (idLabel.getText().length() != 9) {
                            JOptionPane.showMessageDialog(null, "ID must be 9 characters long");
                            return;
                        }
                        try {
                            if (database.IDandUsermatch(username.getText(), Integer.parseInt(idLabel.getText()), true)) {
                                AdminMenu();
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Admin username or ID");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid ID");
                        }
                    } else {
                        if (username.getText().length() < 5) {
                            JOptionPane.showMessageDialog(null, "Username must be at least 5 characters long");
                            return;
                        }
                        if (idLabel.getText().length() != 9) {
                            JOptionPane.showMessageDialog(null, "ID must be 9 characters long");
                            return;
                        }
                        try {
                            if (database.IDandUsermatch(username.getText(), Integer.parseInt(idLabel.getText()), true)) {
                                UserMenu();
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid User username or ID");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid ID");
                        }
                    }
                }
            }
        });
        titlescreen.add(Login);

        titlescreen.revalidate();
        titlescreen.repaint();

    }

    public void AdminMenu() {
        titlescreen.setVisible(false);
        AdminMenu.setLayout(null);
        AdminMenu.setSize(1000, 750);
        AdminMenu.getContentPane().setBackground(new Color(229, 158, 15));
        AdminMenu.setLocationRelativeTo(null);
        AdminMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        AdminMenu.setResizable(false);

        JMenuBar menu = new JMenuBar();
        menu.setBackground(Color.GREEN);
        JMenu options = new JMenu("Settings"); menu.add(options);
        options.setForeground(Color.BLUE);
        JMenuItem changeUsername = new JMenuItem("Change Username"); options.add(changeUsername);
        JMenuItem logOut = new JMenuItem("Log Out"); options.add(logOut);
        JMenuItem addDescription = new JMenuItem("Add Description"); options.add(addDescription);
        JMenuItem checkprofile = new JMenuItem("Check Profile"); options.add(checkprofile);
        menu.setBorderPainted(true);
        AdminMenu.setJMenuBar(menu);

        addingBooks();
        removingBooks();
        viewingBooks();
        acceptingRequests();


        AdminMenu.setVisible(true);
    }

    public void addingBooks() {
        JButton addBook = new JButton("Add Book");
        addBook.setBounds(150, 200, 200, 200);
        addBook.setFont(new Font());
        addBook.setForeground();
        addBook.setBackground();
        AdminMenu.add(addBook);
    }

    public void removingBooks() {
        JButton removeBook = new JButton("Remove Book");
        removeBook.setBounds(650, 200, 200, 200);
        removeBook.setFont(new Font());
        removeBook.setForeground();
        removeBook.setBackground();
        AdminMenu.add(removeBook);
    }

    public void viewingBooks() {
        JButton viewBooks = new JButton("View Books");
        viewBooks.setBounds(150, 450, 200, 200);
        viewBooks.setFont(new Font());
        viewBooks.setForeground();
        viewBooks.setBackground();
        AdminMenu.add(viewBooks);
    }

    public void acceptingRequests() {
        JButton acceptRequest = new JButton("Accept Request");
        acceptRequest.setBounds(650, 450, 200, 200);
        acceptRequest.setFont(new Font());
        acceptRequest.setForeground();
        acceptRequest.setBackground();
        AdminMenu.add(acceptRequest);
    }

    public void UserMenu() {
        titlescreen.setVisible(false);
        //UserMenu.setLayout(new GridLayout(2, 3));
        UserMenu.setSize(1200, 1200);
        UserMenu.getContentPane().setBackground(Color.YELLOW);
        UserMenu.setLocationRelativeTo(null);
        UserMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        UserMenu.setResizable(false);


        JMenuBar menu = new JMenuBar();
        menu.setBackground(Color.BLUE);
        JMenu options = new JMenu("Settings"); menu.add(options);
        JMenuItem changePassword = new JMenuItem("Change Password"); options.add(changePassword);
        JMenuItem logOut = new JMenuItem("Log Out"); options.add(logOut);
        JMenuItem addDescription = new JMenuItem("Add Description"); options.add(addDescription);
        JMenuItem checkprofile = new JMenuItem("Check Profile"); options.add(checkprofile);
        menu.setBorderPainted(true);
        Border newBorder = BorderFactory.createLineBorder(Color.BLACK, 2);

        JButton viewBooks = new JButton("View Books");
        viewBooks.setBorder(newBorder);
        JButton borrowBook = new JButton("Borrow Book");
        JButton returnBook = new JButton("Return Book");
        JButton reserveBook = new JButton("Reserve Book");

        UserMenu.add(viewBooks);
        UserMenu.add(borrowBook);
        UserMenu.add(returnBook);
        UserMenu.add(reserveBook);

        UserMenu.setJMenuBar(menu);

        UserMenu.setVisible(true);
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
