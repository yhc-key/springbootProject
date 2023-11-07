package com.fitpjt.fit.model.service;

import java.util.List;

import com.fitpjt.fit.model.dto.Review;
import com.fitpjt.fit.model.dto.Video;

// 자바용이기에 get, remove,write등 사용
public interface VideoService {
	//비디오 전체 조회
	List<Video> getVideos();
	
	//조회수 기준 동영상 정보
	List<Video> getInterestViewFitVideo();
	
	//특정 부위 동영상 정보
	List<Video> getPartFitVideo(String fitPartName);
	
	//동영상의 모든 리뷰 영상 보기
	List<Review> getAllReview(String youtubeId);
	
	//비디오 추가
	void writeVideo(Video video);
	
	//리뷰 추가
	void writeReview(Review review);
	
	//리뷰 업데이트
	void modifyReview(Review review);
	
	//자세한 리뷰 보기
	Review getDetailReview(int reviewNo);
	
	//랜덤 부위 추천 
	List<Video> randomRecommend();
	
	//동영상 조회수 갱신
	void updateViewCnt(String youtubeId);





	
	
	
}
