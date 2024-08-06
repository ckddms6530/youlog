package com.youlog.youlog.domain.visitor;

public class Visitor {
    private Long id;
    private String token;
    private String browser;
    private DeviceType deviceType;

    protected Visitor() {
    }

    private Visitor(String token, String browser, DeviceType deviceType) {
        this.token = token;
        this.browser = browser;
        this.deviceType = deviceType;
    }

    private enum DeviceType {
        PC, MOBILE, TABLET
    }
}
