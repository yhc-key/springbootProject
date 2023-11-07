package com.fitpjt.fit.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitpjt.fit.model.dto.User;
import com.fitpjt.fit.model.dto.Video;
import com.fitpjt.fit.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user-api")
@Api(tags = "사용자 컨트롤러")
// @CrossOrigin("*") // "*"는 전부 ok라는 의미
public class UserRestController {

	@Autowired
	private UserService uService;

	// 유저 목록 조회
	@GetMapping("user")
	@ApiOperation(value = "사용자 목록 조회")
	private ResponseEntity<List<User>> selectAll() {
		List<User> list = uService.selectAllUser();

		return new ResponseEntity<List<User>>(list, HttpStatus.CREATED);
	}

	// 유저 등록
	@PostMapping("user")
	@ApiOperation(value = "사용자  회원가입")
	private ResponseEntity<Boolean> signup(User user) {
		boolean result = uService.insertUser(user);

		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}

	// 유저 정보 수정
	@PutMapping("user")
	@ApiOperation(value = "사용자 정보 수정")
	private ResponseEntity<Void> update(String id, String name) {
		uService.updateUser(id, name);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 유저 삭제
	@DeleteMapping("user/{id}")
	@ApiOperation(value = "사용자 탈퇴")
	private ResponseEntity<Void> delete(@PathVariable String id) {
		uService.deleteUser(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 유저 정보 조회
	@GetMapping("user/{id}")
	@ApiOperation(value = "사용자 상세조회")
	private ResponseEntity<User> selectOne(@PathVariable String id) {
		User user = uService.selectOneUser(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	// 유저가 좋아요한 영상 조회
	@GetMapping("likedVedio/{userId}")
	@ApiOperation(value = "사용자가 '좋아요'한 영상 조회")
	private ResponseEntity<List<Video>> selectLikedVideo(@PathVariable String userId) {
		List<Video> list = uService.selectLikedVideo(userId);

		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}

	// 유저가 좋아요한 영상 추가
	@PostMapping("likedVedio/{userId}/{youtubeId}")
	@ApiOperation(value = "사용자가 '좋아요'한 영상 추가")
	private ResponseEntity<Void> insertLikedVideo(@PathVariable String userId, @PathVariable String youtubeId) {
		uService.insertLikedVideo(userId, youtubeId);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// 유저가 좋아요한 영상 삭제
	@DeleteMapping("likedVedio/{userId}/{youtubeId}")
	@ApiOperation(value = "사용자가 '좋아요'한 영상 삭제")
	private ResponseEntity<Void> deleteLikedVideo(@PathVariable String userId, @PathVariable String youtubeId) {
		uService.deleteLikedVideo(userId, youtubeId);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 유저 팔로우 기능
	@PostMapping("follow/{followerId}/{followingId}")
	@ApiOperation(value = "사용자 팔로우")
	private ResponseEntity<Void> insertFollow(@PathVariable String followerId, @PathVariable String followingId) {
		uService.addFollow(followerId, followingId);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// 유저 팔로우 삭제
	@DeleteMapping("follow/{followerId}/{followingId}")
	@ApiOperation(value = "사용자 팔로우 삭제")
	private ResponseEntity<Void> deleteFollow(@PathVariable String followerId, @PathVariable String followingId) {
		uService.removeFollow(followerId, followingId);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 내 팔로워 조회
	@GetMapping("follow/{followerId}")
	@ApiOperation(value = "내 팔로워 조회")
	private ResponseEntity<List<User>> deleteFollow(String followerId) {
		List<User> followerList = uService.selectFollowingUser(followerId);

		return new ResponseEntity<List<User>>(followerList, HttpStatus.OK);
	}

	@PostMapping("login")
	@ApiOperation(value = "로그인")
	public ResponseEntity<?> login(User user, HttpSession session) {
		String id = user.getId();
		String password = user.getPass();

		User dbUser = uService.selectOneUser(id);

		if (dbUser != null && dbUser.getPass().equals(password)) {
			session.setAttribute("loginUser", dbUser.getName());
			//name이 한글이어서 인코딩 이슈 때문에 일단 임시로 영어인 ID를 reponseEntity에 넘김
			return new ResponseEntity<String>("welcome, "+ dbUser.getId(), HttpStatus.OK);
		} else {

			return new ResponseEntity<String>("login failed",HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("logout")
	@ApiOperation(value = "로그아웃")
	public ResponseEntity<Void> logout(HttpSession session) {
		// session.removeAttribute("loginUser");
		session.invalidate();
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}