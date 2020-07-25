package algorithm;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class IteratorDemo {
}

interface  Iterator<E> {
  boolean hasNext();
  void next();
  E currentItem();
}

interface List<E> {
  Iterator iterator();
}

//class ArrayIterator<E> implements Iterator<E> {
//  private int cursor;
//  private ArrayList<E> arrayList;
//
//  public ArrayIterator(ArrayList<E> arrayList) {
//    this.cursor = 0;
//    this.arrayList = arrayList;
//  }
//
//  @Override
//  public boolean hasNext() {
//    return cursor != arrayList.size();
//  }
//
//  @Override
//  public void next() {
//    cursor++;
//  }
//
//  @Override
//  public E currentItem() {
//    if (cursor >= arrayList.size()) {
//      throw new NoSuchElementException();
//    }
//    return arrayList.get(cursor);
//  }
//}
//class ArrayList<E> implements List<E> {
//
//  @Override
//  public Iterator iterator() {
//    return null;
//  }
//}