package com.spring.mvc.chap05.service;

import com.spring.mvc.chap05.dto.request.ReplyPostRequestDTO;
import com.spring.mvc.chap05.entity.Reply;
import com.spring.mvc.chap05.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyMapper mapper;

    public void register(ReplyPostRequestDTO dto) {

        // dto를 entitiy로 변환.
        Reply reply = dto.toEntity();
        mapper.save(reply);
    }

    public void getList(int boardNo) {
        mapper.findAll(boardNo);
    }
}
