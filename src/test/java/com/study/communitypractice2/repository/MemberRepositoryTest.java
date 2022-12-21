package com.study.communitypractice2.repository;

import com.study.communitypractice2.entity.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() {
        Member member = new Member(null, "aaa", "000", "A", "ABC", "a@a.com", UserRole.USER);

        repository.save(member);
        Member findMember = repository.findByUsername(member.getUsername());

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getNickname()).isEqualTo(member.getNickname());
        assertThat(findMember.getRole()).isEqualTo(member.getRole());
        assertThat(findMember).isEqualTo(member);
    }

}