import java.util.LinkedList;

class MyCircularDeque {
    private LinkedList<Integer> dq;
    private int n;

    public MyCircularDeque(int k) {
        dq = new LinkedList<>();
        n = k;
    }

    public boolean insertFront(int value) {
        if (dq.size() < n) {
            dq.addFirst(value);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (dq.size() < n) {
            dq.addLast(value);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!dq.isEmpty()) {
            dq.removeFirst();
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!dq.isEmpty()) {
            dq.removeLast();
            return true;
        }
        return false;
    }

    public int getFront() {
        return dq.isEmpty() ? -1 : dq.getFirst();
    }

    public int getRear() {
        return dq.isEmpty() ? -1 : dq.getLast();
    }

    public boolean isEmpty() {
        return dq.isEmpty();
    }

    public boolean isFull() {
        return dq.size() == n;
    }
}