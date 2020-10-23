package cn.ssm.cwg.dao;

import cn.ssm.cwg.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hz
 * @date 2020/4/9 4:42
 */


public interface IPermissionDao {



    @Select("select * from permission")
    List<Permission> findAll();

    @Select("select * from permission where id=#{id}")
    Permission findById(String id);

    @Insert("insert into permission(id,permissionName,url) values(#{id},#{permissionName},#{url})")
    void save(Permission permission);

    @Delete("delete from permission where id=#{id}")
    void deleteById(String id);



    @Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(String id);

    // 查询与role关联的所有的权限
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    List<Permission> findPermissionByRoleId(String id) throws Exception;

}
