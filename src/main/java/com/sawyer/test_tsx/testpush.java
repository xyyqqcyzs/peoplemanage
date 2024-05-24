package com.sawyer.test_tsx;

public class testpush {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public testpush(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "testpush{" +
                "name='" + name + '\'' +
                '}';
    }
}
