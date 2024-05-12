import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     
     d= d%arr.size()
     
     d= 4%5 =4
     
     1, 2, 3, 4, 5
    |<-- d --->|
     
     
      arr  ->  1, 2, 3, 4, 5

     reverse of(arr)
     
     5, 4, 3,  2, 1
     l=arr.size()-d;
     r=arr.size()-1;
     
     ------We are asked to make the left rotations------
     2,3,4,5,1 --> (1) left rotation
     3,4,5,1,2 --> (2) left rotation
     4,5,1,2,3 --> (3) left rotation
     5,1,2,3,4 --> (4) left rotation
     
      
    5,1,2,3,4  --> (1) right rotation
    4,5,1,2,3   --> (2) right rotation
    3,4,5,1,2   --> (3) right rotation
    2,3,4,5,1   --> (4) right rotation
     
     */


   /*Time : O(n) Space :O(n)*/
    public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
        
        int rotateFrom= d%a.size();
        List<Integer> ans=new ArrayList<>();
        for(int i=rotateFrom; i<a.size(); i++){
          ans.add(a.get(i));
        }
        
        for(int i=0;i<rotateFrom;i++){
            ans.add(a.get(i));
        }
        
         return ans;
    }
    
      public static List<Integer> rotLeft1(List<Integer> a, int d) {
    // Write your code here
        
         d= d%a.size();
       // Reverse the entire array
       reverse(a, 0, a.size() - 1);
       // Reverse the first d elements
       reverse(a, 0, d - 1);
       // Reverse the remaining elements
      reverse(a, d, a.size() - 1);
         return a;
    }
    
    
    public static void reverse(List<Integer> a, int start, int end){
        while(start<end){
            int temp=a.get(start);
            a.set(start++,a.get(end));
            a.set(end--, temp);
        }
        
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.rotLeft(a, d);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}


/*

A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become . Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.

Given an array  of  integers and a number, , perform  left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.

Function Description

Complete the function rotLeft in the editor below.

rotLeft has the following parameter(s):

int a[n]: the array to rotate
int d: the number of rotations
Returns

int a'[n]: the rotated array
Input Format

The first line contains two space-separated integers  and , the size of  and the number of left rotations.
The second line contains  space-separated integers, each an .

Constraints

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
Explanation

When we perform  left rotations, the array undergoes the following sequence of changes:



*/
