package ru.ssau.tk.chernyshev_konnova.ui;

import ru.ssau.tk.chernyshev_konnova.functions.factory.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private final JButton buttonCreateArray = new JButton("Массив");
    private final JButton buttonCreateFunction = new JButton("Функция");
    private final JButton buttonSettings = new JButton("Настройки");
    private final JButton buttonOperations = new JButton("Поэлементные операции");
    private final JButton buttonDifferentiation = new JButton("Дифференцирование");

    protected static TabulatedFunctionFactory functionFactory = new ArrayTabulatedFunctionFactory();

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

        getContentPane().setBackground(new Color(0,204,204));

        setVisible(true);
    }

    private void addButtonListeners() {
        buttonCreateFunction.addActionListener(e -> {
            CreatingTFThroughFunction.checkBoxSave.setVisible(true);
            new CreatingTFThroughFunction(function -> {
            });

        });

        buttonCreateArray.addActionListener(e -> {
            CreatingTFThroughArray.checkBoxSave.setVisible(true);
            new CreatingTFThroughArray(function -> {
            });

        });

        buttonSettings.addActionListener(e -> {
            new Settings(tabulatedFunctionFactory -> {
                functionFactory = tabulatedFunctionFactory;
            }
            );
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

        getContentPane().setBackground(Settings.color);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
