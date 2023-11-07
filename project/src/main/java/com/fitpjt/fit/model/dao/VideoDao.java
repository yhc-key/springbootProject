package com.fitpjt.fit.model.dao;

import java.util.List;

import com.fitpjt.fit.model.dto.Review;
import com.fitpjt.fit.model.dto.Video;

//DB용이라 insert, update, delete, 등사용
public interface VideoDao {
	// 비디오 전체 조회
	List<Video> selectAll();

	//특정 파트 비디오 조회
	List<Video> selectPartFitVideo(String fitPartName);
	
	//조회수 순 비디오 조회
	List<Video> selectInterestViewFitVideo();
	// 비디오 등록
	void insertVideo(Video video);

	// 비디오 상세 조회
	Video selectOne(String youtubeId);

	// 비디오 수정
	void updateVideo(Video video);

	// 비디오 삭제
	void deleteVideo(String youtubeId);

	// 조회수 증가
	void updateViewCnt(String youtubeId);
	
	//리뷰 전체 보기
	List<Review> showAllReview(String youtubeId);

	// 리뷰 등록
	void insertReview(Review review);

	// 리뷰 한개 조회
	Review selectOneReview(int reviewNo);
	
	// 리뷰 수정
	void updateReview(Review review);

	// 리뷰 삭제
	void deleteReview(int reviewNo);
	
	//랜덤 파트 비디오 목록 주기
	List<Video> selectRandomVideo();
}
