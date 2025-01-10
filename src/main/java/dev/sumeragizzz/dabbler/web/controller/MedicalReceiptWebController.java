package dev.sumeragizzz.dabbler.web.controller;

import dev.sumeragizzz.dabbler.core.constant.ReceiptType;
import dev.sumeragizzz.dabbler.core.service.MedicalReceiptService;
import dev.sumeragizzz.dabbler.persistence.entity.MedicalReceipt;
import dev.sumeragizzz.dabbler.web.form.MedicalReceiptListForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Stream;

@Controller
public class MedicalReceiptWebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicalReceiptWebController.class);

    private final MedicalReceiptService service;

    public MedicalReceiptWebController(MedicalReceiptService service) {
        this.service = service;
    }

    @GetMapping("/web/medicalReceipt/list")
    public String showList(Model model) {
        List<MedicalReceipt> medicalReceipts = service.getMedicalReceipt();
        model.addAttribute("medicalReceipts", medicalReceipts);

        MedicalReceiptListForm form = new MedicalReceiptListForm();
        model.addAttribute(form);

        return "medicalReceipt/medicalReceiptList";
    }

    @PostMapping(path = "/web/medicalReceipt/list/submit", params = "add")
    public RedirectView add(MedicalReceiptListForm form, RedirectAttributes redirectAttributes) {
        MedicalReceipt medicalReceipt = new MedicalReceipt();
        redirectAttributes.addFlashAttribute("medicalReceipt", medicalReceipt);

        return new RedirectView("/web/medicalReceipt/edit");
    }

    @PostMapping(path = "/web/medicalReceipt/list/submit", params = "edit")
    public RedirectView edit(MedicalReceiptListForm form, RedirectAttributes redirectAttributes) {
        if (form.getSelectedIds().size() != 1) {
            throw new IllegalArgumentException();
        }

        MedicalReceipt medicalReceipt = service.getMedicalReceipt(form.getSelectedIds().getFirst()).orElseThrow();
        redirectAttributes.addFlashAttribute("medicalReceipt", medicalReceipt);

        return new RedirectView("/web/medicalReceipt/edit");
    }

    @GetMapping("/web/medicalReceipt/edit")
    public String showEditing(MedicalReceipt medicalReceipt, Model model) {
        model.addAttribute("receiptTypeValueList", Stream.of(ReceiptType.values()).map(Enum::name).toList());
        model.addAttribute("medicalReceipt", medicalReceipt);

        return "medicalReceipt/medicalReceiptEdit";
    }

    @PostMapping(path = "/web/medicalReceipt/edit/submit", params = "confirm")
    public RedirectView confirm(MedicalReceipt medicalReceipt, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("medicalReceipt", medicalReceipt);

        return new RedirectView("/web/medicalReceipt/confirm");
    }

    @PostMapping(path = "/web/medicalReceipt/edit/submit", params = "cancel")
    public RedirectView cancel(MedicalReceipt medicalReceipt, RedirectAttributes redirectAttributes) {
        return new RedirectView("/web/medicalReceipt/list");
    }

    @GetMapping("/web/medicalReceipt/confirm")
    public String showConfirm(MedicalReceipt medicalReceipt, Model model) {
        model.addAttribute("medicalReceipt", medicalReceipt);

        return "medicalReceipt/medicalReceiptConfirm";
    }

    @PostMapping(path = "/web/medicalReceipt/confirm/submit", params = "execute")
    public RedirectView execute(MedicalReceipt medicalReceipt, RedirectAttributes redirectAttributes) {
        if (medicalReceipt.getId() == null) {
            service.addMedicalReceipt(medicalReceipt);
        } else {
            service.updateMedicalReceipt(medicalReceipt);
        }

        return new RedirectView("/web/medicalReceipt/list");
    }

    @PostMapping(path = "/web/medicalReceipt/confirm/submit", params = "back")
    public RedirectView back(MedicalReceipt medicalReceipt, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("medicalReceipt", medicalReceipt);

        return new RedirectView("/web/medicalReceipt/edit");
    }

    @PostMapping(path = "/web/medicalReceipt/list/submit", params = "delete")
    public RedirectView delete(MedicalReceiptListForm form, RedirectAttributes redirectAttributes) {
        if (form.getSelectedIds().isEmpty()) {
            throw new RuntimeException();
        }

        List<MedicalReceipt> medicalReceipts = service.getMedicalReceipt(form.getSelectedIds());
        redirectAttributes.addFlashAttribute("medicalReceipts", medicalReceipts);

        return new RedirectView("/web/medicalReceipt/confirmDelete");
    }

    @GetMapping("/web/medicalReceipt/confirmDelete")
    public String showConfirmDelete(List<MedicalReceipt> medicalReceipts, Model model) {
        model.addAttribute("medicalReceipts", medicalReceipts);

        return "medicalReceipt/medicalReceiptConfirmDelete";
    }

    @PostMapping(path = "/web/medicalReceipt/confirmDelete/submit", params = "execute")
    public RedirectView executeDelete(MedicalReceiptListForm form, RedirectAttributes redirectAttributes) {
        if (form.getSelectedIds().isEmpty()) {
            throw new RuntimeException();
        }

        service.deleteMedicalReceipt(form.getSelectedIds());

        return new RedirectView("/web/medicalReceipt/list");
    }

    @PostMapping(path = "/web/medicalReceipt/confirmDelete/submit", params = "cancel")
    public RedirectView cancelDelete(MedicalReceiptListForm form, RedirectAttributes redirectAttributes) {
        return new RedirectView("/web/medicalReceipt/list");
    }

}
