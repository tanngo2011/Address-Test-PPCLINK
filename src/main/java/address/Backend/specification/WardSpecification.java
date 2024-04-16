package address.Backend.specification;

import address.Backend.entity.Province;
import address.Backend.entity.Ward;
import address.Backend.form.ProvinceFilterForm;
import address.Backend.form.WardFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class WardSpecification {

    public static Specification<Ward> buildSpec(String form) {

        return form == null ? null : new Specification<Ward>() {
            @Override
            public Predicate toPredicate(Root<Ward> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<>(); //--> Tạo danh sách điều kiện

                String wardInput = form;


                if (StringUtils.hasText(wardInput)) {
                    String pattern = "%" + wardInput.trim() + "%";
                    Predicate hasNameLike = builder.like(root.get("wardName"), pattern);

                    predicates.add(hasNameLike);
                }

                return builder.and(predicates.toArray(new Predicate[0]));
            }

        };
    }


}
