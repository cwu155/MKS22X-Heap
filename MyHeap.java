import java.util.*;

public class MyHeap{
  public static int[] test;

  private static void pushDown(int[]data,int size,int index){

    while (2*index + 1 <= size-1){
      int max = 2*index + 1;

      if (2*index + 2 <= size-1 && data[2*index + 2] > data[max]){
        max = 2*index + 2;
      }

      if (data[index] < data[max]){
        int temp = data[index];
        data[index] = data[max];
        data[max] = temp;
        index = max;
      } else {
        return;
      }
    }
  }

  public static void heapify(int[] data){
    int counter = (data.length-2)/2;
    while (counter >= 0){
      pushDown(data, data.length, counter);
      counter -= 1;
    }
  }

  public static void heapsort(int[] data){
    heapify(data);

    int count = data.length-1;
    for(int i = 0; i < data.length-1; i++){
      int temp = data[count];
      data[count] = data[0];
      data[0] = temp;
      pushDown(data, count , 0);
      count -= 1;
    }
  }

  public static void main(String[] args) {
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
          heapsort(data2);
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
      }
      System.out.println();
    }
  }
}
