package com.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myapp.vo.BoardVo;
import com.myapp.vo.MemberVo;

public interface BoardMapper {
	@Insert("insert into board(no, id, title, content, date, count)values(default, #{id}, #{title}, #{content}, now(), #{count})")
	public boolean insertcontent(BoardVo boardvo);

	@Select("select * from board")
	public List<BoardVo> getContent(BoardVo board);
	
	@Select("select * from board where no=#{no}")
	public List<BoardVo> lookdo2(int no);
	
	@Select("select * from board ORDER BY no desc")
	public List<BoardVo> getContent2();
	
	@Select("select * from board limit #{limit} offset #{offset}")
	public List<BoardVo> Paging(BoardVo board);
	
	@Delete("delete from board where no=#{no}")
	public boolean deleteboard(int no);
	
	@Update("UPDATE board SET title=#{title}, content=#{content} WHERE no=#{no};")
	public boolean updateboard(BoardVo board);
	
	@Update("UPDATE board SET count = count+1 WHERE no=#{no};")
	public boolean count(int no);
	
}
