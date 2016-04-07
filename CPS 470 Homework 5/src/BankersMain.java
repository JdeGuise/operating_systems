//BankersMain.java, John deGuise/Jon Ragon, CPS 470, 4/18/2016 @ midnight

import java.util.Scanner;

public class BankersMain {
	private int need[][];
	private int allocate[][];
	private int max[][];
	private int avail[][];
	private int numProcesses;
	private int numResources;


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		new BankersMain().isSafe();
	}
	
	private int[][] calculate_need (){
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
			if(avail[0][j] < need[i][j]){
				return false;
			}
		}
		return true;
	}
	
    private void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        numProcesses = sc.nextInt();
        
        System.out.println("Enter number of resources: ");
        numResources = sc.nextInt();
        
        need = new int[numProcesses][numResources];  //initializing arrays
        max = new int[numProcesses][numResources];
        allocate = new int[numProcesses][numResources];
        avail = new int[1][numResources];
         
        System.out.println("Enter allocations for proccesses:");
        for(int i = 0;i < numProcesses; i++){
         	System.out.println("Current Process: " + i);
        
            for(int j = 0; j < numResources; j++){
            	allocate[i][j] = sc.nextInt();  //allocation matrix
            }
        }     
        
          
        System.out.println("Enter max matrix -->");
        for(int i = 0; i < numProcesses; i++){
             for(int j = 0; j < numResources; j++){
            	 max[i][j] = sc.nextInt();  //max matrix
             }
        }
        
           System.out.println("Enter available matrix -->");
           for(int j = 0; j < numResources; j++){
        	   avail[0][j] = sc.nextInt();  //available matrix
           }
            
           sc.close();
       }
	
	
	public boolean isSafe(){
		input();
		
		calculate_need();
		
		boolean done[] = new boolean[numProcesses];
		int pAllocated = 0;
		
		while (pAllocated < numProcesses){		//until all processes allocated
			boolean allocated = false;
			
			for(int currProcess = 0; currProcess < numProcesses; currProcess++){
				if(!done[currProcess] && check(currProcess)){			//attempt to allocate
					for(int k = 0; k < numResources; k++)
						avail[0][k] = avail[0][k] - need[currProcess][k] + max[currProcess][k];
						
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
