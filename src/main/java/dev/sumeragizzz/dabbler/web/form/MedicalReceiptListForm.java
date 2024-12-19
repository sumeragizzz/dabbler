package dev.sumeragizzz.dabbler.web.form;

import java.util.ArrayList;
import java.util.List;

public class MedicalReceiptListForm {

    public List<Integer> getSelectedIds() {
        return selectedIds;
    }

    public MedicalReceiptListForm() {
        this.selectedIds = new ArrayList<>();
    }

    public void setSelectedIds(List<Integer> selectedIds) {
        this.selectedIds = selectedIds;
    }

    private List<Integer> selectedIds;

}
