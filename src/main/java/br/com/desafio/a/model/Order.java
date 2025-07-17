package br.com.desafio.a.model;

public class Order {
    private Integer code;
    private Double basic;
    private Double discount;

    public Order(Integer code, Double basic, Double discount) {
        this.code = code;
        this.basic = basic;
        this.discount = discount;
    }

    public Integer getCode() {
        return code;
    }

    public Double getBasic() {
        return basic;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
