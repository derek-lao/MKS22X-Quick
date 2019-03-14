import java.util.*;
import java.io.*;

public class Quick{
  /**@return the index of the final position of the pivot element.
 */
 // // partition WITH dutch flag
 //  public static int partition ( int [] data, int start, int end){
 //    if(start == end)
 //    {
 //      return start;
 //    }
 //    // int random = (((int) (Math.random() * 100) ) % (end - start + 1)) + start;
 //    int random = 0;
 //    int lo = data[start];
 //    int hi = data[end];
 //    int med = data[((start + end) / 2)];
 //    if(lo <= hi && lo >= med)
 //    {
 //      random = start;
 //    }
 //    else if(hi <= lo && hi >= med)
 //    {
 //      random = end;
 //    }
 //    else if(med <= lo && med >= hi)
 //    {
 //      random = (start + end) / 2;
 //    }
 //    int pivot = data[random];
 //    int holder = data[start];
 //    data[start] = pivot;
 //    data[random] = holder;
 //    // System.out.println("The index is " + random);
 //    // System.out.println("The pivot value is " + pivot + "\n");
 //    int s = start + 1;
 //    int st = start + 1;
 //    int e = end;
 //    for(int i = 0; i < data.length && st < data.length && e > -1; i ++)
 //    {
 //      // System.out.println("Before swapping:");
 //      // System.out.println("Index st is " + st + "  Index e is " + e);
 //      // System.out.println("The array is now " + Arrays.toString(data));
 //      if(e <= st)
 //      {
 //        if(data[s] >= pivot)
 //        {
 //          data[start] = data[s - 1];
 //          data[s - 1] = pivot;
 //          random = s - 1;
 //        }
 //        else
 //        {
 //          data[start] = data[s];
 //          data[s] = pivot;
 //          random = s;
 //        }
 //        i = data.length;
 //        // System.out.println("After swapping:");
 //        // System.out.println("Index st is " + st + "  Index e is " + e);
 //        System.out.println("The array is now " + Arrays.toString(data) + "\n");
 //        continue;
 //      }
 //      if(data[st] > pivot)
 //      {
 //        holder = data[st];
 //        data[st] = data[e];
 //        data[e] = holder;
 //        e--;
 //        // System.out.println("After swapping:");
 //        // System.out.println("Index st is " + st + "  Index e is " + e);
 //        // System.out.println("The array is now " + Arrays.toString(data) + "\n");
 //        continue;
 //      }
 //      if(data[st] < pivot)
 //      {
 //        holder = data[st];
 //        data[st] = data[s];
 //        data[s] = holder;
 //        st++;
 //        s++;
 //        // System.out.println("After swapping:");
 //        // System.out.println("Index st is " + st + "  Index e is " + e);
 //        // System.out.println("The array is now " + Arrays.toString(data) + "\n");
 //        continue;
 //      }
 //      if(data[st] == pivot)
 //      {
 //        st++;
 //        // System.out.println("After swapping:");
 //        // System.out.println("Index st is " + st + "  Index e is " + e);
 //        // System.out.println("The array is now " + Arrays.toString(data) + "\n");
 //        continue;
 //      }
 //    }
 //    // System.out.println("The index of the pivot is " + random);
 //    return random;
 //  }


  // partition WITHOUT dutch flag
  public static int partition ( int [] data, int start, int end){
    if(start == end)
    {
      return start;
    }
    // int random = (((int) (Math.random() * 100) ) % (end - start + 1)) + start;
    int random = 0;
    int lo = data[start];
    int hi = data[end];
    int med = data[((start + end) / 2)];
    if(lo <= hi && lo >= med)
    {
      random = start;
    }
    else if(hi <= lo && hi >= med)
    {
      random = end;
    }
    else if(med <= lo && med >= hi)
    {
      random = (start + end) / 2;
    }
    int pivot = data[random];
    int holder = data[start];
    data[start] = pivot;
    data[random] = holder;
    // System.out.println("The index is " + random);
    // System.out.println("The pivot value is " + pivot + "\n");
    int st = start + 1;
    int e = end;
    for(int i = 0; i < data.length && st < data.length && e > -1; i ++)
    {
      // System.out.println("Before swapping:");
      // System.out.println("Index st is " + st + "  Index e is " + e);
      // System.out.println("The array is now " + Arrays.toString(data));
      if(e <= st)
      {
        if(data[st] > pivot)
        {
          data[start] = data[st - 1];
          data[st - 1] = pivot;
          random = st - 1;
        }
        else
        {
          data[start] = data[st];
          data[st] = pivot;
          random = st;
        }
        i = data.length;
        // System.out.println("After swapping:");
        // System.out.println("Index st is " + st + "  Index e is " + e);
        // System.out.println("The array is now " + Arrays.toString(data) + "\n");
        continue;
      }
      if(data[st] > pivot)
      {
        holder = data[st];
        data[st] = data[e];
        data[e] = holder;
        e--;
        // System.out.println("After swapping:");
        // System.out.println("Index st is " + st + "  Index e is " + e);
        // System.out.println("The array is now " + Arrays.toString(data) + "\n");
        continue;
      }
      if(data[st] <= pivot)
      {
        st++;
        // System.out.println("After swapping:");
        // System.out.println("Index st is " + st + "  Index e is " + e);
        // System.out.println("The array is now " + Arrays.toString(data) + "\n");
        continue;
      }
    }
    // System.out.println("The index of the pivot is " + random);
    return random;
  }


  /*return the value that is the kth smallest value of the array. k = 0 is smallest
  */
  public static int quickselect(int[] data, int k){
    int answer = quickselectH(data,k,0,data.length - 1);
    // System.out.println("The array now is " + Arrays.toString(data));
    return answer;
  }

  private static int quickselectH(int[] data, int k, int splice1, int splice2){
    int holder = partition(data,splice1,splice2);
    if(holder < k)
    {
      return quickselectH(data,k,holder + 1,splice2);
    }
    else if(holder > k)
    {
      return quickselectH(data,k,splice1,holder - 1);
    }
    else
    {
      return data[k];
    }
  }

  /*Modify the array to be in increasing order.
  */
  public static void quicksort(int[] data){
    quicksortH(data,0,data.length - 1);
  }

  private static void quicksortH(int[] data,int splice1, int splice2){
    System.out.println("This is the current array: " + Arrays.toString(data));
    int holder = partition(data,splice1,splice2);
    if(splice1 < splice2)
    {
      if(holder != 0)
      {
        quicksortH(data,splice1,holder - 1);
      }
      if(holder != data.length - 1)
      {
        quicksortH(data,holder + 1,splice2);
      }
    }
    System.out.println("This is the new array: " + Arrays.toString(data));
  }


  public static void main(String[] args){
    int[] numArray = new int[10];
    int[][] problemArrays = new int[10][10];
    // problemArrays[0] = {10, 11, 15, 11, 15, 12, 10, 14, 11, 10};
    for(int i = 0; i < numArray.length; i ++)
    {
      numArray[i] = (int) (Math.random()*1000) % 20;
    }
    System.out.println("The original array is: " + Arrays.toString(numArray));
    // partition(numArray,0,numArray.length - 1);
    // System.out.println("quickselect for the element at 4th index: " + quickselect(numArray,4));

    // System.out.println("quickselect for the 0th smallest element: " + quickselect(numArray,0));
    quicksort(numArray);
    System.out.println("The new sorted array is: " + Arrays.toString(numArray));
  }


}
