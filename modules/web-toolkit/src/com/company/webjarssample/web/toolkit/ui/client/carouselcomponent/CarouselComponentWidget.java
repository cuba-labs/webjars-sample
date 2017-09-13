package com.company.webjarssample.web.toolkit.ui.client.carouselcomponent;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Widget;

import java.util.Collections;
import java.util.List;

public class CarouselComponentWidget extends Widget {
    private static long id = 0;

    private DivElement root;
    private boolean initialized = false;

    private String animation = "fade";
    private String navigation = "circles";
    private List<String> slides = Collections.emptyList();

    public CarouselComponentWidget() {
        root = Document.get().createDivElement();
        setElement(root);

        root.setId("carousel_" + id++);
    }

    private native void createCarousel(String elementId) /*-{
        var height = this.@com.google.gwt.user.client.ui.UIObject::getOffsetHeight()();
        var width = this.@com.google.gwt.user.client.ui.UIObject::getOffsetWidth()();

        var animation = this.@com.company.webjarssample.web.toolkit.ui.client.carouselcomponent.CarouselComponentWidget::getAnimation()();
        var navigation = this.@com.company.webjarssample.web.toolkit.ui.client.carouselcomponent.CarouselComponentWidget::getNavigation()();

        var slidesWrapped = this.@com.company.webjarssample.web.toolkit.ui.client.carouselcomponent.CarouselComponentWidget::getSlides()();
        var slides = slidesWrapped.@com.google.gwt.json.client.JSONArray::getJavaScriptObject()();

        $wnd.jQuery("#"+ elementId).jRCarousel({
            slides: slides,
            width: width,
            height: height,
            animation: animation,
            navigation: navigation,
        });
    }-*/;

    @Override
    protected void onAttach() {
        super.onAttach();

        if (!initialized) {
            createCarousel(root.getId());
            initialized = true;
        }
    }

    protected void setAnimation(String animation) {
        this.animation = prettifyAnimationName(animation);

        if (isAttached()) {
            refreshCarousel();
        }
    }

    private String prettifyAnimationName(String animation) {
        StringBuilder sb = new StringBuilder();

        boolean nextShouldBeUpper = false;
        for (int i = 0; i < animation.length(); i++) {
            char c = animation.charAt(i);

            if (c == '_') {
                nextShouldBeUpper = true;
                continue;
            }

            if (!nextShouldBeUpper) {
                c = Character.toLowerCase(c);
            } else {
                nextShouldBeUpper = false;
            }

            sb.append(c);
        }
        return sb.toString();
    }

    protected void setSlides(List<String> slides) {
        this.slides = slides;

        if (isAttached()) {
            refreshCarousel();
        }
    }

    protected void setNavigation(String navigation) {
        this.navigation = navigation.toLowerCase();

        if (isAttached()) {
            refreshCarousel();
        }
    }

    // we have to recreate a carousel because JS library we using doesn't have a public API for modifying its state
    protected void refreshCarousel() {
        root.removeAllChildren();

        createCarousel(root.getId());
    }

    protected String getAnimation() {
        return animation;
    }

    protected JSONArray getSlides() {
        JSONArray array = new JSONArray();

        for (int i = 0; i < slides.size(); i++) {
            String slide = slides.get(i);

            JSONObject obj = new JSONObject();
            obj.put("src", new JSONString(slide));

            array.set(i, obj);
        }

        return array;
    }

    protected String getNavigation() {
        return navigation;
    }
}