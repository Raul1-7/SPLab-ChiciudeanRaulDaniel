package org.info.splab;

public class TableOfContents implements Element {
    private Element parent;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override public void add(Element e) { throw new UnsupportedOperationException(); }
    @Override public void remove(Element e) { throw new UnsupportedOperationException(); }
    @Override public Element get(int index) { throw new UnsupportedOperationException(); }

    @Override public Element getParent() { return this.parent; }
    @Override public void setParent(Element parent) { this.parent = parent; }
}
