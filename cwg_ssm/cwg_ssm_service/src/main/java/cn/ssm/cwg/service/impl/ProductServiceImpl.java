package cn.ssm.cwg.service.impl;

import cn.ssm.cwg.dao.IProductDao;
import cn.ssm.cwg.domain.Product;
import cn.ssm.cwg.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hz
 * @date 2020/4/3 19:33
 */

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception  {
        productDao.save(product);
    }

    @Override
    public void deleteById(String id) throws Exception {
        productDao.deleteById(id);
    }
}
