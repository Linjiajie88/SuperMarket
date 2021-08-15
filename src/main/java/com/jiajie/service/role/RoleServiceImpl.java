package com.jiajie.service.role;

import com.jiajie.dao.BaseDao;
import com.jiajie.dao.role.RoleDao;
import com.jiajie.dao.role.RoleDaoImpl;
import com.jiajie.pojo.Role;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl  implements RoleService{
    //业务层都会调用dao层，所以我们要引入Dao层；
    private RoleDao roleDao;
    public RoleServiceImpl(){ roleDao=new RoleDaoImpl();}
    //方法
    //Service层一般步骤都是获取连接执行操作，返回结果就行
    public List<Role> getRoleList() {
        Connection connection=null;
        List<Role> roleList=null;
        try {
            connection= BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }

}
