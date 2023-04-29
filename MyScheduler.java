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

        // if(timeType == "max wait") {
            PriorityBlockingQueue<Job> pbq1 = new PriorityBlockingQueue<Job>(numJobs, new jobComparator1());
            for(int i = 1; i< numJobs; i++){
                try {
                    pbq1.add(incomingQueue.take());
                }  catch(InterruptedException e) {
                    System.out.println(e);
                }
                outgoingQueue.add(pbq1.poll());
            }

        // }else if(timeType == "avg wait") {
        //     PriorityBlockingQueue<Job> pbq = new PriorityBlockingQueue<Job>();
        //     for(int i = 1; i< numJobs; i++){
                    
        //     }

        // }else { //combined
        //     PriorityBlockingQueue<Job> pbq = new PriorityBlockingQueue<Job>();
        //     for(int i = 1; i< numJobs; i++){
                    
        //     }
                
        // }
    }
}

class jobComparator1 implements Comparator<Job>{
    public int compare(Job j1, Job j2) {
        if(j1.getWaitTime() < j2.getWaitTime()){
            return 1;
        }else if(j1.getWaitTime() > j2.getWaitTime()){
            return -1;
        }else{
            return 0;
        }
    }

}