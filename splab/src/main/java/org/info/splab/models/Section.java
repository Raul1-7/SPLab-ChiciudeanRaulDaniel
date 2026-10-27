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
public class Section extends BaseElement {
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BaseElement> children = new ArrayList<>();

    public Section(String title) {
        this.title = title;
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