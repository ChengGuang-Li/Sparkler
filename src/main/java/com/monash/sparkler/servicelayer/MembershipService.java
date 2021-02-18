package com.monash.sparkler.servicelayer;


import com.monash.sparkler.entity.Membership;
import com.monash.sparkler.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MembershipService {

 private final MembershipRepository membershipRepository;

    @Autowired
    public MembershipService(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    public List<Membership> getAllMemberships(){

        return membershipRepository.findAll();
    }

    public void addNewMembership(Membership membership){

        Optional<Membership> membershipOptional = membershipRepository.findMembershipBymembershipName(membership.getM_name());
        if(membershipOptional.isPresent()) {

          throw new IllegalStateException("membership name is taken");
        }
        membershipRepository.save(membership);
    }

    public void deleteMembershipByid(int id){
       boolean membershipExist = membershipRepository.existsById(id);
       if(membershipExist){
           membershipRepository.deleteById(id);
       }else{

           throw new IllegalStateException("membership with id: " + id + "does not exist");
       }

    }

    @Transactional
    public void updateMembership(int id,Double price,String m_name){
         Membership membership = membershipRepository.findById(id).orElseThrow(() -> new IllegalStateException("membership with id: " + id + "does not exist"));

         if(m_name != null && m_name.length() > 0 && !m_name.equals(membership.getM_name())){

             Optional<Membership> membershipOptional = membershipRepository.findMembershipBymembershipName(m_name);
             if (membershipOptional.isPresent()){
                 throw new IllegalStateException("membership with name: " + m_name + "is taken!");
             }
             membership.setM_name(m_name);

         }

         if(price != null && price > 0 && price != membership.getM_price()){
             membership.setM_price(price);
         }

    }


}
