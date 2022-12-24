package com.study.communitypractice2.Controller;

import com.study.communitypractice2.dto.ChangePasswordRequestDto;
import com.study.communitypractice2.dto.MemberRequestDto;
import com.study.communitypractice2.dto.MemberResponseDto;
import com.study.communitypractice2.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> getMyMemberInfo() {

        MemberResponseDto myInfoBySecurity = memberService.getMyInfoBySecurity();
        log.info(myInfoBySecurity.getNickname());
        return ResponseEntity.ok((myInfoBySecurity));
    }

    @PostMapping("/nickname")
    public ResponseEntity<MemberResponseDto> setMemberNickname(@RequestBody MemberRequestDto requestDto) {

        return ResponseEntity.ok(memberService.changeMemberNickname(requestDto.getEmail(), requestDto.getNickname()));
    }

    @PostMapping("/password")
    public ResponseEntity<MemberResponseDto> setMemberPassword(@RequestBody ChangePasswordRequestDto request) {
        return ResponseEntity.ok(memberService.changeMemberPassword(request.getExPassword(), request.getNewPassword()));
    }
}
