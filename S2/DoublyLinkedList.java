
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {

    // Node class
    private static class Node<T> {

        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Insert an element at the beginning - O(1)
    public void addFirst(T item) {

        if (item == null) {
            throw new IllegalArgumentException(
                    "Null elements are not allowed");
        }

        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    // Insert an element at the end - O(1)
    public void addLast(T item) {

        if (item == null) {
            throw new IllegalArgumentException(
                    "Null elements are not allowed");
        }

        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    // Remove the first element - O(1)
    public T removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException(
                    "List is empty");
        }

        T removedData = head.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;

        return removedData;
    }

    // Remove the last element - O(1)
    public T removeLast() {

        if (isEmpty()) {
            throw new NoSuchElementException(
                    "List is empty");
        }

        T removedData = tail.data;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;

        return removedData;
    }

    // Get the first element - O(1)
    public T getFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException(
                    "List is empty");
        }

        return head.data;
    }

    // Get the last element - O(1)
    public T getLast() {

        if (isEmpty()) {
            throw new NoSuchElementException(
                    "List is empty");
        }

        return tail.data;
    }

    // Search for an element - O(n)
    public boolean contains(T item) {

        Node<T> current = head;

        while (current != null) {

            if (current.data.equals(item)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Return the number of elements - O(1)
    public int size() {
        return size;
    }

    // Check whether the list is empty - O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // Display elements from head to tail - O(n)
    public void displayForward() {

        Node<T> current = head;

        System.out.print("Head -> ");

        while (current != null) {

            System.out.print(current.data + " <-> ");

            current = current.next;
        }

        System.out.println("null");
    }

    // Display elements from tail to head - O(n)
    public void displayBackward() {

        Node<T> current = tail;

        System.out.print("Tail -> ");

        while (current != null) {

            System.out.print(current.data + " <-> ");

            current = current.prev;
        }

        System.out.println("null");
    }

    // Demonstration
    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Insert elements at the end
        System.out.println("Inserting elements:");

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        list.displayForward();

        // Insert an element at the beginning
        System.out.println("\nInserting 5 at the beginning:");

        list.addFirst(5);
        list.displayForward();

        // Display list information
        System.out.println("\nList size: " + list.size());
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        // Display backward
        System.out.println("\nTraversing backward:");

        list.displayBackward();

        // Search for an element
        System.out.println("\nSearching for 30:");

        System.out.println("Contains 30? " + list.contains(30));
        System.out.println("Contains 100? " + list.contains(100));

        // Remove the first element
        System.out.println("\nRemoving first element:");

        System.out.println("Removed: " + list.removeFirst());
        list.displayForward();

        // Remove the last element
        System.out.println("\nRemoving last element:");

        System.out.println("Removed: " + list.removeLast());
        list.displayForward();

        // Display final information
        System.out.println("\nFinal list size: " + list.size());
        System.out.println("Is list empty? " + list.isEmpty());

        // Display backward again
        System.out.println("\nFinal backward traversal:");

        list.displayBackward();
    }
}
