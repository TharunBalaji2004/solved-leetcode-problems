class Node {
    String page;
    Node prev, next;

    public Node(String page) {
        this.page = page;
    }
}

class BrowserHistory {

    Node head, tail, curr;
    
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        curr = head;
        tail = head;
    }
    
    public void visit(String url) {
        Node newPage = new Node(url);
        curr.next = newPage;
        newPage.prev = curr;
        tail = newPage;
        curr = newPage;
    }
    
    public String back(int steps) {
        while (steps > 0) {
            if (curr == head) break;

            curr = curr.prev;
            steps--;
        }

        return curr.page;
    }
    
    public String forward(int steps) {
        while (steps > 0) {
            if (curr == tail) break;

            curr = curr.next;
            steps--;
        }

        return curr.page;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */