package com.vector.dubbo.dto;

public class MusersQueryRequest extends BaseRequest{

    private static final long serialVersionUID = -6488453584405756739L;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
