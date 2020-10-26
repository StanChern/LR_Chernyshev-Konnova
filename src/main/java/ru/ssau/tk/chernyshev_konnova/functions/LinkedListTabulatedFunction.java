package ru.ssau.tk.chernyshev_konnova.functions;

import ru.ssau.tk.chernyshev_konnova.exceptions.InterpolationException;

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
        checkLengthIsTheSame(xValues, yValues);
        checkSorted(xValues);
        for (int i = 0; i < xValues.length; i++) {
            this.addNode(xValues[i], yValues[i]);
        }
    }

    public LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (count < 2) {
            throw new IllegalArgumentException("Length less than 2 points");
        }
        if ((xFrom >= xTo)) {
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
        throw new UnsupportedOperationException("");
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
        if (x < head.x) {
            throw new IllegalArgumentException("X is less than the left border");
        }
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
        if (x < leftNode.x || x > rightNode.x) {
            throw new InterpolationException("X is out of bounds of interpolation");
        }
        return interpolate(x, leftNode.x, rightNode.x, leftNode.y, rightNode.y);
    }

    @Override
    public void remove(int index) {
        if (count == 2) {
            throw new UnsupportedOperationException("Length will become less than 2 points");
        }

        Node deletedNode = getNode(index);
        if (deletedNode == head) {
            head = deletedNode.next;
        } else {
            deletedNode.prev.next = deletedNode.next;
            deletedNode.next.prev = deletedNode.prev;
        }
        count--;
    }

    @Override
    public void insert(double x, double y) {
        if (count == 0) {
            addNode(x, y);
        } else if (indexOfX(x) != -1) {
            setY(indexOfX(x), y);
        } else {
            Node newNode = new Node();
            newNode.x = x;
            newNode.y = y;

            if (x <= head.x) {
                newNode.next = head;
                newNode.prev = head.prev;
                head.prev.next = newNode;
                head = newNode;
            } else {
                if (x >= head.prev.x) {
                    newNode.next = head;
                    newNode.prev = head.prev;
                    head.prev.next = newNode;
                    head.prev = newNode;
                } else {
                    int index = floorIndexOfX(x);
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

    private void checkIndex(int index) {
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException("Index out of bounds of list");
        }
    }

    @Override
    public Iterator<Point> iterator() {
        return new Iterator<>() {
            Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Point next() {
                if (!hasNext()) {
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
    }
}
