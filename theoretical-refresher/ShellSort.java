import java.util.Arrays;

public class ShellSort {
    private final String sortAlgo = "Shell Sort";
    private final String timeComp = "O(n^2), Quadratic";
    private final String algoType = "In Place, ie. no data/array duplication required";
    private final String algoStability = "Unstable, ie. does not maintain order of duplicate items";
    /**
     * It aims to improve hte performance of Insertion sort by performing some preliminary sorting before it implements insetion. 
     * Essentially, we first set a 'gap' value. There are many ways of doing this eg. knuth, len/2 etc.
     * We keep reducing this gap size till the last iteration, where the gap = 1. THe last iteration of shell sort practically becomes
     * an insertion sort, albeit with better performance (in most cases) as the array is partially sorted.
     * 
     * https://www.tutorialspoint.com/data_structures_algorithms/shell_sort_algorithm.htm
     * 
     * @param intArray array in which elements are to be swapped
     * @param elaborate boolean specifying if elaboration is to be displayed on console
     * @return no value
     */
    public void shellSort(int[] intArray, boolean elaborate) {
        long startTime = System.currentTimeMillis();
        int insertionItem;
        for (int gap = intArray.length/2 ; gap > 0; gap /= 2) {
            System.out.println("Gap value =" + gap);
            for (int i = gap; i < intArray.length; i++) {
                insertionItem = intArray[i];
                int j = i;
                while(j >= gap && insertionItem < intArray[j-gap]){
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = insertionItem;
            }
        }
        System.out.println("\n\nOutput Array: " + Arrays.toString(intArray));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Sorting.analysisSummary(intArray, this.sortAlgo, this.timeComp, this.algoType, this.algoStability, duration);
    }       
    public void shellSort(int[] intArray) {
        long startTime = System.currentTimeMillis();
        int insertionItem;
        for (int gap = intArray.length/2 ; gap > 0; gap /= 2) {
            for (int i = gap; i >= intArray.length; i++) {
                insertionItem = intArray[i];
                int j = i;
                while(j >= gap && insertionItem > intArray[j-gap]){
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = insertionItem;
            }
        }
        System.out.println("\n\nOutput Array: " + Arrays.toString(intArray));
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        Sorting.analysisSummary(intArray, this.sortAlgo, this.timeComp, this.algoType, this.algoStability, duration);
    }  
}
