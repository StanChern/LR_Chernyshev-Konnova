package ru.ssau.tk.chernyshev_konnova.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    private final JButton buttonCreateArray = new JButton("Массив");
    private final JButton buttonCreateFunction = new JButton("Функция");
    private final JButton buttonSettings = new JButton("Настройки");
    private final JButton buttonOperations = new JButton("Поэлементные операции");

    public MainWindow() {
        super("Главное окно");
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        getContentPane().add(buttonCreateArray);
        getContentPane().add(buttonCreateFunction);
        getContentPane().add(buttonSettings);
        getContentPane().add(buttonOperations);

        compose();
        addButtonListeners();

        setVisible(true);
    }

    private void addButtonListeners() {
        buttonCreateFunction.addActionListener(e -> {
            setVisible(false);
            JDialog createFunction = new CreatingTFThroughFunction();

            createFunction.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    setVisible(true);
                }
            });
        });

        buttonCreateArray.addActionListener(e -> {
            setVisible(false);
            JDialog createArray = new CreatingTFThroughArray();

            createArray.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    setVisible(true);
                }
            });
        });

        buttonSettings.addActionListener(e -> {
        });

        buttonOperations.addActionListener(e -> {
        });
    }

    private void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(buttonCreateArray)
                .addComponent(buttonCreateFunction)
                .addComponent(buttonOperations)
                .addComponent(buttonSettings));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(buttonCreateArray)
                .addComponent(buttonCreateFunction)
                .addComponent(buttonOperations)
                .addComponent(buttonSettings));
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
