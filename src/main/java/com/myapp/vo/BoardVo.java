package com.myapp.vo;

import java.text.SimpleDateFormat;
import java.util.Date;


public class BoardVo {
	int no;
	String id;
	String title;
	String content;
	String date;
	int count;
	int limit;
	int offset;
	

public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}


	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


@Override
public String toString() {
	return no+id+title+content+count+date;
}


}
