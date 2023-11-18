package Calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.regex.*;

public class BMI extends Frame_Templete {

    private JTextField weighttext, heightfoot, heightinch, bmitext, conditiontext;
    private JLabel BodyMassIndex, weight, height, Bmi, condition;
    private Font f;
    private JButton enter, clear, home;

    BMI() {
        super.frame();
        super.setTitle("Body Mass Index");
        super.container();
        initcomponents();
    }

    private void initcomponents() {

        Font f = new Font ("Arial",Font.CENTER_BASELINE,30);

        BodyMassIndex = new JLabel("BODY MASS INDEX");
        BodyMassIndex.setBounds(100,15,300,30);
        BodyMassIndex.setFont(f);
        container.add(BodyMassIndex);

        weight = new JLabel("Enter Weight :");
        weight.setBounds(50,70,80,30);
        container.add(weight);

        height = new JLabel("Enter Height :");
        height.setBounds(50,115,300,30);
        container.add(height);

        Bmi = new JLabel("BMI :");
        Bmi.setBounds(50,200,300,30);
        container.add(Bmi);

        condition = new JLabel("Condition :");
        condition.setBounds(50,250,300,30);
        container.add(condition);

        weighttext = new JTextField("Kg");
        weighttext.setBounds(170,73, 195, 30);
        container.add(weighttext);

        heightfoot = new JTextField("Foot");
        heightfoot.setBounds(170,118,90, 30);
        container.add(heightfoot);

        heightinch = new JTextField("Inch");
        heightinch.setBounds(275,118,90, 30);
        container.add(heightinch);

        bmitext = new JTextField();
        bmitext.setBounds(170,205,195, 30);
        bmitext.setEnabled(false);
        container.add(bmitext);

        conditiontext = new JTextField();
        conditiontext.setBounds(170,250,195, 30);
        conditiontext.setEnabled(false);
        container.add(conditiontext);

        enter = new JButton("Enter");
        enter.setBounds(280,162,85,30);
        container.add(enter);

        clear = new JButton("Clear");
        clear.setBounds(170,293,85,30);
        container.add(clear);

        home = new JButton("Home");
        home.setBounds(280,293,85,30);
        container.add(home);

        enter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                if(weighttext.getText().isEmpty() || heightfoot.getText().isEmpty()|| heightinch.getText().isEmpty()||
                        heightfoot.getText().equals("Foot") || heightinch.getText().equals("Inch") ||weighttext.getText().equals("Kg")){
                    JOptionPane.showMessageDialog(null,"Enter all value");
                }
                else{

                    if(checkPointWeight()==true && checkPointHeightInch()==false && checkPointHeightFoot()==false){
                        JOptionPane.showMessageDialog(null,"Weight input is invalid");
                        weighttext.setText("");
                        bmitext.setText("");
                        conditiontext.setText("");
                    }

                    else if(checkPointHeightFoot()==true && checkPointHeightInch()==false && checkPointWeight()==false){
                        JOptionPane.showMessageDialog(null,"Height foot input is invalid");
                        heightfoot.setText("");
                        bmitext.setText("");
                        conditiontext.setText("");
                    }

                    else if(checkPointHeightInch()==true && checkPointHeightFoot()==false && checkPointWeight()==false){
                        JOptionPane.showMessageDialog(null,"Height inch input is invalid");
                        heightinch.setText("");
                        bmitext.setText("");
                        conditiontext.setText("");
                    }

                    else if(checkPointHeightInch()==true && checkPointHeightFoot()==true && checkPointWeight()==false){
                        JOptionPane.showMessageDialog(null,"Height foot & inch input is invalid");
                        heightinch.setText("");
                        heightfoot.setText("");
                        bmitext.setText("");
                        conditiontext.setText("");
                    }

                    else if(checkPointHeightInch()==true && checkPointHeightFoot()==false && checkPointWeight()==true){
                        JOptionPane.showMessageDialog(null,"Weight & height inch input is invalid");
                        heightinch.setText("");
                        weighttext.setText("");
                        bmitext.setText("");
                        conditiontext.setText("");
                    }

                    else if(checkPointHeightInch()==false && checkPointHeightFoot()==true && checkPointWeight()==true){
                        JOptionPane.showMessageDialog(null,"Weight & height foot input is invalid");
                        heightfoot.setText("");
                        weighttext.setText("");
                        bmitext.setText("");
                        conditiontext.setText("");
                    }

                    else{
                        try{

                            Double Weight = Double.parseDouble(weighttext.getText());
                            Double Height_Foot = Double.parseDouble(heightfoot.getText());
                            Double Height_Inch = Double.parseDouble(heightinch.getText());

                            Double Foot_to_meter = (Height_Foot * 0.3048 );
                            Double Inch_to_meter = (Height_Inch * 0.0254) ;
                            Double Meter = (Foot_to_meter + Inch_to_meter) ;

                            Double BMI =  Weight / ( Meter * Meter );
                            bmitext.setText(String.valueOf(BMI));

                            if (BMI<18.5)
                                conditiontext.setText("UnderWeight");
                            else if (BMI>18.5 && BMI<24.9)
                                conditiontext.setText("Normal");
                            else if (BMI>25 && BMI<29.9)
                                conditiontext.setText("OverWeight");
                            else if (BMI>30 && BMI<34.9)
                                conditiontext.setText("Medical Obese");
                            else if (BMI>35 && BMI<40)
                                conditiontext.setText("Extremer Obese");
                            else{
                                conditiontext.setText("Input are not logical");
                            }
                            bmitext.setEnabled(true);
                            conditiontext.setEnabled(true);
                        }
                        catch(Exception e1){
                            JOptionPane.showMessageDialog(null,"Your input is not valid");
                            weighttext.setText("");
                            heightfoot.setText("");
                            heightinch.setText("");
                        }
                    }
                }
            }
        });


        clear.addActionListener(new ActionListener(){
            public void actionPerformed ( ActionEvent e){
                weighttext.setText("");
                heightfoot.setText("");
                heightinch.setText("");
                bmitext.setText("");
                conditiontext.setText("");

                bmitext.setEnabled(false);
                conditiontext.setEnabled(false);
            }
        });

        home.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                Layout lay= new Layout ();
                lay.setVisible(true);
                dispose();
            }
        });

        weighttext.addFocusListener(new FocusListener (){
            @Override
            public void focusGained(FocusEvent fe) {

                if(weighttext.getText().equals("Kg"))
                {
                    weighttext.setText("");
                    weighttext.setForeground(new Color(0,0,0));

                }
            }
            @Override
            public void focusLost(FocusEvent fe) {
                if(weighttext.getText().equals(""))
                {
                    weighttext.setText("Kg");
                    weighttext.setForeground(new Color(0,0,0));
                }
            }
        });

        heightfoot.addFocusListener(new FocusListener (){
            @Override
            public void focusGained(FocusEvent fe) {
                if(heightfoot.getText().equals("Foot"))
                {
                    heightfoot.setText("");
                    heightfoot.setForeground(new Color(0,0,0));
                }
            }
            @Override
            public void focusLost(FocusEvent fe) {
                if(heightfoot.getText().equals(""))
                {
                    heightfoot.setText("Foot");
                    heightfoot.setForeground(new Color(0,0,0));
                }
            }
        });

        heightinch.addFocusListener(new FocusListener (){
            @Override
            public void focusGained(FocusEvent fe) {

                if(heightinch.getText().equals("Inch"))
                {
                    heightinch.setText("");
                    heightinch.setForeground(new Color(0,0,0));
                }
            }
            @Override
            public void focusLost(FocusEvent fe) {
                if(heightinch.getText().equals(""))
                {
                    heightinch.setText("Inch");
                    heightinch.setForeground(new Color(0,0,0));
                }
            }
        });
    }
    boolean checkPointHeightFoot(){

        String inputString = heightfoot.getText();
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(inputString);

        boolean isStringContainsSpecialCharacter = matcher.find();

        if (isStringContainsSpecialCharacter)
            return false;
        else
            return true;
    }

    boolean checkPointHeightInch(){

        String inputString = heightinch.getText();
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(inputString);

        boolean isStringContainsSpecialCharacter = matcher.find();

        if (isStringContainsSpecialCharacter)
            return false;
        else
            return true;
    }
    boolean checkPointWeight(){

        String inputString = weighttext.getText();
        Pattern pattern = Pattern.compile("^[+]?[0-9]*(?:\\.[0-9]*)?$");
        Matcher matcher = pattern.matcher(inputString);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if (isStringContainsSpecialCharacter)
            return false;
        else
            return true;
    }
}