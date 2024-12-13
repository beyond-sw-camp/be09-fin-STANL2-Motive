package stanl_2.final_backend.domain.A_sample.query.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import stanl_2.final_backend.domain.A_sample.query.dto.SampleDTO;

@Mapper
public interface SampleMapper {
    String selectNameById(@Param("id") String id);

    SampleDTO selectById(@Param("id") String id);
}
