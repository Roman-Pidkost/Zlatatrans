package ua.com.zlatatrans.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.zlatatrans.entity.Commodity;
import ua.com.zlatatrans.entity.Make;
import ua.com.zlatatrans.entity.Model;
import ua.com.zlatatrans.service.CommodityService;
import ua.com.zlatatrans.service.FileWriter;
import ua.com.zlatatrans.service.MakeService;

@RestController
public class CommodityRestController {

    @Autowired
    private MakeService makeService;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private FileWriter fileWriter;
    
    @RequestMapping(value = "/getModels/{id}", method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
    public String getModels(@PathVariable("id") String id ) {
        Make make = makeService.findByIdFetchModel(Integer.valueOf(id));
        if (make != null){
            StringBuilder builder = new StringBuilder("<option value=\"0\" label=\"Модель\" disabled=\"true\" selected=\"true\"/>");
            for (Model item : make.getModels()) {
                builder.append("<option value=\""+ item.getId() +"\">" + item.getName() + "</option>");
            }
            return builder.toString();
        }
        return "";
    }

    @RequestMapping(value = "/admin/commodity/setMainPhoto/{id}_{num}", method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
    public void setPhoto(@PathVariable("id") String s_id, @PathVariable String num) {
        int id = Integer.valueOf(s_id);
        int number = Integer.valueOf(num);
        Commodity commodity = fileWriter.setMainImage(id, number, commodityService.findOne(id));
        if (commodity != null) {
            commodityService.save(commodity);
        }
    }
}
