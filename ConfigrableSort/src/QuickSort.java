import java.util.ArrayList;
import java.util.Arrays;


	
	public class QuickSort {
	    
	    public final int START_FROM_LEFT = 1;
	    public final int START_FROM_RIGHT = 2;
	    
//	    public static void main(String args[]) 
//	    {
//	        
//	        int[] array = {2, 3, 5, 1, 8, 6, 4, 3,2, 19, 3};
//	        array=quickSort(array); 
//	        for(int num: array)
//	        {
//	            System.out.print(num+",");           
//	        }
//	    }
	    
	    
	    
	    private void swap(int array[], int pos1, int pos2) {
	        int temp = array[pos1];
	        array[pos1] = array[pos2];
	        array[pos2] = temp; 
	    }
	    
	    
	    /**
	     * PRE - it starts with pivot element on the left
	     * POST - the pivot element is at the correct index
	     * @param array
	     * @param indexOne
	     * @param indexTwo
	     * @return
	     */
	    private int partitionArray(int [] array, int indexOne, int indexTwo) {
	        int pivotIndex = indexOne;    
	        int startIndex = indexTwo; 
	        int direction = START_FROM_RIGHT;  
	        
	        while ((direction == START_FROM_RIGHT && startIndex > pivotIndex) || 
	               (direction == START_FROM_LEFT  && startIndex < pivotIndex)) {
	            if (direction == START_FROM_RIGHT) {
	                // pivot element is on the left hand side of the array
	                for (int i = startIndex; i >= pivotIndex; i--) {
	                    if (array[pivotIndex] >= array[i]) { 
	                        swap(array, pivotIndex, i); 
	                        // rearrange the pivot index, starting index, and direction
	                        // since the swap just took place
	                        startIndex = pivotIndex + 1;
	                        pivotIndex = i;
	                        direction = START_FROM_LEFT;   
	                        break;
	                    }
	                }
	            } else {
	                // pivot element is on the right hand side of the array
	                for (int i = startIndex; i <= pivotIndex; i++) {
	                    if (array[pivotIndex] <= array[i]) { 
	                        swap(array, pivotIndex, i); 
	                        // rearrange the pivot index, starting index, and direction
	                        // since the swap just took place
	                        startIndex = pivotIndex - 1;
	                        pivotIndex = i;
	                        direction = START_FROM_RIGHT;  
	                        break;
	                    }
	                }
	            }
	        } 
	        return pivotIndex; // this index is changed potentially many times....
	    }
	    
	    public int sortIntArray(int[] array, int lowIndex, int hiIndex) {
	        int pivotIndex = partitionArray(array, lowIndex, hiIndex);
	        if ((pivotIndex - 1) > lowIndex)
	            pivotIndex = sortIntArray(array, lowIndex, pivotIndex - 1);
	        if ((pivotIndex + 1) < hiIndex)
	            pivotIndex = sortIntArray(array, pivotIndex + 1, hiIndex);
	        return pivotIndex;
	    }
	    

		public static ArrayList<Integer> quickSort (ArrayList<Integer> myArrayList) 
	    {
	    	
	        QuickSort myQuickSort = new QuickSort();

	        int[] Array = convertIntegers(myArrayList);
	        
	        int low = 0;
	        int high = Array.length - 1;
	        myQuickSort.sortIntArray(Array, low, high);
	        
	        myArrayList=convertInt(Array);
	        
	        return myArrayList;
	        
	    }
	    
	    
	    public static int[] convertIntegers(ArrayList<Integer> integers)
	    {
	        int[] ret = new int[integers.size()];
	        for (int i=0; i < ret.length; i++)
	        {
	            ret[i] = integers.get(i).intValue();
	        }
	        return ret;
	    }
	    
	    public static ArrayList<Integer> convertInt(int[] array)
	    {
	    	
	  	    
	    		 
	    		  ArrayList<Integer> list = new ArrayList<Integer>(array.length);
	    		  for (int i = 0; i < array.length; i++)
	    		    list.add(Integer.valueOf(array[i]));
	  	    return list;
	  	    
	    }
	    

	}


