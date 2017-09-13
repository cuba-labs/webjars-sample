package com.company.webjarssample.web.gui.components;

import com.company.webjarssample.gui.components.Carousel;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;

import java.util.List;

public class WebCarousel extends WebAbstractComponent<com.company.webjarssample.web.toolkit.ui.CarouselComponent> implements Carousel {
    public WebCarousel() {
        component = new com.company.webjarssample.web.toolkit.ui.CarouselComponent();
    }

    @Override
    public void setAnimation(Animation animation) {
        component.setAnimation(animation);
    }

    @Override
    public Animation getAnimation() {
        return component.getAnimation();
    }

    @Override
    public void setSlides(List<String> slides) {
        component.setSlides(slides);
    }

    @Override
    public List<String> getSlides() {
        return component.getSlides();
    }

    @Override
    public void setNavigation(Navigation navigation) {
        component.setNavigation(navigation);
    }

    @Override
    public Navigation getNavigation() {
        return component.getNavigation();
    }
}