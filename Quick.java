import java.util.*;
import java.io.*;

public class Quick{
  /**@return the index of the final position of the pivot element.
 */
  public static int partition ( int [] data, int start, int end){
    int random = ((int) (Math.random() * 100) ) % data.length;
    int pivot = data[random];
    int holder = data[start];
    data[start] = pivot;
    data[random] = holder;
    // System.out.println("The index is " + random);
    // System.out.println("The pivot value is " + pivot + "\n");
    int s = start + 1;
    int e = end;
    for(int i = 0; i < data.length && s < data.length && e > -1; i ++)
    {
      // System.out.println("Before swapping:");
      // System.out.println("Index s is " + s + "  Index e is " + e);
      // System.out.println("The array is now " + Arrays.toString(data));
      if(data[s] > pivot)
      {
        holder = data[s];
        data[s] = data[e];
        data[e] = holder;
        e--;
      }
      if(data[s] <= pivot)
      {
        s++;
      }
      if(e <= s)
      {
        if(data[s] > pivot)
        {
          data[start] = data[s - 1];
          data[s - 1] = pivot;
        }
        else
        {
          data[start] = data[s];
          data[s] = pivot;
        }
        i = data.length;
      }
      // System.out.println("After swapping:");
      // System.out.println("Index s is " + s + "  Index e is " + e);
      // System.out.println("The array is now " + Arrays.toString(data) + "\n");
    }
    start = s;
    end = e;
    return random;
  }

  /*return the value that is the kth smallest value of the array.
  */
  public static int quickselect(int[] data, int k){
    return quickselectH(data,k,0,data.length - 1);
  }


  private static int quickselectH(int[] data, int k, int splice1, int splice2){
    int holder = partition(data,splice1,splice2);
    if(holder < k)
    {
      return quickselectH(data,k,holder,splice2);
    }
    else if(holder > k)
    {
      return quickselectH(data,k,splice1,holder);
    }
    else
    {
      return data[k];
    }
  }


  public static void main(String[] args){
    int[] numArray = new int[10];
    for(int i = 0; i < numArray.length; i ++)
    {
      numArray[i] = (int) (Math.random()*1000) % 20;
    }
    System.out.println("The original array is: " + Arrays.toString(numArray));
    // partition(numArray,0,numArray.length - 1);
    System.out.println("quickselect for the fourth smallest element: " + quickselect(numArray,4));
  }


}
