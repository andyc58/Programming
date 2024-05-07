public class LLTester {

    public static void main(String args[]) {
        Queue<Integer> queue = new Queue<Integer>(); 
        Stack<Integer> stack = new Stack<Integer>(); 

        System.out.println("Queue: Should print forwards from 0 to 9");
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        while (!queue.empty()) {
            System.out.println(queue.dequeue());
        }

        System.out.println("\nStack: Should print backwards from 9 to 0");
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}