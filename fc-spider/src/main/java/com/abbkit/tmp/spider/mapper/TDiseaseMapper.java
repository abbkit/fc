package com.abbkit.tmp.spider.mapper;


import com.abbkit.tmp.spider.po.TDiseaseEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author J
 * @since 2023-02-12
 */
@Mapper
public interface TDiseaseMapper {

    @Delete("delete from t_disease ")
    void deleteAll();

    @Insert("INSERT INTO `t_disease` (`id`, `name`, `category`) VALUES (null, #{name}, #{category})")
    void insert(TDiseaseEntity tDiseaseEntity);

}
