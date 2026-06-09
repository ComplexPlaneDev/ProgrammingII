class Item {
    int value;
    Item next;

    Item(int v) {
        value = v;
        next = null;
    }
}

class StackEmpty extends Exception {

}

class Stack {
    Item topItem = null;

    void push(int v) {
        Item newItem = new Item(v);

        if (topItem != null) {
            newItem.next = topItem;
        }

        topItem = newItem;
    }

    int pop() throws StackEmpty {
        if (topItem == null) {
            throw new StackEmpty();
        }

        int res = topItem.value;
        topItem = topItem.next;

        return res;
    }

    int top() throws StackEmpty {
        if (topItem == null) {
            throw new StackEmpty();
        }

        return topItem.value;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        Stack s = new Stack();

        try {
            s.push(5);
            s.push(3);
            s.push(2);
            System.out.println(s.pop());
            s.push(7);
            System.out.println(s.pop());
            System.out.println(s.pop());
            System.out.println(s.pop());
            System.out.println(s.pop());
            System.out.println(s.pop());
            System.out.println(s.pop());
        } catch (StackEmpty e) {
            System.out.println("Stack empty");
        }
    }
}
