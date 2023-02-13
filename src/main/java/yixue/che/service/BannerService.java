package yixue.che.service;

import yixue.che.bean.Banner;
import yixue.che.util.Resp;

import java.util.List;

public interface BannerService {
    long count();

    List<Banner> findByPage(int pageNumber, int pageSize, String query);

    void save(Banner entity);

    Banner findById(Integer id);

    void update(Banner entity);

    Resp queryBannerList();

    void deleteByid(Integer id);
}
