package Calculator;

        import java.awt.Font;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.*;

public class Main_Calculator extends Frame_Templete {

    double num, ans;
    int calculation, point_counter = 0, equal_counter=0;
    private JButton btnSwitchThemes,one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, mul, divide, backward, equal, point, home, clear;
    private JRadioButton on, off;
    private ButtonGroup grp;
    private JLabel calculate, minibar;
    private JTextField display;

 Main_Calculator(){
     super.frame();
     super.setTitle("Calculator");
     super.container();
     initcomponents();
 }

    private void initcomponents() {

        Font font  = new Font("Arial", Font.CENTER_BASELINE, 25);
        Font f1 = new Font("Arial", Font.BOLD, 30);

        minibar = new JLabel("");
        minibar.setBounds(350, 18, 100, 25);
        minibar.setFont(font);
        container.add(minibar);

        display = new JTextField();
        display.setBounds(80, 55, 335, 45);
        display.setEditable(false);
        display.setFont(f1);
        container.add(display);

        one = new JButton("1");
        one.setBounds(80, 270, 67, 38);
        container.add(one);

        two = new JButton("2");
        two.setBounds(170, 270, 67, 38);
        container.add(two);

        three = new JButton("3");
        three.setBounds(260, 270, 67, 38);
        container.add(three);

        four = new JButton("4");
        four.setBounds(80, 220, 67, 38);
        container.add(four);

        five = new JButton("5");
        five.setBounds(170, 220, 67, 38);
        container.add(five);

        six = new JButton("6");
        six.setBounds(260, 220, 67, 38);
        container.add(six);

        mul = new JButton("*");
        mul.setBounds(350, 170, 67, 38);
        container.add(mul);

        seven = new JButton("7");
        seven.setBounds(80, 170, 67, 38);
        container.add(seven);

        eight = new JButton("8");
        eight.setBounds(170, 170, 67, 38);
        container.add(eight);

        nine = new JButton("9");
        nine.setBounds(260, 170, 67, 38);
        container.add(nine);

        divide = new JButton("/");
        divide.setBounds(350, 220, 67, 38);
        container.add(divide);

        backward = new JButton("←");
        backward.setBounds(170, 120, 67, 38);
        container.add(backward);

        zero = new JButton("0");
        zero.setBounds(170, 320, 67, 38);
        container.add(zero);

        plus = new JButton("+");
        plus.setBounds(350, 320, 67, 38);
        container.add(plus);

        minus = new JButton("-");
        minus.setBounds(350, 270, 67, 38);
        container.add(minus);

        clear = new JButton("C");
        clear.setBounds(80, 120, 67, 38);
        container.add(clear);

        home = new JButton("Home");
        home.setBounds(260, 120, 67, 38);
        container.add(home);

        point = new JButton(".");
        point.setBounds(80, 320, 67, 38);
        container.add(point);

        equal = new JButton("=");
        equal.setBounds(260, 320, 67, 38);
        container.add(equal);

        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove_result();
                display.setText(display.getText() + "1");
                equal_counter=0;
            }
        });

        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove_result();
                display.setText(display.getText() + "2");
                equal_counter=0;
            }
        });

        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove_result();
                display.setText(display.getText() + "3");
                equal_counter=0;
            }
        });

        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove_result();
                display.setText(display.getText() + "4");
                equal_counter=0;
            }
        });

        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove_result();
                display.setText(display.getText() + "5");
                equal_counter=0;
            }
        });

        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove_result();
                display.setText(display.getText() + "6");
                equal_counter=0;
            }
        });

        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove_result();
                display.setText(display.getText() + "7");
                equal_counter=0;
            }
        });

        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove_result();
                display.setText(display.getText() + "8");
                equal_counter=0;
            }
        });

        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove_result();
                display.setText(display.getText() + "9");
                equal_counter=0;
            }
        });

        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove_result();
                display.setText(display.getText() + "0");
                equal_counter=0;
            }
        });

        point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove_result();
                if (point_counter == 0) {
                    display.setText(display.getText() + ".");
                    point_counter = 1;
                } else {
                    JOptionPane.showMessageDialog(null, "Two points are not allowed");
                }
                equal_counter=0;
            }
        });

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(display.getText());
                calculation = 1;
                display.setText("");
                minibar.setText(num + "+");
                point_counter = 0;
            }
        });

        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (display.getText().isEmpty()) {
                    display.setText("-");
                    point_counter = 0;
                } else {
                    calculation = 2;
                    num = Double.parseDouble(display.getText());
                    display.setText("");
                    minibar.setText(num + "-");
                    point_counter = 0;
                }

            }
        });

        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(display.getText());
                calculation = 4;
                display.setText("");
                minibar.setText(num + "/");
                point_counter = 0;
            }
        });

        mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(display.getText());
                calculation = 3;
                display.setText("");
                minibar.setText(num + "*");
                point_counter = 0;
            }
        });

        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equal_counter=1;
                calculation();
                minibar.setText("");
                point_counter=1;
            }
        });

        backward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = display.getText().length();
                int number = display.getText().length() - 1;
                String store;
                if (length > 0) {
                    StringBuilder back = new StringBuilder(display.getText());
                    back.deleteCharAt(number);
                    store = back.toString();
                    display.setText(store);
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                minibar.setText(" ");
                point_counter = 0;
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

        grp = new ButtonGroup();
        on = new JRadioButton("on");
        on.setSelected(true);
        on.setBounds(350, 120, 67, 19);
        container.add(on);

        off = new JRadioButton("off");
        off.setBounds(350, 139, 67, 19);
        off.setOpaque(true);
        container.add(off);

        grp.add(on);
        grp.add(off);

        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disable();
            }
        });
        on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enable();
            }
        });
    }

    @Override
    public void disable() {
        display.setEnabled(false);
        off.setEnabled(false);
        on.setEnabled(true);
        one.setEnabled(false);
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        seven.setEnabled(false);
        eight.setEnabled(false);
        nine.setEnabled(false);
        zero.setEnabled(false);
        plus.setEnabled(false);
        minus.setEnabled(false);
        divide.setEnabled(false);
        mul.setEnabled(false);
        point.setEnabled(false);
        backward.setEnabled(false);
        clear.setEnabled(false);
        equal.setEnabled(false);
        home.setEnabled(false);
    }

    public void enable() {
        display.setEnabled(true);
        off.setEnabled(true);
        on.setEnabled(false);
        one.setEnabled(true);
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);
        five.setEnabled(true);
        six.setEnabled(true);
        seven.setEnabled(true);
        eight.setEnabled(true);
        nine.setEnabled(true);
        zero.setEnabled(true);
        plus.setEnabled(true);
        minus.setEnabled(true);
        divide.setEnabled(true);
        mul.setEnabled(true);
        point.setEnabled(true);
        backward.setEnabled(true);
        clear.setEnabled(true);
        equal.setEnabled(true);
        home.setEnabled(true);
    }

    public void remove_result(){
     if(equal_counter==1){
         display.setText("");
         minibar.setText("");
     }
    }

    public void calculation() {
        switch (calculation) {
            case 1:
                ans = num + Double.parseDouble(display.getText());
                display.setText(Double.toString(ans));
                break;
            case 2:
                ans = num - Double.parseDouble(display.getText());
                display.setText(Double.toString(ans));
                break;
            case 3:
                ans = num * Double.parseDouble(display.getText());
                display.setText(Double.toString(ans));
                break;
            case 4:
                ans = num / Double.parseDouble(display.getText());
                display.setText(Double.toString(ans));
                break;
        }
    }
}