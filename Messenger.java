
//Issouf  Diarrassouba --> I apologize just like to sign off on everything 
import java.io.BufferedReader;
import java.io.PrintWriter;

public class Messenger {

    private PrintWriter pw;// PW -> Printwriter --> class used to write any form of data
    private threadReader threadR;// threadReader --> reading thread
    private BufferedReader br;// BR --> Buffered Reader

    // Method for class in the
    public Messenger(PrintWriter pw, BufferedReader br, GWackClientGUI GUI) {

        this.br = br;
        this.pw = pw;
        this.threadR = new threadReader(pw, br, GUI);
        threadR.start();
    }

    public void sms(String s) {

        pw.println(s);
        pw.flush();

    }
}

// Signed By Issouf Diarrassouba