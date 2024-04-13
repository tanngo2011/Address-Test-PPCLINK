package address.Backend.repository;

import address.Backend.entity.District;
import address.Backend.entity.Province;
import address.Backend.entity.Ward;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvinceRepository extends
        JpaRepository<Province, Long>,
        JpaSpecificationExecutor<Province>

{

    @Query(nativeQuery = true, value = "SELECT province.id, province.province_name FROM province\n" +
            "LEFT JOIN ward ON province.id = ward.province_id\n" +
            "WHERE ward.id = :wardId")
    public List<Province> findByWardId(@Param("wardId") Long wardId);


    @Query(nativeQuery = true, value = "SELECT province.id, province.province_name FROM province\n" +
            "LEFT JOIN district ON province.id = district.province_id\n" +
            "WHERE district.id = :districtId")
    public List<Province> findByDistrictId(@Param("districtId") Long districtId);




}
