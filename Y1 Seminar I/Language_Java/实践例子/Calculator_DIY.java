package finalHomework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class diyCalc extends JFrame implements ActionListener {

//    filed to display numbers
    private JTextField tf;
//    whether if the calculator is start
    private boolean start;
//    result number
    private double result;
//    last command
    private String lastCommand;

//    calculator i
    private diyCalc(String title){
        setTitle(title);
        setSize(300,200);
//        way to exit
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        JPanel
        JPanel p = new JPanel();
//        JButtons 16 = 4*4
        JButton[] b = new JButton[16];

//        components : display
        tf = new JTextField(20);
//        align to right
        tf.setHorizontalAlignment(JTextField.RIGHT);
//        TextField location
        add(tf, BorderLayout.NORTH);
//        buttons name
        String[] name = {"1","2","3","+",
                         "4","5","6","-",
                         "7","8","9","*",
                         "0",".","=","/",
        };
//        Grid layout 4x4
        p.setLayout(new GridLayout(4,4));
//        name JButton + ActionListener + add these to JPanel
        for (int i=0; i< name.length ; i++){
            b[i] = new JButton(name[i]);
            b[i].addActionListener(this);
            p.add(b[i]);
        }

//        add JPanel
        add(p,BorderLayout.CENTER);

//        initialize property
        result = 0;
        lastCommand = "=";
        start = true;

    }

//    solve command + display
    private void calculate(double x){

        switch (lastCommand){
            case "+":
                result += x; break;
            case "-":
                result -= x; break;
            case "*":
                result *= x; break;
            case "/":
                result /= x; break;
            case "=":
                result = x;  break;
        }
        // double -> String
        tf.setText(result + "");
    }

//  actions of buttons
    private void commandAction(String command){
//        negative number
        if (start){
            if (command.equals("-")){
                tf.setText(command);
                start = false;
            }else {
                lastCommand = command;
            }
        }else {
            calculate(Double.parseDouble(tf.getText()));
            lastCommand = command;
            start = true;
        }
    }

    private void insertAction(String input){
//        start ? initialize the text field
        if (start){
            tf.setText("");
            start = false;
        }
//        string joint
        tf.setText(tf.getText() + input);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        figure out which button is pressed
        String btnText = e.getActionCommand();
//        all possible chars
        String insert = "1234567890.";

        if (insert.contains(btnText)){
//            number / dot
            insertAction(btnText);

//            operators
        }else {
            commandAction(btnText);
        }
    }


    public static void main(String[] args) {
        diyCalc c = new diyCalc("test");
//        visible !
        c.setVisible(true);
    }

}
