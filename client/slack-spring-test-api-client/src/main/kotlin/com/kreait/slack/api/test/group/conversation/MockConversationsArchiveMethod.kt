package com.kreait.slack.api.test.group.conversation

import com.kreait.slack.api.contract.jackson.group.conversations.ConversationArchiveRequest
import com.kreait.slack.api.contract.jackson.group.conversations.ErrorConversationArchiveResponse
import com.kreait.slack.api.contract.jackson.group.conversations.SuccessfulConversationArchiveResponse
import com.kreait.slack.api.group.ApiCallResult
import com.kreait.slack.api.group.conversations.ConversationsArchiveMethod
import com.kreait.slack.api.group.conversations.ConversationsMethodGroup
import com.kreait.slack.api.test.MockMethod

/**
 * Testable implementation of [ConversationsMethodGroup.archive]
 */
open class MockConversationsArchiveMethod : ConversationsArchiveMethod(),
    MockMethod<SuccessfulConversationArchiveResponse, ErrorConversationArchiveResponse, ConversationArchiveRequest> {

    override var successResponse: SuccessfulConversationArchiveResponse? = null
    override var failureResponse: ErrorConversationArchiveResponse? = null

    override fun request(): ApiCallResult<SuccessfulConversationArchiveResponse, ErrorConversationArchiveResponse> {

        this.successResponse?.let { this.onSuccess?.invoke(it) }
        this.failureResponse?.let { this.onFailure?.invoke(it) }

        return ApiCallResult(this.successResponse, this.failureResponse)
    }

    override fun params(): ConversationArchiveRequest = params
}
