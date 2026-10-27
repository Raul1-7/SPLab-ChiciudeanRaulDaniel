package org.info.splab;

import org.info.splab.models.Book;
import org.info.splab.models.Section;
import org.info.splab.models.Paragraph;
import org.info.splab.models.Image;
import org.info.splab.models.Table;
import org.info.splab.models.TableOfContents;

public interface Visitor {
    void visit(Book book);
    void visit(Section section);
    void visit(Paragraph paragraph);
    void visit(Image image);
    void visit(Table table);
    void visit(TableOfContents toc);
}