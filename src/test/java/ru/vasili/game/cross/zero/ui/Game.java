package ru.vasili.game.cross.zero.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SimpleGUI extends JFrame {
    private JButton button = new JButton("Нажать");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Выбрать:");
    private JRadioButton radio1 = new JRadioButton("Выбрать это");
    private JRadioButton radio2 = new JRadioButton("Что выбрать");
    private JCheckBox check = new JCheckBox("Проверить", false);

    public SimpleGUI() {
        super("Простой образец");
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);

        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Нажата кнопка\n";
            message += "Текст:" + input.getText() + "\n";
            message += (radio1.isSelected()?"Радио #1":"Радио #2")
                    + " В\n";
            message += "флажок установлен " + ((check.isSelected())
                    ?"Проверен":"Не проверен");
            JOptionPane.showMessageDialog(null,
                    message,
                    "Выход",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
    }
}
