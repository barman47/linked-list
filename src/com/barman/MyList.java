package com.barman;

public class MyList {
    private Element elements = new Element();

    public boolean isEmpty () {
        boolean isEmpty = false;
        if (this.elements.size() == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public Element appendElement (int value) {
        this.elements.appendElement(value);
        return elements;
    }

    public Element insertElement (int value) {
        this.elements.insertElement(value);
        return elements;
    }

    public int deleteElement (int value) {
        int valueToDelete = value;
        if(this.elements.existsElement(value)) {
            this.elements.deleteElement(value);
        }
        return valueToDelete;
    }

    public Element printList () {
        return this.elements.printList();
    }
    public int size () {
        return this.elements.size();
    }

    public int sum () {
        return this.elements.sum();
    }

    public boolean isSorted () {
        return this.elements.isSorted();
    }

    public boolean existsElement (int value) {
        return this.elements.existsElement(value);
    }

    public String showValues () {
        return this.elements.showValues();
    }

    public int [] getValues () {
        String value = this.elements.showValues();
        String [] integerStrings = value.split(" ");
        int [] values = new int[integerStrings.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(integerStrings[i]);
        }
        return values;
    }

    public int getValueAt (int index) {
        return this.elements.getValueAt(index);
    }

    public int insertElementAt (int value, int index) {
        this.elements.insertElementAt(value, index);
        return value;
    }

    public int insertElementAtFront (int value) {
        this.elements.insertElementAtFront(value);
        return value;
    }

    public int insertSortedIfUnique (int value) {
        String returnedValue = this.elements.showValues();
        String [] integerStrings = returnedValue.split(" ");
        int [] values = new int[integerStrings.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(integerStrings[i]);
            if (this.elements.existsElement(value)) {
                this.elements = this.elements;
            } else if (value < values[i] + 1) {
                this.elements.insertElement(value);
            }
        }
        return value;
    }
}
