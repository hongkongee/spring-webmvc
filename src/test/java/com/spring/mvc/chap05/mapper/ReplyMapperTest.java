package com.spring.mvc.chap05.mapper;

import com.spring.mvc.chap05.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Autowired
    ReplyMapper replyMapper;

/*
    @Test
    @DisplayName("게시물을 100개 등록하고, 랜덤으로 1000개의 댓글을 게시글에 등록한다.")
    void bulkInsertTest() {
        // when
        for (int i = 1; i <= 100 ; i++) {
            Board b = Board.builder()
                    .title("글 " + i)
                    .content("내용 " + i)
                    .writer("작성자 " + i)
                    .build();

            boardMapper.save(b);
        }

        for (int i = 1; i < 1000; i++) {
            Reply reply = Reply.builder()
                    .replyText("ㅎㅎㅎ " + i)
                    .replyWriter("잼민이 " + i)
                    .boardNo((int) (Math.random()*100 + 1)) // 아무 게시물에 랜덤으로 넣기
                    .build();

            replyMapper.save(reply);

        }

    }
    */


    @Test
    @DisplayName("77번 게시물의 댓글 목록을 조회했을 때 결과 리스트의 사이즈는 n이어야 한다.")
    void findAllTest() {
        // given
        int boardNo = 77;

        // when
        List<Reply> replies = replyMapper.findAll(boardNo, page);

        // then
        assertEquals(replies.size(), 13);

    }

    @Test
    @DisplayName("77번 게시물의 댓글 중 n번 댓글을 삭제하면 n번 댓글은 조회되지 않을 것이고, " +
            "77번을 전체조회하면 리스트 사이즈는 하나 줄어있어야 한다.")
    void deleteTest() {
        // given
        int boardNo = 77;
        int replyNo = 223;

        // when
        replyMapper.delete(replyNo);
        Reply r = replyMapper.findOne(replyNo); // null
        List<Reply> replies = replyMapper.findAll(boardNo, page);

        // then
        assertNull(r);
        assertEquals(replies.size(), 12);
        assertNotEquals(replyMapper.count(boardNo), 13);

    }

    @Test
    @DisplayName("103번 댓글의 댓글 내용을 수정하면 다시 조회했을 때 수정된 내용이 조회되어야 한다.")
    void modifyTest() {
        // given
        int replyNo = 103;
        String newReplyText = "수정한 댓글";

        Reply reply = Reply.builder()
                .replyText(newReplyText)
                .replyNo(replyNo)
                .build();


        // when
        replyMapper.modify(reply);
        Reply foundReply = replyMapper.findOne(replyNo);

        // then
        assertEquals(newReplyText, foundReply.getReplyText());

    }

/*    @Test
    @DisplayName("")
    void () {
        // given

        // when

        // then

    }*/





}