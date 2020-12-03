package ru.ssau.tk.chernyshev_konnova.ui;

import javax.swing.*;
import java.awt.*;

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
    }

    private void compose() {
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
