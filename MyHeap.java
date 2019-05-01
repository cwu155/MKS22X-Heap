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
     int[] test = {10, 3, 7, 6, 1, 4, 2, 5, 6, 22, 2, 3, 111, 44, 27};
     //int[] test = {22, 33, 79, 4, 44};
     //int[] test = {49,	38,	44,	25,	42,	23,	18};
     //heapify(test);
     heapsort(test);
     for (int i : test){System.out.println(i);}
  }
}
