package com.company.webjarssample.web.toolkit.ui.client.carouselcomponent;

import com.company.webjarssample.web.toolkit.ui.CarouselComponent;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.shared.ui.Connect;

@Connect(CarouselComponent.class)
public class CarouselComponentConnector extends AbstractFieldConnector {
    @Override
    public CarouselComponentState getState() {
        return (CarouselComponentState) super.getState();
    }

    @Override
    public CarouselComponentWidget getWidget() {
        return (CarouselComponentWidget) super.getWidget();
    }
}
