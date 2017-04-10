package ua.com.zlatatrans.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.com.zlatatrans.dto.filter.CommodityFilter;
import ua.com.zlatatrans.dto.form.CommodityForm;
import ua.com.zlatatrans.editor.*;
import ua.com.zlatatrans.entity.*;
import ua.com.zlatatrans.service.*;
import ua.com.zlatatrans.util.ParamBuilder;
import ua.com.zlatatrans.validator.CommodityValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/commodity")
@SessionAttributes("commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private BodyTypeService bodyTypeService;

    @Autowired
    private DriveService driveService;

    @Autowired
    private FuelTypeService fuelTypeService;

    @Autowired
    private MakeService makeService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private TransmissionService transmissionService;

    @Autowired
    private ColorService colorService;

    @InitBinder("commodity")
    public void bind(WebDataBinder binder) {
        binder.setValidator(new CommodityValidator());
        binder.registerCustomEditor(BodyType.class, new BodyTypeEditor(bodyTypeService));
        binder.registerCustomEditor(Drive.class, new DriveEditor(driveService));
        binder.registerCustomEditor(FuelType.class, new FuelTypeEditor(fuelTypeService));
        binder.registerCustomEditor(Make.class, new MakeEditor(makeService));
        binder.registerCustomEditor(ua.com.zlatatrans.entity.Model.class, new ModelEditor(modelService));
        binder.registerCustomEditor(Transmission.class, new TransmissionEditor(transmissionService));
        binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
    }

    @ModelAttribute("commodity")
    public CommodityForm getForm() {
        return new CommodityForm();
    }

    @ModelAttribute("filter")
    public CommodityFilter getFilter() {
        return new CommodityFilter();
    }

    @GetMapping
    public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter) {
        model.addAttribute("page", commodityService.findAll(filter, pageable));
        model.addAttribute("bodyTypes", bodyTypeService.findAll());
        model.addAttribute("drives", driveService.findAll());
        model.addAttribute("fuelTypes", fuelTypeService.findAll());
        model.addAttribute("makes", makeService.findAll());
        model.addAttribute("transmissions", transmissionService.findAll());
        model.addAttribute("colors", colorService.findAll());
        return "admin-commodity";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter) {
        model.addAttribute("commodity", commodityService.findForm(id));
        return show(model, pageable, filter);
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter) {
        commodityService.delete(id);
        
        return "redirect:/admin/commodity" + getParams(pageable, filter);
    }

    @PostMapping
    public String save(@ModelAttribute("commodity") @Valid CommodityForm commodity, BindingResult bindingResult, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") CommodityFilter filter) {
        if (bindingResult.hasErrors()) {
            return show(model, pageable, filter);
        }
        commodityService.save(commodity);
        status.setComplete();
        return "redirect:/admin/commodity" + getParams(pageable, filter);
    }

    private String getParams(Pageable pageable, CommodityFilter filter) {
        String page = ParamBuilder.getParams(pageable);
        StringBuilder builder = new StringBuilder(page);
        if (!filter.getMinPriceStr().isEmpty()) {
            builder.append("&minPrice=");
            builder.append(filter.getMinPrice());
        }
        if (!filter.getMaxPriceStr().isEmpty()) {
            builder.append("&maxPrice=");
            builder.append(filter.getMaxPrice());
        }
        if (!filter.getMinYearStr().isEmpty()) {
            builder.append("&minYear=");
            builder.append(filter.getMinYear());
        }
        if (!filter.getMaxYearStr().isEmpty()) {
            builder.append("&maxYear=");
            builder.append(filter.getMaxYear());
        }
        if (!filter.getMinCapacityStr().isEmpty()) {
            builder.append("&minCapacity=");
            builder.append(filter.getMinCapacity());
        }
        if (!filter.getMaxCapacityStr().isEmpty()) {
            builder.append("&maxCapacity=");
            builder.append(filter.getMaxCapacity());
        }
        if (!filter.getMakeId().isEmpty()) {
            builder.append("&makeId=");
            builder.append(filter.getMakeId());
        }
        if (!filter.getTransmissionId().isEmpty()) {
            builder.append("&transmissionId");
            builder.append(filter.getTransmissionId());
        }
        if (!filter.getFuelTypeId().isEmpty()) {
            builder.append("&fuelTypeId");
            builder.append(filter.getFuelTypeId());
        }
        if (!filter.getBodyTypeId().isEmpty()) {
            builder.append("&bodyTypeId");
            builder.append(filter.getBodyTypeId());
        }
        return builder.toString();
    }
}
