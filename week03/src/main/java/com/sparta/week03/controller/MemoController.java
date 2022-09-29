package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo= new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getNames(){
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
//        혼자 풀이: 인자까지 다 맞추놓고는 메모 서비스 안쓰고 뭐하세요^^;
//        Memo memo = memoRepository.findById(id);
//        memo.update(requestDto);
        memoService.update(id,requestDto);
        return id;
    }
}
