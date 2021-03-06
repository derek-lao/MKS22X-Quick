import java.util.*;
import java.io.*;

public class Quick{
  /**@return the index of the final position of the pivot element.
 */
  // partition WITHOUT dutch flag
  public static int partition ( int [] data, int start, int end){
    // System.out.println("BEFORE ANY SWAPPING AT ALL the array is now " + Arrays.toString(data));
    // System.out.println("The start index is " + start + " and the end index is " + end);
    if(start == end)
    {
      return start;
    }
    int random = 0; // debug
    int lo = data[start];
    int hi = data[end];
    int med = data[((start + end) / 2)];
    if((lo <= hi && lo >= med) || (lo >= hi && lo <= med))
    {
      random = start;
    }
    else if((hi <= lo && hi >= med) || (hi >= lo && hi <= med))
    {
      random = end;
    }
    else if((med <= lo && med >= hi) || (med >= lo && med <= hi))
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
    for(;st < data.length && e > -1;)
    {
      // System.out.println("Before swapping:");
      // System.out.println("Index st is " + st + "  Index e is " + e);
      // System.out.println("The array is now " + Arrays.toString(data));
      if(e <= st)
      {
        if(data[st] >= pivot)
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
        st = data.length;
        // System.out.println("After final swapping:");
        // System.out.println("Index st is " + st + "  Index e is " + e);
        // System.out.println("The array is now " + Arrays.toString(data) + "\n");
      }
      else if(data[st] > pivot)
      {
        holder = data[st];
        data[st] = data[e];
        data[e] = holder;
        e--;
        // System.out.println("After swapping:");
        // System.out.println("Index st is " + st + "  Index e is " + e);
        // System.out.println("The array is now " + Arrays.toString(data) + "\n");
      }
      else if(data[st] < pivot)
      {
        st++;
        // System.out.println("After swapping:");
        // System.out.println("Index st is " + st + "  Index e is " + e);
        // System.out.println("The array is now " + Arrays.toString(data) + "\n");
      }
      else
      {
        int thing = ((int) (Math.random() * 1000)) % 2;
        // System.out.println("The stupid random mod2 is " + thing);
        if( (thing == 0))
        {
          st++;
          // System.out.println("After swapping:");
          // System.out.println("Index st is " + st + "  Index e is " + e);
          // System.out.println("The array is now " + Arrays.toString(data) + "\n");
        }
        else
        {
          holder = data[st];
          data[st] = data[e];
          data[e] = holder;
          e--;
          // System.out.println("After swapping:");
          // System.out.println("Index st is " + st + "  Index e is " + e);
          // System.out.println("The array is now " + Arrays.toString(data) + "\n");
        }
      }
    }
    // System.out.println("The index of the pivot is " + random);
    // System.out.println("The pivot value was " + pivot);
    // System.out.println("Finished this partition call.\n");
    return random;
  }

  // copy over partition with dutch flag
  private static int[] partitionSecret ( int [] data, int start, int end){
//     System.out.println("BEFORE ANY SWAPPING AT ALL the array is now " + Arrays.toString(data));
//     System.out.println("The start index is " + start + " and the end index is " + end);
    if(start == end)
    {
      int[] indexList = {start,start};
      return indexList;
    }
    int random = 0; // debug
    int lo = data[start];
    int hi = data[end];
    int med = data[((start + end) / 2)];
    if((lo <= hi && lo >= med) || (lo >= hi && lo <= med))
    {
      random = start;
    }
    else if((hi <= lo && hi >= med) || (hi >= lo && hi <= med))
    {
      random = end;
    }
    else if((med <= lo && med >= hi) || (med >= lo && med <= hi))
    {
      random = (start + end) / 2;
    }
    int pivot = data[random];
    int holder = data[start];
    data[start] = pivot;
    data[random] = holder;
//     System.out.println("The index is " + random);
//     System.out.println("The pivot value is " + pivot + "\n");
    int st = start + 1;
    int s = st;
    int e = end;
    for(;st < data.length && e > -1;)
    {
//       System.out.println("Before swapping:");
//       System.out.println("Index st is " + st + "  Index e is " + e);
//       System.out.println("The array is now " + Arrays.toString(data));
      if(e <= st)
      {
        if(data[st] >= pivot)
        {
          data[start] = data[s - 1];
          data[s - 1] = pivot;
          random = st - 1;
        }
        else
        {
          data[start] = data[st];
          data[st] = pivot;
          random = st;
        }
        st = data.length;
//         System.out.println("After swapping:");
//         System.out.println("Index st is " + st + "  Index e is " + e);
//         System.out.println("The array is now " + Arrays.toString(data) + "\n");
      }
      else if(data[st] > pivot)
      {
         holder = data[st];
         data[st] = data[e];
         data[e] = holder;
         e--;
//          System.out.println("After swapping:");
//          System.out.println("Index st is " + st + "  Index e is " + e);
//          System.out.println("The array is now " + Arrays.toString(data) + "\n");
       }
       else if(data[st] < pivot)
       {
         holder = data[st];
         data[st] = data[s];
         data[s] = holder;
         st++;
         s++;
//          System.out.println("After swapping:");
//          System.out.println("Index st is " + st + "  Index e is " + e);
//          System.out.println("The array is now " + Arrays.toString(data) + "\n");
       }
       else // (data[st] == pivot)
       {
         st++;
//          System.out.println("After swapping:");
//          System.out.println("Index st is " + st + "  Index e is " + e);
//          System.out.println("The array is now " + Arrays.toString(data) + "\n");
      }
    }
//     System.out.println("The index of the pivot is " + random);
//     System.out.println("The pivot value was " + pivot);
//     System.out.println("Finished this partition call.\n");
    int[] indexList = {s,random};
    return indexList;
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
    // System.out.println("This is the current array: " + Arrays.toString(data));
    quicksortH(data,0,data.length - 1);
    // for(int i = 0; i < data.length; i ++)
    // {
    //   data[i] = quickselectH(data,i,i,data.length - 1);
    // }
    // System.out.println("This is the new array: " + Arrays.toString(data));
  }

  private static void quicksortH(int[] data,int splice1, int splice2){
    // System.out.println("This is the current array: " + Arrays.toString(data));
    if(splice1 <= splice2)
    {
      if(splice2 - splice1 <= 50)
      {
        insertionsort(data,splice1,splice2);
      }
      else
      {
        int[] holder = partitionSecret(data,splice1,splice2);
        if(holder[0] != 0)
        {
          quicksortH(data,splice1,holder[0] - 1);
        }
        if(holder[1] != data.length - 1)
        {
          quicksortH(data,holder[1] + 1,splice2);
        }
      }
    }
    // System.out.println("This is the new array: " + Arrays.toString(data));
  }

  public static void insertionsort(int[] data, int lo,int hi){
    for(int i = lo + 1; i <= hi; i ++)
    {
      // System.out.println("Initial look at array " + Arrays.toString(data));
      if(data[i] < data[i - 1])
      {
        for(int n = i; n > lo; n --)
        {
          if(data[n - 1] > data[n])
          {
            int holder = data[n - 1];
            data[n - 1] = data[n];
            data[n] = holder;
          }
          else
          {
            n = -1;
          }
          // System.out.println("Something wrong has been found and fixed " + Arrays.toString(data));
        }
      }
    }
  }


//   public static void main(String[] args){
//     // int[] randomArray = new int[((int) (Math.random() * 1000)) % 20];
//     int[] randomArray = new int[10];
//     int[][] problemArrays = new int[10][10];
//     int[] issueArray = {2, 14, 2, 11, 7, 0, 15, 2, 16, 0};
//     problemArrays[0] = issueArray;
//     int randomIndex = 0;
//
//     for(int i = 0; i < randomArray.length; i ++)
//     {
//       randomArray[i] = ((int) (Math.random() * 1000)) % 20;
//       randomIndex = ((int) (Math.random() * 1000)) % randomArray.length;
//     }
//     System.out.println("The original array is: " + Arrays.toString(randomArray));
//     quicksort(randomArray);
//     System.out.println("The array is: " + Arrays.toString(randomArray));
//     // System.out.println("The original array is: " + Arrays.toString(issueArray));
//     // quicksort(issueArray);
//     // System.out.println("The array is: " + Arrays.toString(issueArray));
//     // System.out.println("The original array is " + Arrays.toString(randomArray));
//     // System.out.println("The " + randomIndex + "th sorted element of the array is " + quickselect(randomArray,randomIndex));
//     // System.out.println("After finding the element, the array is " + Arrays.toString(randomArray));
// //   }

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
        // System.out.println("Numerator is " + qtime);
        // System.out.println("Denominator is " + btime);
      }
      System.out.println();
    }
  }

}
