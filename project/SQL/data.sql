INSERT INTO `user` VALUES ('ssafy', '1234', '김싸피'), ('ssafy2', '1234', '조현수'), ('ssafy3', '1234', '김종인'), ('ssafy4', '1234', '김남준'), ('ssafy5', '1234', '노세희');

INSERT INTO `video` (`youtubeId`, `channelName`, `fitPartName`, `title`, `Date`) VALUES ('-oGon-5QZr8', '윤성빈', '상체', '어깨 운동? 해볼게요', '2023-02-01'),
("u5OgcZdNbMo", "GYM종국", "하체", "저는 하체 식주의자 입니다", "2017-01-01"),("jiiXikQtO-I", "윤성빈", "상체", "팔 운동? 진짜 4개월 차 입니다.", "2021-02-01"),
("SzVGrQoVTJY", "말왕", "하체", "인터벌을 넣어야 진짜 하체지^^", "2023-06-01"),("gMaB-fG4u4g", "ThankyouBUBU", "전신", "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "2019-01-01"),
("tzN6ypk6Sps", "김강민", "하체", "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "2019-05-01"),
("54tTYO-vU2E", "ThankyouBUBU", "상체", "상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "2011-03-03"),("QqqZH3j_vH0", "ThankyouBUBU", "상체", "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "2012-01-01"),
("swRNeYw1JkY", "ThankyouBUBU", "전신", "하루 15분! 전신 칼로리 불태우는 다이어트 운동", "2018-02-01"),("7TLk7pscICk", "SomiFit", "복부", "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "2011-01-01"),
("PjGcOP-TQPE", "ThankyouBUBU", "복부", "11자복근 복부 최고의 운동 [복근 핵매운맛]", "2013-04-01"), ("zruKSHfD7b4", "힙으뜸", "전신", "딱20분, 하루 운동 끝장내는 전신 & 아랫배 & 타바타 올인원 루틴", "2023-01-01"),
("Y5JYCf-tCa4", "윤성빈", "상체", "어깨운동 PT", "2023-07-06"), ("sAVWrSwbtlg", "윤성빈", "하체", "하체? 보여드릴게요", "2023-10-06"), ("6SBrJHbKlN8", "GYM종국", "상체", "상체? 추석 연휴에는 이렇게 운동하세요", "2022-11-05"),
("Cc5HErqdu68", "GYM종국", "상체", "산스장", "2019-12-14"),("Ueb365f-bY0", "힙으뜸", "복부", "복부 중심 뱃살 빼기", "2017-01-13"),
("A5MzlPgNcJM", "힙으뜸", "전신", "전신 근력운동 50분 홈트레이닝", "2018-01-13"),("t70t-sklypk", "ThankyouBUBU", "하체", "집에서 칼로리 불태우는 걷기 유산소운동 [칼소폭 순한맛]", "2020-07-13");


INSERT INTO `review` (`youtubeId`, `userId`, `content`, `regdate`) VALUES ("-oGon-5QZr8", "ssafy", "윤성빈 진짜 어깨 미쳤다...", "2023-01-01"), ("-oGon-5QZr8", "ssafy2", "이렇게 태평양 같은 어깨를 얻기 위해선 정말 피땀눈물이 필요하군요", "2022-02-03"),
("-oGon-5QZr8", "ssafy3", "따라 하는데 너무 어렵네요.. 저는 여기까진가봐요 흑흑", "2022-01-01"),("-oGon-5QZr8", "ssafy", "남자들의 워너비!!", "2022-02-03"), ("gMaB-fG4u4g", "ssafy", "정말 도움이 많이 되는 영상이었어요", "2022-01-01"),
("gMaB-fG4u4g", "ssafy2", "운동 진짜 열심히 하시네요. 저도 꼭 이런 몸을 갖고 싶습니다.", "2022-02-03"),("swRNeYw1JkY", "ssafy", "This is awesome exercise!! Thank you for your video!", "2020-02-03"),
("swRNeYw1JkY", "ssafy2", "작심삼일...ㅠㅠ", "2023-02-03");

INSERT INTO `likedVideo` (`userId`,`youtubeId`) VALUES
("ssafy", "u5OgcZdNbMo"), ("ssafy", "PjGcOP-TQPE"),("ssafy", "-oGon-5QZr8"),
("ssafy2", "7TLk7pscICk"), ("ssafy2", "tzN6ypk6Sps");

INSERT INTO `follow` VALUES ("ssafy", "ssafy5"), ("ssafy", "ssafy2");