package cn.ssm.cwg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hz
 * @date 2020/4/4 10:57
 */


public class RedirectController {

    /**
     * 跳转到添加产品表单
     * @return
     */
    @RequestMapping("/main.do")
    public ModelAndView main() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main");
        return mv;
    }

    /**
     * 跳转到添加产品表单
     * @return
     */
    @RequestMapping("/product/add.do")
    public ModelAndView addForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product-add");
        return mv;
    }
}
