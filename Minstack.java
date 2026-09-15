import java.util.*;


class Minstack {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        mStack stack = new mStack();

        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter operation: ");
            String operation = sc.next();

            if (operation.equals("push")) {

                int value = sc.nextInt();
                stack.push(value);

            } 
            else if (operation.equals("pop")) {

                stack.pop();

            } 
            else if (operation.equals("top")) {

                System.out.println("Top = " + stack.top());

            } 
            else if (operation.equals("getMin")) {

                System.out.println("Minimum = " + stack.getMin());

            } 
            else {

                System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}

class Node {
    int val;
    int minval;
}

class mStack {
    Stack<Node> st;

    public mStack() {
        st = new Stack<>();
    }

    public void push(int value) {
        Node n = new Node();

        n.val = value;

        int mini = value;

        if (!st.isEmpty()) {
            mini = Math.min(mini, st.peek().minval);
        }

        n.minval = mini;

        st.push(n);
    }

    public void pop() {
        if (!st.isEmpty()) {
            st.pop();
        } else {
            System.out.println("Stack is empty");
        }
    }

    public int top() {
        if (!st.isEmpty()) {
            return st.peek().val;
        }

        System.out.println("Stack is empty");
        return -1;
    }

    public int getMin() {
        if (!st.isEmpty()) {
            return st.peek().minval;
        }

        System.out.println("Stack is empty");
        return -1;
    }
}

