package hus.oop.mynumbersystem;

import java.math.BigInteger;

public abstract class AbstractNumberSystemConverter implements NumberSystemConverter {
    protected String convertedNumber;         // Số được chuyển đổi theo cơ số nào đó từ số gốc

    public AbstractNumberSystemConverter(ANumber aNumber) {
        /* TODO */
        convertedNumber = decimalTo(aNumber.getNumberPresentation());


    }

    /**
     * Chuyển đổi số decimal từ hệ cơ số 10 thành số có hệ cơ số nào đó.
     * @param decimal
     * @return xâu ký tự biểu diễn một số trong hệ cơ số nào đó.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     *
     * Gợi ý: có thể sử dụng lớp trung gian BigInteger để thuận lợi hơn cho việc tính toán.
     */
    public abstract String decimalTo(String decimal);

    /**
     * Chuyển đổi số được biểu diễn trong originalNumber sang biểu diễn số trong hệ cơ số 10.
     * @return xâu ký tự biểu diễn một số trong hệ cơ số 10.
     *
     * Yêu cầu: sử dụng thuật toán Horner để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    public String toDecimal() {
        /* TODO */
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < convertedNumber.length(); i++) {
            result = result.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(convertedNumber.charAt(i) - '0'));
        }
        return result.toString();
    }
}
