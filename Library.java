import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Library extends JFrame implements ActionListener {

    private JFrame titlescreen = new JFrame("Library App");
    private JFrame AdminMenu = new JFrame("Admin Menu");
    private JFrame UserMenu = new JFrame("User Menu");
    private User libraryuser;
    private Admin libraryadmin;
    private JScrollPane libraryPane;

    LibraryDatabase database = new LibraryDatabase();

    public Library(String test) {
        UIManager.put("OptionPane.messageFont", new Font("Calibri", Font.BOLD, 18));
        UIManager.put("OptionPane.messageForeground", Color.RED);
        UIManager.put("OptionPane.buttonFont", new Font("Calibri", Font.BOLD, 18));
        UIManager.put("OptionPane.background", Color.BLUE.brighter());
        UIManager.put("Panel.background", new Color(149, 234, 222));
        mainPage();
        AdminMenu(new Admin("test", 123456789, "test", "test"));
        UserMenu(new User("test", 123456789, "test", "test"));
    }

//    public void librarymusic() {
//        try {
//            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("LibraryMusic.wav").getAbsoluteFile());
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioInputStream);
//            clip.start();
//        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
//            System.out.println("Error with playing sound.");
//            e.printStackTrace();
//        }
//    }

    public void mainPage() {
        titlescreen.getContentPane().removeAll();
        titlescreen.setLayout(null);
        titlescreen.setSize(800, 550);
        titlescreen.setLocationRelativeTo(null);
        titlescreen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        titlescreen.setResizable(false);


        JPanel leftside = new JPanel();
        leftside.setBackground(new Color(102, 255, 178));
        leftside.setBounds(0, 0, 400, 550);
        leftside.setLayout(null);
        titlescreen.add(leftside);


        JPanel information = new JPanel();
        information.setBackground(Color.BLUE);
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
        createAccount.setBounds(50, 100, 300, 75);
        createAccount.setFont(new Font("Calibri", Font.BOLD, 20));
        createAccount.setBackground(Color.GREEN);
        createAccount.setForeground(Color.BLACK);
        createAccount.setBorder(new LineBorder(Color.BLACK));
        createAccount.setHorizontalAlignment(SwingConstants.CENTER);
        createAccount.addActionListener(e -> createAccount());
        information.add(createAccount);

        JButton LogIn = new JButton("Log In");
        LogIn.setBounds(50, 300, 300, 75);
        LogIn.setFont(new Font("Calibri", Font.BOLD, 20));
        LogIn.setBackground(Color.GREEN);
        LogIn.setForeground(Color.BLACK);
        LogIn.setBorder(new LineBorder(Color.BLACK));
        LogIn.setHorizontalAlignment(SwingConstants.CENTER);
        LogIn.addActionListener(e -> logAccount());
        information.add(LogIn);


        titlescreen.revalidate();
        titlescreen.repaint();
        titlescreen.setVisible(true);


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
        admin.setForeground(Color.BLUE);
        user.setForeground(Color.BLUE);
        admin.setBackground(Color.WHITE);
        user.setBackground(Color.WHITE);
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
                        JTextArea admininfo = new JTextArea("Admin account created " +
                                "Your username is " + username.getText() + " and your ID is " + database.getAdmins().get(database.getAdmins().size() - 1).getLibraryid());
                        System.out.println("Admin account created " +
                                "Your username is " + username.getText() + " and your ID is " + database.getAdmins().get(database.getAdmins().size() - 1).getLibraryid());
                        admininfo.setFont(new Font("Calibri", Font.BOLD, 20));
                        admininfo.setForeground(Color.RED);
                        admininfo.setBackground(new Color(149, 234, 222));
                        admininfo.setEditable(false);
                        JOptionPane.showMessageDialog(null, admininfo);
                        mainPage();
                    } else {
                        if (database.isUsernamevalid(username.getText(), false)) {
                            JOptionPane.showMessageDialog(null, "Username already exists");
                            return;
                        }
                        database.createAccount(username.getText(), false, first.getText(), last.getText());
                        JTextArea userinfo = new JTextArea("User account created " +
                                "Your username is " + username.getText() + " and your ID is " + database.getUsers().get(database.getUsers().size() - 1).getLibraryId());
                        System.out.println("User account created " +
                                "Your username is " + username.getText() + " and your ID is " + database.getUsers().get(database.getUsers().size() - 1).getLibraryId());
                        userinfo.setFont(new Font("Calibri", Font.BOLD, 20));
                        userinfo.setForeground(Color.RED);
                        userinfo.setBackground(new Color(149, 234, 222));
                        userinfo.setEditable(false);
                        JOptionPane.showMessageDialog(null, userinfo);
                        mainPage();

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
        admin.setForeground(Color.BLUE);
        user.setForeground(Color.BLUE);
        admin.setBackground(Color.WHITE);
        user.setBackground(Color.WHITE);
        admin.setFont(new Font("Calibri", Font.BOLD, 20));
        user.setFont(new Font("Calibri", Font.BOLD, 20));
        titlescreen.add(admin);
        titlescreen.add(user);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        usernameLabel.setForeground(Color.BLUE);
        usernameLabel.setBounds(150, 150, 100, 50);
        titlescreen.add(usernameLabel);

        JTextField usernametext = new JTextField();
        usernametext.setBounds(200, 200, 400, 50);
        usernametext.setFont(new Font("Calibri", Font.BOLD, 20));
        usernametext.setHorizontalAlignment(SwingConstants.CENTER);
        usernametext.setForeground(Color.BLACK);
        titlescreen.add(usernametext);

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
                        if (usernametext.getText().length() < 5) {
                            JOptionPane.showMessageDialog(null, "Username must be at least 5 characters long");
                            return;
                        }
                        if (idLabel.getText().length() != 9) {
                            JOptionPane.showMessageDialog(null, "ID must be 9 characters long");
                            return;
                        }
                        try {
                            if (database.IDandUsermatch(usernametext.getText(), Integer.parseInt(idLabel.getText()), true)) {
                                JOptionPane.showMessageDialog(null, "Admin successfully logged in");
                                for (int i = 0; i < database.getAdmins().size(); i++) {
                                    if (database.getAdmins().get(i).getUsername().equals(usernametext.getText())) {
                                        libraryadmin = database.getAdmins().get(i);
                                    }
                                }
                                AdminMenu(libraryadmin);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Admin username or ID");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid ID");
                        }
                    } else {
                        if (usernametext.getText().length() < 5) {
                            JOptionPane.showMessageDialog(null, "Username must be at least 5 characters long");
                            return;
                        }
                        if (idLabel.getText().length() != 9) {
                            JOptionPane.showMessageDialog(null, "ID must be 9 characters long");
                            return;
                        }
                        try {
                            if (database.IDandUsermatch(usernametext.getText(), Integer.parseInt(idLabel.getText()), false)) {
                                for (int i = 0; i < database.getUsers().size(); i++) {
                                    if (database.getUsers().get(i).getUsername().equals(usernametext.getText())) {
                                        libraryuser = database.getUsers().get(i);
                                    }
                                }
                                JOptionPane.showMessageDialog(null, "User successfully logged in");
                                UserMenu(libraryuser);
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

    public void AdminMenu(Admin admin) {
        titlescreen.setVisible(false);
        AdminMenu.setLayout(null);
        AdminMenu.setSize(1000, 750);
        AdminMenu.getContentPane().setBackground(new Color(229, 158, 15));
        AdminMenu.setLocationRelativeTo(null);
        AdminMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        AdminMenu.setResizable(false);

        JLabel title = new JLabel("Welcome Admin " + admin.getUsername());
        title.setBounds(365, 25, 500, 100);
        title.setFont(new Font("Calibri", Font.BOLD, 35));
        title.setForeground(Color.BLACK);
        AdminMenu.add(title);

        JMenuBar menu = new JMenuBar();
        menu.setBackground(Color.GREEN);
        JMenu options = new JMenu("Settings");
        menu.add(options);
        options.setForeground(Color.BLUE);
        JMenuItem checkprofile = new JMenuItem("Check Profile");
        options.add(checkprofile);
        JMenuItem changeUsername = new JMenuItem("Change Username");
        options.add(changeUsername);
        JMenuItem addDescription = new JMenuItem("Add Description");
        options.add(addDescription);
        JMenuItem logOut = new JMenuItem("Log Out");
        options.add(logOut);


        addDescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = JOptionPane.showInputDialog(null, "Enter a description about yourself" +
                        " that is less than 250 words");
                if (description.length() > 250) {
                    JOptionPane.showMessageDialog(null, "Description must be less than 250 words", "Invalid Description", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                admin.setDescription(description);
                JOptionPane.showMessageDialog(null, "Description added");
            }
        });
        changeUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = JOptionPane.showInputDialog(null, "Enter new username");
                if (newUsername.length() < 5) {
                    JOptionPane.showMessageDialog(null, "Username must be at least 5 characters long", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (database.isUsernamevalid(newUsername, true)) {
                    JOptionPane.showMessageDialog(null, "Username already exists", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your username to " + newUsername + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    admin.setUsername(newUsername);
                    JOptionPane.showMessageDialog(null, "Username changed to " + newUsername);
                }
            }
        });

        checkprofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame profile = new JFrame("Profile");
                profile.setLayout(null);
                profile.setSize(500, 500);
                profile.getContentPane().setBackground(new Color(229, 158, 15));
                profile.setLocationRelativeTo(null);
                profile.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                JLabel title = new JLabel("Admin Profile");
                title.setBounds(150, 25, 200, 50);
                title.setFont(new Font("Calibri", Font.BOLD, 20));
                title.setForeground(Color.BLACK);
                profile.add(title);

                JLabel username = new JLabel("Username: " + admin.getUsername());
                username.setBounds(150, 150, 200, 50);
                username.setFont(new Font("Calibri", Font.BOLD, 20));
                username.setForeground(Color.BLACK);
                profile.add(username);

                JLabel firstname = new JLabel("First Name: " + admin.getFirstname());
                firstname.setBounds(150, 200, 200, 50);
                firstname.setFont(new Font("Calibri", Font.BOLD, 20));
                firstname.setForeground(Color.BLACK);
                profile.add(firstname);

                JLabel lastname = new JLabel("Last Name: " + admin.getLastname());
                lastname.setBounds(150, 250, 200, 50);
                lastname.setFont(new Font("Calibri", Font.BOLD, 20));
                lastname.setForeground(Color.BLACK);
                profile.add(lastname);

                if (admin.getDescription() == null) {
                    admin.setDescription("No description added");
                }
                JLabel description = new JLabel("Description: " + admin.getDescription());
                description.setBounds(150, 300, 300, 200);
                description.setFont(new Font("Calibri", Font.BOLD, 20));
                description.setForeground(Color.BLACK);
                profile.add(description);

                profile.setVisible(true);

            }
        });
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenu.dispose();
                mainPage();
            }
        });
        menu.setBorderPainted(true);
        AdminMenu.setJMenuBar(menu);

        addingBooks();
        removingBooks();
        inventory();
        acceptingRequests();


        AdminMenu.setVisible(true);
    }


    public void addingBooks() {
        final int[] copies = new int[1];
        final int[] pages = new int[1];
        final int[] publication = new int[1];
        JButton addBook = new JButton("Add Book");
        addBook.setBounds(150, 200, 200, 200);
        addBook.setFont(new Font("Calibri", Font.BOLD, 25));
        addBook.setForeground(Color.WHITE);
        addBook.setBackground(Color.BLUE);
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (database.getBooks().size() > 10) {
                    JOptionPane.showMessageDialog(null, "You have reached the maximum amount of books", "Books Filled Out", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String bookname = JOptionPane.showInputDialog(null, "Enter the name of the book");
                for (int i = 0; i < database.getBooks().size(); i++) {
                    if (database.getBooks().get(i).getTitle().equalsIgnoreCase(bookname)) {
                        JOptionPane.showMessageDialog(null, "Book has already been added to library", "Book already added!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                String author = JOptionPane.showInputDialog(null, "Enter the name of the author");
                try {
                    copies[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount of copies"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Copies must be a number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    pages[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount of pages"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Pages must be a number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String genre = JOptionPane.showInputDialog(null, "Enter the genre of the book");
                try {
                    publication[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the year of publication"));
                    if (publication[0] < 0 || publication[0] > 2024) {
                        JOptionPane.showMessageDialog(null, "Year of publication must be a valid year", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Year of publication must be a number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String description = JOptionPane.showInputDialog(null, "Enter a description of the book");
                if (copies[0] < 0 || pages[0] < 0 || publication[0] < 0) {
                    JOptionPane.showMessageDialog(null, "Copies, pages, and publication year must be greater than 0", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Here is all the information: " +
                        "\nBook Name: " + bookname +
                        "\nAuthor: " + author +
                        "\nCopies: " + copies[0] +
                        "\nPages: " + pages[0] +
                        "\nGenre: " + genre +
                        "\nYear of Publication: " + publication[0] +
                        "\nDescription: " + description);
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to add this book to the library?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.NO_OPTION) {
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Book added to library");
                }
                database.addBooktoLibrary(bookname, author, copies[0], pages[0], genre, publication[0], description);
            }
        });
        AdminMenu.add(addBook);
    }

    public void removingBooks() {
        JButton removeBook = new JButton("Remove Book");
        removeBook.setBounds(650, 200, 200, 200);
        removeBook.setFont(new Font("Calibri", Font.BOLD, 25));
        removeBook.setForeground(Color.WHITE);
        removeBook.setBackground(Color.BLUE);
        removeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String remove = JOptionPane.showInputDialog(null, "Enter the title of the book you wish to remove");
                if (remove.isEmpty()) {
                    return;
                }
                removeBookRecursion(0, remove);
            }
        });
        AdminMenu.add(removeBook);
    }

    public void removeBookRecursion(int index, String title) {
        if (index >= database.getBooks().size()) {
            JOptionPane.showMessageDialog(null, "No such book found");
            return;
        }
        if (database.getBooks().get(index).getTitle().equalsIgnoreCase(title)) {
            database.removeBookfromLibrary(index);
            JOptionPane.showMessageDialog(null, "Book removed from library");
            return;
        }
        removeBookRecursion(index + 1, title);
    }

    public void inventory() {
        JFrame inventory = new JFrame("Inventory");
        inventory.setLayout(null);
        inventory.setSize(1000, 750);
        inventory.getContentPane().setBackground(new Color(229, 158, 15));
        inventory.setLocationRelativeTo(null);
        inventory.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        inventory.setResizable(false);

        JLabel title = new JLabel("Book Inventory");
        title.setBounds(365, 25, 500, 100);
        title.setFont(new Font("Calibri", Font.BOLD, 33));
        title.setForeground(Color.BLACK);
        inventory.add(title);

        JButton viewBooks = new JButton("View Books");
        viewBooks.setBounds(150, 450, 200, 200);
        viewBooks.setFont(new Font("Calibri", Font.BOLD, 25));
        viewBooks.setForeground(Color.WHITE);
        viewBooks.setBackground(Color.BLUE);
        viewBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] columns = {"Title", "Author", "Copies", "Pages", "Genre", "Year of Publication", "Description"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                for (int i = 0; i < database.getBooks().size(); i++) {
                    Object[] data = new Object[7];
                    data[0] = database.getBooks().get(i).getTitle();
                    data[1] = database.getBooks().get(i).getAuthor();
                    data[2] = database.getBooks().get(i).getCopies();
                    data[3] = database.getBooks().get(i).getPages();
                    data[4] = database.getBooks().get(i).getGenre();
                    data[5] = database.getBooks().get(i).getYearofpublication();
                    data[6] = database.getBooks().get(i).getDescription();
                    model.addRow(data);
                }
                JTable table = new JTable(model);
                table.setFont(new Font("Calibri", Font.BOLD, 20));
                table.setRowHeight(30);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                table.getColumnModel().getColumn(0).setPreferredWidth(200);
                table.getColumnModel().getColumn(1).setPreferredWidth(200);
                table.getColumnModel().getColumn(2).setPreferredWidth(100);
                table.getColumnModel().getColumn(3).setPreferredWidth(100);
                table.getColumnModel().getColumn(4).setPreferredWidth(200);
                table.getColumnModel().getColumn(5).setPreferredWidth(200);
                table.getColumnModel().getColumn(6).setPreferredWidth(400);

                if (libraryPane != null) {
                    inventory.remove(libraryPane);
                }

                libraryPane = new JScrollPane(table);
                libraryPane.setBounds(100, 100, 800, 500);
                inventory.add(libraryPane);

                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
                table.setRowSorter(sorter);

                inventory.revalidate();
                inventory.repaint();

                inventory.setVisible(true);

            }
        });
        AdminMenu.add(viewBooks);
    }



    public void acceptingRequests() {
        JFrame requestedBooks = new JFrame("Requested Books");
        requestedBooks.setLayout(null);
        requestedBooks.setSize(1000, 750);
        requestedBooks.getContentPane().setBackground(new Color(229, 158, 15));
        requestedBooks.setLocationRelativeTo(null);
        requestedBooks.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        requestedBooks.setResizable(false);

        JLabel title = new JLabel("Requested Books");
        title.setBounds(365, 25, 500, 100);
        title.setFont(new Font("Calibri", Font.BOLD, 33));
        title.setForeground(Color.BLACK);


        JButton acceptRequest = new JButton("Accept Request");
        acceptRequest.setBounds(650, 450, 200, 200);
        acceptRequest.setFont(new Font("Calibri", Font.BOLD, 25));
        acceptRequest.setForeground(Color.WHITE);
        acceptRequest.setBackground(Color.BLUE);
        acceptRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] columns = {"Title", "Author", "Copies", "Pages", "Genre", "Year of Publication", "Description"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                for (int i = 0; i < database.getRequestedBooks().size(); i++) {
                    Object[] data = new Object[7];
                    data[0] = database.getRequestedBooks().get(i).getTitle();
                    data[1] = database.getRequestedBooks().get(i).getAuthor();
                    data[2] = database.getRequestedBooks().get(i).getCopies();
                    data[3] = database.getRequestedBooks().get(i).getPages();
                    data[4] = database.getRequestedBooks().get(i).getGenre();
                    data[5] = database.getRequestedBooks().get(i).getYearofpublication();
                    data[6] = database.getRequestedBooks().get(i).getDescription();
                    model.addRow(data);
                }

                JTable requestedtable = new JTable(model);
                requestedtable.setFont(new Font("Calibri", Font.BOLD, 20));
                requestedtable.setRowHeight(30);
                requestedtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                requestedtable.getColumnModel().getColumn(0).setPreferredWidth(200);
                requestedtable.getColumnModel().getColumn(1).setPreferredWidth(200);
                requestedtable.getColumnModel().getColumn(2).setPreferredWidth(100);
                requestedtable.getColumnModel().getColumn(3).setPreferredWidth(100);
                requestedtable.getColumnModel().getColumn(4).setPreferredWidth(200);
                requestedtable.getColumnModel().getColumn(5).setPreferredWidth(200);
                requestedtable.getColumnModel().getColumn(6).setPreferredWidth(400);

                requestedtable.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int row = requestedtable.rowAtPoint(evt.getPoint());
                        int col = requestedtable.columnAtPoint(evt.getPoint());
                        if (row >= 0 && col >= 0) {
                            JOptionPane.showMessageDialog(null, "Title: " + requestedtable.getValueAt(row, 0) +
                                    "\nAuthor: " + requestedtable.getValueAt(row, 1) +
                                    "\nCopies: " + requestedtable.getValueAt(row, 2) +
                                    "\nPages: " + requestedtable.getValueAt(row, 3) +
                                    "\nGenre: " + requestedtable.getValueAt(row, 4) +
                                    "\nYear of Publication: " + requestedtable.getValueAt(row, 5) +
                                    "\nDescription: " + requestedtable.getValueAt(row, 6));
                        }
                        int option = JOptionPane.showConfirmDialog(null, "Do you want to accept this request?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Request accepted");
                            database.addBooktoLibrary(requestedtable.getValueAt(row, 0).toString(), requestedtable.getValueAt(row, 1).toString(), (int) requestedtable.getValueAt(row, 2), (int) requestedtable.getValueAt(row, 3),
                                    requestedtable.getValueAt(row, 4).toString(), (int) requestedtable.getValueAt(row, 5), requestedtable.getValueAt(row, 6).toString());
                            database.removeRequest(requestedtable.getValueAt(row, 0).toString());
                            DefaultTableModel model = (DefaultTableModel) requestedtable.getModel();
                            model.removeRow(row);
                            model.fireTableDataChanged();
                        } else {
                            JOptionPane.showMessageDialog(null, "Request denied");
                        }
                    }
                });
                requestedBooks.add(title);
                if (libraryPane != null) {
                    requestedBooks.remove(libraryPane);
                }
                libraryPane = new JScrollPane(requestedtable);
                libraryPane.setBounds(100, 100, 800, 500);
                requestedBooks.add(libraryPane);

                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) requestedtable.getModel());
                requestedtable.setRowSorter(sorter);

                requestedBooks.revalidate();
                requestedBooks.repaint();

                requestedBooks.setVisible(true);
            }
        });
        AdminMenu.add(acceptRequest);
    }

    public void UserMenu(User user) {
        titlescreen.setVisible(false);
        UserMenu.setLayout(null);
        UserMenu.setSize(1000, 750);
        UserMenu.getContentPane().setBackground(new Color(229, 158, 15));
        UserMenu.setLocationRelativeTo(null);
        UserMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        UserMenu.setResizable(false);

        JLabel title = new JLabel("Welcome " + "User " + user.getUsername());
        title.setBounds(365, 25, 500, 125);
        title.setFont(new Font("Calibri", Font.BOLD, 35));
        title.setForeground(Color.BLACK);
        UserMenu.add(title);

        JMenuBar menu = new JMenuBar();
        menu.setBackground(Color.BLUE);
        JMenu options = new JMenu("Settings");
        menu.add(options);
        options.setForeground(Color.BLUE);
        JMenuItem checkprofile = new JMenuItem("Check Profile");
        options.add(checkprofile);
        JMenuItem changeUsername = new JMenuItem("Change Username");
        options.add(changeUsername);
        JMenuItem addDescription = new JMenuItem("Add Description");
        options.add(addDescription);
        JMenuItem logOut = new JMenuItem("Log Out");
        options.add(logOut);

        addDescription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = JOptionPane.showInputDialog(null, "Enter a description about yourself" +
                        " that is less than 250 words");
                if (description.length() > 250) {
                    JOptionPane.showMessageDialog(null, "Description must be less than 250 words");
                    return;
                }
                user.setDescription(description);
                JOptionPane.showMessageDialog(null, "Description added");
            }
        });

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserMenu.dispose();
                mainPage();
            }
        });

        changeUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = JOptionPane.showInputDialog(null, "Enter new username");
                if (newUsername.length() < 5) {
                    JOptionPane.showMessageDialog(null, "Username must be at least 5 characters long");
                    return;
                }
                if (database.isUsernamevalid(newUsername, false)) {
                    JOptionPane.showMessageDialog(null, "Username already exists", "Username Change Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                user.setUsername(newUsername);
                JOptionPane.showMessageDialog(null, "Username changed to " + newUsername);
            }
        });

        checkprofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame profile = new JFrame("Profile");
                profile.setLayout(null);
                profile.setSize(500, 500);
                profile.getContentPane().setBackground(new Color(229, 158, 15));
                profile.setLocationRelativeTo(null);
                profile.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                JLabel title = new JLabel("User Profile");
                title.setBounds(150, 25, 200, 50);
                title.setFont(new Font("Calibri", Font.BOLD, 20));
                title.setForeground(Color.BLACK);
                profile.add(title);

                JLabel username = new JLabel("Username: " + user.getUsername());
                username.setBounds(150, 150, 200, 50);
                username.setFont(new Font("Calibri", Font.BOLD, 20));
                username.setForeground(Color.BLACK);
                profile.add(username);

                JLabel firstname = new JLabel("First Name: " + user.getFirstname());
                firstname.setBounds(150, 250, 200, 50);
                firstname.setFont(new Font("Calibri", Font.BOLD, 20));
                firstname.setForeground(Color.BLACK);
                profile.add(firstname);

                JLabel lastname = new JLabel("Last Name: " + user.getLastname());
                lastname.setBounds(150, 300, 200, 50);
                lastname.setFont(new Font("Calibri", Font.BOLD, 20));
                lastname.setForeground(Color.BLACK);
                profile.add(lastname);

                if (user.getDescription() == null) {
                    user.setDescription("No description added");
                }
                JLabel description = new JLabel("Description: " + user.getDescription());
                description.setBounds(150, 300, 300, 150);
                description.setFont(new Font("Calibri", Font.BOLD, 20));
                description.setForeground(Color.BLACK);
                profile.add(description);

                profile.setVisible(true);
            }
        });


        menu.setBorderPainted(true);


        viewBooks(user);
        borrowBooks(user);
        requestbook(user);
        returnBook(user);


        UserMenu.setJMenuBar(menu);

        UserMenu.setVisible(true);
    }

    public void viewBooks(User user) {
        JFrame displayBooks = new JFrame("Books");
        displayBooks.setLayout(null);
        displayBooks.setSize(1000, 750);
        displayBooks.getContentPane().setBackground(new Color(229, 158, 15));
        displayBooks.setLocationRelativeTo(null);
        displayBooks.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        displayBooks.setResizable(false);

        JButton viewBooks = new JButton("View Books");
        viewBooks.setBounds(150, 200, 200, 200);
        viewBooks.setFont(new Font("Calibri", Font.BOLD, 25));
        viewBooks.setForeground(Color.WHITE);
        viewBooks.setBackground(Color.BLUE);

        JLabel title = new JLabel("Books Currently Owned");
        title.setBounds(365, 25, 500, 50);
        title.setFont(new Font("Calibri", Font.BOLD, 33));
        title.setForeground(Color.BLACK);
        displayBooks.add(title);

        viewBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String column[] = {"Title", "Author", "Copies", "Pages", "Genre", "Year of Publication", "Description"};
                DefaultTableModel model = new DefaultTableModel(column, 0);
                for (int i = 0; i < user.getBooksowned().size(); i++) {
                    Object[] data = new Object[7];
                    data[0] = user.getBooksowned().get(i).getTitle();
                    data[1] = user.getBooksowned().get(i).getAuthor();
                    data[2] = user.getBooksowned().get(i).getCopies();
                    data[3] = user.getBooksowned().get(i).getPages();
                    data[4] = user.getBooksowned().get(i).getGenre();
                    data[5] = user.getBooksowned().get(i).getYearofpublication();
                    data[6] = user.getBooksowned().get(i).getDescription();
                    model.addRow(data);
                }
                JTable inventorybooks = new JTable(model);
                inventorybooks.setFont(new Font("Calibri", Font.BOLD, 20));
                inventorybooks.setRowHeight(30);
                inventorybooks.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

                inventorybooks.getColumnModel().getColumn(0).setPreferredWidth(200);
                inventorybooks.getColumnModel().getColumn(1).setPreferredWidth(200);
                inventorybooks.getColumnModel().getColumn(2).setPreferredWidth(100);
                inventorybooks.getColumnModel().getColumn(3).setPreferredWidth(100);
                inventorybooks.getColumnModel().getColumn(4).setPreferredWidth(200);
                inventorybooks.getColumnModel().getColumn(5).setPreferredWidth(200);
                inventorybooks.getColumnModel().getColumn(6).setPreferredWidth(400);

                inventorybooks.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int row = inventorybooks.rowAtPoint(evt.getPoint());
                        int col = inventorybooks.columnAtPoint(evt.getPoint());
                        if (row >= 0 && col >= 0) {
                            JOptionPane.showMessageDialog(null, "Title: " + inventorybooks.getValueAt(row, 0) +
                                    "\nAuthor: " + inventorybooks.getValueAt(row, 1) +
                                    "\nCopies: " + inventorybooks.getValueAt(row, 2) +
                                    "\nPages: " + inventorybooks.getValueAt(row, 3) +
                                    "\nGenre: " + inventorybooks.getValueAt(row, 4) +
                                    "\nYear of Publication: " + inventorybooks.getValueAt(row, 5) +
                                    "\nDescription: " + inventorybooks.getValueAt(row, 6));
                        }
                    }
                });
                if (libraryPane != null) {
                    displayBooks.remove(libraryPane);
                }
                libraryPane = new JScrollPane(inventorybooks);
                libraryPane.setBounds(100, 100, 800, 500);
                displayBooks.add(libraryPane);

                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) inventorybooks.getModel());
                inventorybooks.setRowSorter(sorter);

                displayBooks.revalidate();
                displayBooks.repaint();

                displayBooks.setVisible(true);
            }
        });
        UserMenu.add(viewBooks);
    }

    public void borrowBooks(User user) {
        JFrame borrowBooks = new JFrame("Borrow Books");
        borrowBooks.setLayout(null);
        borrowBooks.setSize(1000, 750);
        borrowBooks.getContentPane().setBackground(new Color(229, 158, 15));
        borrowBooks.setLocationRelativeTo(null);
        borrowBooks.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        borrowBooks.setResizable(false);

        JLabel title = new JLabel("Book Inventory");
        title.setBounds(365, 25, 500, 50);
        title.setFont(new Font("Calibri", Font.BOLD, 33));
        title.setForeground(Color.BLACK);
        borrowBooks.add(title);

        JButton borrowedBooks = new JButton("Borrow Books");
        borrowedBooks.setBounds(150, 450, 200, 200);
        borrowedBooks.setFont(new Font("Calibri", Font.BOLD, 25));
        borrowedBooks.setForeground(Color.WHITE);
        borrowedBooks.setBackground(Color.BLUE);


        borrowedBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] columns = {"Title", "Author", "Copies", "Pages", "Genre", "Year of Publication", "Description"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                for (int i = 0; i < database.getBooks().size(); i++) {
                    Object[] data = new Object[7];
                    data[0] = database.getBooks().get(i).getTitle();
                    data[1] = database.getBooks().get(i).getAuthor();
                    data[2] = database.getBooks().get(i).getCopies();
                    data[3] = database.getBooks().get(i).getPages();
                    data[4] = database.getBooks().get(i).getGenre();
                    data[5] = database.getBooks().get(i).getYearofpublication();
                    data[6] = database.getBooks().get(i).getDescription();
                    model.addRow(data);
                }
                JTable table = new JTable(model);
                table.setFont(new Font("Calibri", Font.BOLD, 20));
                table.setRowHeight(30);
                table.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int row = table.rowAtPoint(evt.getPoint());
                        int col = table.columnAtPoint(evt.getPoint());
                        if ((int)table.getValueAt(row, 2) == 0) {
                            JOptionPane.showMessageDialog(null, "No copies available");
                            return;
                        }
                        if (row >= 0 && col >= 0) {
                            JOptionPane.showMessageDialog(null, "Title: " + table.getValueAt(row, 0) +
                                    "\nAuthor: " + table.getValueAt(row, 1) +
                                    "\nCopies: " + table.getValueAt(row, 2) +
                                    "\nPages: " + table.getValueAt(row, 3) +
                                    "\nGenre: " + table.getValueAt(row, 4) +
                                    "\nYear of Publication: " + table.getValueAt(row, 5) +
                                    "\nDescription: " + table.getValueAt(row, 6));
                        }
                        for (int i = 0; i < user.getBooksowned().size(); i++) {
                            if (user.getBooksowned().get(i).getTitle().equals(table.getValueAt(row, 0).toString())) {
                                JOptionPane.showMessageDialog(null, "You already own this book");
                                return;
                            }
                        }
                        int choice = JOptionPane.showConfirmDialog(null, "Do you want to borrow this book?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Book borrowed");
                            user.addBook(new Book(table.getValueAt(row, 0).toString(), table.getValueAt(row, 1).toString(), 1, (int) table.getValueAt(row, 3),
                                    table.getValueAt(row, 4).toString(), (int) table.getValueAt(row, 5), table.getValueAt(row, 6).toString()));
                            for (int i = 0; i < database.getBooks().size(); i++) {
                                if (database.getBooks().get(i).getTitle().equals(table.getValueAt(row, 0).toString())) {
                                    database.getBooks().get(i).changeCopies();
                                }
                            }
                            model.fireTableDataChanged();
                        } else {
                            JOptionPane.showMessageDialog(null, "Book not borrowed");
                        }
                    }
                });
                if (libraryPane != null) {
                    borrowBooks.remove(libraryPane);
                }
                libraryPane = new JScrollPane(table);
                libraryPane.setBounds(100, 100, 800, 500);
                borrowBooks.add(libraryPane);

                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
                table.setRowSorter(sorter);

                borrowBooks.revalidate();
                borrowBooks.repaint();

                borrowBooks.setVisible(true);
            }
        });
        UserMenu.add(borrowedBooks);
    }

    public void requestbook(User user) {
        final int[] pages = new int[1];
        final int[] year = new int[1];
        JButton requestBook = new JButton("Request Book");
        requestBook.setBounds(650, 450, 200, 200);
        requestBook.setFont(new Font("Calibri", Font.BOLD, 25));
        requestBook.setForeground(Color.WHITE);
        requestBook.setBackground(Color.BLUE);
        requestBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String request = JOptionPane.showInputDialog(null, "Enter the title of the book you wish to request");
                String author = JOptionPane.showInputDialog(null, "Enter the author of the book you wish to request");
                try {
                    pages[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount of pages of the book you wish to request"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Copies and pages must be valid numbers", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String genre = JOptionPane.showInputDialog(null, "Enter the genre of the book you wish to request");
                try {
                    if (year[0] < 0 || year[0] > 2024) {
                        JOptionPane.showMessageDialog(null, "Year of publication must be a valid year", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    year[0] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the year of publication of the book you wish to request"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Year of publication must be a valid number", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String description = JOptionPane.showInputDialog(null, "Enter a description of the book you wish to request");
                JOptionPane.showMessageDialog(null, "Here is all the information: " +
                        "\nBook Name: " + request +
                        "\nAuthor: " + author +
                        "\nPages: " + pages[0] +
                        "\nGenre: " + genre +
                        "\nYear of Publication: " + year[0] +
                        "\nDescription: " + description);
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to request this book?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Book request cancelled");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Book requested");
                    database.addRequest(new Book(request, author, 1, pages[0], genre, year[0], description));
                }
            }
        });
        UserMenu.add(requestBook);
    }

    public void returnBook(User user) {
        JFrame returnBooks = new JFrame("Return Books");
        returnBooks.setLayout(null);
        returnBooks.setSize(1000, 750);
        returnBooks.getContentPane().setBackground(new Color(229, 158, 15));
        returnBooks.setLocationRelativeTo(null);
        returnBooks.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        returnBooks.setResizable(false);

        JLabel title = new JLabel("Books Borrowed");
        title.setBounds(350, 25, 500, 50);
        title.setFont(new Font("Calibri", Font.BOLD, 33));
        title.setForeground(Color.BLACK);
        returnBooks.add(title);

        JButton returnBook = new JButton("Return Book");
        returnBook.setBounds(650, 200, 200, 200);
        returnBook.setFont(new Font("Calibri", Font.BOLD, 25));
        returnBook.setForeground(Color.WHITE);
        returnBook.setBackground(Color.BLUE);

        returnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] columns = {"Title", "Author", "Copies", "Pages", "Genre", "Year of Publication", "Description"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                for (int i = 0; i < user.getBooksowned().size(); i++) {
                    Object[] data = new Object[7];
                    data[0] = user.getBooksowned().get(i).getTitle();
                    data[1] = user.getBooksowned().get(i).getAuthor();
                    data[2] = user.getBooksowned().get(i).getCopies();
                    data[3] = user.getBooksowned().get(i).getPages();
                    data[4] = user.getBooksowned().get(i).getGenre();
                    data[5] = user.getBooksowned().get(i).getYearofpublication();
                    data[6] = user.getBooksowned().get(i).getDescription();
                    model.addRow(data);
                }
                JTable returntable = new JTable(model);
                returntable.setFont(new Font("Calibri", Font.BOLD, 20));
                returntable.setRowHeight(30);
                returntable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                returntable.getColumnModel().getColumn(0).setPreferredWidth(200);
                returntable.getColumnModel().getColumn(1).setPreferredWidth(200);
                returntable.getColumnModel().getColumn(2).setPreferredWidth(100);
                returntable.getColumnModel().getColumn(3).setPreferredWidth(100);
                returntable.getColumnModel().getColumn(4).setPreferredWidth(200);
                returntable.getColumnModel().getColumn(5).setPreferredWidth(200);
                returntable.getColumnModel().getColumn(6).setPreferredWidth(400);

                returntable.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int row = returntable.rowAtPoint(evt.getPoint());
                        int col = returntable.columnAtPoint(evt.getPoint());
                        if (row >= 0 && col >= 0) {
                            JOptionPane.showMessageDialog(null, "Title: " + returntable.getValueAt(row, 0) +
                                    "\nAuthor: " + returntable.getValueAt(row, 1) +
                                    "\nCopies: " + returntable.getValueAt(row, 2) +
                                    "\nPages: " + returntable.getValueAt(row, 3) +
                                    "\nGenre: " + returntable.getValueAt(row, 4) +
                                    "\nYear of Publication: " + returntable.getValueAt(row, 5) +
                                    "\nDescription: " + returntable.getValueAt(row, 6));
                        }
                        int choice = JOptionPane.showConfirmDialog(null, "Do you want to return this book?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Book returned");
                            for (int i = 0; i < database.getBooks().size(); i++) {
                                if (database.getBooks().get(i).getTitle().equals(returntable.getValueAt(row, 0).toString())) {
                                    database.getBooks().get(i).addCopies();
                                }
                            }
                            user.removeBook(returntable.getValueAt(row, 0).toString());
                            DefaultTableModel model = (DefaultTableModel) returntable.getModel();
                            model.removeRow(row);
                            model.fireTableDataChanged();
                        } else {
                            JOptionPane.showMessageDialog(null, "Book not returned");
                        }
                    }
                });
                if (libraryPane != null) {
                    returnBooks.remove(libraryPane);
                }
                libraryPane = new JScrollPane(returntable);
                libraryPane.setBounds(100, 100, 800, 500);
                returnBooks.add(libraryPane);

                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) returntable.getModel());
                returntable.setRowSorter(sorter);

                returnBooks.revalidate();
                returnBooks.repaint();

                returnBooks.setVisible(true);
            }
        });
        UserMenu.add(returnBook);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
