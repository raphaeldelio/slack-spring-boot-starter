package com.kreait.slack.api.spring.group.usergroups

/**
 * Spring based implementation of [UsergroupsMethodGroup.update]
 */
import com.kreait.slack.api.contract.jackson.group.usergroups.ErrorUpdateResponse
import com.kreait.slack.api.contract.jackson.group.usergroups.SuccessfulUpdateResponse
import com.kreait.slack.api.contract.jackson.group.usergroups.UpdateResponse
import com.kreait.slack.api.group.ApiCallResult
import com.kreait.slack.api.group.usergroups.UsergroupsUpdateMethod
import com.kreait.slack.api.group.users.UsersMethodGroup
import com.kreait.slack.api.spring.group.RestTemplateFactory
import com.kreait.slack.api.spring.group.SlackRequestBuilder
import org.springframework.web.client.RestTemplate


/**
 * Spring based implementation of [UsersMethodGroup.conversations]
 */
@Suppress("UNCHECKED_CAST")
class SpringUsergroupsUpdateMethod(
    private val authToken: String,
    private val restTemplate: RestTemplate = RestTemplateFactory.slackTemplate()
) : UsergroupsUpdateMethod() {

    override fun request(): ApiCallResult<SuccessfulUpdateResponse, ErrorUpdateResponse> {
        val response = SlackRequestBuilder<UpdateResponse>(authToken, restTemplate)
            .toMethod("usergroups.update")
            .returnAsType(UpdateResponse::class.java)
            .postWithJsonBody()

        return when (response.body!!) {
            is SuccessfulUpdateResponse -> {
                val responseEntity = response.body as SuccessfulUpdateResponse
                this.onSuccess?.invoke(responseEntity)
                ApiCallResult(success = responseEntity)
            }
            is ErrorUpdateResponse -> {
                val responseEntity = response.body as ErrorUpdateResponse
                this.onFailure?.invoke(responseEntity)
                ApiCallResult(failure = responseEntity)
            }
        }
    }
}
