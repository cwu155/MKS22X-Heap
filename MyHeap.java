import java.util.*;

public class MyHeap{
  public static int[] test;
  public static int max, temp;

  public static void pushDown(int[]data,int size,int index){
    if ((2*index) + 2 > size-1){ return; }
    if (data[(2*index) + 1] > data[index] || data[(2*index) + 2] > data[index]){

      if (data[(2*index) + 1] > data[(2*index) + 2]){
        max = (2*index) + 1;
      } else {
        max = (2*index) + 2;
      }
      //System.out.println("Bigger child index: " + max);
      temp = data[index];
      data[index] = data[max];
      data[max] = temp;
    }
  }

  public static void heapify(int[] data){
    for (int i = 0; i < data.length; i++){
      pushDown(data, data.length, i);
    }
  }

  public static void main(String[] args) {
     int[] test = {3, 10, 8, 5, 2, 4};
     heapify(test);
    // pushDown(test, 5, 0);
    // pushDown(test, 5, 1);
    // for (int i : test){System.out.println(i);}
    // System.out.println("--------------");
    // pushDown(test, 5, 2);
     for (int i : test){System.out.println(i);}
  }
}
