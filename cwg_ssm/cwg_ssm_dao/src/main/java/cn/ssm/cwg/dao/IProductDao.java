package cn.ssm.cwg.dao;

import cn.ssm.cwg.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hz
 * @date 2020/4/3 19:24
 */


public interface IProductDao {

    /**
     *  查询所有产品信息
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 保存产品信息
     * @param product
     * @throws Exception
     */
    @Select("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    /**
     *  根据id删除产品信息
     * @param id
     * @throws Exception
     */
    @Select("DELETE FROM product where id=#{id}")
    void deleteById(String id) throws Exception;

    /**
     * 根据Id查询产品信息
     * @param id
     * @throws Exception
     */
    @Select("select * from product where id=#{id}")
    void findById(String id ) throws Exception;


}
