package com.jaeh.blog.service;

import com.jaeh.blog.model.Board;
import com.jaeh.blog.model.Reply;
import com.jaeh.blog.model.RoleType;
import com.jaeh.blog.model.User;
import com.jaeh.blog.repository.BoardRepository;
import com.jaeh.blog.repository.ReplyRepository;
import com.jaeh.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ObjectError;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void
    write(Board board,User user) {
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }
    @Transactional(readOnly = true)
    public Page<Board> list(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board listDetail(int id) {
        return boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패");
                });
    }
    @Transactional
    public void delete(int id) {
         boardRepository.deleteById(id);
    }

    @Transactional
    public void modify(int id, Board requestBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(()->{
                return new IllegalArgumentException("글 수정 실패");
                });
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
    }

    @Transactional
    public void commentWrite(User user, int boardId, Reply requestReply) {

        Board board = boardRepository.findById(boardId).orElseThrow(()->{
            return new IllegalArgumentException("댓글 작성 실패: id를 찾을 수 없습니다");
        });

        requestReply.setUser(user);
        requestReply.setBoard(board);

        replyRepository.save(requestReply);
    }

}

