package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.MemberBean;

public class MemberDAO extends DAO {

	public MemberBean search(String memberNo) throws Exception {
		
		MemberBean member = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement("select * from members where member_no = ?");
		st.setString(1, memberNo);
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			member = new MemberBean();
			member.setMemberNo(rs.getString("member_no"));
			member.setName(rs.getString("name"));
			member.setAge(rs.getInt("age"));
			member.setBirthYear(rs.getInt("birth_year"));
			member.setBirthMonth(rs.getInt("birth_month"));
			member.setBirthDay(rs.getInt("birth_day"));
		}
		st.close();
		con.close();
		return member;  //見つからなかったときはMemberBean型のnullを返す。
	}
	
	public int insert(MemberBean member) throws Exception { //なぜ例外を投げるのか理解できてない(要不要の判断ができない)。→とりあえず呼び出し元にエラーを投げておくという理解。
		
		Connection con = getConnection(); //親クラスで定義したメソッド。
		
		String memberNo = member.getMemberNo();
		String name = member.getName();
		int age = member.getAge();
		if (age >= 1000) throw new Exception();
		int birthYear = member.getBirthYear();
		int birthMonth = member.getBirthMonth();
		int birthDay = member.getBirthDay();
		
		PreparedStatement st = con.prepareStatement("insert into members values(?, ?, ?, ?, ?, ?)");
		st.setString(1, memberNo);
		st.setString(2, name);
		st.setInt(3, age);
		st.setInt(4, birthYear);
		st.setInt(5, birthMonth);
		st.setInt(6, birthDay);
		
		int line = st.executeUpdate();
		
		return line; //更新に成功したレコードの数を返す。
	}
	
	public int update(MemberBean member) throws Exception{
		
		Connection con = getConnection();
		
		String memberNo = member.getMemberNo();
		String name = member.getName();
		int age = member.getAge();
		if (age >= 1000) throw new Exception();
		int birthYear = member.getBirthYear();
		int birthMonth = member.getBirthMonth();
		int birthDay = member.getBirthDay();
		
		PreparedStatement st = con.prepareStatement(
				"update members "
				+ "set name = ?, age = ?, birth_year = ?, birth_month = ?, birth_day = ? "
				+ "where member_no = ?"
			);
		
		st.setString(1, name);
		st.setInt(2, age);
		st.setInt(3, birthYear);
		st.setInt(4, birthMonth);
		st.setInt(5, birthDay);
		st.setString(6, memberNo);
		
		int line = st.executeUpdate();
		
		return line;
	}
	
	public int delete(MemberBean member) throws Exception {
		
		Connection con = getConnection();
		
		String memberNo = member.getMemberNo();
//		String name = member.getName();
//		int age = member.getAge();
//		int birthYear = member.getBirthYear();
//		int birthMonth = member.getBirthMonth();
//		int birthDay = member.getBirthDay();
		
		PreparedStatement st = con.prepareStatement(
				"delete from members "
				+ "where member_no = ?"
			);
		
		st.setString(1, memberNo);
		
		int line = st.executeUpdate();
		
		return line;
	}
}
