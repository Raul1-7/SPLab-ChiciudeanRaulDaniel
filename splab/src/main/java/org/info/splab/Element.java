package org.info.splab;

public interface Element {
    void print();
    void add(Element e);
    void remove(Element e);
    Element get(int index);

    Element getParent();
    void setParent(Element parent);
}
