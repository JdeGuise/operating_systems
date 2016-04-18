//BankersMain.java, John deGuise/Jon Ragon, CPS 470, 4/18/2016 @ midnight

import java.util.*;
import java.util.concurrent.Semaphore;

// public class Customer {

// }

public class BankersMain {
	private static int need[][];
	private static int allocate[][];
	private static int max[][];
	private static int avail[];
	private static int numProcesses = 5;
	private static int numResources = 3;
	private static String[] arguments;

	private final Semaphore mutex = new Semaphore(1, true);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arguments = args;
		input();

		Runnable bankThread = new Runnable() {
			public void run() {
				long threadID = Thread.currentThread().getId() - 10;
				System.out.println(threadID);
				while (true) {
					//do what it should do, which is accepting and releasing resources
					//if system is in a safe state
					//in the order of processes

					mutex.acquire();
					//do the thing
					int request[] = new int[numProcesses]
					for(int i = 0; i > numProcesses; i++){
						request[i] = (int)(Math.random() * need[threadID][i])
					}

					requestResources(threadID, request[]);

					mutex.release();


					try {
					    Thread.sleep(2000);
					} 
					catch(InterruptedException e){
					     
					}

					mutex.acquire();
					releaseResources(threadID, request[]);
					mutex.release();


					try {
					    Thread.sleep(2000);
					} 
					catch(InterruptedException e){
					     
					}

				}
			}
		};
		// TODO create student objects based on numProcesses and activate them in the thread numerically from 0 to 4
		int threads = 0;
		for(int i = 0; i < numProcesses; i++){
			new Thread(bankThread).start();
		}
		// while (threads > numProcesses){
		// 	new Thread(bankThread).start();
		// }

		
		calculate_need();
		//threading starts here
		new BankersMain().isSafe();
	}

	public int requestResources (int customer_number, int request[]) {
		//needs to check if request leaves system in safe state
		return 0;
	}

	public int releaseResources (int customer_number, int release[]) {

		return 0;
	}
	
	private static int[][] calculate_need (){
		for(int i = 0; i < numProcesses; i++){
			for (int j = 0; j < numResources; j++){
				need[i][j] = max[i][j] - allocate[i][j];
			}
		}
		return need;
	}
	
	private boolean check(int i){
		//check if all resources for i'th process can be allocated
		
		for(int j = 0; j < numResources; j++){
			if(avail[j] < need[i][j]){
				return false;
			}
		}
		return true;
	}
	
    private static void input(){
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter number of processes: ");
        // numProcesses = sc.nextInt();
        
        // System.out.println("Enter number of resources: ");
        // numResources = sc.nextInt();
        
        need = new int[numProcesses][numResources];  //initializing arrays
        max = new int[numProcesses][numResources];
        allocate = new int[numProcesses][numResources];
        avail = new int[numResources];

         
        // System.out.println("Enter allocations for proccesses:");
        // for(int i = 0;i < numProcesses; i++){
        //  	System.out.println("Current Process: " + i);
        
        //     for(int j = 0; j < numResources; j++){
        //     	allocate[i][j] = sc.nextInt();  //allocation matrix
        //     }
        // }     
        
          
        // System.out.println("Enter max matrix -->");
        // for(int i = 0; i < numProcesses; i++){
        //      for(int j = 0; j < numResources; j++){
        //     	 max[i][j] = sc.nextInt();  //max matrix
        //      }
        // }
        

        //Sets available
        for(int i = 0; i < numResources; i++){
        	avail[i] = Integer.parseInt(arguments[i]);
        }

        System.out.println(avail);
       //     System.out.println("Enter available matrix -->");
       //     for(int j = 0; j < numResources; j++){
       //  	   avail[0][j] = sc.nextInt();  //available matrix
       //     }
            
       //     sc.close();
        }
	
	
	public boolean isSafe(){

		
		boolean done[] = new boolean[numProcesses];
		int pAllocated = 0;
		
		while (pAllocated < numProcesses){		//until all processes allocated
			boolean allocated = false;
			
			for(int currProcess = 0; currProcess < numProcesses; currProcess++){
				if(!done[currProcess] && check(currProcess)){			//attempt to allocate
					for(int k = 0; k < numResources; k++)
						avail[k] = avail[k] - need[currProcess][k] + max[currProcess][k];
						
						System.out.println("Allocated process: " + currProcess);
						
						allocated = done[currProcess] = true;
						pAllocated++;
					
				}
				if(!allocated) break;		//no allocation
			}
			
		}
		if (pAllocated == numProcesses){
			System.out.println("\nSafely allocated");
			return true;
		}
		else{
			System.out.println("All proocesses cannot be allocated safely.");
			return false;
		}
		
		
	}

}
