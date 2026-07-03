public class App {
    static class Item {
        int value;
        Item next;
    }

    static class LList {
        Item head;

        public void prepend(int v) {
            Item n = new Item();
            n.value = v;
            n.next = head;

            head = n;
        }

        public void prepend(Item n) {
            n.next = head;
            head = n;
        }

        public Item take() {
            if (head == null) {
                return null;
            }

            Item n = head;
            head = head.next;
            n.next = null;

            return n;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int headValue() {
            return head.value;
        }
    }


    public static void main(String[] args) throws Exception {
        /*
        int[] x = { -1, 3, -2, 0, 10 };
        int[] y = { 5, -7, 0, 1, 4, 6 };

        int[] m = new int[x.length + y.length];

        int ix = 0;
        int iy = 0;
        int im = 0;

        do {
            if (ix < x.length && iy < y.length) {
                if (x[ix] <= y[iy]) {
                    m[im] = x[ix];
                    ix++;
                } else {
                    m[im] = y[iy];
                    iy++;
                }
                ++im;
            } else if (ix < x.length) {
                for (; ix < x.length; ++im, ++ix) {
                    m[im] = x[ix];
                }
            } else {
                for (; iy < y.length; ++im, ++iy) {
                    m[im] = y[iy];
                }
            }
        } while (ix < x.length || iy < y.length);
        */

        LList ll1 = new LList();
        LList ll2 = new LList();
        LList merged = new LList();

        ll1.prepend(3);
        ll1.prepend(8);

        ll2.prepend(40);
        ll2.prepend(30);
        ll2.prepend(20);
        ll2.prepend(10);
        ll2.prepend(-7);
        ll2.prepend(4);

        do {
            if (!ll1.isEmpty() && !ll2.isEmpty()) {
                if (ll1.headValue() <= ll2.headValue()) {
                    Item n = ll1.take();
                    merged.prepend(n);
                } else {
                    Item n = ll2.take();
                    merged.prepend(n);
                }
            } else if (!ll1.isEmpty()) {
                while (!ll1.isEmpty()) {
                    merged.prepend(ll1.take());
                }
            } else {
                while (!ll2.isEmpty()) {
                    merged.prepend(ll2.take());
                }
            }
        } while (!ll1.isEmpty() || !ll2.isEmpty());
    }
}
