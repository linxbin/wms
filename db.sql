SET NAMES utf8mb4;

CREATE TABLE `storehouse`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `number` VARCHAR(40) NOT NULL COMMENT '编号',
    `name` VARCHAR(20) NOT NULL COMMENT '名称',
    `volume` DECIMAL(12, 2) NOT NULL DEFAULT '0' COMMENT '容量',
    `used_volume` DECIMAL(12, 2) NOT NULL DEFAULT '0' COMMENT '已用容量',
    `note` VARCHAR(255) NOT NULL COMMENT '备注',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间'
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '仓库';

CREATE TABLE `storehouse_area`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `number` VARCHAR(40) NOT NULL COMMENT '编码',
    `name` VARCHAR(20) NOT NULL COMMENT '名称',
    `storehouse_id` BIGINT UNSIGNED NOT NULL COMMENT '仓库ID',
    `volume` DECIMAL(8, 2) NOT NULL DEFAULT '0' COMMENT '总容量',
    `use_volume` DECIMAL(8, 2) NOT NULL DEFAULT '0' COMMENT '已用容量',
    `note` VARCHAR(255) NOT NULL DEFAULT '‘’' COMMENT '备注',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '库区';

CREATE TABLE `storehouse_location`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `number` VARCHAR(40) NOT NULL COMMENT '编号',
    `name` VARCHAR(20) NOT NULL COMMENT '名称',
    `storehoue_id` BIGINT UNSIGNED NOT NULL COMMENT '仓库ID',
    `storehouse_area_id` BIGINT UNSIGNED NOT NULL COMMENT '库区ID',
    `volume` DECIMAL(8, 2) NOT NULL DEFAULT '0' COMMENT '容量',
    `used_volume` DECIMAL(8, 2) NOT NULL DEFAULT '0' COMMENT '已用容量',
    `note` VARCHAR(255) NOT NULL COMMENT '备注',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '库位';

CREATE TABLE `goods`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `number` VARCHAR(40) NOT NULL COMMENT '编号',
    `name` VARCHAR(20) NOT NULL COMMENT '名称',
    `category_id` BIGINT NOT NULL COMMENT '品类ID',
    `specification` VARCHAR(20) NOT NULL COMMENT '规格型号',
    `unit` VARCHAR(20) NOT NULL COMMENT "计量单位",
    `packing` VARCHAR(20) NOT NULL COMMENT '包装方式',
    `unit_price` DECIMAL(12, 2) NOT NULL DEFAULT 0.00 COMMENT '单价',
    `barcode` VARCHAR(100) NOT NULL COMMENT '条形码',
    `length` DECIMAL(12, 2) NOT NULL DEFAULT 0.00 COMMENT '长',
    `width` DECIMAL(12, 2) NOT NULL DEFAULT 0.00 COMMENT '宽',
    `height` DECIMAL(12, 2) NOT NULL DEFAULT 0.00 COMMENT '高',
    `volume` DECIMAL(12, 2) NOT NULL DEFAULT 0.00 COMMENT '体积',
    `net_weight` DECIMAL(12, 2) NOT NULL COMMENT '净重',
    `gross_weight` DECIMAL(12, 2) NOT NULL COMMENT '毛重',
    `status` TINYINT NOT NULL COMMENT '状态',
    `supplier_id` BIGINT NOT NULL COMMENT '供应商ID',
    `max_stock` INT NOT NULL COMMENT '最高库存',
    `min_stock` INT NOT NULL COMMENT '最低库存',
    `remind_before_expire_days` INT NOT NULL DEFAULT 0 COMMENT '过期前提醒（天）',
    `is_inspect` TINYINT(1) NOT NULL COMMENT '是否检查',
    `inspector_number` VARCHAR(255) NOT NULL COMMENT '检查人员',
    `inspect_item` BIGINT NOT NULL COMMENT '送检项目',
    `storage_cost_ratio` DECIMAL(8, 2) NOT NULL COMMENT '存储费用比例',
    `brand` VARCHAR(255) NOT NULL COMMENT '品牌',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '货物';

CREATE TABLE `goods_category`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `number` VARCHAR(40) NOT NULL COMMENT '编号',
    `name` VARCHAR(20) NOT NULL COMMENT '名称',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '货物品类';

CREATE TABLE `vehicle`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `plate_number` VARCHAR(255) NOT NULL COMMENT '车牌号',
    `driver` VARCHAR(255) NOT NULL COMMENT '司机',
    `driver_contact` INT NOT NULL COMMENT '司机联系电话',
    `type` TINYINT NOT NULL COMMENT '车辆类型',
    `volume` DECIMAL(8, 2) NOT NULL COMMENT '运输体积',
    `weight` DECIMAL(8, 2) NOT NULL COMMENT '运输重量',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '车辆';

CREATE TABLE `settlement_company`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `number` VARCHAR(255) NOT NULL,
    `contact_name` VARCHAR(255) NOT NULL,
    `contact_number` VARCHAR(255) NOT NULL,
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '结算单位';

CREATE TABLE `supplier`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `number` VARCHAR(255) NOT NULL COMMENT '编码',
    `name` VARCHAR(255) NOT NULL COMMENT '名称',
    `contact_name` VARCHAR(255) NOT NULL,
    `contact_number` INT UNSIGNED NOT NULL,
    `note` VARCHAR(255) NOT NULL,
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '供应商';

CREATE TABLE `customer`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `number` VARCHAR(255) NOT NULL,
    `settlement_company_id` BIGINT UNSIGNED NOT NULL COMMENT '结算单位ID',
    `contact_name` VARCHAR(255) NOT NULL,
    `contact_number` INT NOT NULL,
    `address` VARCHAR(255) NOT NULL,
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间'
)ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '客户';