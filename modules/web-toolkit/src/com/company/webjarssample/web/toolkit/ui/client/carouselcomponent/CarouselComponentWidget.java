package com.company.webjarssample.web.toolkit.ui.client.carouselcomponent;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

public class CarouselComponentWidget extends Widget {
    private static long id = 0;

    private final DivElement root;
    private boolean initialized = false;

    public CarouselComponentWidget() {
        root = Document.get().createDivElement();
        setElement(root);

        root.setId("carousel_" + ++id);
    }

    private native void initCarousel(String elementId) /*-{
        var images = [
            {src: 'VAADIN/images/1.jpg'},
            {src: 'VAADIN/images/2.jpg'},
            {src: 'VAADIN/images/3.jpg'},
            {src: 'VAADIN/images/4.jpg'},
            {src: 'VAADIN/images/5.jpg'},
            {src: 'VAADIN/images/6.jpg'},
            {src: 'VAADIN/images/7.jpg'}
        ];

        $wnd.jQuery("#"+ elementId).jRCarousel({
            slides: images
        });
    }-*/;

    @Override
    protected void onAttach() {
        super.onAttach();

        if (!initialized) {
            initCarousel(root.getId());
            initialized = true;
        }
    }
}