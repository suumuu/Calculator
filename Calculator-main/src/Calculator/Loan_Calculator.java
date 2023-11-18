package Calculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.regex.*;

public class Loan_Calculator extends Frame_Templete{

    private JTextField amounttext , interesttext , monthtext , totaltext , paymenttext ;
    private JLabel loancalculator , amount , interest , month  ,total  , payment;
    private JButton enter , clear ,home;
    private Font font , f1;

    Loan_Calculator(){
        super.frame();
        super.container();
        super.setTitle("Loan Calculator");
        initcomponent();
    }
    private void initcomponent() {

        Font font   = new Font ("Arial",Font.CENTER_BASELINE,30);

        loancalculator = new JLabel("Loan Calculator");
        loancalculator.setBounds(140,15,300,30);
        loancalculator.setFont(font);
        container.add(loancalculator);

        amount = new JLabel("Loan Amount               :");
        amount.setBounds(50,70,130,30);
        container.add(amount);

        interest = new JLabel("Interest Rate (%)         :");
        interest.setBounds(50,115,130,30);
        container.add(interest);

        month = new JLabel("Month                            :");
        month.setBounds(50,160,130,30);
        container.add(month);

        total = new JLabel("Total Payment             :");
        total.setBounds(50,240,130,30);
        container.add(total);

        payment = new JLabel("Payment Per Month   :");
        payment.setBounds(50,285,130,40);
        container.add(payment);

        amounttext = new JTextField();
        amounttext.setBounds(190,73, 195, 25);
        amounttext.setFont(f1);
        container.add(amounttext);

        interesttext = new JTextField();
        interesttext.setBounds(190,118,195, 25);
        interesttext.setFont(f1);
        container.add(interesttext);

        monthtext = new JTextField();
        monthtext.setBounds(190,163,195, 25);
        monthtext.setFont(f1);
        container.add(monthtext);

        totaltext = new JTextField();
        totaltext.setBounds(190,245,195, 25);
        totaltext.setEnabled(false);
        totaltext.setFont(f1);
        container.add(totaltext);

        paymenttext = new JTextField();
        paymenttext.setBounds(190,293,195, 25);
        paymenttext.setEnabled(false);
        paymenttext.setFont(f1);
        container.add(paymenttext);

        enter = new JButton("Enter");
        enter.setBounds(300,205,85,25);
        container.add(enter);

        clear = new JButton("Clear");
        clear.setBounds(190,330,85,25);
        container.add(clear);

        home = new JButton("Home");
        home.setBounds(300,330,85,25);
        container.add(home);

        enter.addActionListener(new ActionListener(){

            public void actionPerformed ( ActionEvent e){
                if(amounttext.getText().isEmpty() || interesttext.getText().isEmpty() ||  monthtext.getText().isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Enter all value");
                }

                else {
                    if(checkMonth()==true && checkLoan()==false && checkInterest()==false){
                        JOptionPane.showMessageDialog(null, "Month input is invalid");
                        monthtext.setText("");
                        totaltext.setText("");
                        paymenttext.setText("");
                    }

                    else if(checkMonth()==false && checkLoan()==true && checkInterest()==false){
                        JOptionPane.showMessageDialog(null, "Loan input is invalid");
                        amounttext.setText("");
                        totaltext.setText("");
                        paymenttext.setText("");
                    }

                    else if(checkMonth()==false && checkLoan()==false && checkInterest()==true){
                        JOptionPane.showMessageDialog(null, "Interest input is invalid");
                        interesttext.setText("");
                        totaltext.setText("");
                        paymenttext.setText("");
                    }

                    else if(checkMonth()==true && checkLoan()==true && checkInterest()==false){
                        JOptionPane.showMessageDialog(null, "Loan & Month input is invalid");
                        monthtext.setText("");
                        amounttext.setText("");
                        totaltext.setText("");
                        paymenttext.setText("");
                    }

                    else if(checkMonth()==true && checkLoan()==false && checkInterest()==true){
                        JOptionPane.showMessageDialog(null, "Interest & Month input is invalid");
                        monthtext.setText("");
                        interesttext.setText("");
                        totaltext.setText("");
                        paymenttext.setText("");
                    }

                    else if(checkMonth()==false && checkLoan()==true && checkInterest()==true){
                        JOptionPane.showMessageDialog(null, "Loan & Interest input is invalid");
                        amounttext.setText("");
                        interesttext.setText("");
                        totaltext.setText("");
                        paymenttext.setText("");
                    }

                    else{
                        try {
                            double totalamount = 0;
                            double Loan_Amount = Double.parseDouble(amounttext.getText());
                            double Interest_Rate = Double.parseDouble(interesttext.getText());
                            double Month = Double.parseDouble(monthtext.getText());

                            totalamount = Loan_Amount + Loan_Amount * Interest_Rate / 100;
                            totaltext.setText(String.valueOf(totalamount));

                            double payment_per_month = 0;
                            payment_per_month = (totalamount / Month);
                            paymenttext.setText(String.valueOf(payment_per_month));

                            totaltext.setEnabled(true);
                            paymenttext.setEnabled(true);
                            totaltext.setEditable(false);
                            paymenttext.setEditable(false);
                        }
                        catch (Exception e1){

                            JOptionPane.showMessageDialog(null, "your input is not valid");
                            totaltext.setText("");
                            paymenttext.setText("");
                            amounttext.setText("");
                            interesttext.setText("");
                            monthtext.setText("");
                        }
                    }
                }
            }
        });

        clear.addActionListener(new ActionListener(){
            public void actionPerformed ( ActionEvent e){

                amounttext.setText("");
                interesttext.setText("");
                monthtext.setText("");
                totaltext.setText("");
                paymenttext.setText("");
                totaltext.setEnabled(false);
                paymenttext.setEnabled(false);
            }
        });

        home.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                Layout layout= new Layout ();
                layout.setVisible(true);
                dispose();
            }
        });
    }

    boolean checkMonth(){
        String inputString = monthtext.getText();
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(inputString);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if (isStringContainsSpecialCharacter)
            return false;
        else
            return true;
    }

    boolean checkLoan(){

        String inputString = amounttext.getText();
        Pattern pattern = Pattern.compile("^[+]?[0-9]*(?:\\.[0-9]*)?$");
        Matcher matcher = pattern.matcher(inputString);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if (isStringContainsSpecialCharacter)
            return false;
        else
            return true;
    }

    
    boolean checkInterest(){

        String inputString = interesttext.getText();
        Pattern pattern = Pattern.compile("^[+]?[0-9]*(?:\\.[0-9]*)?$");
        Matcher matcher = pattern.matcher(inputString);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if (isStringContainsSpecialCharacter)
            return false;
        else
            return true;
    }
}