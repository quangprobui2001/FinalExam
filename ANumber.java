package hus.oop.mynumbersystem;

public class ANumber {
    private String numberPresentation;  // Biểu diễn số
    private int radix;                  // Cơ số


    public ANumber(String originalNumber, int radix) {
        /* TODO */
        this.numberPresentation = originalNumber;
        this.radix = radix;
    }

    public String getNumberPresentation() {
        /* TODO */
        return this.numberPresentation;
    }

    public void setNumberPresentation(String numberPresentation) {
        /* TODO */
        this.numberPresentation = numberPresentation;
    }

    public int getRadix() {
        /* TODO */
        return this.radix;
    }

    public void setRadix(int radix) {
        /* TODO */
        this.radix = radix;
    }
}