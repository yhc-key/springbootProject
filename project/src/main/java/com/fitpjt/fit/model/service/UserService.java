package com.fitpjt.fit.model.service;

import java.util.List;

import com.fitpjt.fit.model.dto.User;
import com.fitpjt.fit.model.dto.Video;

public interface UserService {
	// 전체 유저 조회
	List<User> selectAllUser();

	// 유저 생성
	boolean insertUser(User user);

	// 유저 정보 수정
	void updateUser(String id, String name);

	// 유저 삭제
	void deleteUser(String id);

	// 유저 조회
	User selectOneUser(String id);

	// 유저 좋아요한 영상 조회
	List<Video> selectLikedVideo(String userId);

	// 유저 좋아요 영상 추가
//	void createUserVideo(List<Basket> baskets, Basket basket);
	void insertLikedVideo(String userId, String youtubeId);

	// 유저 좋아요 영상 삭제
	void deleteLikedVideo(String userId, String youtubeId);

	// 팔로우
	void addFollow(String followerId, String followingId);

	// 팔로우 삭제
	void removeFollow(String followerId, String followingId);

	// 유저가 팔로우한 유저 조회
	List<User> selectFollowingUser(String followerId);

}
