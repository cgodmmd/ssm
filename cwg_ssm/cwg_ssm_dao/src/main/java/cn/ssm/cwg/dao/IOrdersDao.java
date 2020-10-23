package cn.ssm.cwg.dao;

import cn.ssm.cwg.domain.Orders;
import cn.ssm.cwg.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hz
 * @date 2020/4/7 0:48
 */

public interface IOrdersDao {

    @Select("select * from orders")
    List<Orders> findAll(int pageNum, int pageSize) throws Exception;
//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "orderNum", column = "orderNum"),
//            @Result(property = "orderTime", column = "orderTime"),
//            @Result(property = "peopleCount", column = "peopleCount"),
//            @Result(property = "orderDesc", column = "orderDesc"),
//            @Result(property = "payType", column = "payType"),
//            @Result(property = "orderStatus", column = "orderStatus"),
//            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.hz.dao.IProductDao.findById"))})


    List<Orders> findAllOrders() throws Exception;
}
