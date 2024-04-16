package address.Backend.specification;

import address.Backend.entity.Province;
import address.Backend.form.ProvinceFilterForm;
import address.Backend.repository.ProvinceRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProvinceSpecification {


    public static Specification<Province> buildSpec(String form) {

        return form == null ? null : new Specification<Province>() {
            @Override
            public Predicate toPredicate(Root<Province> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<>(); //--> Tạo danh sách điều kiện

                String provinceInput = form;


                if (StringUtils.hasText(provinceInput)) {
                    String pattern = "%" + provinceInput.trim() + "%";
                    Predicate hasNameLike = builder.like(root.get("provinceName"), pattern);

                    predicates.add(hasNameLike);
                }

                return builder.and(predicates.toArray(new Predicate[0]));
            }

        };
    }
}
