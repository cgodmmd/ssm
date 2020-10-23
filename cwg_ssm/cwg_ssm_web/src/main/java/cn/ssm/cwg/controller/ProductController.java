package cn.ssm.cwg.controller;


import cn.ssm.cwg.domain.Product;
import cn.ssm.cwg.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

/**
 * @author hz
 * @date 2020/4/3 19:54
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;


    /**
     * 查询所有产品信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList", products);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 添加产品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

    /**
     * 根据Id删除产品
     * @param id
     */
    @RequestMapping("/deleteById.do")
    public String deleteById(@RequestParam(name = "id") String id) throws Exception {
        System.out.println("delete --> " + id);
        productService.deleteById(id);
        return "redirect:/product/findAll.do";
    }
}
