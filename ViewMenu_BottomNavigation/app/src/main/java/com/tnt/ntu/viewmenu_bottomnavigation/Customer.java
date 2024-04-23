package com.tnt.ntu.viewmenu_bottomnavigation;

public class Customer {
    String tenKH, anhKH;
    int tuoi;

    public Customer(String tenKH, String anhKH, int tuoi) {
        this.tenKH = tenKH;
        this.anhKH = anhKH;
        this.tuoi = tuoi;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getAnhKH() {
        return anhKH;
    }

    public void setAnhKH(String anhKH) {
        this.anhKH = anhKH;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
