package ru.ssau.tk.chernyshev_konnova.ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class CreatingTFThroughArray extends JFrame {
    List<String> strings = new ArrayList<>();
    AbstractTableModel tableModel = new TableModelXY(strings);
    JTable tableXY = new JTable(tableModel);
    // JFrame windowArray = new JFrame("Попытка 4534-369405693456");
    JLabel labelCount = new JLabel("Количество точек n:");
    JButton buttonCreateFunction = new JButton("Создать функцию");
    JTextField textFieldCount = new JTextField("2");
    JButton buttonCreateTable = new JButton("Создать");

    CreatingTFThroughArray() {
        super("Попытка 4534-369405693456");
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        getContentPane().add(labelCount);
        getContentPane().add(textFieldCount);
        getContentPane().add(buttonCreateTable);
        getContentPane().add(buttonCreateFunction);

        strings.add(String.valueOf(50));
        strings.add(String.valueOf(50));
        strings.add(String.valueOf(50));
        strings.add(String.valueOf(50));
        strings.add(String.valueOf(50));
        strings.add(String.valueOf(50));
        strings.add(String.valueOf(50));
        strings.add(String.valueOf(50));
        strings.add(String.valueOf(50));
        strings.add(String.valueOf(50));
        strings.add(String.valueOf(50));
        strings.add(String.valueOf(50));

        tableXY.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        compose();
        setVisible(true);
    }

    private void compose() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JScrollPane scrollPane = new JScrollPane(tableXY);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCount)
                        .addComponent(textFieldCount)
                        .addComponent(buttonCreateTable))
                .addComponent(scrollPane)
                .addComponent(buttonCreateFunction)

        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelCount)
                        .addComponent(textFieldCount)
                        .addComponent(buttonCreateTable))
                .addComponent(scrollPane)
                .addComponent(buttonCreateFunction));
    }

    public static void main(String[] args) {
        new CreatingTFThroughArray();
    }
}
