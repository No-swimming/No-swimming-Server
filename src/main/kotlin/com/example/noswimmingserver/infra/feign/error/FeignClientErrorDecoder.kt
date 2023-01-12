package com.example.noswimmingserver.infra.feign.error

import com.example.noswimmingserver.infra.feign.exception.FeignBadRequestException
import com.example.noswimmingserver.infra.feign.exception.FeignExpiredTokenException
import com.example.noswimmingserver.infra.feign.exception.FeignForbiddenException
import com.example.noswimmingserver.infra.feign.exception.FeignUnAuthorizedException
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder

class FeignClientErrorDecoder : ErrorDecoder {

    override fun decode(methodKey: String, response: Response): Exception {
        if (response.status() >= 400) {
            when (response.status()) {
                401 -> throw FeignUnAuthorizedException
                403 -> throw FeignForbiddenException
                419 -> throw FeignExpiredTokenException
                else -> throw FeignBadRequestException
            }
        }

        return FeignException.errorStatus(methodKey, response)
    }

}