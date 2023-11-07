package com.fitpjt.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitpjt.fit.model.dao.UserDao;
import com.fitpjt.fit.model.dto.User;
import com.fitpjt.fit.model.dto.Video;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao uDao;

	@Override
	public List<User> selectAllUser() {
		return uDao.selectAllUser();
	}

	@Override
	public boolean insertUser(User user) {
		return uDao.insertUser(user);

	}

	@Override
	public User selectOneUser(String id) {
		return uDao.selectOneUser(id);
	}

	@Override
	public void updateUser(String id, String name) {
		uDao.updateUser(id, name);
	}

	@Override
	public void deleteUser(String id) {
		uDao.deleteUser(id);
	}

	@Override
	public List<Video> selectLikedVideo(String userId) {
		return uDao.selectLikedVideo(userId);
	}

//	public void createUserVideo(List<Basket> baskets, Basket basket) {
//		dao.insertUserVideo(baskets, basket);
//
//	}

	@Override
	public void insertLikedVideo(String userId, String youtubeId) {
		uDao.insertLikedVideo(userId, youtubeId);

	}

	@Override
	public void deleteLikedVideo(String userId, String youtubeId) {
		uDao.deleteLikedVideo(userId, youtubeId);

	}

	// 다른 회원 팔로우
	@Override
	public void addFollow(String followerId, String followingId) {
		uDao.insertFollow(followerId, followingId);
	}

	// 팔로우 삭제
	@Override
	public void removeFollow(String followerId, String followingId) {
		uDao.deleteFollow(followerId, followingId);
	}

	@Override
	public List<User> selectFollowingUser(String followerId) {
		return uDao.selectFollowingUser(followerId);
	}
}