package com.company.webjarssample.gui.xml.layout.loaders;

import com.company.webjarssample.gui.components.Carousel;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractComponentLoader;

public class CarouselLoader extends AbstractComponentLoader<Carousel> {
    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(Carousel.class);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
        assignXmlDescriptor(resultComponent, element);

        loadStyleName(resultComponent, element);

        loadWidth(resultComponent, element);
        loadHeight(resultComponent, element);
        loadAlign(resultComponent, element);
    }
}
