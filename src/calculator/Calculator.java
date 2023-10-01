package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    // Components
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;

    // Variables
    private double firstNumber = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;

    public Calculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new GridLayout(5,4 ));

        display = new JTextField();
        display.setEditable(false);
        add(display);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            add(numberButtons[i]);
        }

        operationButtons = new JButton[4];
        operationButtons[0] = new JButton("+");
        operationButtons[1] = new JButton("-");
        operationButtons[2] = new JButton("*");
        operationButtons[3] = new JButton("/");
        for (int i = 0; i < 4; i++) {
            operationButtons[i].addActionListener(this);
            add(operationButtons[i]);
        }

        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        add(equalsButton);

        clearButton = new JButton("C");
        clearButton.addActionListener(this);
        add(clearButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (Character.isDigit(command.charAt(0))) {
            if (isOperatorClicked) {
                display.setText(command);
                isOperatorClicked = false;
            } else {
                display.setText(display.getText() + command);
            }
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            if (!operator.isEmpty()) {
                calculate();
            }
            firstNumber = Double.parseDouble(display.getText());
            operator = command;
            isOperatorClicked = true;
        } else if (command.equals("=")) {
            calculate();
        } else if (command.equals("C")) {
            display.setText("");
            firstNumber = 0;
            operator = "";
        }
    }

    private void calculate() {
        double secondNumber = Double.parseDouble(display.getText());
        double result = 0;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    display.setText("Error");
                    return;
                }
                break;
        }
        display.setText(String.valueOf(result));
        operator = "";
    }
}
