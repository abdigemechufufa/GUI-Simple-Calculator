package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author t.me/ag3m3chu
 * 15/03/2021
 */
public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton, clrButton,negButton, infoButton;
    JPanel panel;
    
    double num1=0,num2=0,result=0;
    char operator;
    
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,385);
        frame.setLayout(null);
        frame.setResizable(false);
       
        textfield = new JTextField();
        textfield.setBounds(20, 20, 250, 50);
        textfield.setEditable(false);
        textfield.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        addButton = new JButton("+");
        subButton = new JButton("–");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("<");
        clrButton = new JButton("C");
        negButton = new JButton("±");
        infoButton = new JButton("Info");
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = infoButton;
        for(int i = 0;i<10;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }
        for(int i = 0;i<10;i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
        }
        panel = new JPanel();
        panel.setBounds(20,90,250,250);
        panel.setLayout(new GridLayout(5,4,10,10));
        
        panel.add(infoButton);
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(divButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(mulButton);
        panel.add(negButton);
        panel.add(numberButton[0]);
        panel.add(decButton);
        panel.add(equButton);
        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        for(int i=0;i<10;i++){
            if(ae.getSource() == numberButton[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(ae.getSource() == decButton){
            textfield.setText(textfield.getText().concat("."));
        }
        if(ae.getSource() == addButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(ae.getSource() == subButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(ae.getSource() == mulButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(ae.getSource() == divButton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(ae.getSource() == equButton){
            num2=Double.parseDouble(textfield.getText());
            switch(operator){
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(ae.getSource() == clrButton){
            textfield.setText("");
        }
        if(ae.getSource() == delButton){
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if(ae.getSource() == negButton){
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
        if(ae.getSource() == infoButton){
           JOptionPane.showMessageDialog( null,"author t.me/ag3m3chu"
           );
        }
    }
}
