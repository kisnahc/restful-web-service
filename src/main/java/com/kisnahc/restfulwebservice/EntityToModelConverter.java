package com.kisnahc.restfulwebservice;

import com.kisnahc.restfulwebservice.controller.MemberController;
import com.kisnahc.restfulwebservice.domain.Member;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EntityToModelConverter implements RepresentationModelAssembler<Member, EntityModel<Member>> {

    @Override
    public EntityModel<Member> toModel(Member member) {

        return EntityModel.of(member,
                linkTo(methodOn(MemberController.class).findMember(member.getId())).withSelfRel(),
                linkTo(methodOn(MemberController.class).memberList()).withRel("memberList")
        );
    }
}
