package com.kreait.slack.api.group.conversations

import com.kreait.slack.api.group.ApiCallMethod
import com.kreait.slack.api.contract.jackson.group.conversations.ErrorConversationsInfoResponse
import com.kreait.slack.api.contract.jackson.group.conversations.ConversationsInfoRequest
import com.kreait.slack.api.contract.jackson.group.conversations.SuccessfulConversationsInfoResponse

abstract class ConversationsInfoMethod : ApiCallMethod<ConversationsInfoMethod, SuccessfulConversationsInfoResponse, ErrorConversationsInfoResponse, ConversationsInfoRequest>()