package com.music.feature.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.music.feature.member.service.MemberService;
import com.music.feature.member.vo.MemberVo;

@Controller
public class MemberController {
	public static final String TILES_PREFIX="tiles.member.";
	
	@Autowired MemberService memberService;

	/**
	 * <pre>회원 등록 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/member/pageRegist.do")
	public String pageMemberRegist() {
		return TILES_PREFIX + "memberRegist";
	}
	
	/**
	 * <pre>회원 로그인 페이지 이동</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @return
	 */
	@GetMapping("/member/pageLogin.do")
	public String pageMemberLogin() {
		return TILES_PREFIX + "memberLogin";
	}
	
	/**
	 * <pre>회원 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param memberVo
	 * @return
	 */
	@PostMapping("/member/create.do")
	public @ResponseBody ResponseEntity<String> createMember(MemberVo memberVo) {
		memberService.createMember(memberVo);
		return new ResponseEntity<String>(null, null, HttpStatus.CREATED);
	}
	
	/**
	 * <pre>회원 상세 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param memberVo
	 * @return
	 */
	@GetMapping("/member/get.do")
	public @ResponseBody MemberVo getMember(MemberVo memberVo) {
		return memberService.getMember(memberVo);
	}
	
	/**
	 * <pre>회원 로그인</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param memberVo
	 * @return
	 */
	@GetMapping("/member/login.do")
	public @ResponseBody Map<String, String> loginMember(MemberVo memberVo, HttpSession session) {
		  return memberService.loginMember(memberVo, session);
	}
}

