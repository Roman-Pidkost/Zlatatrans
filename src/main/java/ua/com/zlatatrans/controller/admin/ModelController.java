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

import ua.com.zlatatrans.dto.filter.ModelFilter;
import ua.com.zlatatrans.editor.MakeEditor;
import ua.com.zlatatrans.entity.Make;
import ua.com.zlatatrans.service.MakeService;
import ua.com.zlatatrans.service.ModelService;
import ua.com.zlatatrans.util.ParamBuilder;
import ua.com.zlatatrans.validator.ModelValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/model")
@SessionAttributes("model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @Autowired
    private MakeService makeService;

    @InitBinder("model")
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(new ModelValidator(modelService));
        binder.registerCustomEditor(Make.class, new MakeEditor(makeService));
    }

    @ModelAttribute("model")
    public ua.com.zlatatrans.entity.Model getForm() {
        return new ua.com.zlatatrans.entity.Model();
    }

    @ModelAttribute("filter")
	public ModelFilter getFilter() {
    	return new ModelFilter();
    }
    
    @GetMapping
    public String show(Model model, @PageableDefault(size = 100) Pageable pageable, @ModelAttribute("filter") ModelFilter filter) {
        model.addAttribute("makes", makeService.findAll());
        model.addAttribute("page", modelService.findAll(pageable, filter));
        return "admin-model";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, @PageableDefault(size = 100) Pageable pageable, @ModelAttribute("filter") ModelFilter filter) {
        modelService.delete(id);
        return "redirect:/admin/model";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable int id, Model model, @PageableDefault(size = 100) Pageable pageable, @ModelAttribute("filter") ModelFilter filter) {
        model.addAttribute("model", modelService.findOne(id));
        return show(model, pageable, filter);
    }

    @PostMapping
    public String show(@ModelAttribute("model") @Valid ua.com.zlatatrans.entity.Model entity, BindingResult bindingResult, SessionStatus status, Model model, @PageableDefault(size = 100) Pageable pageable, @ModelAttribute("filter") ModelFilter filter) {
        if (bindingResult.hasErrors()) {
            return show(model, pageable, filter);
        }
        modelService.save(entity);
        status.setComplete();
        return "redirect:/admin/model";
    }
    
    private String getParams(Pageable pageable, ModelFilter filter){
		String page = ParamBuilder.getParams(pageable);
		StringBuilder builder = new StringBuilder(page);
		if(!filter.getSearch().isEmpty()){
			builder.append("&search=");
			builder.append(filter.getSearch());
		}
		if(!filter.getMakeId().isEmpty()) {
			builder.append("&makeId=");
			builder.append(filter.getMakeId());
		}
		return builder.toString();
    }
}
