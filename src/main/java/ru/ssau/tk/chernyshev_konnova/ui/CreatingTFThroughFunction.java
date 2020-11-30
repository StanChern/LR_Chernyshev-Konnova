package ru.ssau.tk.chernyshev_konnova.ui;

import javax.swing.*;
import java.awt.*;

public class CreatingTFThroughFunction extends JFrame {
    JLabel labelCount = new JLabel("Количество точек: ");
    JLabel labelInterval = new JLabel("Интервал: ");
    JLabel labelBracket1 = new JLabel("[ ");
    JLabel labelBracket3 = new JLabel(" ]");
    JLabel labelBracket2 = new JLabel(" ; ");
    JTextField textFieldCount = new JTextField(2);
    JTextField textFieldTo = new JTextField(0);
    JTextField textFieldFrom = new JTextField(10);
    JButton buttonCreateFunction = new JButton("Создать функцию");
    JComboBox comboBoxFunctions = new JComboBox();

    CreatingTFThroughFunction() {
        super("Окно 2");
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        getContentPane().add(labelCount);
        getContentPane().add(textFieldCount);

        getContentPane().add(labelInterval);
        getContentPane().add(labelBracket1);
        getContentPane().add(textFieldFrom);
        getContentPane().add(labelBracket2);
        getContentPane().add(textFieldTo);
        getContentPane().add(labelBracket3);
        getContentPane().add(comboBoxFunctions);

        getContentPane().add(buttonCreateFunction);

        compose();
        setVisible(true);
    }

    private void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCount)
                        .addComponent(textFieldCount))
                .addComponent(labelInterval)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelBracket1)
                        .addComponent(textFieldFrom)
                        .addComponent(labelBracket2)
                        .addComponent(textFieldTo)
                        .addComponent(labelBracket3))
                .addComponent(comboBoxFunctions)
                .addComponent(buttonCreateFunction)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelCount)
                        .addComponent(textFieldCount))
                .addComponent(labelInterval)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelBracket1)
                        .addComponent(textFieldFrom)
                        .addComponent(labelBracket2)
                        .addComponent(textFieldTo)
                        .addComponent(labelBracket3))
                .addComponent(comboBoxFunctions)
                .addComponent(buttonCreateFunction));
    }

    public static void main(String[] args) {
        new CreatingTFThroughFunction();
    }
}
