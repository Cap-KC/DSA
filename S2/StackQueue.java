
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class StackQueue<T> {

    private final Deque<T> inStack = new ArrayDeque<>();
    private final Deque<T> outStack = new ArrayDeque<>();

    // Insert an element into the queue - O(1)
    public void enqueue(T item) {

        if (item == null) {
            throw new IllegalArgumentException(
                    "Null elements are not allowed");
        }

        inStack.push(item);
    }

    // Remove an element from the queue - O(1) amortized
    public T dequeue() {

        shiftIfNeeded();

        if (outStack.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return outStack.pop();
    }

    // Return the front element without removing it
    public T peek() {

        shiftIfNeeded();

        if (outStack.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return outStack.peek();
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Return the number of elements
    public int size() {
        return inStack.size() + outStack.size();
    }

    // Transfer elements when outStack is empty
    private void shiftIfNeeded() {

        if (outStack.isEmpty()) {

            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    // Demonstration
    public static void main(String[] args) {

        StackQueue<Integer> queue = new StackQueue<>();

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

        // Remove elements from the queue
        System.out.println("\nRemoving elements:");

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        // Insert another element
        queue.enqueue(50);
        System.out.println("\nEnqueued: 50");

        // Remove remaining elements
        System.out.println("\nRemoving remaining elements:");

        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        System.out.println("\nQueue size: " + queue.size());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
