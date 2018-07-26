package com.jpa.app.springjpaonetoone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "userprofile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;

    /**
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;
     **/

    @Column(name = "address")
    private String address;

    /**one to one mapped ke table user - id adalah primary key dari user id**/
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    public UserProfile(){}

    public UserProfile(String phone, Gender gender, /**Date birthday**/ String address){
        this.phone = phone;
        this.gender = gender;
        //this.birthday = birthday;
        this.address = address;
    }


}
