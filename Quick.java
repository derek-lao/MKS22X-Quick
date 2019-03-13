public class Quick{
  public int partition ( int [] data, int start, int end){
    int random = ((int) (Math.random() * 100) ) % data.length;
    int pivot = data[random];
    int holder = data[0];
    data[start] = pivot;
    data[random] = holder;
    // int[] holderArray = new int[data.length];
    int s = start + 1;
    int e = end;
    for(int i = 0; i < data.length - 1 && s < data.length && e > -1; i ++)
    {
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



}
