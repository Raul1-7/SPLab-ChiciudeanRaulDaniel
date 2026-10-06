package org.info.splab;

public class ImageProxy {
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
}
