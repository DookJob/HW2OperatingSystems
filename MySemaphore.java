public class MySemaphore {

    /**
    * Implements a multi-token semaphore.
    * 
    * Authors: Patrick Marino, Peter Green
    */

    private int numTokens;

    public MySemaphore(int i) {
        this.numTokens = i;
    }

    public int getNumTokens() {
        return this.numTokens;
    }

    public void setNumTokens(int i) {
        this.numTokens = i;
    }
        
    // Synchronized function that closes the thread when there is no more tokens
    synchronized public void p() {
        while(this.numTokens <= 0) {
            try {
                wait();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
        this.numTokens --;
    }

    // Synchronized function that opens a thread and adds a token to the total number of tokens
    synchronized public void v() {
        notify();
        this.numTokens++;
    }
}
