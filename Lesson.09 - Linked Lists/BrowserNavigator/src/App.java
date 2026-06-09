class Item {
    String url;
    Item prev;
    Item next;

    Item(String u) {
        url = u;
        prev = next = null;
    }
}

class NoSuchUrl extends Exception {

}

class BrowserNavigator {
    Item lastVisited = null;

    public String back() throws NoSuchUrl {
        if (lastVisited != null && lastVisited.prev != null) {
            lastVisited = lastVisited.prev;
            return lastVisited.url;
        }

        // return null;
        // throw
        throw new NoSuchUrl();
    }

    public String forward() throws NoSuchUrl  {
        if (lastVisited != null && lastVisited.next != null) {
            lastVisited = lastVisited.next;
            return lastVisited.url;
        }

        throw new NoSuchUrl();
    }

    public void visit(String url) {
        Item newItem = new Item(url);

        newItem.prev = lastVisited;
        if (lastVisited != null) {
            lastVisited.next = newItem;
        }

        lastVisited = newItem;

        System.out.println("Visiting " + url);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        BrowserNavigator bn = new BrowserNavigator();

        bn.visit("http://www.google.com");
        bn.visit("http://www.dhbw.com");
        bn.visit("http://www.yahoo.de");
        bn.visit("http://www.cnn.us");

        try {
            System.out.println(bn.back());
            System.out.println(bn.back());
            System.out.println(bn.forward());

            bn.visit("http://www.ferrari.it");
            System.out.println(bn.back());
            System.out.println(bn.forward());
            System.out.println(bn.forward());
        } catch (NoSuchUrl e) {
            System.out.println("cannot move back/forward");
        }
    }
}
