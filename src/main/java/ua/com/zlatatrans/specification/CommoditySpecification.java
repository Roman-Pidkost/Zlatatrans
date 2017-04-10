package ua.com.zlatatrans.specification;

import org.springframework.data.jpa.domain.Specification;
import ua.com.zlatatrans.dto.filter.CommodityFilter;
import ua.com.zlatatrans.entity.Commodity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CommoditySpecification implements Specification<Commodity> {

    private final CommodityFilter filter;

    private static final Pattern REG = Pattern.compile("\\d{1,9}");

    private static final Pattern REG_D = Pattern.compile("\\d{1,9}(.|,)\\d{0,3}");

    private final List<Predicate> predicates = new ArrayList<>();

    public CommoditySpecification(CommodityFilter filter) {
        this.filter = filter;
        if(REG.matcher(filter.getMinYearStr()).matches()) {
            filter.setMinYear(Integer.valueOf(filter.getMinYearStr()));
        }
        if(REG.matcher(filter.getMaxYearStr()).matches()) {
            filter.setMaxYear(Integer.valueOf(filter.getMaxYearStr()));
        }
        if(REG.matcher(filter.getMinPriceStr()).matches()) {
            filter.setMinPrice(Integer.valueOf(filter.getMinPriceStr()));
        }
        if(REG.matcher(filter.getMaxPriceStr()).matches()) {
            filter.setMaxPrice(Integer.valueOf(filter.getMaxPriceStr()));
        }
        if(REG_D.matcher(filter.getMinCapacityStr()).matches()) {
            filter.setMinCapacity(Double.valueOf(filter.getMinCapacityStr().replace(',', '.')));
        }
        if(REG_D.matcher(filter.getMaxCapacityStr()).matches()) {
            filter.setMaxCapacity(Double.valueOf(filter.getMaxCapacityStr().replace(',', '.')));
        }
    }

    private void findByYear(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (filter.getMinYear() != null) {
            predicates.add(criteriaBuilder.ge(root.get("year"), filter.getMinYear()));
        }
        if (filter.getMaxYear() != null) {
            predicates.add(criteriaBuilder.le(root.get("year"), filter.getMaxYear()));
        }
    }

    private void findByPrice(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (filter.getMinPrice() != null) {
            predicates.add(criteriaBuilder.ge(root.get("price"), filter.getMinPrice()));
        }
        if (filter.getMaxPrice() != null) {
            predicates.add(criteriaBuilder.le(root.get("price"), filter.getMaxPrice()));
        }
    }

    private void findByCapacity(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (filter.getMinCapacity() != null) {
            predicates.add(criteriaBuilder.ge(root.get("capacity"), filter.getMinCapacity()));
        }
        if (filter.getMaxCapacity() != null) {
            predicates.add(criteriaBuilder.le(root.get("capacity"), filter.getMaxCapacity()));
        }
    }

    private void findByMake(Root<Commodity> root, CriteriaQuery<?> query) {
        if (!filter.getMakeId().isEmpty()) {
            predicates.add(root.get("model").get("make").in(filter.getMakeId()));
        }
    }

    private void findByFuelType(Root<Commodity> root, CriteriaQuery<?> query) {
        if (!filter.getFuelTypeId().isEmpty()) {
            predicates.add(root.get("fuelType").in(filter.getFuelTypeId()));
        }
    }

    private void findByBodyType(Root<Commodity> root, CriteriaQuery<?> query) {
        if (!filter.getBodyTypeId().isEmpty()) {
            predicates.add(root.get("bodyType").in(filter.getBodyTypeId()));
        }
    }

    private void findByTransmission(Root<Commodity> root, CriteriaQuery<?> query) {
        if (!filter.getTransmissionId().isEmpty()) {
            predicates.add(root.get("transmission").in(filter.getTransmissionId()));
        }
    }

    @Override
    public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        findByPrice(root, criteriaQuery, criteriaBuilder);
        findByYear(root, criteriaQuery, criteriaBuilder);
        findByCapacity(root, criteriaQuery, criteriaBuilder);
        findByFuelType(root, criteriaQuery);
        findByTransmission(root, criteriaQuery);
        findByMake(root, criteriaQuery);
        findByBodyType(root, criteriaQuery);
        if(predicates.isEmpty())return null;
        Predicate[] array = new Predicate[predicates.size()];
        array = predicates.toArray(array);
        return criteriaBuilder.and(array);
    }
}
