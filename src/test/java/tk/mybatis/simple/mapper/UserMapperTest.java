package tk.mybatis.simple.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public class UserMapperTest extends BaseMapperTest{
	
	@Test
	public void testSelectById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = userMapper.selectById(1L);
			assertNotNull(sysUser);
			assertEquals("admin", sysUser.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> sysUserList = userMapper.selectAll();
			assertNotNull(sysUserList);
			assertEquals(2, sysUserList.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserId() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysRole> sysRoleList = userMapper.selectRolesByUserId(1L);
			assertNotNull(sysRoleList);
			assertEquals(2, sysRoleList.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	
	
	
	
	
	
	//========自己写的，不规范的写法==========
//	@Test
//	public void testSelectById() {
//		SqlSession sqlSession = getSqlSession();
//		try {
//			SysUser sysUser = sqlSession.selectOne("selectById",1);
//			System.out.println("用户名称-->"+sysUser.getUserName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			sqlSession.close();
//		}
//	}
//	
//	@Test
//	public void testSelectAll() {
//		SqlSession sqlSession = getSqlSession();
//		try {
//			List<SysUser> sysUserList = sqlSession.selectList("tk.mybatis.simple.mapper.UserMapper.selectAll");
//			for(SysUser sysUser : sysUserList) {
//				System.out.println("用户名称-->"+sysUser.getUserName());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			sqlSession.close();
//		}
//	}

}
