# 게시판
DROP TABLE IF EXISTS board;
create table board
(
    pk int primary key auto_increment,
    title varchar(30) not null comment '제목',
    writer varchar(30) not null comment '작성자',
    board_detail varchar(200) not null  comment '내용',
    create_at datetime not null comment '작성일',
    update_at datetime not null comment '최종 수정일'
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8MB4;