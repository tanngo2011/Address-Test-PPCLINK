package address.Backend.repository;

import address.Backend.entity.District;
import address.Backend.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WardRepository extends
        JpaRepository<Ward, Long>,
        JpaSpecificationExecutor<Ward>
{

    @Query("FROM Ward WHERE district.id = :district_id")
    public List<Ward> findByDistrictId(@Param("district_id") Long districtId);


    public List<Ward> findByProvinceId(Long provinceId);
}
