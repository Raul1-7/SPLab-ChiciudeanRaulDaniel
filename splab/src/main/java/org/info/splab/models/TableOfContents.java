package org.info.splab.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.info.splab.Element;
import org.info.splab.Visitor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TableOfContents extends BaseElement {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override public void add(Element e) {}
    @Override public void remove(Element e) {}
    @Override public Element get(int index) { return null; }
}