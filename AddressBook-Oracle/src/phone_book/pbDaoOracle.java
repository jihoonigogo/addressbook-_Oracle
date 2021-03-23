package phone_book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

public class pbDaoOracle implements phoneBookDao {
	
	//공통 연결 conn = getConnection();
	public Connection getConnection() throws SQLException	{
		Connection conn = null;
		try {
			//드라이브 로드 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl,"C##JIHOONI","1234");
		}catch(ClassNotFoundException e	) {
			System.err.println("드라이버 로드 실패");
		}
		return conn;
	}
	
	@Override
	public List<phoneBookVo> getList() {
		
		List<phoneBookVo> list = new ArrayList<>(); // 테이블 값을 최종적으로 담기 위한 리스트
		Connection conn = null; // 연결
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT id,name,hp,tel FROM phone_book";
			rs = stmt.executeQuery(sql);
		
			while(rs.next()) {
			Long id = rs.getLong("id"); //혹은 1
			String name = rs.getString("name"); //2
			String hp = rs.getString("hp");//3
			String tel = rs.getString("tel");//4
			
			//VO객체 생성 
			phoneBookVo vo = new phoneBookVo (id,name,hp,tel); //생성자 
			list.add(vo); //나중에 tostring 형태로 반환 ??
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return list;
}

	@Override
	public List<phoneBookVo> search(String keyword) {
		
		List<phoneBookVo> list = new ArrayList<> ();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "SELECT id,name,hp,tel FROM phone_book WHERE name LIKE ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {				
				phoneBookVo vo = new phoneBookVo ();
				vo.setId(rs.getLong(1)); //id
				vo.setName(rs.getString(2));//name
				vo.setHp(rs.getString(3));//hp
				vo.setTel(rs.getString(4));//tel
				list.add(vo);
			}
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception e ) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	@Override
	public phoneBookVo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(phoneBookVo vo) { // 추가하기 
		Connection conn = null; 
		String sql = "INSERT INTO phone_book VALUES(seq_author.NEXTVAL,?,?,?)"; //실행계획
		int insertedCount = 0; // 불린용
		PreparedStatement pstmt = null;
		
		try{
			conn = getConnection();		
			pstmt = conn.prepareStatement(sql);
			
			//동적 파라미터 연결 
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getTel());
			
			insertedCount = pstmt.executeUpdate(); //인서트 딜리트 업데이트 모두사용됨			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return insertedCount ==1; //문장의 성공여부
	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM phone_book WHERE id= ? ";
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setLong(1, id);
			deletedCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();			
		}catch( Exception e ) {
			e.printStackTrace();
		}
		}
		return deletedCount == 1;
	}
	}

		/*Scanner sc = new Scanner(System.in);
		System.out.prinltn("이름 : ");
		String name = sc.next();
		System.out.prinltn("핸드폰번호 : ");
		String hp = sc.next();
		System.out.prinltn("전화번호 : ");
		String tel = sc.next();
		
		phoneBookVo vo = new phoneBookVo( name,hp,tel);
		return vo;
	}
*/
		
		

		/*
	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM phone_book WHERE id=?";
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setLong(1, id);
			deletedCount = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			
		}catch( Exception e ) {
			e.printStackTrace();
		}
		return deletedCount == 1;
	}
	}

}*/

