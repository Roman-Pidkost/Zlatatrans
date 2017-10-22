package ua.com.zlatatrans.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.com.zlatatrans.dto.filter.IndexFilter;
import ua.com.zlatatrans.dto.filter.SimpleFilter;
import ua.com.zlatatrans.editor.*;
import ua.com.zlatatrans.entity.*;
import ua.com.zlatatrans.service.*;
import ua.com.zlatatrans.util.ParamBuilder;

@Controller
@RequestMapping("/")
@SessionAttributes("index")
public class IndexController {

    @Autowired
    private MakeService makeService;

    @Autowired
    private DriveService driveService;

    @Autowired
    private BodyTypeService bodyTypeService;

    @Autowired
    private FuelTypeService fuelTypeService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private TransmissionService transmissionService;

    @Autowired
    private CommodityService commodityService;

    @ModelAttribute("filter")
    public IndexFilter getFilter() {
        return new IndexFilter();
    }

    @InitBinder("auto")
    public void bind(WebDataBinder binder) {
        binder.registerCustomEditor(BodyType.class, new BodyTypeEditor(bodyTypeService));
        binder.registerCustomEditor(Drive.class, new DriveEditor(driveService));
        binder.registerCustomEditor(FuelType.class, new FuelTypeEditor(fuelTypeService));
        binder.registerCustomEditor(Make.class, new MakeEditor(makeService));
        binder.registerCustomEditor(ua.com.zlatatrans.entity.Model.class, new ModelEditor(modelService));
        binder.registerCustomEditor(Transmission.class, new TransmissionEditor(transmissionService));
    }

    @GetMapping()
    public String show(Model model, @PageableDefault(size = 9, sort = "model.make.name") Pageable pageable, @ModelAttribute("filter") IndexFilter filter) {
        model.addAttribute("page", commodityService.findAll(filter, pageable));
        model.addAttribute("bodyTypes", bodyTypeService.findAll());
        model.addAttribute("drives", driveService.findAll());
        model.addAttribute("fuelTypes", fuelTypeService.findAll());
        model.addAttribute("makes", makeService.findAll());
        model.addAttribute("transmissions", transmissionService.findAll());
        return "user-index";
    }

    private String getParams(Pageable pageable, IndexFilter filter) {
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
        if (filter.getMakeId() != null) {
            builder.append("&makeId=");
            builder.append(filter.getMakeId());
        }
        if (filter.getModelId() != null) {
            builder.append("&modelId=");
            builder.append(filter.getModelId());
        }
        if (filter.getTransmissionId() != null) {
            builder.append("&transmissionId");
            builder.append(filter.getTransmissionId());
        }
        if (filter.getFuelTypeId() != null) {
            builder.append("&fuelTypeId");
            builder.append(filter.getFuelTypeId());
        }
        if (filter.getBodyTypeId() != null) {
            builder.append("&bodyTypeId");
            builder.append(filter.getBodyTypeId());
        }
        if (filter.getDriveId() != null) {
            builder.append("&driveId");
            builder.append(filter.getDriveId());
        }
        return builder.toString();
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, @PageableDefault(size = 9) Pageable pageable, Model model) {
        SimpleFilter filter = new SimpleFilter();
        filter.setSearch(search);
        model.addAttribute("page", commodityService.findAll(filter, pageable));
        model.addAttribute("bodyTypes", bodyTypeService.findAll());
        model.addAttribute("drives", driveService.findAll());
        model.addAttribute("fuelTypes", fuelTypeService.findAll());
        model.addAttribute("makes", makeService.findAll());
        model.addAttribute("transmissions", transmissionService.findAll());
        return "user-index";
    }
}
