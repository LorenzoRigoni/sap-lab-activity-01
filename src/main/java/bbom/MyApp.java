package bbom;

import bbom.controllers.Controller;
import bbom.views.MainView;

import javax.swing.SwingUtilities;

public class MyApp {
    static public void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(Controller::new);
    }
}
