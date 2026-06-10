class LLNodeItem {
    Node node;
    LLNodeItem next;

    LLNodeItem(Node n) {
        node = n;
        next = null;
    }
}

class StackEmpty extends Exception {

}

class Stack {
    LLNodeItem topItem = null;

    void push(Node n) {
        LLNodeItem newItem = new LLNodeItem(n);

        if (topItem != null) {
            newItem.next = topItem;
        }

        topItem = newItem;
    }

    Node pop() throws StackEmpty {
        if (topItem == null) {
            throw new StackEmpty();
        }

        Node res = topItem.node;
        topItem = topItem.next;

        return res;
    }

    Node top() throws StackEmpty {
        if (topItem == null) {
            throw new StackEmpty();
        }

        return topItem.node;
    }
}
