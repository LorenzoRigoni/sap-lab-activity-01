package bbom.controllers;

import bbom.models.Counter;
import bbom.models.CounterImpl;
import bbom.views.CounterGUI;
import bbom.views.CounterView;
import bbom.views.MainView;
import bbom.views.StdinScanner;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the controller. It manages the communications between the model and the view.
 */
public class Controller {
    private final Counter counter;
    private final List<CounterView> views;

    public Controller() {
        this.counter = new CounterImpl();
        this.views = new ArrayList<>();
        this.views.add(new MainView(this));
        this.views.add(new CounterGUI(this));

        new StdinScanner(this).start();

        new AutonomousController(this).start();
    }

    /**
     * Update the state of the model.
     */
    public void updateState() {
        this.counter.updateState();
        notifyViews();
    }

    /**
     * Get the state of the model.
     *
     * @return the state of the model
     */
    public int getState() {
        return this.counter.getState();
    }

    /**
     * Print the value inserted in the stdin.
     *
     * @param value the value to print
     */
    public void printStdinInput(String value) {
        for (final CounterView view : this.views) {
            view.printStdIn(value);
        }
    }

    private void notifyViews() {
        final int value = getState();
        for (final CounterView view : this.views) {
            view.showState(value);
        }
    }
}
