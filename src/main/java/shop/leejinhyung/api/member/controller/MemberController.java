package shop.leejinhyung.api.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.leejinhyung.api.member.domain.MemberDTO;
import shop.leejinhyung.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    @PostMapping("")
    public void save(@RequestBody MemberDTO memberDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    @PutMapping("/{id}")
    public void update(@RequestBody MemberDTO memberDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @GetMapping("/id/{id}")
    public void findById(@PathVariable String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    @GetMapping("/all")
    public void findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
