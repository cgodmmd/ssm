package cn.ssm.cwg.service.impl;

import cn.ssm.cwg.dao.IRoleDao;
import cn.ssm.cwg.domain.Permission;
import cn.ssm.cwg.domain.Role;
import cn.ssm.cwg.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hz
 * @date 2020/4/9 3:47
 */

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findALl();
    }

    @Override
    public void save(Role role) throws Exception {
        // 不好的设计
        Integer roleId = (int) (Math.random() * Math.random() * Math.random() * 100000);
        role.setId(roleId.toString());
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public void deleteRoleById(String roleId) {
        roleDao.deleteRoleById(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return roleDao.findOtherPermissions(roleId);
    }

}
