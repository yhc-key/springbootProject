package com.fitpjt.fit.model.dto;

import java.util.Date;

public class Review {
	private static int no = 1;
	
	private String youtubeId;
	private int reviewNo;
	private String title;
	private String writer;
	private String content;
	private String regDate;
	private int viewCnt =3;
	
	public Review() {

	}

	public Review(String youtubeId, String title, String writer, String content) {
		super();
		this.youtubeId = youtubeId;
		this.reviewNo = no++;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = new Date().toString();
		this.viewCnt = 4;
	}



	public String getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Review [youtubeId=" + youtubeId + ", reviewId=" + reviewNo + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}



	
	
	
}