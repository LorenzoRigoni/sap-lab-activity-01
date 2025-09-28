package bbom.views;

public interface CounterView {

    /**
     * Show the state of the model.
     *
     * @param value the value of the counter
     */
    void showState(int value);

    /**
     * Print in console the input of stdin.
     *
     * @param value the input string
     */
    void printStdIn(String value);
}
