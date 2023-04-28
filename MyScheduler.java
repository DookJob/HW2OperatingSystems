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
        return this.outgoingQueue;
    }

    //method
    public BlockingQueue<Job> getIncomingQueue() {
        return this.incomingQueue;
    }

    public void run() {

        //first job goes straight into outgoing queue
        try {
            outgoingQueue.add(incomingQueue.take());
        } catch(InterruptedException e) {
            System.out.println(e);
        }
        

        Job[] incomingArray = incomingQueue.toArray(Job[]::new);
        if (this.timeType == "max wait") {
            for(int i = 0; i < numJobs; i++){
                try {
                    outgoingQueue.add(incomingQueue.take());
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
            }


        } else if(this.timeType == "avg wait"){
            // avg wait
            for(int i = 0; i < numJobs; i++){
                try {
                    outgoingQueue.add(incomingQueue.take());
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
            }

            
        } else {
            // "combined"
            for(int i = 0; i < numJobs; i++){
                try {
                    outgoingQueue.add(incomingQueue.take());
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
            }
        }

    }
}
