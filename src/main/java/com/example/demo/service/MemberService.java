package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {
    private final MemberRepository repository;

    /**
     * 회원가입
     */

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Long join(Member member) {
        validateDuplicationMember(member);
        repository.save(member);
        return member.getId();
    }

    private void validateDuplicationMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 사용자입니다.");
                });// cmd + option + v 타입 자동지정
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findAll() {
        return repository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return repository.findById(memberId);
    }


}
