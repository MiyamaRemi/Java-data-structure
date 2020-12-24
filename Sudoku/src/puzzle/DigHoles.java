//DigHoles.java
package puzzle;

import java.util.Random;

public class DigHoles {
	public static final int GRID_SIZE = 9;
	public static final int SUBGRID_SIZE = 3;
	
	private Random random = new Random(); 
	
	public boolean[][] digHolesByLevel (String level) {
		boolean[][] visibleArray = new boolean[GRID_SIZE][];
		int randomInt = 0;
		
		//initialize array
		for(int row=0; row<GRID_SIZE; row++) {
			visibleArray[row] = new boolean[GRID_SIZE];
			for(int col=0; col<GRID_SIZE; col++) {
				visibleArray[row][col] = false; 
			}
		}
		
		for(int i=0; i<GRID_SIZE; i++) {
			randomInt = getRandomNumberByLevel(level);  
			int[] randomPositions = populateRandomArray(randomInt);  
			
			//根据所选难度，随机剔除显示的数字。
			for (int j = 0; j < randomPositions.length; j++) {  
                int col = (i % 3) * 3 + (randomPositions[j] - 1) % 3;  
                int row = (i / 3) * 3 + ((randomPositions[j] - 1) / 3);  

                visibleArray[row][col] = true;  
            }  
		}
		
		return visibleArray;
	}
	
	public int getRandomNumberByLevel(String level) {
		int randomValue = 5;
		
		switch(level) {
		case "easy": randomValue = random.nextInt(2) + 2;
		    break;
		case "medium": randomValue = random.nextInt(2) + 4;
		    break;
		case "difficult": randomValue = random.nextInt(3) + 5;
		    break;
		default: break;
		}
		
		return randomValue;
	}
	
	private int[] populateRandomArray(int numOfRandoms) {
		int array[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int randomInt = 0;  
        for (int i = 0; i < 20; i++) {  
            randomInt = random.nextInt(8) + 1;  
            int temp = array[0];  
            array[0] = array[randomInt];  
            array[randomInt] = temp;  
        }  
        
        int[] result = new int[numOfRandoms];  
        
        System.arraycopy(array, 0, result, 0, numOfRandoms);  
  
        return result; 
	}
}
