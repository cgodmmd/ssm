package cn.ssm.cwg.service;

import cn.ssm.cwg.domain.Permission;

import java.util.List;

/**
 * @author hz
 * @date 2020/4/9 4:40
 */


public interface IPermissionService {

    void deleteById(String id) throws Exception;

    Permission findById(String id) throws Exception;

    void save(Permission permission) throws Exception;

    List<Permission> findAll() throws Exception;
}
