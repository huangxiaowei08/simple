package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.Country;

public class CountryTest2 extends BaseMapperTest {
	
	@Test
	public void testSellectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
			// 方法名不唯一的时候，要带上全的命名空间
			List<Country> countryList = sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
			printCountryList(countryList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	private void printCountryList(List<Country> countryList) {
		for(Country country : countryList) {
			System.out.printf("%-4d%4s%4s\n",
					country.getId(),country.getCountryname(),country.getCountrycode());
		}
	}

}
