package hus.oop.mynumbersystem;

import java.util.List;
import java.util.ArrayList;

public class NumberSystemController {
    private ANumber originalNumber;
    private String numberPresentation;  // Biểu diễn số
    private int radix;                  // Cơ số
    private List<NumberSystemConverter> converters;  // Danh sách các converter theo observer pattern

    public NumberSystemController() {
        /* TODO */
        this.originalNumber = new ANumber("", 10);
        this.numberPresentation = "";
        this.radix = 10;
        this.converters = new ArrayList<>();
    }

    /**
     * Thêm vào converter để quan sát số ban đầu.
     * @param converter
     */
    public void registerConverter(NumberSystemConverter converter) {
        /* TODO */
        converters.add(converter);
        converter.update(originalNumber);
    }

    /**
     * Hủy quan sát số ban đầu của converter.
     * @param converter
     */
    public void unregisterConverter(NumberSystemConverter converter) {
        /* TODO */
        converters.remove(converter);
    }

    /**
     * Khi có sự thay đổi trạng thái (biểu diễn số hoặc cơ số), thông báo cho tất cả
     * các converter đang ký quan sát để cập nhật lại trạng thái theo dữ liệu mới.
     */
    public void notifyConverters() {
        /* TODO */
        for(NumberSystemConverter converter : converters) {
            converter.update(originalNumber);
        }
    }

    public String getNumberPresentation() {
        /* TODO */
        return numberPresentation;
    }

    public void setNumberPresentation(String numberPresentation) {
        /* TODO */
        this.numberPresentation = numberPresentation;
        onStateChanged();
    }

    public int getRadix() {
        /* TODO */
        return radix;
    }

    public void setRadix(int radix) {
        /* TODO */
        this.radix = radix;
        onStateChanged();
    }

    /**
     * Được gọi khi có sự thay đổi về trạng thái (biểu diến số hoặc cơ số),
     * hàm này sẽ gọi hàm để thông báo cho tất cả các observer đang ký quan sát
     * cập nhật lại trạng thái.
     */
    private void onStateChanged() {
        /* TODO */
        notifyConverters();
    }
}
