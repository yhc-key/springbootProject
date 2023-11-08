package com.fitpjt.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitpjt.fit.model.dao.VideoDao;
import com.fitpjt.fit.model.dto.Review;
import com.fitpjt.fit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService{
	
	@Autowired
	VideoDao vDao;
	@Override
	public List<Video> getVideos() {
		return vDao.selectAll();
	}

	@Override
	public List<Video> getInterestViewFitVideo() {
		return vDao.selectInterestViewFitVideo();

	}
	@Override
	public List<Video> getPartFitVideo(String fitPartName) {
		return vDao.selectPartFitVideo(fitPartName);
	}

	@Override
	public List<Review> getAllReview(String youtubeId) {
		// TODO Auto-generated method stub
		return vDao.showAllReview(youtubeId);
	}

	@Override
	public void writeReview(Review review) {
		vDao.insertReview(review);
		return;
	}

	@Override
	public void modifyReview(Review review) {
		// TODO Auto-generated method stub
		vDao.updateReview(review);
		return;
	}

	@Override
	public Review getDetailReview(int reviewNo) {
		// TODO Auto-generated method stub
		return vDao.selectOneReview(reviewNo);
	}


	@Override
	public void updateViewCnt(String youtubeId) {
		vDao.updateViewCnt(youtubeId);
		return ;
	}


	@Override
	public Video getVideo(String youtubeId) {
		return vDao.selectVideo(youtubeId);
	}

	@Override
	public List<Video> getRandomVideo() {
		return vDao.selectRandomVideo();
	}

	@Override
	public void removeReview(int reviewNo) {
		vDao.deleteReview(reviewNo);
		return ;
	}

	@Override
	public void writeVideo(Video video) {
		// TODO Auto-generated method stub
		
	}


}
