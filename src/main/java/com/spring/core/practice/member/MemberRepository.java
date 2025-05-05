package com.spring.core.practice.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
