package Calculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Layout extends Frame_Templete {

    private JButton calculator, loan, convert, bmi;
    private JLabel label;

    Layout(){
        super.frame();
        super.container();
        super.setTitle("Home");
        initcomponents();
    }

    public void initcomponents() {

        Font f = new Font("Arial", Font.CENTER_BASELINE, 30);
        Font f1 = new Font("Arial", Font.BOLD, 13);
        label = new JLabel("Reckoner");
        label.setBounds(180, 15, 200, 35);
        label.setFont(f);
        super.container.add(label);

        calculator = new JButton("Simple Calculator");
        calculator.setBounds(100, 70, 300, 35);
        calculator.setFont(f1);
        container.add(calculator);

        loan = new JButton("Loan Calculator");
        loan.setBounds(100, 120, 300, 35);
        loan.setFont(f1);
        container.add(loan);

        convert = new JButton("Converter");
        convert.setBounds(100, 170, 300, 35);
        convert.setFont(f1);
        container.add(convert);

        bmi = new JButton("Body Mass Index");
        bmi.setBounds(100, 220, 300, 35);
        bmi.setFont(f1);
        container.add(bmi);

        calculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_Calculator calcu = new Main_Calculator();
                calcu.setVisible(true);
                dispose();
            }
        });

        loan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loan_Calculator loan = new Loan_Calculator();
                loan.setVisible(true);
                dispose();
            }
        });

        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Converter convert = new Converter();
                convert.setVisible(true);
                dispose();
            }
        });

        bmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BMI bmi = new BMI();
                bmi.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Layout lay = new Layout();
        lay.setVisible(true);
    }
}