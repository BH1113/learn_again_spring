create table board
(
    pk           INT primary key auto_increment,
    title        VARCHAR(30)  not null comment '제목',
    writer       VARCHAR(30)  not null comment '작성자',
    tag          TINYINT      not null comment '태그',
    board_detail VARCHAR(200) not null comment '내용',
    create_at    DATETIME     not null comment '작성일',
    update_at    DATETIME     not null comment '최종 수정일'
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;
create table board_tag
(
    pk INT PRIMARY KEY auto_increment,
    tag TINYINT not null comment '태그',
    name VARCHAR(30) not null comment '이름',
    create_at DATETIME not null comment '작성일',
    update_at DATETIME not null comment '수정일'
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;