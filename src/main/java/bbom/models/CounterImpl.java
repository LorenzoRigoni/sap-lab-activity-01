package bbom.models;

/**
 * This class implements the logics.
 */
public class CounterImpl implements Counter {
    private int counter;

    public CounterImpl() {
        this.counter = 0;
    }

    @Override
    public void updateState() {
        this.counter++;
    }

    @Override
    public int getState() {
        return this.counter;
    }
}
