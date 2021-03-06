package com.kreait.slack.api.test.group.dialog

import com.kreait.slack.api.contract.jackson.group.dialog.ErrorOpenDialogResponse
import com.kreait.slack.api.contract.jackson.group.dialog.OpenDialogRequest
import com.kreait.slack.api.contract.jackson.group.dialog.SuccessfulOpenDialogResponse
import com.kreait.slack.api.group.ApiCallResult
import com.kreait.slack.api.group.dialog.DialogMethodGroup
import com.kreait.slack.api.group.dialog.DialogOpenMethod
import com.kreait.slack.api.test.MockMethod

/**
 * Testable implementation of [DialogMethodGroup.open]
 */
class MockDialogOpenMethod : DialogOpenMethod(),
    MockMethod<SuccessfulOpenDialogResponse, ErrorOpenDialogResponse, OpenDialogRequest> {
    
    override var successResponse: SuccessfulOpenDialogResponse? = null
    override var failureResponse: ErrorOpenDialogResponse? = null

    override fun request(): ApiCallResult<SuccessfulOpenDialogResponse, ErrorOpenDialogResponse> {

        this.successResponse?.let { this.onSuccess?.invoke(it) }
        this.failureResponse?.let { this.onFailure?.invoke(it) }

        return ApiCallResult(this.successResponse, this.failureResponse)
    }

    override fun params(): OpenDialogRequest = params
}
