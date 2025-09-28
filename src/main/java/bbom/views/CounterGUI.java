package bbom.views;

import bbom.controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CounterGUI extends JFrame implements CounterView {
    private final JLabel stateLabel;

    public CounterGUI(Controller controller) {
        super("Counter GUI");

        setSize(300, 100);
        setResizable(false);

        var updateButton = new JButton("Update");
        updateButton.addActionListener(e -> controller.updateState());

        var panel = new JPanel(new BorderLayout());
        this.stateLabel = new JLabel("State value: 0");
        panel.add(stateLabel, BorderLayout.CENTER);
        panel.add(updateButton, BorderLayout.SOUTH);

        add(panel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(-1);
            }
        });

        setVisible(true);
    }

    @Override
    public void showState(int value) {
        SwingUtilities.invokeLater(() ->
                this.stateLabel.setText("State value: " + value)
        );
    }

    @Override
    public void printStdIn(String value) {
        System.out.println("You wrote in stdin: " + value);
    }
}
