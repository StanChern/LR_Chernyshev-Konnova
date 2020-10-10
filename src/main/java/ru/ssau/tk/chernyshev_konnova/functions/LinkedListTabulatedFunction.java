package ru.ssau.tk.chernyshev_konnova.functions;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction implements Insertable, Removable {

    private Node head;

    protected static class Node {
        public double x;
        public double y;
        public Node next;
        public Node prev;
    }

    public LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length < 2) {
            throw new IllegalArgumentException("Length less than 2 points");
        }
        for (int i = 0; i < xValues.length; i++) {
            this.addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (count < 2) {
            throw new IllegalArgumentException("Length less than 2 points");
        }
        if ((xFrom >= xTo) || (xFrom < 0) | (xTo < 0)) {
            throw new IllegalArgumentException("Incorrect parameter values");
        }
        double step = (xTo - xFrom) / (count - 1);
        for (int i = 0; i < count; i++) {
            this.addNode(xFrom, source.apply(xFrom));
            xFrom += step;
        }
    }

    public void addNode(double x, double y) {
        Node newNode = new Node();
        newNode.x = x;
        newNode.y = y;
        if (head == null) {
            head = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
        } else {
            Node last = head.prev;
            newNode.prev = last;
            newNode.next = head;
            last.next = newNode;
        }
        head.prev = newNode;
        count++;
    }

    @Override
    public double leftBound() {
        return head.x;
    }

    @Override
    public double rightBound() {
        return head.prev.x;
    }

    private Node getNode(int index) {
        checkIndex(index);
        Node indexNode;
        if (index <= (count / 2)) {
            indexNode = head;
            for (int i = 0; i < count; i++) {
                if (i == index) {
                    return indexNode;
                }
                indexNode = indexNode.next;
            }
        } else {
            indexNode = head.prev;
            for (int i = count - 1; i > 0; i--) {
                if (i == index) {
                    return indexNode;
                }
                indexNode = indexNode.prev;
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getX(int index) {
        checkIndex(index);
        return getNode(index).x;
    }

    @Override
    public double getY(int index) {
        checkIndex(index);
        return getNode(index).y;
    }

    @Override
    public void setY(int index, double valueY) {
        checkIndex(index);
        getNode(index).y = valueY;
    }

    @Override
    public int indexOfX(double x) {
        Node indexNode = head;
        for (int i = 0; i < count; i++) {
            if (indexNode.x == x) {
                return i;
            }
            indexNode = indexNode.next;
        }
        return -1;
    }

    @Override
    public int indexOfY(double y) {
        Node indexNode = head;
        for (int i = 0; i < count; i++) {
            if (indexNode.y == y) {
                return i;
            }
            indexNode = indexNode.next;
        }
        return -1;
    }

    @Override
    protected int floorIndexOfX(double x) {
        Node indexNode = head;
        for (int i = 0; i < count; i++) {
            if (indexNode.x < x) {
                indexNode = indexNode.next;
            } else {
                if (i == 0) {
                    return 0;
                }
                return i - 1;
            }
        }
        return getCount();
    }

    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, head.x, head.next.x, head.y, head.next.y);
    }

    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x, head.prev.prev.x, head.prev.x, head.prev.prev.y, head.prev.y);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        Node leftNode = getNode(floorIndex);
        Node rightNode = leftNode.next;
        return interpolate(x, leftNode.x, rightNode.x, leftNode.y, rightNode.y);
    }

    @Override
    public void remove(int index) {
        Node deletedNode = getNode(index);
        deletedNode.prev.next = deletedNode.next;
        deletedNode.next.prev = deletedNode.prev;
        count--;
    }

    @Override
    public void insert(double x, double y) {

        if (count == 0) {
            addNode(x, y);

        } else if (indexOfX(x) != -1) {
            setY(indexOfX(x), y);

        } else {
            int index = floorIndexOfX(x);
            Node newNode = new Node();
            newNode.x = x;
            newNode.y = y;

            if (index == 0) {
                newNode.next = head;
                newNode.prev = head.prev;
                head.prev.next = newNode;
                head = newNode;
            } else {
                if (index == count) {
                    newNode.next = head;
                    newNode.prev = head.prev;
                    head.prev.next = newNode;
                    head.prev = newNode;
                } else {
                    Node previous = getNode(index);
                    newNode.next = previous.next;
                    newNode.prev = previous;
                    previous.next = newNode;
                    newNode.next.prev = newNode;
                }
            }
            count++;
        }
    }

    @Override
    public Iterator<Point> iterator() {
        Iterator<Point> myIterator = new Iterator<Point>() {
            Node node = head;

            @Override
            public boolean hasNext() {
                if (node.next instanceof Node) {
                    return false;
                }
                return true;
            }

            @Override
            public Point next() {
                if (hasNext() == false) {
                    throw new NoSuchElementException();
                }
                Point point = new Point(node.x, node.y);
                if (node == head.prev) {
                    node = null;
                } else {
                    node = node.next;
                }
                return point;
            }
        };
        return myIterator;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > count - 1) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds of array");
        }
    }
}
