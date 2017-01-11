package top.guinguo.algorithm;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Customizing DataStruct
 */
public class MyDataStruct {

    public static void main(String[] args) {
        MyDataStruct mds = new MyDataStruct();
        mds.testQueue();
    }

    public void testStack() {
        try {
            MyStack stack = new MyStack();
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

    public void testQueue() {
        try {
            MyQueue queue = new MyQueue(20);
            MyQueue<String> mq = new MyQueue();
            mq.add("d");
            System.out.println(mq.poll());
            System.out.println(queue.add(new MyDataStruct()));
            System.out.println(queue.size());
            System.out.println(queue.peek());
            System.out.println(queue.element());
            System.out.println(queue.poll());
//            System.out.println(queue.peek());
//            System.out.println(queue.element());
            System.out.println(queue.offer(new MyDataStruct()));
            System.out.println(queue.size());
            System.out.println(queue.remove());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Stack design by Object[]
     * @return
     */

    class MyStack{

        private static final int DEFAULT_SIZE = 12;
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

    class MyQueue<E>{
        private static final int DEFAULT_SIZE = 12;
        private Object[] queue;
        private int tail;

        public MyQueue() {
            this.tail = 0;
            this.queue = new Object[DEFAULT_SIZE];
        }

        public MyQueue(int size) {
            if (size < 1)
                throw new IllegalArgumentException();
            if (size > Integer.MAX_VALUE - 8)
                throw new IllegalArgumentException();
            this.tail = 0;
            this.queue = new Object[size];
        }

        public boolean add(E e) {
            return offer(e);
        }

        public boolean offer(E e) {
            if (e == null)
                throw new NullPointerException();
            if (tail == queue.length) {
                queue = Arrays.copyOf(queue, (tail + (tail >> 1)));
            }
            queue[tail++] = e;
            return true;
        }

        public E remove() {
            if (tail == 0)
                throw new NoSuchElementException();
            E e = (E) queue[0];
            for (int i=1;i<tail;i++) {
                queue[i - 1] = queue[i];
            }
            tail--;
            return e;
        }

        public E poll() {
            if (tail == 0)
                return null;
            E e = (E) queue[0];
            for (int i=1;i<tail;i++) {
                queue[i - 1] = queue[i];
            }
            tail--;
            return e;
        }

        public E peek() {
            if (tail == 0)
                return null;
            return (E) queue[0];
        }

        public E element() {
            if (tail == 0)
                throw new NoSuchElementException();
            return (E) queue[0];
        }

        public int size() {
            return tail;
        }
    }
}
