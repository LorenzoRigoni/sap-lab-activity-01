package bbom.controllers;

import bbom.models.Counter;
import bbom.models.CounterImpl;
import bbom.views.MainView;

/**
 * This class represents the controller. It manages the communications between the model and the view.
 */
public class Controller {
    private final Counter counter;
    private final MainView mainView;

    public Controller() {
        this.counter = new CounterImpl();
        this.mainView = new MainView(this);
        this.mainView.setVisible(true);
    }

    /**
     * Update the state of the model.
     */
    public void updateState() {
        this.counter.updateState();
    }

    /**
     * Get the state of the model.
     *
     * @return the state of the model
     */
    public int getState() {
        return this.counter.getState();
    }
}
