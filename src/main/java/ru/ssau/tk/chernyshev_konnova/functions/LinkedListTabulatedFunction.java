package ru.ssau.tk.chernyshev_konnova.functions;

public class LinkedListTabulatedFunction extends AbstractTabulatedFunction {

    private Node head; //голова списка
    private Node last; //последний узел

    protected class Node {
        double x;
        double y;
        Node next;
        Node prev;
    }

    private void addNode(double x, double y) {
        Node newNode = new Node();
        if (head == null) {
            head = newNode;
            newNode.prev = newNode;
            newNode.next = newNode;
            newNode.x = x;
            newNode.y = y;
            last = newNode;
        } else {
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
            last.next = newNode;
            newNode.x = x;
            newNode.y = y;
            last = newNode;
        }
        count += 1;
    }

    LinkedListTabulatedFunction(double[] xValues, double[] yValues) {
        for (int i = 0; i < xValues.length; i++) {
            this.addNode(xValues[i], yValues[i]);
        }
    }

    LinkedListTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        //TODO: конструктор с 4 параметрами
    }

    @Override
    public double leftBound() {
        return head.x;
    }

    @Override
    public double rightBound() {
        return last.x;
    }

    private Node getNode(int index) {
        //TODO: возвращает ссылку на узел номер index
        return new Node();
    }

    @Override
    public double getX(int index) {
        return getNode(index).x;
    }

    @Override
    public double getY(int index) {
        return getNode(index).y;
    }

    @Override
    public void setY(int index, double valueY) {
        valueY = getNode(index).y;
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
        return 0;
    }

    @Override
    protected double extrapolateRight(double x) {
        return 0;
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        return 0;
    }


}
