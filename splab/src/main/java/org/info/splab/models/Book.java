package org.info.splab.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.info.splab.Element;
import org.info.splab.Visitor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Book extends BaseElement {
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<BaseElement> children = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element e) {
        if (e instanceof BaseElement) {
            children.add((BaseElement) e);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (BaseElement child : children) {
            child.accept(visitor);
        }
    }

    @Override
    public void add(Element e) {
        if (e instanceof BaseElement) {
            children.add((BaseElement) e);
        }
    }

    @Override
    public void remove(Element e) {
        if (e instanceof BaseElement) {
            children.remove(e);
        }
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }
}