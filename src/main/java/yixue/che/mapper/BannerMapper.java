package yixue.che.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yixue.che.bean.Banner;

import java.util.List;

@Mapper
public interface BannerMapper {

    long count();

    List<Banner> findListByQuery(@Param("query") String query);

    List<Banner> findList();

    void save(Banner entity);

    Banner findById(Integer id);

    void update(Banner entity);

    List<Banner> queryBannerList();

    void deleteByid(Integer id);
}
