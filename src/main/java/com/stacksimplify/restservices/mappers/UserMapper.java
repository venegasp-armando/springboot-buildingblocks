package com.stacksimplify.restservices.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;

@Mapper(componentModel = "Spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mappings({
	@Mapping(source = "email", target = "emailaddress"),
	@Mapping(source = "id", target = "userid"),
	@Mapping(source="role", target = "rolename")})
	UserMsDto userToUserMsDto(User user);
	
	List<UserMsDto> usersToUserMsDtos(List<User> users);
}
