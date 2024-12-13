package pj.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pj.spring.vo.ProductVO;
import pj.spring.vo.UserVO;

@Repository
public class AdminDAO {

	@Autowired
	public SqlSession sqlSession;
	
	private final String namespace = "pj.spring.mapper.adminMapper";
	
	// ��ú��� �ֹ� ����  �� ��
	public Map<String, Object> orderCount(){
		return sqlSession.selectOne(namespace + ".orderCount");
	}
	
	// ��ú��� ��� ����  �� ��
	public Map<String, Object> cancelCount(){
		return sqlSession.selectOne(namespace + ".cancelCount");
	}
	
	// ��ú��� ����/���� ����  �� ��
	public Map<String, Object> contentCount(){
		return sqlSession.selectOne(namespace + ".contentCount");
	}
	
	// ȸ�� ���� list
	public List<UserVO> userList(Map<String,Integer> pagingParam){
		return sqlSession.selectList(namespace+".userList",pagingParam);
	}
	
	// ȸ�� ��ü ��
	public int selectTotal() {
		return sqlSession.selectOne(namespace+".selectTotal");
	}
	
	// ��ǰ ���
	public int insertProduct(ProductVO productVO){
		return sqlSession.insert(namespace+".insertProduct",productVO);
	}
	
	// ��ǰ ÷������
	public int insertAttachment(ProductVO productVO){
		return sqlSession.insert(namespace+".insertAttachment",productVO);
	}
	
	// ��ǰ ÷������ ��
	public int insertAttachmentDetail(ProductVO productVO){
		return sqlSession.insert(namespace+".insertAttachmentDetail",productVO);
	}
	
}
