package pj.spring.vo;

public class CartSummary {
    private int totalQuantity;
    private int totalPrice;
    private int shippingFee;
    private String displayProductName;

    // ������
    public CartSummary(int totalQuantity, int totalPrice, int shippingFee, String displayProductName) {
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.shippingFee = shippingFee;
        this.displayProductName = displayProductName;
    }

    // Getter/Setter
    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(int shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getDisplayProductName() {
        return displayProductName;
    }

    public void setDisplayProductName(String displayProductName) {
        this.displayProductName = displayProductName;
    }
}

