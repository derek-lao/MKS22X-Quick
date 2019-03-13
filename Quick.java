import java.util.*;
import java.io.*;

public class Quick{
  public static int partition ( int [] data, int start, int end){
    int random = ((int) (Math.random() * 100) ) % data.length;
    int pivot = data[random];
    int holder = data[start];
    data[start] = pivot;
    data[random] = holder;
    // int[] holderArray = new int[data.length];
    int s = start + 1;
    int e = end;
    for(int i = 0; i < data.length - 1 && s < data.length && e > -1; i ++)
    {
    System.out.println("The array is now " + Arrays.toString(data));
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
      if(e == s)
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
      }
    }
    start = s;
    end = e;
    return random;
  }

  public static void main(String[] args){
    int[] numArray = new int[10];
    for(int i = 0; i < numArray.length; i ++)
    {
      numArray[i] = (int) (Math.random()*1000) % 20;
    }
    System.out.println("The original array is: " + Arrays.toString(numArray));
    System.out.println("The index is " + partition(numArray,0,numArray.length - 1));
    System.out.println("The new array is: " + Arrays.toString(numArray));

  }


}
