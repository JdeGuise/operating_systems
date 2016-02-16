//Part3_40Pts.java, John deGuise/Jon Ragon, CPS 470 2-3:15 T/TH, Due 2/29 by 11:59PM
public class Part3_40Pts {
	
	public static int[] int_list = new int[]{
			1, 11, 2, 3, 4, 46, 5, 6, 7, 88, 19, 3, 2, 3, 11, 3, 8, 9, 10
	};

	public static int[] final_list = new int[int_list.length];
	
	public static int swap;
	
	/* multithreaded sorting program
	 * 		Note: Project will require passing parameters to each of the sorting threads
			Necessary to identify starting index for each thread (refer to P1)
	 * 
		1 list of ints divided into two smaller lists of equal size
		
		2 two sorting threads sort a sublist using any algorithm i want
		
		3 two sub lists merged by a third thread - merging thread
			merges two sublists into a single sorted list
	
		4 Use a global array for sharing data across threads
			Each sorting thread will work on half of the global array
			
		5 Use a global array of the same size as the first to merge two lists into
				(see Figure 4.20)
			
		6 Parent thread outputs sorted array once sorting threads have exited
	
	*/
	
	public static void main(String[] args) {
		Thread sub1 = new Thread(){
			
			public void run(){
				for(int i = 0; i < ((int_list.length) / 2); i++){
					for(int j = i; j < ((int_list.length) / 2); j++){
						if(int_list[i] > int_list[j]){
							//they are not sorted
							swap = int_list[i];   //temp the bigger value
							int_list[i] = int_list[j];
							int_list[j] = swap;
						}

					}
				}
				System.out.println("Sub1 done");
			}
	
		};
		
		Thread sub2 = new Thread(){
			
			public void run(){
				for(int i = (int_list.length) / 2; i < int_list.length; i++){
					for(int j = i; j < int_list.length; j++){
						if(int_list[i] > int_list[j]){
							//they are not sorted, must swap
							swap = int_list[i];
							int_list[i] = int_list[j];
							int_list[j] = swap;
						}
					}
				}
				System.out.println("Sub2 done");
				
			}
			
		};
		sub1.start();
		sub2.start();
		
		
		for(int i = 0; i < final_list.length; i++){
			for(int j = i; j < final_list.length; j++){
				if(int_list[i] > int_list[j]){
					//they are not sorted, must swap
					swap = int_list[i];
					int_list[i] = int_list[j];
					int_list[j] = swap;
				}
			}
			System.out.println(int_list[i]);
		}
		
	}

}


