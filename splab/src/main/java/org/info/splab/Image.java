package org.info.splab;

public class Image implements Element {
    private String url;
    private Element parent;

    public Image(String url) { this.url = url; }

    @Override
    public void print() { System.out.println("Image with name:" + url); }

    @Override public void add(Element e) { throw new UnsupportedOperationException("Nu se pot adăuga elemente într-o imagine"); }
    @Override public void remove(Element e) { throw new UnsupportedOperationException(); }
    @Override public Element get(int index) { throw new UnsupportedOperationException(); }

    @Override public Element getParent() { return this.parent; }
    @Override public void setParent(Element parent) { this.parent = parent; }
}