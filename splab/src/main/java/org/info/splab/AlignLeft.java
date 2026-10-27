package org.info.splab;

import org.info.splab.models.Paragraph;

public class AlignLeft implements AlignStrategy{
    @Override
    public void render(Paragraph paragraph, Context context) {
        System.out.println("## " + paragraph.getText());
    }
}
