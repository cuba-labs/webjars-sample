package com.company.webjarssample.web.gui.components;

import com.company.webjarssample.gui.components.Carousel;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;

public class WebCarousel extends WebAbstractComponent<com.company.webjarssample.web.toolkit.ui.CarouselComponent> implements Carousel {
    public WebCarousel() {
        component = new com.company.webjarssample.web.toolkit.ui.CarouselComponent();
    }
}