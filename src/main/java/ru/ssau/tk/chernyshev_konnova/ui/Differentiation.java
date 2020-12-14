package ru.ssau.tk.chernyshev_konnova.ui;

import ru.ssau.tk.chernyshev_konnova.functions.TabulatedFunction;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Differentiation extends JDialog {
    //X & Yla
    private final java.util.List<String> xValues = new ArrayList<>();
    private final List<String> yValues = new ArrayList<>();
    private final AbstractTableModel tableModel = new TableModelXY(xValues, yValues);
    private final JTable tableResult = new JTable(tableModel);
    private final JTable tableInitial = new JTable(tableModel);
    private final JButton buttonResult = new JButton("Сохранить результат");

    private final JButton buttonCreate = new JButton("Создать..");
    private final JButton buttonSave = new JButton("Сохранить..");
    private final JButton buttonDownload = new JButton("Загрузить..");

    TabulatedFunction functionResult;
    TabulatedFunction functionInitial;

    Differentiation() {
        super();
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setModal(true);
        setBounds(100, 100, 800, 700);


        compose();
        addButtonListeners();

        tableResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableInitial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setVisible(true);
    }

    private void addButtonListeners() {
        buttonCreate.addActionListener(e -> {
            Object[] buttonsName = {"Массив", "Функция", "Отмена"};
            int resultDialog = JOptionPane.showOptionDialog(new JFrame(), "Как вы хотите создать функцию?",
                    "Создать..", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, buttonsName, buttonsName[2]);

            switch (resultDialog) {
                case 0:
                    new CreatingTFThroughArray();
                    break;
                case 1:
                    new CreatingTFThroughFunction();
                    break;
            }

        });

    }

    private void compose() {
        JPanel panelResult = new JPanel();
        GroupLayout layoutResult = new GroupLayout(panelResult);
        JScrollPane scrollPaneResult = new JScrollPane(tableResult);
        layoutResult.setHorizontalGroup(
                layoutResult.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layoutResult.createSequentialGroup()
                                .addComponent(buttonResult)
                                .addComponent(tableResult))
                        .addComponent(scrollPaneResult));

        layoutResult.setVerticalGroup(layoutResult.createSequentialGroup()
                .addGroup(layoutResult.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(buttonResult)
                        .addComponent(tableResult))
                .addComponent(scrollPaneResult));


        JPanel panelInitial = new JPanel();
        GroupLayout layoutInitial = new GroupLayout(panelInitial);
        JScrollPane scrollPaneInitial = new JScrollPane(tableInitial);

        layoutInitial.setHorizontalGroup(
                layoutInitial.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layoutInitial.createSequentialGroup()
                                .addComponent(buttonCreate)
                                .addComponent(buttonDownload)
                                .addComponent(buttonSave)
                                .addComponent(tableInitial))
                        .addComponent(scrollPaneInitial));

        layoutInitial.setVerticalGroup(layoutInitial.createSequentialGroup()
                .addGroup(layoutInitial.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(buttonCreate)
                        .addComponent(buttonDownload)
                        .addComponent(buttonSave)
                        .addComponent(tableInitial))
                .addComponent(scrollPaneInitial));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup().addGroup(layout.createSequentialGroup()
                .addComponent(panelInitial)
                .addComponent(panelResult)));

        layout.setVerticalGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup()
                .addComponent(panelInitial)
                .addComponent(panelResult)));


    }
}
