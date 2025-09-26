package bbom.models;

/**
 * This interface represents the logic.
 */
public interface Counter {
    /**
     * Update the state.
     */
    void updateState();

    /**
     * Get the state.
     *
     * @return the state
     */
    int getState();
}
