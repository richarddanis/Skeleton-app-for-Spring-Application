package com.richard.danis.www.sandbox.rest.eventlistener;

import org.springframework.context.ApplicationEvent;

import java.util.Locale;

public class SomethingHappenedEvent extends ApplicationEvent {

    private String appUrl;
    private Locale locale;

    public SomethingHappenedEvent(Locale locale, String appUrl) {
        super(appUrl);
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
