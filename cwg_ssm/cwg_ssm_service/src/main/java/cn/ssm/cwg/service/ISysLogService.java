package cn.ssm.cwg.service;

import cn.ssm.cwg.domain.SysLog;

import java.util.List;

/**
 * @author hz
 * @date 2020/4/10 19:25
 */


public interface ISysLogService {

    List<SysLog> findAll(Integer pageNum, Integer pageSize) throws Exception;

    void save(SysLog sysLog) throws Exception;

}
