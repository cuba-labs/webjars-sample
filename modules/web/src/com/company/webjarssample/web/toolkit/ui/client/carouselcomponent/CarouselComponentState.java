package com.company.webjarssample.web.toolkit.ui.client.carouselcomponent;

import com.vaadin.shared.AbstractFieldState;

import java.util.Collections;
import java.util.List;

public class CarouselComponentState extends AbstractFieldState {
    {
        primaryStyleName = "carousel";
    }

    public String animation = "FADE";
    public String navigation = "circles";
    public List<String> slides = Collections.emptyList();
}
