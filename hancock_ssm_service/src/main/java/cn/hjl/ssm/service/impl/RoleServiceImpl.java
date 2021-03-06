package cn.hjl.ssm.service.impl;

import cn.hjl.ssm.dao.PermissionDao;
import cn.hjl.ssm.dao.RoleDao;
import cn.hjl.ssm.domain.Permission;
import cn.hjl.ssm.domain.Role;
import cn.hjl.ssm.service.PermissionService;
import cn.hjl.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll() ;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public void deleteRole(String id) throws Exception{
        roleDao.deleteRole(id);
    }
    @Override
    public List<Role> findOtherRoles(String userId) {
        return roleDao.findOtherRoles(userId);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
