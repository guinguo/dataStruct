package top.guinguo.algorithm;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Customizing DataStruct
 */
public class MyDataStruct {

    public static void main(String[] args) {
        MyDataStruct mds = new MyDataStruct();
        mds.testStack();
    }

    public void testStack() {
        try {
            MyDataStruct mds = new MyDataStruct();
            MyStack stack = mds.MyStack();
            System.out.println(stack.empty());
            System.out.println(stack.push(new MyDataStruct()));
            System.out.println(stack.empty());
            System.out.println(stack.size());
            stack.push(new MyDataStruct());
            stack.push(new MyDataStruct());
            stack.push(new MyDataStruct());
            System.out.println(stack.size());
            System.out.println(stack.peek());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Stack design by Object[]
     * @return
     */
    public MyStack MyStack(){
        return new MyStack();
    }

    public MyStack MyStack(int size) {
        return new MyStack(size);
    }

    class MyStack{

        public static final int DEFAULT_SIZE = 12;
        private Object[] stack;
        private int top;

        public MyStack(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("Illegal Size");
            }
            this.top = 0;
            this.stack = new Object[size];
        }

        public MyStack() {
            this.top = 0;
            this.stack = new Object[DEFAULT_SIZE];
        }

        public Object push(Object o) {
            if (top >= this.stack.length) {
                stack = Arrays.copyOf(stack, top + (top >> 1));
            }
            stack[top++] = o;
            return o;
        }

        public Object pop() {
            if (top == 0) {
                throw new EmptyStackException();
            }
            return stack[--top];
        }

        public Object peek() {
            if (top == 0) {
                throw new EmptyStackException();
            }
            return stack[top-1];
        }

        public boolean empty() {
            return top == 0;
        }

        public int size() {
            return top;
        }
    }
}
