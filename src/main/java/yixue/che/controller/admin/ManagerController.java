package yixue.che.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import yixue.che.service.IAdminService;


@Controller
public class ManagerController {

    @Autowired
    private IAdminService adminService;

    /**
     * 首页
     * @return
     */
    @GetMapping("/manager/index")
    public ModelAndView manager(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    /**
     * 主页面
     * @return
     * @throws Exception
     */
    @GetMapping("/manager/main")
    public ModelAndView main() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("porvice",adminService.countPorvice());
        mv.setViewName("main");

        //System.out.println("****************************"+adminService.countPorvice());
        return mv;
    }

    /**
     * 错误页面
     * @return
     */
    @GetMapping("/manager/404")
    public ModelAndView notFound(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("404");
        return mv;
    }

    /**
     * 系统设置
     * @return
     */
    @GetMapping("/manager/systemParameter")
    public ModelAndView systemParameter(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("systemParameter/systemParameter");
        return mv;
    }
}
