package algorithm;

import org.w3c.dom.ls.LSOutput;

import java.util.stream.Stream;

public class BubbleSort {
  public static void main(String[] args) {
    Integer[] arr = {2,9,3,4,5,6,7,0};
    for (int i = 0; i < arr.length; i++) {
      for (int j = arr.length - 2; j >= i; j--) {
        int tmp = arr[j];
        if(tmp > arr[j + 1]) {
          arr[j] = arr[j + 1];
          arr[j + 1] = tmp;
        }
      }
    }

    Stream.of(arr)
            .forEach(c -> System.out.println(c));
  }
}
