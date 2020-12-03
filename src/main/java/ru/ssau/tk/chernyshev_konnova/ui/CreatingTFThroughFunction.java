package ru.ssau.tk.chernyshev_konnova.ui;

import ru.ssau.tk.chernyshev_konnova.functions.*;
import ru.ssau.tk.chernyshev_konnova.functions.simple.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

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

    Map<String, MathFunction> functionMap = new HashMap<>();
    JComboBox <String> comboBoxFunctions = new JComboBox<>();

    private void createMap(){

        functionMap.put("Функция кубического корня", new CbrtFunction());
        functionMap.put("Константная функция", new ConstantFunction(5));
        functionMap.put("Тождественная функция", new IdentityFunction());
        functionMap.put("Логарифмическая функция", new LnFunction());
        functionMap.put("Квадратичная функция", new SqrFunction());
        functionMap.put("Единичная функция", new UnitFunction());
        functionMap.put("Нулевая функция", new ZeroFunction());

       // functionMap.keySet().stream().sorted();
    }

    CreatingTFThroughFunction() {
        super("Окно 2");
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        createMap();

        getContentPane().add(labelCount);
        getContentPane().add(textFieldCount);

        getContentPane().add(labelInterval);
        getContentPane().add(labelBracket1);
        getContentPane().add(textFieldFrom);
        getContentPane().add(labelBracket2);
        getContentPane().add(textFieldTo);
        getContentPane().add(labelBracket3);
        //
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
