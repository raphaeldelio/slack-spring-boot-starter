package com.kreait.slack.api.test.group.usergroups

import com.kreait.slack.api.test.MockMethodTestHelper
import com.nhaarman.mockitokotlin2.mock
import com.kreait.slack.api.test.MockSlackClient
import com.kreait.slack.api.contract.jackson.group.usergroups.ErrorUsergroupsUpdateResponse
import com.kreait.slack.api.contract.jackson.group.usergroups.SlackUsergroupsUpdateRequest
import com.kreait.slack.api.contract.jackson.group.usergroups.SuccessfulUsergroupsUpdateResponse
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Mock usergroups.update Method")
class UsergroupsUpdateUnitTest {

    @DisplayName("Mock Successfuk")
    @Test
    fun mockSuccess() {
        val successFunction: (SuccessfulUsergroupsUpdateResponse?) -> Any = mock { }
        val failureFunction: (ErrorUsergroupsUpdateResponse?) -> Any = mock { }
        val mockClient = MockSlackClient()

        MockMethodTestHelper.verify({ mockClient.usergroups().update("") },
                successFunction, SuccessfulUsergroupsUpdateResponse.sample(),
                failureFunction, ErrorUsergroupsUpdateResponse.sample(),
                SlackUsergroupsUpdateRequest.sample())
    }
}