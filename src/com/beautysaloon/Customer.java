package com.beautysaloon;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private MembershipType membershipType;

    private String name;

    private List<Visit> visits = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
        membershipType = MembershipType.NONE;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public Visit createVisit() {
        Visit visit = new Visit(membershipType);
        visits.add(visit);
        return visit;
    }
}
