/**
 * Job Scheduler
 * 
 * Peter Green
 * Patrick Marino
 */

import java.util.*;
import java.util.concurrent.*; //for java.util.concurrent.BlockingQueue ??

public class MyScheduler {
    
    //constructor
    public MyScheduler(int numJobs, String property) {
        //property can be "avg wait", "max wait", "combined"
    }

    //getter
    public BlockingQueue<Job> getOutgoingQueue() {
        //create outgoing queue in constructor?
    }

    //method
    public getIncomingQueue() {
        //returns BlockingQueue of Jobs
        //call or create this in constructor?
    }
}
