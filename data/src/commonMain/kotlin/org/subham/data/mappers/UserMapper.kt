package org.subham.data.mappers

import org.subham.data.model.UserDto
import org.subham.domain.model.UserModel

object UserMapper {

    fun toDomain(
        dto: UserDto
    ): UserModel {
        return UserModel(
            email = dto.email,
            firstName = dto.firstName,
            id = dto.id,
            lastName = dto.lastName
        )
    }


}