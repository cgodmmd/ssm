package cn.ssm.cwg.service;

import cn.ssm.cwg.domain.Orders;

import java.util.List;

/**
 * @author hz
 * @date 2020/4/7 0:49
 */


public interface IOrdersService {

    /**
     * 查询所有订单
     * @return
     * @throws Exception
     */
    List<Orders> findAllOrders() throws Exception;

    /**
     * 查询所有订单 带分页
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<Orders> findAll(Integer page, Integer size) throws Exception;


    /**
     *  根据订单编号查询订单
     * @param ordersId
     * @return
     * @throws Exception
     */
    Orders findById(String ordersId) throws Exception;
}
