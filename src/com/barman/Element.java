package com.barman;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BARMAN
 */
public class Element {

    private int value;
    private Element next;

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public int getValue() {

        return this.value;
    }

    public Element getNext() {

        return this.next;
    }

    //  Appending of a New Element
    public Element appendElement(int value) {
        if (this.next == null) {
            Element newElement = new Element();
            newElement.setValue(value);
            this.next = newElement;
        } else {
            this.next = this.next.appendElement(value);
        }
        return this;
    }

    // Sorted Insertion of a New Element
    public Element insertElement(int value) {
        if (this.value > value) {
            Element newElement = new Element();
            newElement.setValue(value);
            newElement.setNext(this);
            return newElement;
        } else if (this.next == null) {
            Element newElement = new Element();
            newElement.setValue(value);
            this.next = newElement;
            return this;
        } else {
            this.next = this.next.insertElement(value);
            return this;
        }
    }

    // Deleting a List Element
    public Element deleteElement(int value) {
        if (this.value == value) {
            return this.next;
        } else {
            if (this.next != null) {
                this.next = this.next.deleteElement(value);
            }
            return this;
        }
    }

    //Output of Element and Succeeding Elements
    public Element printList() {
        System.out.println(value);
        if (this.next != null) {
            this.next.printList();
        }
        return this.next;
    }

    public int size() {
        if (next == null) return 0;
        else return 1 + next.size();
    }

    public int sum() {
        int sum = this.getValue();
        if (this.next != null) {
            sum = sum + this.next.sum();
        }

        return sum;
    }

    public boolean isSorted() {
        boolean isSorted = false;
        if (this.next == null) {
            isSorted = true;
        } else if (this.value < this.next.value) {
            isSorted = this.next.isSorted();
        } else if (this.value == this.next.value) {
            isSorted = this.next.isSorted();
        }
        return isSorted;
    }

    public boolean existsElement(int value) {
        boolean existsElement = false;
        if (this.value == value) {
            existsElement = true;
        } else if (this.next != null) {
            existsElement = this.next.existsElement(value);
        }
        return existsElement;
    }

    public String showValues() {
        if (this.next == null) {
            return String.valueOf(this.getValue());

        } else {
            return this.getValue() + " " + this.next.showValues();
        }
    }

    public int getValueAt(int index) {
        int getValue = Integer.MAX_VALUE;
        if (index == 0) {
            getValue = this.value;
        } else if (index > 0 && this.next != null) {
            getValue = this.next.getValueAt(index - 1);
        }
        return getValue;
    }

    public Element insertElementAtFront(int value) {
        Element temp = new Element();
        temp.setValue(value);
        temp.setNext(this);
        return temp;
    }

    public Element insertElementAt(int value, int index) {

        if (index == 0) {
            return this.insertElementAtFront(value);
        } else if (index > 0 && this.next != null) {
            this.next = this.next.insertElementAt(value, index - 1);}
        else if(index < 0 ||index > size()){
            return this;

        }
        return this;
    }
}
