package yixue.che.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import yixue.che.bean.Banner;
import yixue.che.mapper.BannerMapper;
import yixue.che.service.BannerService;
import yixue.che.util.Resp;
import yixue.che.util.Tools;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xianhu
 * @description
 * @date 2023年02月12日 13:04
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public long count() {
        return bannerMapper.count();
    }

    @Override
    public List<Banner> findByPage(int pageNumber, int pageSize, String query) {
        List<Banner> list = new ArrayList<Banner>();
        PageHelper.startPage(pageNumber, pageSize);
        if (!Tools.isEmpty(query)) {
            list = bannerMapper.findListByQuery("%" + query + "%");
        } else {
            list = bannerMapper.findList();
        }
        PageInfo<Banner> pageInfo=new PageInfo<Banner>(list);
        return pageInfo.getList();
    }

    @Override
    public void save(Banner entity) {
        bannerMapper.save(entity);
    }

    @Override
    public Banner findById(Integer id) {
        return bannerMapper.findById(id);
    }

    @Override
    public void update(Banner entity) {
        bannerMapper.update(entity);
    }

    @Override
    public Resp queryBannerList() {
        List<Banner> bannerList = bannerMapper.queryBannerList();
        if (CollectionUtils.isEmpty(bannerList)){
            return Resp.ok();
        }
        List<Banner> collect = bannerList.stream().peek((r) -> {
            String imgUrl = r.getRealImageUrl();
            File file = new File(imgUrl);
            try (InputStream inputStream = new FileInputStream(file)){
                byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
                String encodeToString = Base64.getEncoder().encodeToString(bytes);
                r.setImageData(encodeToString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).collect(Collectors.toList());
        return Resp.ok(collect,"查询成功");
    }

    @Override
    public void deleteByid(Integer id) {
        bannerMapper.deleteByid(id);
    }
}
