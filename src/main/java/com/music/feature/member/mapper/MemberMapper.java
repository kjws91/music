package com.music.feature.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.music.feature.member.vo.MemberVo;

@Mapper
public interface MemberMapper {

	/**
	 * <pre>회원정보 등록</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param MemberVo
	 * @return
	 */
	public int insertMember(MemberVo memberVo);
	
	/**
	 * <pre>회원정보 상세 조회</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param memberVo
	 * @return
	 */
	public MemberVo selectMember(MemberVo memberVo);
	
	/**
	 * <pre>회원 로그인 정보</pre>
	 * @Author      : kjws
	 * @Date        : 2020. 8. 10.
	 * @param memberVo
	 * @return
	 */
	public MemberVo selectLoginMember(MemberVo session);
	
}
