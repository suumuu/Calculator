package Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.regex.*;

public class Converter extends Frame_Templete {

    private JLabel converter, from, to;
    private JTextField display, result;
    private JButton enter, home, clear;
    private JComboBox combo1, combo2;
    private String[] fromcombo = {"Inch", "Foot", "Miles", "Centimeter", "Meter", "Kilometer"};
    private String[] tocombo = {"Inch", "Foot", "Miles", "Centimeter", "Meter", "Kilometer"};

    Converter() {
        super.frame();
        super.setTitle("Converter");
        super.container();
        initcomponents();
    }

    private void initcomponents() {

        Font f = new Font("Arial", Font.CENTER_BASELINE, 30);
        Font f1 = new Font("Arial", Font.BOLD, 15);

        converter = new JLabel("Converter");
        converter.setBounds(175, 20, 300, 25);
        converter.setFont(f);
        container.add(converter);

        display = new JTextField();
        display.setBounds(105, 65, 280, 35);
        container.add(display);

        from = new JLabel("From");
        from.setBounds(105, 115, 300, 25);
        from.setFont(f1);
        container.add(from);

        to = new JLabel("To");
        to.setBounds(275, 115, 300, 25);
        to.setFont(f1);
        container.add(to);

        combo1 = new JComboBox(fromcombo);
        combo1.setBounds(105, 155, 110, 30);
        combo1.setEditable(false);
        combo1.setSelectedIndex(0);
        container.add(combo1);

        combo2 = new JComboBox(tocombo);
        combo2.setBounds(275, 155, 110, 30);
        combo2.setEditable(false);
        combo2.setSelectedIndex(0);
        container.add(combo2);

        enter = new JButton("Convert");
        enter.setBounds(305, 205, 80, 30);
        container.add(enter);

        result = new JTextField();
        result.setBounds(105, 255, 280, 35);
        result.setEnabled(false);
        result.setFont(f1);
        container.add(result);

        home = new JButton("Home");
        home.setBounds(220, 310, 80, 30);
        container.add(home);

        clear = new JButton("Clear");
        clear.setBounds(305, 310, 80, 30);
        container.add(clear);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                result.setText("");
                result.setEnabled(false);
            }
        });

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Layout lay = new Layout();
                lay.setVisible(true);
                dispose();
            }
        });

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (display.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter value");

                }
                else {

                    if(checkDisplay()==true)
                        {
                            JOptionPane.showMessageDialog(null,"your input is invalid");
                            display.setText("");
                            result.setText("");
                            result.setEnabled(false);

                        }
                        
                    else{

                    try {

                        int from_value = combo1.getSelectedIndex();
                        int to_value = combo2.getSelectedIndex();
                        double output;
                        double xyz = Double.parseDouble(display.getText());
                        if (from_value == 0) {
                            if (to_value == 0) {
                                output = (xyz * 1);
                                result.setText("" + output + "  Inch");
                            }
                            if (to_value == 1) {
                                output = (xyz * 0.08333);
                                result.setText("" + output + "  Foot");

                            }
                            if (to_value == 2) {
                                output = (xyz * .00001578282);
                                result.setText("" + output + "  Mile");
                            }
                            if (to_value == 3) {
                                output = (xyz * 2.54);
                                result.setText("" + output + "  Centimeter");
                            }
                            if (to_value == 4) {
                                output = (xyz * .0254);
                                result.setText("" + output + "  Meter");
                            }
                            if (to_value == 5) {
                                output = (xyz * 0.0000254);
                                result.setText("" + output + "  Kilometer");
                            }
                        }
                        else if (from_value == 1) {
                            if (to_value == 0) {
                                output = (xyz * 12);
                                result.setText("" + output + "  Inch");
                            }
                            if (to_value == 1) {
                                output = (xyz * 1);
                                result.setText("" + output + "  Foot");
                            }
                            if (to_value == 2) {
                                output = (xyz * 0.000189393939);
                                result.setText("" + output + "  Mile");
                            }
                            if (to_value == 3) {
                                output = (xyz * 30.48);
                                result.setText("" + output + "  Centimeter");
                            }
                            if (to_value == 4) {
                                output = (xyz * 0.3048);
                                result.setText("" + output + "  Meter");
                            }
                            if (to_value == 5) {
                                output = (xyz * 0.0003048);
                                result.setText("" + output + "  Kilometer");
                            }
                        }
                        else if (from_value == 2) {
                            if (to_value == 0) {
                                output = (xyz * 63364);
                                result.setText("" + output + "  Inch");
                            }
                            if (to_value == 1) {
                                output = (xyz * 5280);
                                result.setText("" + output + "  Foot");
                            }
                            if (to_value == 2) {
                                output = (xyz * 1);
                                result.setText("" + output + "  Mile");
                            }
                            if (to_value == 3) {
                                output = (xyz * 160934.4);
                                result.setText("" + output + "  Centimeter");

                            }
                            if (to_value == 4) {
                                output = (xyz * 1609.344);
                                result.setText("" + output + "  Meter");
                            }
                            if (to_value == 5) {
                                output = (xyz * 1.609344);
                                result.setText("" + output + "  Kilometer");
                            }
                        }
                        else if (from_value == 3) {
                            if (to_value == 0) {
                                output = (xyz * 0.393700787);
                                result.setText("" + output + "  Inch");
                            }
                            if (to_value == 1) {
                                output = (xyz * 0.032808399);
                                result.setText("" + output + "  Foot");
                            }
                            if (to_value == 2) {
                                output = (xyz * 0.000006214);
                                result.setText("" + output + "  Mile");
                            }
                            if (to_value == 3) {
                                output = (xyz * 1);
                                result.setText("" + output + "  Centimeter");
                            }
                            if (to_value == 4) {
                                output = (xyz * 0.01);
                                result.setText("" + output + "  Meter");
                            }
                            if (to_value == 5) {
                                output = (xyz * 0.0001);
                                result.setText("" + output + "  Kilometer");
                            }
                        }
                        else if (from_value == 4) {
                            if (to_value == 0) {
                                output = (xyz * 39.3700787);
                                result.setText("" + output + "  Inch");
                            }
                            if (to_value == 1) {
                                output = (xyz * 3.2808399);
                                result.setText("" + output + "  Foot");
                            }
                            if (to_value == 2) {
                                output = (xyz * 0.0006214);
                                result.setText("" + output + "  Mile");
                            }
                            if (to_value == 3) {
                                output = (xyz * 100);
                                result.setText("" + output + "  Centimeter");
                            }
                            if (to_value == 4) {
                                output = (xyz * 1);
                                result.setText("" + output + "  Meter");
                            }
                            if (to_value == 5) {
                                output = (xyz * 0.001);
                                result.setText("" + output + "  Kilometer");
                            }
                        }
                        else if (from_value == 5) {
                            if (to_value == 0) {
                                output = (xyz * 39370.0787);
                                result.setText("" + output + "  Inch");
                            }
                            if (to_value == 1) {
                                output = (xyz * 3280.8399);
                                result.setText("" + output + "  Foot");
                            }
                            if (to_value == 2) {
                                output = (xyz * 0.6214);
                                result.setText("" + output + "  Mile");
                            }
                            if (to_value == 3) {
                                output = (xyz * 10000);
                                result.setText("" + output + "  Centimeter");
                            }
                            if (to_value == 4) {
                                output = (xyz * 1000);
                                result.setText("" + output + "  Meter");
                            }
                            if (to_value == 5) {
                                output = (xyz * 1);
                                result.setText("" + output + "  Kilometer");
                            }
                        }
                        result.setEditable(false);
                        result.setDisabledTextColor(Color.BLACK);
                        result.setEnabled(true);
                    }
                    catch (Exception x) {

                        JOptionPane.showMessageDialog(null, "your input is not valid");
                        display.setText("");
                        result.setText("");
                        result.setEnabled(false);
                    }
                }
                }
            }
        });
    }
    boolean checkDisplay(){

        String inputString = display.getText();
        Pattern pattern = Pattern.compile("^[+]?[0-9]*(?:\\.[0-9]*)?$");
        Matcher matcher = pattern.matcher(inputString);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if (isStringContainsSpecialCharacter)
            return false;
        else
            return true;
    }
}