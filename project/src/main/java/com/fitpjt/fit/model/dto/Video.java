package com.fitpjt.fit.model.dto;

public class Video implements Comparable<Video>{
	private String youtubeId;
	private String channelName;
	private String fitPartName;
	private String title;
	private String date;
	private int viewCnt;
	public Video() {}
	
	public Video(String title, String fitPartName, String youtubeId, String channelName, String date,  int viewCnt) {
		super();
		this.fitPartName = fitPartName;
		this.youtubeId = youtubeId;
		this.title = title;
		this.channelName = channelName;
		this.date = date;
		this.viewCnt = viewCnt;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFitPartName() {
		return fitPartName;
	}

	public void setFitPartName(String fitPartName) {
		this.fitPartName = fitPartName;
	}

	public String getYoutubeId() {
		return youtubeId;
	}

	public void setYoutubeId(String youtubeId) {
		this.youtubeId = youtubeId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Video [title=" + title + ", fitPartName=" + fitPartName + ", youtubeId=" + youtubeId + ", channelName="
				+ channelName + ", viewCnt=" + viewCnt + "]";
	}

	@Override
	public int compareTo(Video o) {
		
		return o.viewCnt - this.viewCnt;
	}
	
}