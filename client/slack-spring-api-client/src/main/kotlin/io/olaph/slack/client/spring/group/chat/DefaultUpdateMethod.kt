package io.olaph.slack.client.spring.group.chat

import io.olaph.slack.client.group.ApiCallResult
import io.olaph.slack.client.group.chat.ChatUpdateMethod
<<<<<<< HEAD
import io.olaph.slack.client.spring.group.RestTemplateFactory
=======
>>>>>>> made response classes sealed & when expressions exhaustive
import io.olaph.slack.client.spring.group.SlackRequestBuilder
import io.olaph.slack.dto.jackson.group.chat.ErrorChatUpdateResponse
import io.olaph.slack.dto.jackson.group.chat.SlackChatUpdateResponse
import io.olaph.slack.dto.jackson.group.chat.SuccessfulChatUpdateResponse
import org.springframework.web.client.RestTemplate


@Suppress("UNCHECKED_CAST")
<<<<<<< HEAD
class DefaultUpdateMethod(private val authToken: String, private val restTemplate: RestTemplate = RestTemplateFactory.slackTemplate()) : ChatUpdateMethod() {
=======
class DefaultUpdateMethod(private val authToken: String) : ChatUpdateMethod() {
>>>>>>> made response classes sealed & when expressions exhaustive

    override fun request(): ApiCallResult<SuccessfulChatUpdateResponse, ErrorChatUpdateResponse> {
        val response = SlackRequestBuilder<SlackChatUpdateResponse>(authToken, restTemplate)
                .with(this.params)
                .toMethod("chat.update")
                .returnAsType(SlackChatUpdateResponse::class.java)
                .postWithJsonBody()

        return when (response.body!!) {
            is SuccessfulChatUpdateResponse -> {
                val responseEntity = response.body as SuccessfulChatUpdateResponse
                this.onSuccess?.invoke(responseEntity)
                ApiCallResult(success = responseEntity)
            }
            is ErrorChatUpdateResponse -> {
                val responseEntity = response.body as ErrorChatUpdateResponse
                this.onFailure?.invoke(responseEntity)
                ApiCallResult(failure = responseEntity)
            }
        }
    }
}
