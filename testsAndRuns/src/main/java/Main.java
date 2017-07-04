import java.util.Stack;

/**
 * Created by clr on 27.04.2017.
 */
public class Main {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Main() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x < getMin()) minStack.push(x);
    }

    public void pop() {
        if (stack.peek() == minStack.peek()) minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main (String[] args) {
        Main stack = new Main();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
