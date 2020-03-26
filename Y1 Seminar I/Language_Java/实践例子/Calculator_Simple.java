package finalHomework;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calc extends JFrame implements ActionListener {
    private String lastCommand;
    private double result;
    private boolean start;
    private JTextField tf;
    Calc(String s){
        setTitle(s);
        setVisible(true);
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        JButton[] b =new JButton[16];

        tf = new JTextField(20);
        tf.setHorizontalAlignment(JTextField.RIGHT);

        add(tf, BorderLayout.NORTH);

        String[] name = {"1","2","3","+",
                "4","5","6","-",
                "7","8","9","*",
                "0",".","=","/",
        };

        p.setLayout(new GridLayout(4,4));

        for (int i = 0 ; i< name.length ; i++){
            b[i] = new JButton(name[i]);
            b[i].addActionListener(this);
            p.add(b[i]);
        }

        add(p, BorderLayout.CENTER);

        result = 0;
        lastCommand = "=";
        start = true;

    }

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
        tf.setText(result+"");

    }

    private void insertAction(String input){
        if (start){
            tf.setText("");
            start = false;
        }

        tf.setText(tf.getText() + input );
    }

    private void commandAction(String command){
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
    public void actionPerformed(ActionEvent e){
        String btnText = e.getActionCommand();
        String insert = "1234567890.";

        if (insert.contains(btnText)){
            insertAction(btnText);
        }else{
            commandAction(btnText);
        }
    }

    public static void main(String[] args) {
        Calc c = new Calc("nice");

    }


}
