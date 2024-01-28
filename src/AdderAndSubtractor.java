import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AdderAndSubtractor extends JFrame {

    public static Operator operator = Operator.NONE;
    public static ButtonType lastButtonType = ButtonType.Number;
    public static int oldNumber = 0;
    public AdderAndSubtractor() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextField text = new JTextField("0");
        text.setEditable(false);
        mainPanel.add(text, BorderLayout.NORTH);

        JPanel keypad = new JPanel();
        keypad.setLayout(new GridLayout(4, 3));

        JButton button7 = new JButton("7");
        button7.addActionListener(new ButtonEvent(text));
        keypad.add(button7);
        JButton button8 = new JButton("8");
        button8.addActionListener(new ButtonEvent(text));
        keypad.add(button8);
        JButton button9 = new JButton("9");
        button9.addActionListener(new ButtonEvent(text));
        keypad.add(button9);
        JButton button4 = new JButton("4");
        button4.addActionListener(new ButtonEvent(text));
        keypad.add(button4);
        JButton button5 = new JButton("5");
        button5.addActionListener(new ButtonEvent(text));
        keypad.add(button5);
        JButton button6 = new JButton("6");
        button6.addActionListener(new ButtonEvent(text));
        keypad.add(button6);
        JButton button1 = new JButton("1");
        button1.addActionListener(new ButtonEvent(text));
        keypad.add(button1);
        JButton button2 = new JButton("2");
        button2.addActionListener(new ButtonEvent(text));
        keypad.add(button2);
        JButton button3 = new JButton("3");
        button3.addActionListener(new ButtonEvent(text));
        keypad.add(button3);
        keypad.add(new JPanel());
        JButton button0 = new JButton("0");
        button0.addActionListener(new ButtonEvent(text));
        keypad.add(button0);
        keypad.add(new JPanel());

        JPanel allKeys = new JPanel();
        allKeys.add(keypad);

        JPanel operatorButton = new JPanel();
        operatorButton.setLayout(new GridLayout(4, 1));

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ButtonEvent(text));
        operatorButton.add(clearButton);

        JButton add = new JButton("+");
        add.addActionListener(new ButtonEvent(text));
        operatorButton.add(add);

        JButton subtract = new JButton("-");
        subtract.addActionListener(new ButtonEvent(text));
        operatorButton.add(subtract);

        JButton equal = new JButton("=");
        equal.addActionListener(new ButtonEvent(text));
        operatorButton.add(equal);

        allKeys.add(operatorButton);

        mainPanel.add(allKeys, BorderLayout.CENTER);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        AdderAndSubtractor app = new AdderAndSubtractor();
        app.setVisible(true);
    }

    private static class ButtonEvent implements ActionListener {
        private final JTextField textField;

        public ButtonEvent(JTextField textField) {
            this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Clear" -> {
                    textField.setText("0");
                    oldNumber = 0;
                    lastButtonType = ButtonType.Number;
                    operator = Operator.NONE;
                }
                case "+" -> {

                    if (!lastButtonType.equals(ButtonType.Operator)) {
                        if (operator.equals(Operator.ADD)) {
                            textField.setText(String.valueOf(oldNumber + Integer.parseInt(textField.getText())));
                        } else if (operator.equals(Operator.SUBTRACT)) {
                            textField.setText(String.valueOf(oldNumber - Integer.parseInt(textField.getText())));
                        }
                    }
                    oldNumber = Integer.parseInt(textField.getText());
                    operator = Operator.ADD;
                    lastButtonType = ButtonType.Operator;
                }
                case "-" -> {
                    if (!lastButtonType.equals(ButtonType.Operator)) {
                        if (operator.equals(Operator.ADD)) {
                            textField.setText(String.valueOf(oldNumber + Integer.parseInt(textField.getText())));
                        } else if (operator.equals(Operator.SUBTRACT)) {
                            textField.setText(String.valueOf(oldNumber - Integer.parseInt(textField.getText())));
                        }
                    }
                    oldNumber = Integer.parseInt(textField.getText());
                    operator = Operator.SUBTRACT;
                    lastButtonType = ButtonType.Operator;
                }
                case "=" -> {
                    if (operator.equals(Operator.ADD)) {
                        textField.setText(String.valueOf(oldNumber + Integer.parseInt(textField.getText())));
                    }
                    else if (operator.equals(Operator.SUBTRACT)) {
                        textField.setText(String.valueOf(oldNumber - Integer.parseInt(textField.getText())));
                    }
                    operator = Operator.NONE;
                    lastButtonType = ButtonType.Number;
                }
                default -> {
                    textField.setText((textField.getText().equals("0") || lastButtonType.equals(ButtonType.Operator)) ? e.getActionCommand() : textField.getText() + e.getActionCommand());
                    lastButtonType = ButtonType.Number;
                }
            }
        }
    }

    public enum Operator {
        ADD,
        SUBTRACT,
        NONE
    }
    public enum ButtonType {
        Operator,
        Number
    }
}