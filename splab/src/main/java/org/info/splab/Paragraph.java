package org.info.splab;

public class Paragraph implements Element {
    private String text;
    private Element parent;
    private AlignStrategy textAlignment; // Noua asociere către Strategy

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy textAlignment) {
        this.textAlignment = textAlignment;
    }

    @Override
    public void print() {
        if (textAlignment != null) {
            // Dacă are o strategie setată, deleagă randarea către ea
            textAlignment.render(this, new Context());
        } else {
            // Comportamentul implicit (fără aliniere)
            System.out.println("Paragraph: " + text);
        }
    }

    @Override public void add(Element e) { throw new UnsupportedOperationException(); }
    @Override public void remove(Element e) { throw new UnsupportedOperationException(); }
    @Override public Element get(int index) { throw new UnsupportedOperationException(); }

    @Override public Element getParent() { return this.parent; }
    @Override public void setParent(Element parent) { this.parent = parent; }
}