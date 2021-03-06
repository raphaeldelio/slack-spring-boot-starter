package com.kreait.slack.api.test.group.users

import com.kreait.slack.api.contract.jackson.group.users.ErrorInfoResponse
import com.kreait.slack.api.contract.jackson.group.users.InfoRequest
import com.kreait.slack.api.contract.jackson.group.users.SuccessfulInfoResponse
import com.kreait.slack.api.group.ApiCallResult
import com.kreait.slack.api.group.users.UsersInfoMethod
import com.kreait.slack.api.group.users.UsersMethodGroup
import com.kreait.slack.api.test.MockMethod

/**
 * Testable implementation of [UsersMethodGroup.info]
 */
class MockUsersInfoMethod : UsersInfoMethod(), MockMethod<SuccessfulInfoResponse, ErrorInfoResponse, InfoRequest> {

    override var successResponse: SuccessfulInfoResponse? = null
    override var failureResponse: ErrorInfoResponse? = null

    override fun request(): ApiCallResult<SuccessfulInfoResponse, ErrorInfoResponse> {

        this.successResponse?.let { this.onSuccess?.invoke(it) }
        this.failureResponse?.let { this.onFailure?.invoke(it) }

        return ApiCallResult(this.successResponse, this.failureResponse)
    }

    override fun params(): InfoRequest = params
}
