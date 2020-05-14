package com.company;

import java.util.Stack;

public class LinkedList {
    static class Node {
        int data;
        Node next;
    }

    Node head;

    public void insert (int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public void show () {
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
        //System.out.println(node.data);
    }

    public void insertAtFirst (int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }

    public void insert (int position, int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        if (position == 0) {
            insertAtFirst(data);
        } else {
            Node n = head;
            for (int i = 0; i < position - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void delete (int position) {
        if (position == 0) {
            head = head.next;
        } else {
            Node n = head;                        //Node temp;  temp=n.next;  n.next=temp.next  temp=null
            for (int i = 0; i < position - 1; i++) {
                n = n.next;
            }
            n.next = n.next.next;
        }
    }

    public void deleteAtLast () {
        if (head == null || head.next == null) {
            return;
        } else {
            Node n = head;
            while (n.next.next != null) {
                n = n.next;
            }
            n.next = null;
        }
    }

    public int size () {
        int count = 0;
        if (head == null) {
            count = 0;
        } else {
            Node n = head;
            while (n != null) {
                count++;
                n = n.next;
            }
        }
        return count;
    }

    public boolean isNodeExists (int val) {
        if (head == null) {
            return false;
        } else {
            Node n = head;
            while (n != null) {
                if (n.data == val) {
                    return true;
                }
                n = n.next;
            }
        }
        return false;
    }

    public void rotateClockwise (int k) {
        if (head.next == null || head == null || k < 0) {
            return;
        }
        int size = size();
        k = k % size;
        if (k == 0) {
            return;
        }
        Node start = head;
        Node n = head;
        for (int i = 0; i < size - k - 1; i++) {
            n = n.next;
        }
        head = n.next;
        Node temp = n.next;
        n.next = null;
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        temp.next = start;
    }

    public void rotateAntiClockwise (int k) {
        if (head == null || head.next == null || k < 0) {
            return;
        }
        int size = size();
        k = k % size();
        if (k == 0) {
            return;
        }
        Node start = head;
        Node temp = head;
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        Node n = temp.next;
        head = n;
        temp.next = null;
        for (int i = 0; i < size - k - 1; i++) {
            n = n.next;
        }
        n.next = start;
    }

    public void reverse () {
        Node prev = null;
        Node current = head;
        Node after;
        while (current != null) {
            after = current.next;
            current.next = prev;
            prev = current;
            current = after;
        }
        head = prev;
    }

    public void recursionReversePrint () {
        rrp(head);
    }

    void rrp (Node node) {
        if (node == null) {
            return;
        }
        rrp(node.next);
        System.out.println(node.data);
    }

    public void recursionReverseLinkedList () {
        rrl(head);
    }

    void rrl (Node p) {
        if (p.next == null) {
            head = p;
            return;
        }
        rrl(p.next);
        Node q = p.next;
        q.next = p;
        p.next = null;
    }

    public void getMiddleElement () {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element is " + slow.data);
    }

    public boolean isFirstSecondHalfMatch () {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = head;
        slow = slow.next;
        while (slow != null) {
            if (temp.data != slow.data) {
                return false;
            }
            slow = slow.next;
            temp = temp.next;
        }
        return true;
    }

    public boolean ispalindrome () {
        Node slow = head;
        Node fast = head.next;
        Stack<Integer> s = new Stack<Integer>();
        s.push(slow.data);
        while (fast != null && fast.next != null) {
            s.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
            s.push(slow.data);
        }
        if (fast == null) {
            s.pop();
        }
        slow = slow.next;
        while (slow != null) {
            if (s.pop() != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public void deleteList () {
        head = null;
    }

    // i/p 12 - 99 - 8 - 39 - 5
    // o/p 99 - 39 - 5
    public void deleteGreaterValuesOnRight () {
        if (head == null || head.next == null) {
            return;
        }
        reverse();
        Node temp = head;
        int max = temp.data;
        while (temp.next != null) {
            if (temp.next.data > max) {
                max = temp.next.data;
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        reverse();
    }

    // i/p 1 - 2 - 3 - 4 - 5
    // o/p 2 - 1 - 4 - 3 - 5
    public void pairwiseSwapElements () {
        if (head == null || head.next == null) {
            return;
        }
        Node temp = head;
        while (temp != null && temp.next != null) {
            int value = temp.data;
            temp.data = temp.next.data;
            temp.next.data = value;

            temp = temp.next.next;
        }
    }

    // i/p 1 - 2 - 3 - 4 - 5
    // o/p 1 - 3 - 5
    public void deleteAlternateNodes () {
        if (head == null || head.next == null) {
            return;
        }
        Node temp = head;
        while (temp != null && temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
    }

    public void moveLastNodeTOFront () {
        Node temp = head;
        int val = 0;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        val = temp.next.data;
        temp.next = null;
        insertAtFirst(val);
    }

    public int getCountOfValue (int number) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (number == temp.data) {
                count++;
            }
            temp = temp.next;
        }
        return count;
    }

    public void seperateEvenodd () {
        if (head == null || head.next == null) {
            return;
        }

        Node evenStarting = null, evenEnding = null, oddStarting = null, oddEnding = null;
        Node temp = head;
        while (temp != null) {
            if ((temp.data & 1) == 0) {
                if (evenStarting == null) {
                    evenStarting = temp;
                    evenEnding = evenStarting;
                } else {
                    evenEnding.next = temp;
                    evenEnding = evenEnding.next;
                }
            } else {
                if (oddStarting == null) {
                    oddStarting = temp;
                    oddEnding = oddStarting;
                } else {
                    oddEnding.next = temp;
                    oddEnding = oddEnding.next;

                }
            }
            temp = temp.next;
        }
        evenEnding.next=oddStarting;
        oddEnding.next=null;
        head=evenStarting;
    }
}
