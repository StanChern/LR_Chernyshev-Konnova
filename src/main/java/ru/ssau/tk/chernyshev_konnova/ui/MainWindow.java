package ru.ssau.tk.chernyshev_konnova.ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final JButton buttonCreateArray = new JButton("Массив");
    private final JButton buttonCreateFunction = new JButton("Функция");
    private final JButton buttonSettings = new JButton("Настройки");
    private final JButton buttonOperations = new JButton("Поэлементные операции");
    private final JButton buttonDifferentiation = new JButton("Дифференцирование");

    public MainWindow() {
        super("Главное окно");
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        getContentPane().add(buttonCreateArray);
        getContentPane().add(buttonCreateFunction);
        getContentPane().add(buttonSettings);
        getContentPane().add(buttonOperations);
        getContentPane().add(buttonDifferentiation);

        compose();
        addButtonListeners();


        setVisible(true);
    }

    private void addButtonListeners() {
        buttonCreateFunction.addActionListener(e -> {
            new CreatingTFThroughFunction(function -> {
                String[] buttonsNames = {"Да", "Нет"};
                int resultSave = JOptionPane.showOptionDialog(new Frame(), "Вы хотите сохранить функцию?",
                        "Сохранить..", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, buttonsNames, buttonsNames[1]);
            });
        });

        buttonCreateArray.addActionListener(e -> {
            new CreatingTFThroughArray(function -> {
                String[] buttonsNames = {"Да", "Нет"};
                int resultSave = JOptionPane.showOptionDialog(new Frame(), "Вы хотите сохранить функцию?",
                        "Сохранить..", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, buttonsNames, buttonsNames[1]);

            });
        });

        buttonSettings.addActionListener(e -> {
            //
        });

        buttonOperations.addActionListener(e -> {
            // new Operations();
        });

        buttonDifferentiation.addActionListener(e -> {
            new Differentiation();

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
                .addComponent(buttonSettings)
                .addComponent(buttonDifferentiation));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(buttonCreateArray)
                .addComponent(buttonCreateFunction)
                .addComponent(buttonOperations)
                .addComponent(buttonSettings)
                .addComponent(buttonDifferentiation));
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
