package org.info.splab;

import java.util.concurrent.TimeUnit;

public class Image implements Element {
    private String url;
    private Element parent;

    public Image(String name) {
        this.url = name;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    // Metoda accept care înlocuiește vechiul print()
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override public void add(Element e) { throw new UnsupportedOperationException("Nu se pot adăuga elemente într-o imagine"); }
    @Override public void remove(Element e) { throw new UnsupportedOperationException(); }
    @Override public Element get(int index) { throw new UnsupportedOperationException(); }

    @Override public Element getParent() { return this.parent; }
    @Override public void setParent(Element parent) { this.parent = parent; }
}