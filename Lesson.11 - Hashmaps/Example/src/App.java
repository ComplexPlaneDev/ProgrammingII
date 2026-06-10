class Item {
    String value;
    Item next;

    Item(String v) {
        value = v;
        next = null;
    }
}

class LinkedList extends Object {
    Item head = null;

    void add(String v) {
        Item newItem = new Item(v);

        newItem.next = head;
        head = newItem;
    }
}

class HashMap {
    LinkedList[] buckets = new LinkedList[26];

    public void add(String s) {
        int index = HashMap.hash(s);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList();
        }

        buckets[index].add(s);
    }

    public boolean exists(String s) {
        int index = HashMap.hash(s);

        if (buckets[index] == null) {
            return false;
        }

        LinkedList ll = buckets[index];
        Item head = ll.head;
        while (head != null) {
            if (head.value.equals(s)) {
                return true;
            }

            head = head.next;
        }

        return false;
    }

    private static int hash(String v) {
        return v.toUpperCase().codePointAt(0) - 65;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        HashMap hm = new HashMap();

        hm.add("DAD");
        hm.add("DOLL");
        hm.add("HOUSE");

        System.out.println(hm.exists("CAT"));
        System.out.println(hm.exists("HOUSE"));
    }

}
