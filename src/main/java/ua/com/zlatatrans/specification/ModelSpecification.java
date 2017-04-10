package ua.com.zlatatrans.specification;

import org.springframework.data.jpa.domain.Specification;
import ua.com.zlatatrans.dto.filter.ModelFilter;
import ua.com.zlatatrans.entity.Model;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ModelSpecification implements Specification<Model>{
	
	private final ModelFilter filter;
	
	private final List<Predicate> predicates = new ArrayList<>();

	public ModelSpecification(ModelFilter filter) {
		this.filter = filter;
	}
	
	private void findByMake(Root<Model> root, CriteriaQuery<?> query) {
		if(!filter.getMakeId().isEmpty()){
			predicates.add(root.get("make").in(filter.getMakeId()));
		}
	}
	
	private void findByName(Root<Model> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(filter.getSearch().isEmpty()){
			cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase()+"%");
		}
	}

	@Override
	public Predicate toPredicate(Root<Model> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		findByName(root, query, cb);
		findByMake(root, query);
		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}
	
}
