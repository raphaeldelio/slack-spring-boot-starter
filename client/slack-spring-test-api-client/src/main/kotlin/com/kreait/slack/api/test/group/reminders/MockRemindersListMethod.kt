package com.kreait.slack.api.test.group.reminders

import com.kreait.slack.api.contract.jackson.group.reminders.ErrorRemindersListResponse
import com.kreait.slack.api.contract.jackson.group.reminders.SuccessfulRemindersListResponse
import com.kreait.slack.api.group.ApiCallResult
import com.kreait.slack.api.group.reminders.RemindersListMethod
import com.kreait.slack.api.group.reminders.RemindersMethodGroup
import com.kreait.slack.api.test.MockMethod

/**
 * Testable implementation of [RemindersMethodGroup.list]
 */
class MockRemindersListMethod : RemindersListMethod(),
    MockMethod<SuccessfulRemindersListResponse, ErrorRemindersListResponse, Unit> {

    override var successResponse: SuccessfulRemindersListResponse? = null
    override var failureResponse: ErrorRemindersListResponse? = null

    override fun request(): ApiCallResult<SuccessfulRemindersListResponse, ErrorRemindersListResponse> {

        this.successResponse?.let { this.onSuccess?.invoke(it) }
        this.failureResponse?.let { this.onFailure?.invoke(it) }

        return ApiCallResult(this.successResponse, this.failureResponse)
    }

    override fun params() = params
}
