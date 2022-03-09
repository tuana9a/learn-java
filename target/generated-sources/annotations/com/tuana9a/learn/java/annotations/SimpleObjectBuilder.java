package com.tuana9a.learn.java.annotations;

public class SimpleObjectBuilder {

    private SimpleObject object = new SimpleObject();

    public SimpleObject build() { return object; }

    public SimpleObjectBuilder address(java.lang.String value) {
        object.setAddress(value);
        return this;
    }

    public SimpleObjectBuilder name(java.lang.String value) {
        object.setName(value);
        return this;
    }

    public SimpleObjectBuilder age(int value) {
        object.setAge(value);
        return this;
    }

}
