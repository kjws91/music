package com.music.feature.member.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.music.feature.member.mapper.MemberMapper;
import com.music.feature.member.vo.MemberVo;

@Service
public class MemberService {

	@Autowired MemberMapper memberMapper;
	
	/**
	 * <pre>회원정보 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param memberVo
	 * @return
	 */
	@Transactional
	public void createMember(MemberVo memberVo) {
		memberMapper.insertMember(memberVo);
	}
	
	/**
	 * <pre>회원정보 상세 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public MemberVo getMember(MemberVo memberVo) {
		return memberMapper.selectMember(memberVo);
	}
	
	/**
	 * <pre>회원 로그인</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param boardVo
	 * @return
	 */
	public Map<String, String> loginMember(MemberVo memberVo, HttpSession session) {
		Map<String, String> resultMap = new HashMap<>();
		MemberVo userInfo = memberMapper.selectLoginMember(memberVo);
		String password = memberVo.getPassword();
		String realPassword = userInfo.getPassword();
		String resultCode = "";
		String resultMsg = "";
		if(password.equals(realPassword)){
			//비번이 같을경우
			resultCode="200";
			resultMsg = "로그인성공";
			session.setAttribute("userinfo", userInfo);
		}else if (!password.equals(realPassword)) {
			//비번이 다를경우
			resultCode = "999";
			resultMsg = "정보가 일치하지 않습니다.";
		}
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMsg", resultMsg);
		return resultMap;
			
		}
	
}