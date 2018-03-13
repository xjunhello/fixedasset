package com.fixed.asset.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fixed.asset.mapper.RoleMapper;
import com.fixed.asset.mapper.RoleResourceMapper;
import com.fixed.asset.mapper.UserMapper;
import com.fixed.asset.mapper.UserRoleMapper;
import com.fixed.asset.model.Role;
import com.fixed.asset.model.RoleExample;
import com.fixed.asset.model.User;
import com.fixed.asset.model.UserExample;
import com.fixed.asset.model.UserRole;
import com.fixed.asset.model.UserRoleKey;


@Service("roleService")
public class RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
    
	@Autowired
    private RoleResourceMapper rrMapper;
	
	public List<Role> getRoles(RoleExample example){
		return roleMapper.selectByExample(example);
	}
	
	public long countByExample(RoleExample example) throws Exception{
		return roleMapper.countByExample(example);
	}

	public int deleteByExample(RoleExample example) throws Exception{
		return roleMapper.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer roleId) throws Exception{
		return roleMapper.deleteByPrimaryKey(roleId);
	}

	public int insert(Role record) throws Exception{
		return roleMapper.insert(record);
	}

	public int insertSelective(Role record) throws Exception{
		return roleMapper.insertSelective(record);
	}

	public List<Role> selectByExample(RoleExample example) throws Exception{
		return roleMapper.selectByExample(example);
	}

	public Role selectByPrimaryKey(Integer roleId) throws Exception{
		return roleMapper.selectByPrimaryKey(roleId);
	}

	public int updateByExampleSelective(@Param("record") Role record,
			@Param("example") RoleExample example) throws Exception{
		return roleMapper.updateByExample(record, example);
	}

	public int updateByExample(@Param("record") Role record,
			@Param("example") RoleExample example) throws Exception{
		return roleMapper.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(Role record) throws Exception{
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Role record) throws Exception{
		return roleMapper.updateByPrimaryKey(record);
	}
}
