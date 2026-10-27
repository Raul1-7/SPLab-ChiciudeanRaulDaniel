package org.info.splab;

import org.info.splab.models.Image;
import org.info.splab.Element;

public class ImageProxy implements Element {
    private String url;
    private Image realImage;
    private Element parent;

    public ImageProxy(String name) {
        this.url = name;
    }

    public Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this.loadImage());
    }

    @Override public void add(Element e) { throw new UnsupportedOperationException("Nu se pot adăuga elemente într-un ImageProxy"); }
    @Override public void remove(Element e) { throw new UnsupportedOperationException(); }
    @Override public Element get(int index) { throw new UnsupportedOperationException(); }

    @Override public Element getParent() { return this.parent; }
    @Override public void setParent(Element parent) { this.parent = parent; }
}
