import java.util.*;

public class MyHeap{
  public static int[] test;
  public static int max, min, temp, counter;

  public static void pushDown(int[]data,int size,int index){
    //this code big lmao
    if ((2*index) + 2 > size){ return; }
    if (data[(2*index) + 1] > data[index] || data[(2*index) + 2] > data[index]){

      if ((2*index) + 2 == size){
        max = (2*index) + 1;
        temp = data[index];
        data[index] = data[max];
        data[max] = temp;
        return;
      }

      if (data[(2*index) + 1] > data[(2*index) + 2]){
        max = (2*index) + 1;
      } else {
        max = (2*index) + 2;
      }
      temp = data[index];
      data[index] = data[max];
      data[max] = temp;
    }
  }

  public static void pushUp(int[]data,int index){
    if (2*index + 2 > data.length){return;}
    if (data[2*index + 1] < data[index] || data[2*index + 2] < data[index]){
      if (data[2*index + 1] < data[2*index + 2]){
        min = 2*index + 1;
      } else {
        min = 2*index+2;
      }
      temp = data[index];
      data[index] = data[min];
      data[min] = temp;
    }
  }

  public static void heapify(int[] data){
    for (int i = 0; i < data.length; i++){
      //pushDown(data, data.length, i);
      pushUp(data, i);
    }
  }

  public static void heapsort(int[] data){
    heapify(data);
    for (int i : data){System.out.println(i);}
    System.out.println("---------------");

    counter = data.length-1;
    for (int i = 0; i < 2; i++){
      temp = data[counter];
      data[counter] = data[0];
      data[0] = temp;
      pushDown(data, counter+1, 0);
      counter -= 1;
    }
  }

  public static void main(String[] args) {
     int[] test = {5, 8, 16, 12, 7, 0, 4};
     heapify(test);
     for (int i : test){System.out.println(i);}
  }
}
