package com.company.webjarssample.gui.components;

import com.haulmont.cuba.gui.components.Component;

import java.util.List;

public interface Carousel extends Component {
    String NAME = "carousel";

    void setAnimation(Animation animation);
    Animation getAnimation();

    void setSlides(List<String> slides);
    List<String> getSlides();

    void setNavigation(Navigation navigation);
    Navigation getNavigation();

    enum Animation {
        SCROLL,
        SLIDE,
        FADE,
        ZOOM_IN_SLIDE,
        ZOOM_IN_SCROLL
    }

    enum Navigation {
        CIRCLES,
        SQUARES
    }
}