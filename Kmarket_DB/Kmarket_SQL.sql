ALTER TABLE `km_product_cate2` RENAME COLUMN `km_product_cate1_cate1` TO cate1;

ALTER TABLE `km_product` AUTO_INCREMENT=1000000;

ALTER TABLE `km_product` MODIFY COLUMN `seller` VARCHAR(20) AFTER `prodNo`;
ALTER TABLE `km_product` MODIFY COLUMN `prodName` VARCHAR(100) AFTER `prodCate2`;

ALTER TABLE `km_cs_file` RENAME `km_file`;	

ALTER TABLE `km_product` ADD `newThumb1` VARCHAR(255) NOT NULL AFTER `thumb1`;	
ALTER TABLE `km_product` ADD `newThumb2` VARCHAR(255) NOT NULL AFTER `thumb2`;	
ALTER TABLE `km_product` ADD `newThumb3` VARCHAR(255) NOT NULL AFTER `thumb3`;	
ALTER TABLE `km_product` ADD `newDetail` VARCHAR(255) NOT NULL AFTER `detail`;	