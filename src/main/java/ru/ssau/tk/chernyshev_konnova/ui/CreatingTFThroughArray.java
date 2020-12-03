package ru.ssau.tk.chernyshev_konnova.ui;

import com.sun.nio.sctp.MessageInfo;
import ru.ssau.tk.chernyshev_konnova.functions.*;
import ru.ssau.tk.chernyshev_konnova.functions.factory.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class CreatingTFThroughArray extends JFrame {

    private java.util.List<String> xValues = new ArrayList<>();
    private List<String> yValues = new ArrayList<>();

    AbstractTableModel tableModel = new TableModelXY(xValues, yValues);
    JTable tableXY = new JTable(tableModel);


    JLabel labelCount = new JLabel("Количество точек n:");
    JButton buttonCreateFunction = new JButton("Создать функцию");
    JTextField textFieldCount = new JTextField("2");
    JButton buttonCreateTable = new JButton("Создать");

    public CreatingTFThroughArray() {
        super("Окно 1. Создание функции через массив значений");
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);

        getContentPane().add(labelCount);
        getContentPane().add(textFieldCount);
        getContentPane().add(buttonCreateTable);
        getContentPane().add(buttonCreateFunction);


        compose();
        addButtonListeners();

        tableXY.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setVisible(true);
    }

    private void addButtonListeners() {
        buttonCreateTable.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = Integer.parseInt(textFieldCount.getText());
                        for (int i = 0; i < count; i++) {
                            xValues.add(i, "");
                            yValues.add(i, "");

                            tableModel.fireTableDataChanged();

                        }
                    }
                }
        );

        buttonCreateFunction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null,"Всё идет по плану..");
                            //  TabulatedFunction function = new ArrayTabulatedFunctionFactory().create(arrayX, arrayY);
            }
        });
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

    private Double[] convert(List<String> values) {
        Double[] array = new Double[values.size()];
        for (int i = 0; i < values.size(); i++) {
            String num = values.get(i);
            array[i] = Double.parseDouble(num);
        }
        return array;
    }

    public static void main(String[] args) {
        new CreatingTFThroughArray();
    }
}
