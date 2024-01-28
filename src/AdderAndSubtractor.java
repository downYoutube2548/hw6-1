import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class AdderAndSubtractor extends JFrame {
    public AdderAndSubtractor() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextField text = new JTextField("0");
        mainPanel.add(text, BorderLayout.NORTH);

        JPanel keypad = new JPanel();
        keypad.setLayout(new GridLayout(3, 3));

        JButton button7 = new JButton("7");
        keypad.add(button7);
        JButton button8 = new JButton("8");
        keypad.add(button8);
        JButton button9 = new JButton("9");
        keypad.add(button9);
        JButton button4 = new JButton("4");
        keypad.add(button4);
        JButton button5 = new JButton("5");
        keypad.add(button5);
        JButton button6 = new JButton("6");
        keypad.add(button6);
        JButton button1 = new JButton("1");
        keypad.add(button1);
        JButton button2 = new JButton("2");
        keypad.add(button2);
        JButton button3 = new JButton("3");
        keypad.add(button3);

        JPanel allKeys = new JPanel();
        allKeys.add(keypad);

        JButton clearButton = new JButton("Clear");
        allKeys.add(clearButton);

        mainPanel.add(allKeys, BorderLayout.CENTER);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        AdderAndSubtractor app = new AdderAndSubtractor();
        app.setVisible(true);
    }
}