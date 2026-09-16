/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int value) pushes the element value onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
*/
import java.util.*;
class Minstack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mStack stack = new mStack();
        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();
        for (int i=0;i<n;i++) {
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

