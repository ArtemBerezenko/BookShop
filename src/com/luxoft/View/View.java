package com.luxoft.View;

import com.luxoft.Controller.ControllerInterface;
import com.luxoft.Model.ShopInterface;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class View extends JDialog{
    public ControllerInterface controller;
    public ShopInterface shop;
    private JPanel contentPane;
    private JButton buttonRemove;
    private JButton buttonBuy;
    private JList list1;
    private JList list2;
    private JButton addButton;
    private JTextPane textPane1;
    private JTextField textField1;
    private JButton newOrder;

    public View(ControllerInterface controller, ShopInterface shop){
        this.controller = controller;
        this.shop = shop;
    }


    public void createView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonBuy);
        setMinimumSize(new Dimension(1000,600));

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                controller.setCustomer(name);
            }
        });

        controller.setEnabledComponent(list1, addButton);

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                super.mouseClicked(e);
                if(!textField1.getText().isEmpty()) {
                    Object elem = list1.getSelectedValue();
                    controller.addCurrentOrder(elem);
                    String name = textField1.getText();
                    controller.setCustomer(name);
                }
                }
            }
        });

        controller.setEnabledComponent(list2, buttonRemove);

        textPane1.setText(String.valueOf(controller.getAllOrders()));
        controller.CreateNewOrder();

        buttonRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object elem = list2.getSelectedValue();
                controller.onRemove(elem);
                addOnList(controller.getCurrentBooks());
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField1.getText().isEmpty()) {
                    controller.addCurrentOrder(list1.getSelectedValue());
                    addOnList(controller.getCurrentBooks());
                    String name = textField1.getText();
                    controller.setCustomer(name);
//                    textField1.setEditable(false);
                }
            }
        });

        buttonBuy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.onBuy();
                textPane1.setText(String.valueOf(controller.getAllOrders()));
                controller.loadInFile();
            }
        });

        newOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.CreateNewOrder();

            }
        });


        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }

        });


        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public void setEnabledList(JList list, JButton button) {
        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (list.getSelectedIndices().length == 0) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }

            }
        });
    }

    public void showProducts() {
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < controller.getBooks().size(); ++i) {
            listModel.addElement(controller.getBooks().get(i));
        }
        list1.setModel(listModel);
        list1.setVisible(true);
    }

    public void update() {
        textField1.setText("");
        DefaultListModel listModel3 = new DefaultListModel();
        listModel3.addElement(controller.getCurrentBooks());
        list2.setModel(listModel3);

    }


    public void addOnList(Object elem) {
        DefaultListModel listModel2 = new DefaultListModel();
        for (int i = 0; i < controller.getCurrentBooks().size(); ++i) {
            listModel2.addElement(controller.getCurrentBooks().get(i));
        }
                list2.setModel(listModel2);
    }

    public void disableEditTextField(){
        textField1.setEnabled(false);
    }

    public void disableEditListOrders(){
        list2.setEnabled(false);
    }

    public void disableEditListProducts(){
        list1.setEnabled(false);
    }

    public void disabledButtonBuy(){
        buttonBuy.setEnabled(false);
    }

    public void disabledEditButtonAdd(){
        addButton.setEnabled(false);
    }

    public void disabledEditButtonRemove(){
        buttonRemove.setEnabled(false);
    }

    public void enableEditTextField(){
        textField1.setEnabled(true);
    }

    public void enableEditListOrders(){
        list2.setEnabled(true);
    }

    public void enabledEditListProducts(){
        list1.setEnabled(true);
    }

    public void enabledEditButtonBuy(){
        buttonBuy.setEnabled(true);
    }

    public void enabledEditButtonAdd(){
        addButton.setEnabled(true);
    }

    public void enabledEditButtonRemove(){
        buttonRemove.setEnabled(true);
    }
}
