package hus.oop.mynumbersystem;

import java.math.BigInteger;

public class HexadecimalConverter extends AbstractNumberSystemConverter {
    public HexadecimalConverter(ANumber aNumber) {
        /* TODO */
        super(aNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 16.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 16.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        /* TODO */
        BigInteger decimalNumber = new BigInteger(decimal);
        StringBuilder hexadecimalNumber = new StringBuilder();
        String hexChars = "0123456789ABCDEF";
        while (decimalNumber.compareTo(BigInteger.ZERO) > 0) {
            hexadecimalNumber.insert(0, hexChars.charAt(decimalNumber.mod(BigInteger.valueOf(16)).intValue()));
            decimalNumber = decimalNumber.divide(BigInteger.valueOf(16));
        }
        return hexadecimalNumber.toString();
    }

    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi.
     */
    @Override
    public void update(ANumber number) {
        /* TODO */
        convertedNumber = decimalTo(number.getNumberPresentation());

    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(16).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println(convertedNumber);
    }
}
