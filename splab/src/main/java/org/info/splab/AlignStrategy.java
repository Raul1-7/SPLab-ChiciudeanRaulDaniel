package org.info.splab;

import org.info.splab.models.Paragraph;

public interface AlignStrategy {
    void render(Paragraph paragraph, Context context);
}
