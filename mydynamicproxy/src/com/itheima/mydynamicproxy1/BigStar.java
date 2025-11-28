package com.itheima.mydynamicproxy1;

public class BigStar implements Star {
    private String name;

    public BigStar() {
    }

    public BigStar(String name) {
        this.name = name;
    }

    @Override
    public String sing(String song) {
        System.out.println(this.name + "唱" + song);
        return "tt";
    }

    @Override
    public String dance() {
        System.out.println(this.name + "跳");
        return "tt";
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "BigStar{name = " + name + "}";
    }
}
