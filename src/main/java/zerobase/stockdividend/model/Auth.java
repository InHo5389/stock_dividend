package zerobase.stockdividend.model;

import lombok.Data;
import zerobase.stockdividend.persist.entity.MemberEntity;

import java.util.List;

public class Auth {

    @Data
    public static class SignIn{
        private String username;
        private String password;
    }

    // signUp 클래스의 내용을 엔티티로 만든다.
    @Data
    public static class SignUp{
        private String username;
        private String password;
        private List<String> roles;

        public MemberEntity toEntity(){
            return  MemberEntity.builder()
                    .username(this.username)
                    .password(this.password)
                    .roles(this.roles)
                    .build();
        }
    }
}
