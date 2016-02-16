//Part1_30Pts.java, John deGuise/Jon Ragon, CPS 470 2-3:15 T/TH, Due 2/25 by 11:59PM

// Program runs from command line with int args, and calculates the respective function per thread.


public class Part1_30Pts{

	public static void main(String[] args) {
		final int[] argList = new int[args.length];
		
		try{
			for(int i = 0; i < args.length; i++){
				argList[i] = Integer.parseInt(args[i]);
			}
		}
		catch(NumberFormatException nfe){
			nfe.printStackTrace();
		}
	
		Thread avgThread = new Thread(){
			private long sum = 0;
			
			public void run(){
				for(int i = 0; i < argList.length; i++){
					sum += argList[i];
				}
				System.out.println("The average value is " + (sum / argList.length));
			}
		};
		
		Thread minThread = new Thread(){
			private int currMin = Integer.MAX_VALUE;		//magic number for initializing min to something other than 0
			
			public void run(){
				
				for(int i = 0; i < argList.length; i++){
					if(argList[i] < currMin){
						currMin = argList[i];
					}
				}
				
				System.out.println("The minimum value is " + currMin);
			}
		};
		
		Thread maxThread = new Thread(){
			private int currMax = Integer.MIN_VALUE;
			
			public void run(){
				
				for(int i = 0; i < argList.length; i++){
					
					if(argList[i] > currMax){
						currMax = argList[i];
					}
				}
				
				System.out.println("The maximum value is " + currMax);
			}
		};
		
		avgThread.start();
		minThread.start();
		maxThread.start();
	
	}

}