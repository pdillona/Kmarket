ALTER TABLE `km_product_cate2` RENAME COLUMN `km_product_cate1_cate1` TO cate1;

ALTER TABLE `km_product` AUTO_INCREMENT=1000000;

ALTER TABLE `km_product` MODIFY COLUMN `seller` VARCHAR(20) AFTER `prodNo`;
ALTER TABLE `km_product` MODIFY COLUMN `prodName` VARCHAR(100) AFTER `prodCate2`;

ALTER TABLE `km_cs_file` RENAME `km_file`;	

ALTER TABLE `km_product` ADD `newThumb1` VARCHAR(255) NOT NULL AFTER `thumb1`;	
ALTER TABLE `km_product` ADD `newThumb2` VARCHAR(255) NOT NULL AFTER `thumb2`;	
ALTER TABLE `km_product` ADD `newThumb3` VARCHAR(255) NOT NULL AFTER `thumb3`;	
ALTER TABLE `km_product` ADD `newDetail` VARCHAR(255) NOT NULL AFTER `detail`;	

INSERT INTO `km_product_cate1` VALUES(10, '브랜드패션');
INSERT INTO `km_product_cate1` VALUES(11, '패션의류·잡화·뷰티');
INSERT INTO `km_product_cate1` VALUES(12, '유아동');
INSERT INTO `km_product_cate1` VALUES(13, '식품·생필품');
INSERT INTO `km_product_cate1` VALUES(14, '홈데코·문구·취미·반려');
INSERT INTO `km_product_cate1` VALUES(15, '컴퓨터·디지털·가전');
INSERT INTO `km_product_cate1` VALUES(16, '스포츠·건강·렌탈');
INSERT INTO `km_product_cate1` VALUES(17, '자동차·공구');
INSERT INTO `km_product_cate1` VALUES(18, '여행·km_product_cate1도서·티켓·e쿠폰');

INSERT INTO `km_product_cate2` VALUES(10, '브랜드 여성의류', 10);
INSERT INTO `km_product_cate2` VALUES(11, '브랜드 남성의류', 10);
INSERT INTO `km_product_cate2` VALUES(12, '브랜드 진/캐쥬얼', 10);
INSERT INTO `km_product_cate2` VALUES(13, '브랜드 신발/가방', 10);
INSERT INTO `km_product_cate2` VALUES(14, '브랜드 쥬얼리/시계', 10);
INSERT INTO `km_product_cate2` VALUES(15, '브랜드 아웃도어', 10);

INSERT INTO `km_product_cate2` VALUES(10, '여성의류', 11);
INSERT INTO `km_product_cate2` VALUES(11, '남성의류', 11);
INSERT INTO `km_product_cate2` VALUES(12, '언더웨어', 11);
INSERT INTO `km_product_cate2` VALUES(13, '신발', 11);
INSERT INTO `km_product_cate2` VALUES(14, '가방/잡화', 11);
INSERT INTO `km_product_cate2` VALUES(15, '쥬얼리/시계', 11);

INSERT INTO `km_product_cate2` VALUES(10, '출산/육아', 12);
INSERT INTO `km_product_cate2` VALUES(11, '장난감/완구', 12);
INSERT INTO `km_product_cate2` VALUES(12, '유아동 의류', 12);
INSERT INTO `km_product_cate2` VALUES(13, '유아동 신발/잡화', 12);

INSERT INTO `km_product_cate2` VALUES(10, '신선식품', 13);
INSERT INTO `km_product_cate2` VALUES(11, '가공식품', 13);
INSERT INTO `km_product_cate2` VALUES(12, '건강식품', 13);
INSERT INTO `km_product_cate2` VALUES(13, '커피/음료', 13);
INSERT INTO `km_product_cate2` VALUES(14, '생필품', 13);
INSERT INTO `km_product_cate2` VALUES(15, '바디/헤어', 13);

INSERT INTO `km_product_cate2` VALUES(10, '가구/DIY', 14);
INSERT INTO `km_product_cate2` VALUES(11, '침구/커튼', 14);
INSERT INTO `km_product_cate2` VALUES(12, '조명/인테리어', 14);
INSERT INTO `km_product_cate2` VALUES(13, '생활용품', 14);
INSERT INTO `km_product_cate2` VALUES(14, '주방용품', 14);
INSERT INTO `km_product_cate2` VALUES(15, '문구/사무용품', 14);
INSERT INTO `km_product_cate2` VALUES(16, '사무기기', 14);
INSERT INTO `km_product_cate2` VALUES(17, '악기/취미', 14);
INSERT INTO `km_product_cate2` VALUES(18, '반려동물용품', 14);

INSERT INTO `km_product_cate2` VALUES(10, '노트북/PC', 15);
INSERT INTO `km_product_cate2` VALUES(11, '모니터/프린터', 15);
INSERT INTO `km_product_cate2` VALUES(12, 'PC주변기기', 15);
INSERT INTO `km_product_cate2` VALUES(13, '모바일/태블릿', 15);
INSERT INTO `km_product_cate2` VALUES(14, '카메라', 15);
INSERT INTO `km_product_cate2` VALUES(15, '게임', 15);
INSERT INTO `km_product_cate2` VALUES(16, '영상가전', 15);
INSERT INTO `km_product_cate2` VALUES(17, '주방가전', 15);
INSERT INTO `km_product_cate2` VALUES(18, '계절가전', 15);
INSERT INTO `km_product_cate2` VALUES(19, '생활/미용가전', 15);
INSERT INTO `km_product_cate2` VALUES(20, '음향가전', 15);
INSERT INTO `km_product_cate2` VALUES(21, '건강가전', 15);

INSERT INTO `km_product_cate2` VALUES(10, '스포츠의류/운동화', 16);
INSERT INTO `km_product_cate2` VALUES(11, '휘트니스/수영', 16);
INSERT INTO `km_product_cate2` VALUES(12, '구기/라켓', 16);
INSERT INTO `km_product_cate2` VALUES(13, '골프', 16);
INSERT INTO `km_product_cate2` VALUES(14, '자전거/보드/기타레저', 16);
INSERT INTO `km_product_cate2` VALUES(15, '캠핑/낚시', 16);
INSERT INTO `km_product_cate2` VALUES(16, '등산/아웃도어', 16);
INSERT INTO `km_product_cate2` VALUES(17, '건강/의료용품', 16);
INSERT INTO `km_product_cate2` VALUES(18, '건강식품', 16);
INSERT INTO `km_product_cate2` VALUES(19, '렌탈서비스', 16);

INSERT INTO `km_product_cate2` VALUES(10, '자동차용품', 17);
INSERT INTO `km_product_cate2` VALUES(11, '공구/안전/산업용품', 17);

INSERT INTO `km_product_cate2` VALUES(10, '여행/항공권', 18);
INSERT INTO `km_product_cate2` VALUES(11, '도서/음반/e교육', 18);
INSERT INTO `km_product_cate2` VALUES(12, '공연티켓', 18);
INSERT INTO `km_product_cate2` VALUES(13, 'e쿠폰', 18);
INSERT INTO `km_product_cate2` VALUES(14, '상품권', 18);
INSERT INTO `km_product_cate2` VALUES(15, '캠핑/낚시', 18);
