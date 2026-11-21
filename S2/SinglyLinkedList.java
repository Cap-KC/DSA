
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

    // Node class
    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor
    public SinglyLinkedList() {
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

        newNode.next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
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

        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        return removedData;
    }

    // Remove the last element - O(n)
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

            Node<T> current = head;

            while (current.next != tail) {
                current = current.next;
            }

            current.next = null;
            tail = current;
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

    // Display all elements - O(n)
    public void display() {

        Node<T> current = head;

        System.out.print("Head -> ");

        while (current != null) {

            System.out.print(current.data + " -> ");

            current = current.next;
        }

        System.out.println("null");
    }

    // Demonstration
    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        // Insert elements at the end
        System.out.println("Inserting elements:");

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        list.display();

        // Insert an element at the beginning
        System.out.println("\nInserting 5 at the beginning:");

        list.addFirst(5);
        list.display();

        // Display list information
        System.out.println("\nList size: " + list.size());
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        // Search for an element
        System.out.println("\nSearching for 30:");

        System.out.println("Contains 30? " + list.contains(30));
        System.out.println("Contains 100? " + list.contains(100));

        // Remove the first element
        System.out.println("\nRemoving first element:");

        System.out.println("Removed: " + list.removeFirst());
        list.display();

        // Remove the last element
        System.out.println("\nRemoving last element:");

        System.out.println("Removed: " + list.removeLast());
        list.display();

        // Display final information
        System.out.println("\nFinal list size: " + list.size());
        System.out.println("Is list empty? " + list.isEmpty());
    }
}
