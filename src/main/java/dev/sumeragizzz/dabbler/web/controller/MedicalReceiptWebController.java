package dev.sumeragizzz.dabbler.web.controller;

import dev.sumeragizzz.dabbler.core.service.MedicalReceiptService;
import dev.sumeragizzz.dabbler.persistence.entity.MedicalReceipt;
import dev.sumeragizzz.dabbler.web.form.MedicalReceiptListForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MedicalReceiptWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicalReceiptWebController.class);

    private final MedicalReceiptService service;

    public MedicalReceiptWebController(MedicalReceiptService service) {
        this.service = service;
    }

    @GetMapping("/web/medicalReceipt")
    public String showMedicalReceiptList(Model model) {
        List<MedicalReceipt> medicalReceipts = service.getMedicalReceipt();
        model.addAttribute("medicalReceipts", medicalReceipts);

        MedicalReceiptListForm form = new MedicalReceiptListForm();
        model.addAttribute(form);

        return "medicalReceiptList";
    }

    @PostMapping(value = "/web/medicalReceipt/edit", params = "add")
    public String addMedicalReceipt(MedicalReceiptListForm form, BindingResult bindingResult, Model model) {
        LOGGER.info("add. selected: {}", form.getSelectedIds());

        List<MedicalReceipt> medicalReceipts = service.getMedicalReceipt();
        model.addAttribute("medicalReceipts", medicalReceipts);

        model.addAttribute("medicalReceiptListForm", form);

        // TODO Forward to addition screen
        return "medicalReceiptList";
    }

    @PostMapping(value = "/web/medicalReceipt/edit", params = "edit")
    public String editMedicalReceipt(MedicalReceiptListForm form, BindingResult bindingResult, Model model) {
        LOGGER.info("edit. selected: {}", form.getSelectedIds());

        List<MedicalReceipt> medicalReceipts = service.getMedicalReceipt();
        model.addAttribute("medicalReceipts", medicalReceipts);

        model.addAttribute("medicalReceiptListForm", form);

        // TODO Forward to editing screen
        return "medicalReceiptList";
    }

    @PostMapping(value = "/web/medicalReceipt/edit", params = "delete")
    public String deleteMedicalReceipt(MedicalReceiptListForm form, BindingResult bindingResult, Model model) {
        LOGGER.info("delete. selected: {}", form.getSelectedIds());

        List<MedicalReceipt> medicalReceipts = service.getMedicalReceipt();
        model.addAttribute("medicalReceipts", medicalReceipts);

        model.addAttribute("medicalReceiptListForm", form);

        // TODO Forward to deletion screen
        return "medicalReceiptList";
    }

}
