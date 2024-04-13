package address.Backend.repository;

import address.Backend.entity.District;
import address.Backend.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistrictRepository extends
        JpaRepository<District, Long>,
        JpaSpecificationExecutor<District>
{

    @Query("FROM District WHERE province.id = :province_id")
    public List<District> findByProvinceId(@Param("province_id") Long provinceId);


    @Query(nativeQuery = true, value = "SELECT district.id, district.district_name, district.full_name, district.province_id, district.unit FROM district\n" +
            "LEFT JOIN ward ON district.id = ward.district_id\n" +
            "WHERE ward.id = :wardId")
    public List<District> findByWardId(@Param("wardId") Long wardId);


}
