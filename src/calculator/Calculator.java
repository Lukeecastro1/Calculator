/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;
import java.awt.*;
import java.awt.event.ActionEvent;
/**
 *
 * @author User
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame frame = new Frame("Simple Calculator");
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setName("Simple Calculator");
        
        TextField text1 = new TextField();
        text1.setName("num1TextField");
        text1.setBounds(100, 50, 130, 30);
        
        TextField text2 = new TextField();
        text2.setName("num2TextField");
        text2.setBounds(300, 50, 130, 30);
        
        Choice c = new Choice();
        c.setBounds(100,90,100,40);
        c.setName("operationsChoice");
        c.add("+");
        c.add("-");
        c.add("*");
        c.add("/");
        
        Button b = new Button("Compute Result");
        b.setName("computeButton");
        b.setBounds(100,150,90,30);
        
        Label l = new Label("");
        l.setName("resultLabel");
        l.setBounds(100,200,200,30);
        
        b.addActionListener((ActionEvent e)->{
            int num1 = Integer.parseInt(text1.getText());
            int num2 = Integer.parseInt(text2.getText());
            String operation = c.getSelectedItem();
            int result = 0;
            
            switch(operation){
                case "+":
                result = num1 + num2;
                break;
                case "-":
                result = num1 - num2;
                break;
                case "*":
                result = num1 * num2;
                break;
                case "/":
                result = num1 / num2;
                break;
            }
            l.setText(String.valueOf(result));
        });
        
        frame.add(l);
        frame.add(b);
        frame.add(c);
        frame.add(text1);
        frame.add(text2);
        frame.setVisible(true);
    }
    
}
