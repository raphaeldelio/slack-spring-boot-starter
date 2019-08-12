package com.kreait.slack.api.test.group.im

import com.kreait.slack.api.group.ApiCallResult
import com.kreait.slack.api.group.im.ImOpenMethod
import com.kreait.slack.api.test.MockMethod
import com.kreait.slack.api.contract.jackson.group.im.ErrorImOpenResponse
import com.kreait.slack.api.contract.jackson.group.im.SlackImOpenRequest
import com.kreait.slack.api.contract.jackson.group.im.SuccessfulImOpenResponse

class MockImOpenMethod : ImOpenMethod(), MockMethod<SuccessfulImOpenResponse, ErrorImOpenResponse, SlackImOpenRequest> {
    override var successResponse: SuccessfulImOpenResponse? = null

    override var failureResponse: ErrorImOpenResponse? = null

    override fun params(): SlackImOpenRequest {
        return params
    }

    override fun request(): ApiCallResult<SuccessfulImOpenResponse, ErrorImOpenResponse> {

        this.successResponse?.let { this.onSuccess?.invoke(it) }
        this.failureResponse?.let { this.onFailure?.invoke(it) }

        return ApiCallResult(this.successResponse, this.failureResponse)
    }
}