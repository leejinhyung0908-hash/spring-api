package shop.leejinhyung.api.member.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.leejinhyung.api.member.domain.MemberDTO;
import shop.leejinhyung.api.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImplement implements MemberService {
    
    private final MemberRepository memberRepository;

    @Override
    public void save(MemberDTO memberDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'join'");
    }

    @Override
    public void findById(MemberDTO memberDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public void findAll(MemberDTO memberDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'logout'");
    }

    @Override
    public void update(MemberDTO memberDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(MemberDTO memberDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


}
