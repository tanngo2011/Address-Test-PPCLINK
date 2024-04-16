package address.Backend.specification;

import address.Backend.entity.District;
import address.Backend.entity.Province;
import address.Backend.form.DistrictFilterForm;
import address.Backend.form.ProvinceFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DistrictSpecification {

    public static Specification<District> buildSpec(String form) {

        return form == null ? null : new Specification<District>() {
            @Override
            public Predicate toPredicate(Root<District> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<>(); //--> Tạo danh sách điều kiện

                String districtInput = form;


                if (StringUtils.hasText(districtInput)) {
                    String pattern = "%" + districtInput.trim() + "%";
                    Predicate hasNameLike = builder.like(root.get("fullname"), pattern);

                    predicates.add(hasNameLike);
                }

                return builder.and(predicates.toArray(new Predicate[0]));
            }

        };
    }
}
