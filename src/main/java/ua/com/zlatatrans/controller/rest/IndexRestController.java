package ua.com.zlatatrans.controller.rest;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.zlatatrans.dto.form.FavoriteCommodity;
import ua.com.zlatatrans.service.CommodityService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class IndexRestController {
	
	@Autowired
	public CommodityService commodityService;

    @RequestMapping(value = "/getFavorites/{fav}", method = RequestMethod.GET, produces = {"text/html;charset=utf-8"})
    public String getFavorites9(@PathVariable("fav") String fav) {
        String[] favoriteId = Arrays.stream(fav.split("x")).distinct().toArray(String[]::new);
        List<FavoriteCommodity> commodities = new ArrayList<>(favoriteId.length);
        for (String id : favoriteId) {
            commodities.add(commodityService.findFavorites(Integer.valueOf(id)));
        }
        Gson gson = new Gson();
        return gson.toJson(commodities);
    }
}
