package DoublyLinkedList;

import LinkedList.Node;

public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    //Create a DLL
    public DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }


    //insert into a DLL
    //0. If link list doesn't
    //1. inserting at the begining
    //2. Inserting at the ending
    //3. Insert anywhere

    public void  insertDLL (int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if(head == null) {
            createDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = tail;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    //Traverse a Linked List
    public void traverseDLL(){
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size -1) {
                    System.out.print(" <->");

                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

    // Reverse Traverse
    public void reverseTraverseDLL() {
        if (tail == null) {
            System.out.println("Double Link List does not exist");
        } else {
            DoublyNode tempNpde = tail;
            for (int i = size - 1; i >= 0; i--) {
                System.out.print(tempNode.value);
                if (i != 0) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.prev;
            }
        }
        System.out.print)("\n");
    }


    // Search Node

    public boolean searchDLL(int nodeValue) {
        if (head != null) {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (yempNode.value == nodeValue) {
                    System.out.println("Node found at location: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }


    // Deletion Method
    public void deleteNodeDLL(int location) {
        if (head == null) {
            System.out.println("The Double Linked List does not exist");
            return;
        } else if (location == 0) {
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return;
            } else {
                head = head.next;
                head.prev = null;
                size--;
            }
        } else if (location >= size) {
            DoublyNode tempNode = tail.prev;
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return;
            } else {
                tempNode.next = null;
                tail = tempNode;
                size--;
            }
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            temoNode.next.prev = tempNode;
            size--;
        }
    }


    // Delete entire DLL
    public void deleteDLL() {
        DoublyNode tempNode = head;
        While (tempNode != null) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        size = 0;
        System.out.println("The Double Linked List has been deleted");
    }
}
package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertDLL(1, 0);
        doublyLinkedList.insertDLL(2, 1);
        doublyLinkedList.insertDLL(3, 2);

        doublyLinkedList.traverseDLL();
        doublyLinkedList.reverseTraverseDLL();
        doublyLinkedList.searchDLL(2);
        doublyLinkedList.deleteNodeDLL(1);
        doublyLinkedList.traverseDLL();
        doublyLinkedList.deleteDLL();
        doublyLinkedList.traverseDLL();



    }
}