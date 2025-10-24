package shop.leejinhyung.api.member.service;

import shop.leejinhyung.api.member.domain.MemberDTO;

public interface MemberService {
    
    public void save (MemberDTO memberDTO);
    public void update (MemberDTO memberDTO);
    public void delete (MemberDTO memberDTO);
    public void findById (MemberDTO memberDTO);
    public void findAll (MemberDTO memberDTO);

}
