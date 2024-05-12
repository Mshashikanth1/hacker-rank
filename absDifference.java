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
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
    
      int n=arr.size(), m= arr.get(0).size();
      
      int leftDiagonalSum=0 , rightDiagonalSum=0;
      for(int i=0;i<n;i++){
         leftDiagonalSum+=arr.get(i).get(i);
      }
      
      int i=0,j=m-1;
      while(i<n){
          rightDiagonalSum+= arr.get(i).get(j);
          i+=1;
          j-=1;
      }
      
      return Math.abs(leftDiagonalSum-rightDiagonalSum);


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*
Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix  is shown below:

1 2 3
4 5 6
9 8 9  
The left-to-right diagonal = . The right to left diagonal = . Their absolute difference is .

Function description

Complete the  function in the editor below.

diagonalDifference takes the following parameter:

int arr[n][m]: an array of integers
Return

int: the absolute diagonal difference
Input Format

The first line contains a single integer, , the number of rows and columns in the square matrix .
Each of the next  lines describes a row, , and consists of  space-separated integers .

Constraints

Output Format

Return the absolute difference between the sums of the matrix's two diagonals as a single integer.

Sample Input

3
11 2 4
4 5 6
10 8 -12
Sample Output

15
Explanation

The primary diagonal is:

11
   5
     -12
Sum across the primary diagonal: 11 + 5 - 12 = 4

The secondary diagonal is:

     4
   5
10
Sum across the secondary diagonal: 4 + 5 + 10 = 19
Difference: |4 - 19| = 15

Note: |x| is the absolute value of x

Language
Java 8
More
41424344454647484026272829303839313332343735364950515253545556252423
      
      int i=0,j=m-1;
      while(i<n){
          rightDiagonalSum+= arr.get(i).get(j);
          i+=1;
          j-=1;
      }
      
      return Math.abs(leftDiagonalSum-rightDiagonalSum);


Line: 40 Col: 1

Test against custom input
Problem Solving
You have earned 10.00 points!
You are now 59 points away from the 2nd star for your problem solving badge.
16%41/100
Congratulations
You solved this challenge. Would you like to challenge your friends?Share on FacebookShare on TwitterShare on LinkedIn

Test case 0

Test case 1

Test case 2

Test case 3

Test case 4

Test case 5

Test case 6

Test case 7

Test case 8

Test case 9

Test case 10
Compiler Message
Success
Input (stdin)
3
11 2 4
4 5 6
10 8 -12
Expected Output
15
BlogScoringEnvironmentFAQAbout UsSupportCareersTerms Of ServicePrivacy Policy
*/
