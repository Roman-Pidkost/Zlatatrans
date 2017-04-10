package ua.com.zlatatrans.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class ModelFilter extends SimpleFilter{
	
	private List<Integer> makeId = new ArrayList<>();

	public List<Integer> getMakeId() {
		return makeId;
	}

	public void setMakeId(List<Integer> makeId) {
		this.makeId = makeId;
	}
}
