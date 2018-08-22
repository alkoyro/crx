package com.ak.crx.model;

/**
 * represents dto object for responses {@link com.ak.crx.controller.HillRestController}
 */
public class HillResponse {
    private String message;
    private Integer volume;

    public HillResponse() {
    }

    public HillResponse(String message, Integer volume) {
        this.message = message;
        this.volume = volume;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
