package algorithm;

import java.util.HashMap;

public class LinkedListDemo {
  private static HashMap<Node, Integer> nodeMap = new HashMap<>();

  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(4);
    Node node3 = new Node(6);
    Node node4 = new Node(8);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    Node node11 = new Node(2);
    Node node22 = new Node(3);
    Node node33 = new Node(5);
    Node node44 = new Node(7);
    node11.next = node22;
    node22.next = node33;
    node33.next = node44;

//    reverseByTraversal(node1);
    System.out.println(mergeByRecursion(node1, node11));
  }

  /********* 单链表的反转 *******/

  /**
   * recursion 递归法
   * @param head
   * @return
   */
  public static Node reverseByRecursion (Node head) {
    if (head == null || head.next == null) {
      return head;
    }
    Node temp = head.next;
    Node newHead = reverseByRecursion(head.next);
    temp.next = head;
    head.next = null;
    return newHead;
  }

  public static Node reverseByTraversal (Node node) {
    Node pre = null;
    Node next = null;
    while (node != null) {
      next = node.next;
      node.next = pre;
      pre = node;
      node = next;
    }
    return pre;
  }

  /********* 链表中环的检测 *******/

  /**
   * 快慢指针法 判断链表是否有环
   * @param head
   * @return
   */
  public static boolean hasLoopV1 (Node head) {
    if (head == null) {
      return false;
    }

    Node p = head;
    Node q = head.next;

    //快指针未能遍历所有结点
    while (q != null && q.next != null) {
      p = p.next; // 遍历一个结点
      q = q.next.next; // 遍历两个结点

      // 已到链表末尾
      if (q == null) {
        return false;
      } else if (p == q) {
        // 快慢指针相遇，存在环
        return true;
      }
    }
    return false;
  }

  /**
   * 足迹法：遍历所有节点，并将所有遍历过的结点信息保存下来，如果结点的信息出现了两次，则存在环
   *
   * @param head
   * @param index
   * @return
   */
  public static boolean hasLoopV2 (Node head, int index) {
    if (head == null || head.next == null) {
      return false;
    }

    if (nodeMap.containsKey(head)) {
      return true;
    } else {
      nodeMap.put(head, index);
      return hasLoopV2(head.next, index++);
    }
  }

  /**
   * 递归法进行合并
   * @param list1
   * @param list2
   * @return
   */
  public static Node mergeByRecursion (Node list1, Node list2) {
    // 将1，2 合并
    if (list1 == null || list2 == null) {
      return list1 == null ? list2: list1;
    }

    Node head = null;
    if (list1.value <= list2.value) {
      head = list1;
      head.next = mergeByRecursion(list1.next, list2);
    } else {
      head = list2;
      head.next = mergeByRecursion(list1, list2.next);
    }
    return head;
  }

  /**
   * 非递归算法 -- 简化
   * @param node1
   * @param node2
   * @return
   */
  public static Node mergeNoRecursion(Node node1, Node node2) {
    if (node1 == null || node2 == null) {
      return node1 == null ? node2 : node1;
    }

    Node head = node1.value <= node2.value ? node1 : node2;

    Node list1 = head == node1 ? node1 : node2;
    Node list2 = head == node1 ? node2 : node1;

    Node point = head;
    list1 = list1.next;

    while (list1 != null && list2 != null) {
      if (list1.value <= list2.value) {
        point.next = list1;
        list1 = list1.next;
      } else {
        point.next = list2;
        list2 = list2.next;
      }
      point = point.next;
    }

    point.next = list1 == null ? list2 : list1;
    return head;
  }
}

class Node {
  public int value;
  public Node next;

  public Node (int data) {
    this.value = data;
  }

  @Override
  public String toString() {
    return "Node{" +
            "value=" + value +
            ", next=" + next +
            '}';
  }
}

