package address.Backend.repository;

import address.Backend.entity.Province;
import address.Backend.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProvinceRepository extends
        JpaRepository<Province, Long>,
        JpaSpecificationExecutor<Province>

{
}
