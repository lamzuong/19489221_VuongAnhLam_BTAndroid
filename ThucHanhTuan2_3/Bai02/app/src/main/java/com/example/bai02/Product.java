package com.example.bai02;

public class Product extends Goods {
    private Catalog DMuc;

    public Catalog getDMuc() {
        return DMuc;
    }

    public void setDMuc(Catalog DMuc) {
        this.DMuc = DMuc;
    }

    public Product(String id, String name) {
        super(id, name);
    }

    public Product(String id, String name, Catalog DMuc) {
        super(id, name);
        this.DMuc = DMuc;
    }

    public Product() {
    }
}
