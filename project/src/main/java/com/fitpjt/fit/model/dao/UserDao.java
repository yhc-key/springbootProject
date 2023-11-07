package com.fitpjt.fit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fitpjt.fit.model.dto.User;
import com.fitpjt.fit.model.dto.Video;

public interface UserDao {
	// 유저 목록 가져오기
	List<User> selectAllUser();
	
	// 유저 생성
	boolean insertUser(User user);
	
	// 유저 정보 수정
	void updateUser(@Param("id") String id, @Param("name") String name);
	
	// 유저 삭제
	void deleteUser(String id);
	
	// 유저 정보 조회
	User selectOneUser(String id);

	// 유저의 좋아요한 영상 조회
	List<Video> selectLikedVideo(String userId);

	// 유저의 좋아요 영상 추가
//	void insertUserVideo(List<Basket> baskets, Basket basket);
	void insertLikedVideo(@Param("userId") String userId, @Param("youtubeId") String youtubeId);

	// 유저의 좋아요 영상 삭제
	void deleteLikedVideo(@Param("userId") String userId, @Param("youtubeId") String youtubeId);

	// 유저 팔로우 기능
	void insertFollow(@Param("followerId") String followerId, @Param("followingId") String followingId);
	
	// 유저 팔로우 삭제
	void deleteFollow(@Param("followerId") String followerId, @Param("followingId") String followingId);
	
	// 팔로우하고 있는 유저 조회
	List<User> selectFollowingUser(String followerId);

	
}