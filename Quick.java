public class Quick{
  public int partition ( int [] data, int start, int end){
    int random = ((int) (Math.random() * 100) ) % data.length;
    int pivot = data[random];
    int[] holderArray = new int[data.length];
    int s = 0;
    int e = data.length - 1;
    for(int i = 0; i < data.length && s < data.length && e > -1; i ++)
    {
      if(data[i] <= pivot)
      {
        holderArray[s] = data[i];
        s++;
      }
      if(data[i] > pivot)
      {
        holderArray[e] = data[i];
        e--;
      }
    }
    return random;
  }



}
