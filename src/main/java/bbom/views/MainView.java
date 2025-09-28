package bbom.views;

import bbom.controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainView extends JFrame implements ActionListener, CounterView {
    private final Controller controller;

    public MainView(Controller controller) {
        super("My App");

        this.controller = controller;

        setSize(300, 70);
        setResizable(false);

        var updateButton = new JButton("Update");
        updateButton.addActionListener(this);

        var panel = new JPanel();
        panel.add(updateButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(-1);
            }
        });

        showState(this.controller.getState());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.updateState();
        showState(this.controller.getState());
    }

    @Override
    public void showState(int value) {
        log("State value: " + value);
    }

    @Override
    public void printStdIn(String value) {
        System.out.println("You wrote in stdin: " + value);
    }

    private void log(String msg) {
        System.out.println("[Output] " + msg);
    }
}
