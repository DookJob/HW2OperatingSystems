/**
 * Job Scheduler
 * 
 * Peter Green
 * Patrick Marino
 */

import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.Comparator;


public class MyScheduler {

    private BlockingQueue<Job> outgoingQueue;
    private BlockingQueue<Job> incomingQueue;

    private String timeType;
    private int numJobs;
    private int counter;
    
    

    public MyScheduler(int numJobs, String property) {
        this.timeType = property;
        this.numJobs = numJobs;
        this.incomingQueue = new ArrayBlockingQueue<Job>(numJobs);


        if(timeType == "max wait") {
            this.outgoingQueue = new ArrayBlockingQueue<Job>(numJobs); // dont change, this seems to work most the time lol!
        }else if(timeType == "avg wait") {
            this.outgoingQueue = new PriorityBlockingQueue<Job>(numJobs, new jobComparator1());
        } else { //combined
            this.outgoingQueue = new ArrayBlockingQueue<Job>(numJobs);
        }
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
        for(int i = 0; i< numJobs; i++){
            try {
                outgoingQueue.add(incomingQueue.take());
            } catch(InterruptedException e) {
                System.out.println(e);
            }
            
        }
    }
}

class jobComparator1 implements Comparator<Job>{
    public int compare(Job j1, Job j2) {
        if(j1.getLatency() > j2.getLatency()){
            return 1;
        }else if(j1.getLatency() < j2.getLatency()){
            return -1;
        }else{
            return 0;
        }
    }

}