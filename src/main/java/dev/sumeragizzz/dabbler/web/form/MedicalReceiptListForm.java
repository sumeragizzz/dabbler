package dev.sumeragizzz.dabbler.web.form;

import java.util.ArrayList;
import java.util.List;

public class MedicalReceiptListForm {

    public List<Long> getSelectedIds() {
        return selectedIds;
    }

    public MedicalReceiptListForm() {
        this.selectedIds = new ArrayList<>();
    }

    public void setSelectedIds(List<Long> selectedIds) {
        this.selectedIds = selectedIds;
    }

    private List<Long> selectedIds;

}
