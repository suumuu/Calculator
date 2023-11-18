package Calculator;

import javax.swing.*;
import java.awt.*;

public class Frame_Templete extends JFrame {
    public Container container ;

    public void frame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(400, 180, 500, 420);
        this.setResizable(false);
        this.setTitle("Reckoner");
    }

    public void container(){
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(211,211,211));
    }
}