package org.info.splab;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    protected String title;
    protected List<Element> children = new ArrayList<>();
    private Element parent;

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void add(Element e) {
        if (e.getParent() != null) {
            throw new IllegalArgumentException("Acest element aparține deja altei secțiuni!");
        }
        e.setParent(this);
        children.add(e);
    }

    @Override
    public void remove(Element e) {
        children.remove(e);
        e.setParent(null);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element child : children) {
            child.print();
        }
    }

    @Override
    public Element getParent() { return this.parent; }

    @Override
    public void setParent(Element parent) { this.parent = parent; }
}