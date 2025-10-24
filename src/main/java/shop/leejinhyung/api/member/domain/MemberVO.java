package shop.leejinhyung.api.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class MemberVO {
    private String UserId;
    private String Survived;
    private String Pclass;
    private String Name;
    private String Gender;
    private String Age;
    private String SibSp;
    private String Parch;
    private String Ticket;
    private String Fare;
    private String Cabin;
    private String Embarked;
}
