package cn.ssm.cwg.dao;

import cn.ssm.cwg.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hz
 * @date 2020/4/10 20:04
 */


public interface ISysLogDao {

    @Select("select * from sysLog")
    List<SysLog> findAll(Integer pageNum, Integer pageSize) throws Exception;

    @Insert("insert into syslog(id,visitTime,username,ip,url,executionTime,method) values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;
}
