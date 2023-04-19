/**
 * Job Scheduler
 * 
 * Peter Green
 * Patrick Marino
 */

import java.util.concurrent.*;


public class MyScheduler {

    private BlockingQueue<Job> outgoingQueue;
    private BlockingQueue<Job> incomingQueue;

    private String timeType;
    private int numJobs;
    private int counter;
    
    

    public MyScheduler(int numJobs, String property) {
        this.timeType = property;
        this.numJobs = numJobs;
        this.outgoingQueue = new ArrayBlockingQueue<Job>(numJobs);
        this.incomingQueue = new ArrayBlockingQueue<Job>(numJobs);
        
    }

    //getter
    public BlockingQueue<Job> getOutgoingQueue() {
        //create outgoing queue in constructor?
        return outgoingQueue;
    }

    //method
    public BlockingQueue<Job> getIncomingQueue() {
        return incomingQueue;
    }

    public void run() {
        


        

    }
}
