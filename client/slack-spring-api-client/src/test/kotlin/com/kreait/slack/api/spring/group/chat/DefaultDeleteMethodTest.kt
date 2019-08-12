package com.kreait.slack.api.spring.group.chat

import com.kreait.slack.api.spring.MockServerHelper
import com.kreait.slack.api.spring.Verifier
import com.kreait.slack.api.spring.group.RestTemplateFactory
import com.kreait.slack.api.contract.jackson.group.chat.ErrorChatDeleteResponse
import com.kreait.slack.api.contract.jackson.group.chat.SlackChatDeleteRequest
import com.kreait.slack.api.contract.jackson.group.chat.SuccessfulChatDeleteResponse
import com.kreait.slack.api.contract.jackson.group.chat.sample
import com.kreait.slack.api.spring.group.chat.DefaultDeleteMethod
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.web.client.RestTemplate

internal class DefaultDeleteMethodTest {

    private lateinit var mockTemplate: RestTemplate

    @BeforeEach
    fun setup() {
        mockTemplate = RestTemplateFactory.slackTemplate()
    }

    @Test
    @DisplayName("chat.delete Failure")
    fun chatDeleteFailure() {
        val response = ErrorChatDeleteResponse.sample()
        val mockServer = MockServerHelper.buildMockRestServer(mockTemplate, "chat.delete", response)
        val verifier = Verifier(response)

        DefaultDeleteMethod("", mockTemplate)
                .with(SlackChatDeleteRequest.sample())
                .onFailure { verifier.set(it) }
                .invoke()
        mockServer.verify()
        verifier.verify()
    }

    @Test
    @DisplayName("chat.delete Success")
    fun chatDeleteSuccess() {
        val response = SuccessfulChatDeleteResponse.sample()
        val mockServer = MockServerHelper.buildMockRestServer(mockTemplate, "chat.delete", response)
        val verifier = Verifier(response)

        DefaultDeleteMethod("", mockTemplate)
                .with(SlackChatDeleteRequest.sample())
                .onSuccess { verifier.set(it) }
                .invoke()
        mockServer.verify()
        verifier.verify()
    }
}