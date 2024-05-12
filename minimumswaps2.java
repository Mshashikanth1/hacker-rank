import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps1(int[] arr) {
        
        //you shoudl not use bubble sort, need to use selection sort
        boolean isSwapped;
        int totalSwapCount=0;
        do{
            isSwapped=false;
            for(int i=0; i<arr.length-1; i++){
                if(arr[i] > arr[i+1]) {
                    isSwapped=true;
                    swap(arr, i,i+1);
                    totalSwapCount++;
                }
            }
        }while(isSwapped);
        System.out.println(Arrays.toString(arr));
        return totalSwapCount;
    }
    
     static int minimumSwaps2(int[] arr) {
        
        //you shoudl not use bubble sort, need to use selection sort
       
        int totalSwapCount=0, minEle=Integer.MAX_VALUE, minEleIndx=-1;
        for(int i=0;i<arr.length;i++){
            minEle=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < minEle) {
                    minEle=arr[j];
                    minEleIndx=j;
                }
            }
            if(minEle!=arr[i]){
                swap(arr,i,minEleIndx);
                totalSwapCount++;
            }
         
        }
        
        System.out.println(Arrays.toString(arr));
        return totalSwapCount;
    }
    
    static int minimumSwaps(int[] arr) {
    int n = arr.length;
    // Create a boolean array to mark visited elements
    boolean[] visited = new boolean[n];
    int swapCount = 0;

    for (int i = 0; i < n; i++) {
        int correctValue = i + 1; // Expected value at index i
        int currentValue = arr[i];
        
        // If the current element is already at its correct position or already visited,
        // move to the next element
        if (currentValue == correctValue || visited[i]) {
            continue;
        }

        // Traverse through the cycle to count the elements
        int cycleSize = 0;
        int j = i;
        while (!visited[j]) {
            visited[j] = true;
            j = arr[j] - 1; // Move to the index where arr[j] should be placed
            cycleSize++;
        }

        // Add the number of swaps required within the cycle
        swapCount += (cycleSize - 1);
    }

    return swapCount;
}

    
     static int totalSwapCoun=0;
     static int minimumSwaps3(int[] arr) {
        
        //you shoudl not use bubble sort, need to use selection sort
       
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        return totalSwapCoun;
    }
    
    static void quickSort(int[] arr, int left, int right){
        if(left<right){
            int pivotIndex=partition(arr, left,right);
            quickSort(arr, left, pivotIndex-1);
            quickSort(arr, pivotIndex+1, right);
        }
    }
    static int partition(int[] arr, int left, int right){
        int i=left-1, j=left;
        while(j<right){
            if(arr[j] < arr[right]) {
                swap(arr, ++i, j);
            }
            j++;
         }
         swap(arr, ++i, right);
         return i;
    }
    
    
    static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
                  totalSwapCoun++;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

/*
You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending order.

Example


Perform the following steps:

i   arr                         swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
It took  swaps to sort the array.

Function Description

Complete the function minimumSwaps in the editor below.

minimumSwaps has the following parameter(s):

int arr[n]: an unordered array of integers
Returns

int: the minimum number of swaps to sort the array
Input Format

The first line contains an integer, , the size of .
The second line contains  space-separated integers .

Constraints

Sample Input 0

4
4 3 1 2
Sample Output 0

3
Explanation 0

Given array 
After swapping  we get 
After swapping  we get 
After swapping  we get 
So, we need a minimum of  swaps to sort the array in ascending order.

Sample Input 1

5
2 3 4 1 5
Sample Output 1

3
Explanation 1

Given array 
After swapping  we get 
After swapping  we get 
After swapping  we get 
So, we need a minimum of  swaps to sort the array in ascending order.

Sample Input 2

7
1 3 5 2 4 6 7
Sample Output 2

3
Explanation 2

Given array 
After swapping  we get 
After swapping  we get 
After swapping  we get 
So, we need a minimum of  swaps to sort the array in ascending order.
*/
