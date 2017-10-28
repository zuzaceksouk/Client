import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Trida pro praci s grafickym rozhranim
 */
public class Gui extends JFrame {
    private JLabel butLab;
    private JButton saveBut;
    private JTextField login;
    private JPanel panel1;
    private JPanel panel2;
    private JButton sectiBut[];
    private JLabel notificLab;
    private int counter;

    public Gui() {
        super("Pexeso"); //parametr je titulek okna
    }

    public void leadingGui() {
        counter = 0;
        setLoginWindow();
        showWindow();

        //makeLayout();
        pauseToRead();

        notificLab.setText("Hotovo");
        /*
        hideWindow();
        setGameWindow();
        showWindow();*/

    }

    /**
     * pozastavi vlakno na 5 sekund
     */
    public void pauseToRead() {

        try {
            // počkat 5 sekund
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // NOP
        }
    }

    /**
     * Vykresli okno a nastavi zakladni moznosti
     */
    public  void showWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300, 200);
        setLocationRelativeTo(null);
    }

    public void hideWindow() {
        setVisible(false);
        getContentPane().removeAll();
    }

    public void setLoginWindow() {
        panel1 = new JPanel();
        add(panel1);

        panel2 = new JPanel();
        add(panel2);

        butLab = new JLabel("Zadej login: ");
        panel1.add(butLab);

        login = new JTextField(5);
        panel1.add(login);

        saveBut = new JButton("Save");
        panel2.add(saveBut);

        notificLab = new JLabel();
        add(notificLab);

        EventSave eventSave = new EventSave();
        saveBut.addActionListener(eventSave);


        FlowLayout layout = new FlowLayout();
        setLayout(layout);
    }


    public void setGameWindow() {
        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(4, 4));

        sectiBut = new JButton[16];

        for (int i = 0; i < 16 ; i++) {
            sectiBut[i] = new JButton();
            pane.add(sectiBut[i]);

        }

    }
    class EventSave implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String jmeno;
            if (counter  > 0) {
                notificLab.setText("Login už byl zadán");
            }
            else {
                jmeno = login.getText();
                System.out.println(jmeno);

                counter++;
            }

            // hideWindow();
        }
    }
}
