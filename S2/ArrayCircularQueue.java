
import java.util.NoSuchElementException;

public class ArrayCircularQueue<T> {

    private final T[] array;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    // Constructor
    @SuppressWarnings("unchecked")
    public ArrayCircularQueue(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero");
        }

        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    // Insert an element into the queue - O(1)
    public void enqueue(T item) {

        if (item == null) {
            throw new IllegalArgumentException(
                    "Null elements are not allowed");
        }

        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        rear = (rear + 1) % capacity;

        array[rear] = item;
        size++;
    }

    // Remove an element from the queue - O(1)
    public T dequeue() {

        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T item = array[front];

        array[front] = null;

        front = (front + 1) % capacity;

        size--;

        return item;
    }

    // Return the front element without removing it - O(1)
    public T peek() {

        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return array[front];
    }

    // Check whether the queue is empty - O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // Check whether the queue is full - O(1)
    public boolean isFull() {
        return size == capacity;
    }

    // Return the number of elements - O(1)
    public int size() {
        return size;
    }

    // Return the maximum capacity - O(1)
    public int capacity() {
        return capacity;
    }

    // Demonstration
    public static void main(String[] args) {

        ArrayCircularQueue<Integer> queue = new ArrayCircularQueue<>(5);

        // Insert numbers into the queue
        System.out.println("Inserting elements:");

        queue.enqueue(10);
        System.out.println("Enqueued: 10");

        queue.enqueue(20);
        System.out.println("Enqueued: 20");

        queue.enqueue(30);
        System.out.println("Enqueued: 30");

        queue.enqueue(40);
        System.out.println("Enqueued: 40");

        // Display queue information
        System.out.println("\nQueue size: " + queue.size());
        System.out.println("Front element: " + queue.peek());

        // Remove elements
        System.out.println("\nRemoving elements:");

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        // Insert more elements to demonstrate circular behavior
        System.out.println("\nInserting more elements:");

        queue.enqueue(50);
        System.out.println("Enqueued: 50");

        queue.enqueue(60);
        System.out.println("Enqueued: 60");

        queue.enqueue(70);
        System.out.println("Enqueued: 70");

        System.out.println("\nQueue size: " + queue.size());
        System.out.println("Front element: " + queue.peek());

        // Remove all remaining elements
        System.out.println("\nRemoving remaining elements:");

        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        System.out.println("\nQueue size: " + queue.size());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
