package com.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.myapp.vo.MemberVo;

public interface MemberMapper {
	
	@Insert("insert into member(id, pw) values (#{id}, #{pw})")
	public boolean createmember(MemberVo membervo);
	
	@Select("select * from member where id=#{id} and pw=#{pw}")
	public List<MemberVo> login(MemberVo membervo);
	
	@Delete("delete from member where id=#{id}")
	public boolean deletemember(String id);
}
