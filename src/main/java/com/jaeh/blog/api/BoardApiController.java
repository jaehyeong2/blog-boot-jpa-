package com.jaeh.blog.api;

import com.jaeh.blog.auth.PrincipalDetail;
import com.jaeh.blog.auth.PrincipalDetailService;
import com.jaeh.blog.dto.ResponseDto;
import com.jaeh.blog.model.Board;
import com.jaeh.blog.model.User;
import com.jaeh.blog.service.BoardService;
import com.jaeh.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){
        boardService.write(board,principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id){
        boardService.delete(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @PutMapping("/api/boatd/{id}")
    public ResponseDto<Integer> update(@PathVariable int id,Board board) {
        boardService.modify(id,board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }



}
