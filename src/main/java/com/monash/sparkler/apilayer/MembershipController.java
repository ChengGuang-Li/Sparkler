package com.monash.sparkler.apilayer;


import com.monash.sparkler.entity.Membership;
import com.monash.sparkler.servicelayer.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "sparkler/membership")
public class MembershipController {

    private final MembershipService membershipService;

    @Autowired
    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping
    public List<Membership> findAllMembership(){

        return membershipService.getAllMemberships();
    }

    @DeleteMapping(path = "{id}")
    public void deleteMembershipById(@PathVariable("id") int id){
         membershipService.deleteMembershipByid(id);
    }

    @PutMapping(path = "{id}")
    public void updateMembershipById(@PathVariable("id") int id,
                                     @RequestParam(required = false) Double price,
                                     @RequestParam(required = false) String name
                                     ){

        membershipService.updateMembership(id,price,name);
    }
}
