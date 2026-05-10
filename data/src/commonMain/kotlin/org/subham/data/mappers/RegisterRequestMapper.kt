package org.subham.data.mappers

import org.subham.data.model.request.RegisterRequest
import org.subham.domain.model.RegisterModel

object RegisterRequestMapper {

    fun toDomain(dto: RegisterRequest): RegisterModel {
        return RegisterModel(
            email = dto.email,
            password = dto.password,
            lastName = dto.lastName,
            firstName = dto.firstName,
            role = dto.role,
            phone = dto.phone

        )
    }
    fun toDto(model: RegisterModel): RegisterRequest{
        return RegisterRequest(
            email = model.email,
            password = model.password,
            firstName = model.firstName,
            lastName = model.lastName,
            phone = model.phone,
            role = model.role

        )
    }
}