
//Issouf  Diarrassouba --> I apologize just like to sign off on everything 
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;//Why is this underlined uhh bettter not give me an error right before I submit 
import java.io.PrintWriter;
import java.net.Socket;

// Imported things above ^
// Satisfying the extra points by making my frame look nice 
// Providing an abundance of options and colors for the viewers 
public class GWackClientGUI extends JFrame {

    private Socket socket;
    private PrintWriter pw;
    private BufferedReader buff;
    private Messenger nn;

    private final String[] values = { "Available", "Gone", "Busy" }; // The statuses of the personel behind the computer
                                                                     // or using the computer / Whether they are here
                                                                     // gone or busy --> I prefered to use gone than
                                                                     // waya hope that doesnt casue issues when I run it
    private final Color[] color = { java.awt.Color.BLACK, java.awt.Color.ORANGE, java.awt.Color.GREEN,
            java.awt.Color.BLUE, java.awt.Color.PINK, java.awt.Color.RED }; // Wanted to implement colors like brown and
                                                                            // purple but couldn't find them
    private final String[] colors = { "Black", "Orange", "Green", "Blue", "Pink", "Red" };
    private final int[] fonts = { Font.PLAIN, Font.ITALIC, Font.BOLD }; // How come I couldn't implement script? Being
                                                                        // limited to the fonts was annoying I went to
                                                                        // google docs to see the different fonts lol
    private final String[] font = { "Plain", "Italic", "Bold" };
    private final String[] themes = { "LightMode", "Darkmode" }; // The tow different modes avaliable

    private JPanel panel;
    private JLabel text;
    private JLabel name;
    private JLabel ttype;
    private JLabel stat;
    private JLabel choosecolor;
    private JLabel IPadLabel;
    private JLabel PortLabel;
    private JLabel MembersLabel;
    private JLabel MessagesLabel;
    private JLabel ComposeLabel;
    private JTextField IPField;
    private JTextField PortField;
    private JTextField NameField;
    private JButton cd;

    private JButton send;
    private JTextArea Members;
    private JTextArea Messages;
    private JTextArea Compose;
    private JComboBox status;
    private JComboBox colorbox;
    private JComboBox fbox;
    private JComboBox theme;

    // Code for Lightmode background
    // Alot of the code below is created for the overall background and design of
    // the server/Client
    // One of options for the background and in this area since we are wanting a
    // lighter color the color will be some sort of a bage white or biege if that is
    // how it is spelled
    public void lightmode() {
        Color rr = new Color(180, 180, 180);
        Color bageWhite = new ColorUIResource(248, 237, 226);
        panel.setBackground(rr);
        text.setForeground(bageWhite);
        name.setForeground(bageWhite);
        ttype.setForeground(bageWhite);
        stat.setForeground(bageWhite);
        choosecolor.setForeground(bageWhite);
        IPadLabel.setForeground(bageWhite);
        PortLabel.setForeground(bageWhite);
        MembersLabel.setForeground(bageWhite);
        MessagesLabel.setForeground(bageWhite);
        ComposeLabel.setForeground(bageWhite);
        IPField.setBackground(bageWhite);
        PortField.setBackground(bageWhite);
        NameField.setBackground(bageWhite);
        cd.setBackground(bageWhite);
        send.setBackground(bageWhite);
        Members.setBackground(bageWhite);
        Messages.setBackground(bageWhite);
        Compose.setBackground(bageWhite);
        status.setBackground(bageWhite);
        colorbox.setBackground(bageWhite);
        fbox.setBackground(bageWhite);
        theme.setBackground(bageWhite);
    }

    // Code for Darkmode background
    // One of options for the background and in this the color will be a dark color
    // most likely black when I decide to provide that dark feature for it
    // Want to make it colorful and different add as many colors as possible
    public void Darkmode() {
        Color bageWhite = new ColorUIResource(82, 130, 118);
        panel.setBackground(java.awt.Color.darkGray);
        text.setForeground(java.awt.Color.PINK);
        name.setForeground(java.awt.Color.GREEN);
        ttype.setForeground(java.awt.Color.PINK);
        stat.setForeground(java.awt.Color.GREEN);
        choosecolor.setForeground(java.awt.Color.PINK);
        IPadLabel.setForeground(java.awt.Color.RED);
        PortLabel.setForeground(java.awt.Color.PINK);
        MembersLabel.setForeground(java.awt.Color.GREEN);
        MessagesLabel.setForeground(java.awt.Color.PINK);
        ComposeLabel.setForeground(java.awt.Color.RED);
        IPField.setBackground(bageWhite);
        PortField.setBackground(bageWhite);
        NameField.setBackground(bageWhite);
        cd.setBackground(bageWhite);
        send.setBackground(bageWhite);
        Members.setBackground(bageWhite);
        Messages.setBackground(bageWhite);
        Compose.setBackground(bageWhite);
        status.setBackground(bageWhite);
        colorbox.setBackground(bageWhite);
        fbox.setBackground(bageWhite);
        theme.setBackground(bageWhite);
    }

    // COde for disconnecting from the server
    // Note for myself:
    // Make sure to include the Server disconnect message as that is what should be
    // shown as stated in direction I believe

    public void disconnect() {

        try {
            pw.close();
            buff.close();
            socket.close();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(new JFrame(), "Server disconnected", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void connect(Integer port, String ip) {

        try {

            socket = new Socket(ip, port);
            pw = new PrintWriter(socket.getOutputStream());
            buff = new BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
            pw.println("SECRET");
            pw.println("3c3c4ac618656ae32b7f3431e75f7b26b1a14a87"); // Server connector
            pw.println("NAME");
            pw.println(NameField.getText() + " (" + values[status.getSelectedIndex()] + ")");
            pw.flush();
            nn = new Messenger(pw, buff, GWackClientGUI.this);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(new JFrame(), "Cannot Connect", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    // Clearing member method
    public void clearmembers() {
        Members.setText("");
    }

    // adding memebers method
    public void addmember(String message) {
        Members.append(message + "\n");
    }

    // adding message method
    public void addmessage(String message) {

        if (theme.getSelectedIndex() == 0) {
            lightmode();

        } else {

            Darkmode();

        }

        Messages.append(message + "\n");
        Color cc = color[colorbox.getSelectedIndex()];
        Messages.setForeground(cc);
        Font type = new Font("Some Font", fonts[fbox.getSelectedIndex()], 12);
        Messages.setFont(type);
    }

    // method for clearing messages
    public void clearmessages() {
        Messages.setText("");
    }

    // Socket --> an endpoint for communication between two machines.
    public Socket getSocket() {
        return socket;
    }

    public void sendmessage() {
        String empty = "";
        if (!empty.equals(Compose.getText())) {
            nn.sms(Compose.getText());
            Compose.setText("");
        }
    }

    private GWackClientGUI() {

        socket = null;
        panel = new JPanel();
        this.setSize(930, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setTitle("GWack -- GW Slack Simulator");
        panel.setLayout(null);
        Color rr = new Color(180, 180, 180);
        Color bageWhite = new ColorUIResource(248, 240, 227);
        panel.setBackground(rr);

        // Status
        status = new JComboBox<>(values);
        status.setBounds(50, 20, 80, 25);
        panel.add(status);
        status.setBackground(bageWhite);
        status.setForeground(rr);

        // ColorBox
        colorbox = new JComboBox<>(colors);
        colorbox.setBounds(230, 20, 80, 25);
        panel.add(colorbox);
        colorbox.setBackground(bageWhite);
        colorbox.setForeground(rr);

        // Fbox
        fbox = new JComboBox<>(font);
        fbox.setBounds(243, 60, 80, 25);
        panel.add(fbox);
        fbox.setBackground(bageWhite);
        fbox.setForeground(rr);

        // themes --> my favorite one
        theme = new JComboBox<>(themes);
        theme.setBounds(50, 60, 120, 25);
        panel.add(theme);
        theme.setBackground(bageWhite);
        theme.setForeground(rr);

        // type
        ttype = new JLabel("Theme");
        ttype.setForeground(java.awt.Color.BLUE);
        ttype.setBounds(0, 60, 80, 25);
        panel.add(ttype);
        ttype.setBackground(bageWhite);
        text = new JLabel("Text Style");
        text.setForeground(java.awt.Color.BLUE);
        text.setBounds(170, 60, 80, 25);
        panel.add(text);
        text.setBackground(bageWhite);
        stat = new JLabel("Status");
        stat.setForeground(java.awt.Color.BLUE);
        stat.setBounds(0, 20, 80, 25);
        panel.add(stat);
        stat.setBackground(bageWhite);
        choosecolor = new JLabel("Choose Color");
        choosecolor.setForeground(java.awt.Color.BLUE);
        choosecolor.setBounds(150, 20, 80, 25);
        panel.add(choosecolor);
        choosecolor.setBackground(bageWhite);
        name = new JLabel("Name");
        name.setForeground(java.awt.Color.BLUE);
        name.setBounds(320, 20, 80, 25);
        panel.add(name);
        name.setBackground(bageWhite);
        IPadLabel = new JLabel("IP Address");
        IPadLabel.setForeground(java.awt.Color.BLUE);
        IPadLabel.setBounds(495, 20, 80, 25);
        panel.add(IPadLabel);
        IPadLabel.setBackground(bageWhite);

        // Port label where is it going but the color of it
        PortLabel = new JLabel("Port");
        PortLabel.setForeground(java.awt.Color.BLUE);
        PortLabel.setBounds(695, 20, 80, 25);
        panel.add(PortLabel);
        PortLabel.setBackground(bageWhite);

        // lets leave the rest black and see how it looks --> Focusing on the decoratin
        // since I have time to spare
        MembersLabel = new JLabel("Members Online");
        MembersLabel.setForeground(java.awt.Color.BLACK);
        MembersLabel.setBounds(0, 150, 150, 25);
        panel.add(MembersLabel);
        MembersLabel.setBackground(bageWhite);

        // Message label
        MessagesLabel = new JLabel("Mesages");
        MessagesLabel.setForeground(java.awt.Color.BLACK);
        MessagesLabel.setBounds(200, 150, 150, 25);
        panel.add(MessagesLabel);
        MessagesLabel.setBackground(bageWhite);

        // compose label --> meassege title
        ComposeLabel = new JLabel("Compose");
        ComposeLabel.setForeground(java.awt.Color.BLACK);
        ComposeLabel.setBounds(200, 420, 150, 25);
        panel.add(ComposeLabel);
        ComposeLabel.setBackground(bageWhite);

        // Name Field
        NameField = new JTextField();
        NameField.setBounds(360, 20, 130, 25);
        panel.add(NameField);
        NameField.setBackground(bageWhite);

        // IPF Feild
        IPField = new JTextField();
        IPField.setBounds(565, 20, 130, 25);
        panel.add(IPField);
        IPField.setBackground(bageWhite);

        // Portfield
        PortField = new JTextField();
        IPField.setBounds(565, 20, 130, 25);
        panel.add(IPField);
        IPField.setBackground(bageWhite);

        PortField = new JTextField();
        PortField.setBounds(730, 20, 80, 25);
        panel.add(PortField);
        PortField.setBackground(bageWhite);

        cd = new JButton("Connect");
        cd.setBounds(820, 20, 100, 25);
        panel.add(cd);
        cd.setBackground(bageWhite);
        cd.setForeground(java.awt.Color.BLACK);

        // Final part the sending haha
        send = new JButton("Send");
        send.setBounds(840, 550, 70, 25);
        panel.add(send);
        send.setBackground(bageWhite);
        send.setForeground(java.awt.Color.BLACK);
        cd.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                if (cd.getText().equals("Connect")) {
                    int value = 0;
                    boolean port = true;

                    if (NameField.getText().equals("")) {
                        JOptionPane.showMessageDialog(new JFrame(), "No Name", "Inane error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    if (PortField.getText().equals("")) {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Port", "Inane error",
                                JOptionPane.ERROR_MESSAGE);
                        port = false;

                    } else {

                        value = Integer.parseInt(PortField.getText());
                    }

                    if ((value == 8886 || value == 8887 || value == 8888)// three ports

                            && (IPField.getText().equals("ssh-cs2113.adamaviv.com")) && (port)) {

                        cd.setText("Disconnect");
                        connect(value, IPField.getText());
                        Members.setEditable(false);
                        Messages.setEditable(false);
                        MessagesLabel.setText("");
                        GWackClientGUI.this.setTitle("GWack -- GW Simulater (Connected)");

                    }

                    if (!(IPField.getText().equals("ssh-cs2113.adamaviv.com"))) {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Host", "Inane error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    if (!(value == 8886 || value == 8887 || value == 8888) && (port)) {// 3 ports
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Port", "Inane error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }

                else {

                    cd.setText("Connect");
                    Members.setEditable(true);
                    Messages.setEditable(true);
                    GWackClientGUI.this.setTitle("GWack -- GW Simulater (Disconnected)");
                    clearmembers();
                    clearmessages();
                    disconnect();

                }
            }
        });

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                sendmessage();
            }
        });

        // Members
        Members = new JTextArea();
        Members.setBounds(0, 170, 180, 345);
        panel.add(Members);
        Members.setBackground(bageWhite);
        Members.setLineWrap(true);
        Members.setWrapStyleWord(true);

        // Messages their box
        Messages = new JTextArea();
        Messages.setBounds(200, 170, 720, 240);
        panel.add(Messages);
        Messages.setBackground(bageWhite);

        // Compose --> box Might want to make this one a different color instead of
        // bageWhite
        Compose = new JTextArea();
        Compose.setBounds(200, 440, 720, 75);
        panel.add(Compose);
        Compose.setBackground(bageWhite);// Find out why my other color s dont work here. did i re implement them or is
                                         // it outside of my fielld
        Compose.setLineWrap(true);
        Compose.setWrapStyleWord(true);

        Compose.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    sendmessage();

                }
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.setVisible(true);
    }

    // Final Part --> My main method
    public static void main(String args[]) {

        // Is the capitilization going to affect em? --> We will see when I run it
        GWackClientGUI Final = new GWackClientGUI();
        Final.setVisible(true);

    }

}

// Signed By Issouf DIarrassouba
// Question why everytime I save in VScode it indents it down ne