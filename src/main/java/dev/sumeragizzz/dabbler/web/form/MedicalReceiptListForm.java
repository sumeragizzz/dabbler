package dev.sumeragizzz.dabbler.web.form;

import java.util.ArrayList;
import java.util.List;

public class MedicalReceiptListForm {

    private List<Long> selectedIds;

    public MedicalReceiptListForm() {
        this.selectedIds = new ArrayList<>();
    }

    public List<Long> getSelectedIds() {
        return selectedIds;
    }

    public void setSelectedIds(List<Long> selectedIds) {
        this.selectedIds = selectedIds;
    }

}
