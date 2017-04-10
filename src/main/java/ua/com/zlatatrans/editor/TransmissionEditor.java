package ua.com.zlatatrans.editor;

import ua.com.zlatatrans.entity.Transmission;
import ua.com.zlatatrans.service.TransmissionService;

import java.beans.PropertyEditorSupport;

public class TransmissionEditor extends PropertyEditorSupport {

    private final TransmissionService transmissionService;

    public TransmissionEditor(TransmissionService transmissionService) {
        this.transmissionService = transmissionService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Transmission transmission = transmissionService.findOne(Integer.valueOf(text));
        setValue(transmission);
    }
}
