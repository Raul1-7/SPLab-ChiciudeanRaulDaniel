package org.info.splab;

public class BookStatistics implements Visitor {
    private int paragraphsCount = 0;
    private int imagesCount = 0;
    private int tablesCount = 0;

    @Override
    public void visit(Paragraph paragraph) { paragraphsCount++; }

    @Override
    public void visit(Image image) { imagesCount++; }

    @Override
    public void visit(ImageProxy imageProxy) { imagesCount++; }

    @Override
    public void visit(Table table) { tablesCount++; }

    // Metodele pentru structură pot fi lăsate goale
    @Override public void visit(Book book) {}
    @Override public void visit(Section section) {}
    @Override public void visit(TableOfContents toc) {}

    public void printStatistics() {
        System.out.println("Book Statistics:");
        System.out.println("*** Number of images: " + imagesCount);
        System.out.println("*** Number of tables: " + tablesCount);
        System.out.println("*** Number of paragraphs: " + paragraphsCount);
    }
}
