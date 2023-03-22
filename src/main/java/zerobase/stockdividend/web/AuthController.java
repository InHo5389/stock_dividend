package zerobase.stockdividend.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zerobase.stockdividend.model.Auth;
import zerobase.stockdividend.persist.entity.MemberEntity;
import zerobase.stockdividend.security.TokenProvider;
import zerobase.stockdividend.service.MemberService;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;
    private final TokenProvider tokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Auth.SignUp request){
        // 회원가입을 위한 API
        var result = memberService.register(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody Auth.SignIn request){
        var member = memberService.authenticate(request);
        var token = tokenProvider.generateToken(member.getUsername(), member.getRoles());
        log.info("user login -> "+ request.getUsername());
        return ResponseEntity.ok(token);
    }
}
