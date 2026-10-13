package org.info.splab;

public class Table implements Element {
    private String title;
    private Element parent;

    public Table(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override public void add(Element e) { throw new UnsupportedOperationException("Nu se pot adăuga elemente într-un tabel"); }
    @Override public void remove(Element e) { throw new UnsupportedOperationException(); }
    @Override public Element get(int index) { throw new UnsupportedOperationException(); }

    @Override public Element getParent() { return this.parent; }
    @Override public void setParent(Element parent) { this.parent = parent; }
}
