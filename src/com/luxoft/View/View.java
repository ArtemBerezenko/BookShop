package com.luxoft.View;

import com.luxoft.Controller.Controller;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class View extends JDialog {
    private JPanel contentPane;
    private JButton buttonRemove;
    private JButton buttonBuy;
    private JList list1;
    private JList list2;
    private JButton addButton;
    private JTextPane textPane1;
    private JTextField textField1;
    private JButton newOrder;


    public View() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonRemove);

        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < Controller.getBooks().size(); ++i) {
            listModel.addElement(Controller.getBooks().get(i));
        }
        list1.setModel(listModel);
        list1.setVisible(true);

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                Controller.addCustomer(name);

            }
        });

        list1.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (list1.getSelectedIndices().length == 0) {
                    addButton.setEnabled(false);
                } else {
                    addButton.setEnabled(true);
                }

            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                super.mouseClicked(e);
                if(!textField1.getText().isEmpty()) {
                    Object elem = list1.getSelectedValue();
                    Controller.addCurrentOrder(elem);
                    addOnList(elem);
                }
                }
            }
        });

        list2.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (list2.getSelectedIndices().length == 0) {
                    buttonRemove.setEnabled(false);
                } else {
                    buttonRemove.setEnabled(true);
                }

            }
        });

        buttonRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object elem = list2.getSelectedValue();
                Controller.onRemove(elem);
                addOnList(Controller.displayCurrentOrder());
//                list2.updateUI();
//                list2.setVisible(true);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object elem = list1.getSelectedValue();
                Controller.addCurrentOrder(elem);
                addOnList(Controller.displayCurrentOrder());
//                list2.setVisible(true);
            }
        });

        buttonBuy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller.onBuy();
                textPane1.setText(String.valueOf(Controller.getAllOrders()));
            }
        });

        newOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.createNewOrder();
                update();

            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }

        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void update() {
//        textField1.setText("");
        DefaultListModel listModel3 = new DefaultListModel();
        listModel3.addElement(Controller.displayCurrentOrder());
        list2.setModel(listModel3);

    }


    public void addOnList(Object elem) {
        DefaultListModel listModel2 = new DefaultListModel();
        for (int i = 0; i < Controller.displayCurrentOrder().size(); ++i) {
                listModel2.addElement(Controller.displayCurrentOrder().get(i));
                list2.setModel(listModel2);
//                listModel2.clear();
//                list2.setModel(listModel2);
//            list2.setVisible(true);
        }
    }


}
