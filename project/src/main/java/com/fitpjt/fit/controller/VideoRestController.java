package com.fitpjt.fit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitpjt.fit.model.dto.Review;
import com.fitpjt.fit.model.dto.Video;
import com.fitpjt.fit.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/video-api")
@Api(tags="비디오 컨트롤러")
//@CrossOrigin("*")
public class VideoRestController {
	@Autowired
	private VideoService videoService;

	// 1. 영상 전체 목록(검색조건 있을 수도 있고 없을 수도 있다.)
	@GetMapping("/video")
	@ApiOperation(value="영상 전체 목록", notes="검색조건도 넣으면 같이 가져온다.")
	public ResponseEntity<?> list(){
		
		List<Video> list = videoService.getList(condition); //전체 조회
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	// 2. 영상 상세
	@GetMapping("/video/{youtubeId}")
	@ApiOperation(value = "영상 상세")
	public ResponseEntity<?> detail(@PathVariable String youtubeId){
		Map<Video, List<Review>> map = new HashMap<>();
	
		Video video = videoService.getVideo(youtubeId);
		List<Review> review = videoService.getReview(youtubeId);
		map.put(video, review);
		
		return new ResponseEntity<Map<Video, List<Review>>>(map, HttpStatus.OK);
	}
	
	// 3. 영상 등록
	@PostMapping("/video")
	@ApiOperation(value = "영상 등록")
	public ResponseEntity<Video> write(Video video){
		videoService.writeVideo(video);
	
		return new ResponseEntity<Video>(video, HttpStatus.CREATED);
	}
	
	// 4. 영상 삭제
	@DeleteMapping("/video/{youtubeId}")
	@ApiOperation(value = "영상 삭제")
	public ResponseEntity<Void> delete(@PathVariable String youtubeId){
		videoService.removeVideo(youtubeId);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 5. 영상 수정
	@PutMapping("/video") //JSON 형태의 데이터로 넘어왔을 떄 처리하고 싶은데?
	@ApiOperation(value = "영상 수정")
	public ResponseEntity<Void> update(@RequestBody Video video){
		videoService.modifyVideo(video);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//6. 리뷰 작성
	@PostMapping("/video/review")
	@ApiOperation(value = "리뷰 작성")
	public ResponseEntity<Void> writeReview(@RequestBody Review review){
		videoService.writeReview(review);
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	//7. 리뷰 수정
	@PutMapping("/video/review")
	@ApiOperation(value = "리뷰 수정")
	public ResponseEntity<Void> updateReview(@RequestBody Review review){
		videoService.modifyReview(review);
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	//8. 리뷰 삭제
	@DeleteMapping("/video/review/{reviewNo}")
	@ApiOperation(value = "리뷰 삭제")
	public ResponseEntity<Void> deleteReview(@PathVariable int reviewNo){
		videoService.removeReview(reviewNo);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//9. 리뷰 상세
	@GetMapping("/video/review/{reviewNo}")
	@ApiOperation(value = "리뷰 상세")
	public ResponseEntity<Review> readReview(@PathVariable int reviewNo){
		return new ResponseEntity<Review>(videoService.getOneReview(reviewNo), HttpStatus.OK);
	}
	
}
