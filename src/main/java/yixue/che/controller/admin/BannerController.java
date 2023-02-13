package yixue.che.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import yixue.che.bean.Banner;
import yixue.che.bean.page.PageParam;
import yixue.che.service.BannerService;
import yixue.che.util.Tools;

import java.io.File;
import java.util.List;

/**
 * @description 轮播图管理
 * @date 2023年02月12日 12:46
 */
@Controller
@RequestMapping("/manager")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping("/bannerDelete")
    public String travelRouteDelete(Integer id) {
        if (!Tools.isEmpty(id)) {
            try {
                bannerService.deleteByid(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/manager/banner/list";
    }


    /**
     *
     * @param id
     * @return
     */
    @RequestMapping("/bannerEdit")
    public ModelAndView travelRouteEdit(Integer id) {
        ModelAndView mv = new ModelAndView();
        try {
            mv.addObject("entity", bannerService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("banner/bannerEdit");
        return mv;
    }

    @RequestMapping("/bannerView")
    public ModelAndView travelRouteView(Integer id) {
        ModelAndView mv = new ModelAndView();
        try {
            mv.addObject("entity", bannerService.findById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("banner/bannerView");
        return mv;
    }

    @RequestMapping("/banner/list")
    public ModelAndView bannerList(PageParam pageParam, @RequestParam(value = "query", required = false) String query) {

        ModelAndView mv = new ModelAndView();
        if (pageParam.getPageNumber() < 1) {
            pageParam = new PageParam();
            long count = 0;
            try {
                count = bannerService.count();
            } catch (Exception e) {
                e.printStackTrace();
            }
            pageParam.setCount(count);
            if (count <= 10) {
                pageParam.setSize(1);
            } else {
                pageParam.setSize(count % 10 == 0 ? count / 10 : count / 10 + 1);
            }
            pageParam.setPageNumber(1);
            pageParam.setPageSize(10);
        }
        try {
            List<Banner> list = bannerService.findByPage(pageParam.getPageNumber(), pageParam.getPageSize(), query);

            mv.addObject("pageData", list);

            if (!Tools.isEmpty(query)) {
                mv.addObject("query", query);

                pageParam.setCount(list.size());
                if (list.size() > pageParam.getPageSize()) {
                    pageParam.setSize(list.size() / pageParam.getPageSize());
                } else {
                    pageParam.setSize(1);
                }
            }
        } catch (Exception e) {
            mv.setViewName("404");
            return mv;
        }
        mv.addObject("pageParam", pageParam);
        mv.setViewName("banner/bannerList");
        return mv;
    }

    /**
     * 跳转到编辑页面
     *
     * @return
     */
    @RequestMapping("/bannerAdd")
    public ModelAndView travelRouteAdd() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("entity", new Banner());
        mv.setViewName("banner/add");
        return mv;
    }


    @RequestMapping("/bannerSave")
    public String bannerSave(Banner entity, @RequestParam("fileName") MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                int size = (int) file.getSize();
                System.out.println(fileName + "-->" + size);
                String path = "/Users/wangxianhu/xianhu/code/wx/yixueche-manage/src/main/resources/static/banner";
                File dest = new File(path + "/" + fileName);
                //判断文件父目录是否存在
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdir();
                }
                try {
                    //保存文件
                    file.transferTo(dest);
                    entity.setImgUrl("/banner/" + fileName);
                    entity.setRealImageUrl(dest.getPath());
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            if (Tools.isEmpty(entity.getId())) {
                bannerService.save(entity);
            } else {
                if (entity.getImgUrl() == null) {
                    Banner banner = bannerService.findById(entity.getId());
                    entity.setImgUrl(banner.getImgUrl());
                    bannerService.update(entity);
                } else {
                    bannerService.update(entity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/manager/banner/list";
    }
}
