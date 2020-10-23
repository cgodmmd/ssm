package cn.ssm.cwg.service.impl;


import cn.ssm.cwg.dao.IOrdersDao;
import cn.ssm.cwg.domain.Orders;
import cn.ssm.cwg.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hz
 * @date 2020/4/7 0:50
 */

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAllOrders() throws Exception {
        return ordersDao.findAllOrders();
    }

    @Override
    public List<Orders> findAll(Integer pageNum, Integer pageSize) throws Exception {
        // 参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return  ordersDao.findAll(pageNum, pageSize);
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return null;
    }
}
