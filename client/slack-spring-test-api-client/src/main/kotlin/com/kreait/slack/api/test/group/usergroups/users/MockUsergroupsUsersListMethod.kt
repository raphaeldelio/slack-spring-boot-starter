package com.kreait.slack.api.test.group.usergroups.users

import com.kreait.slack.api.contract.jackson.group.usergroups.users.ErrorUsergroupsUsersListResponse
import com.kreait.slack.api.contract.jackson.group.usergroups.users.SuccessfulUsergroupsUsersListResponse
import com.kreait.slack.api.contract.jackson.group.usergroups.users.UsergroupsUsersListRequest
import com.kreait.slack.api.group.ApiCallResult
import com.kreait.slack.api.group.usergroups.UsergroupsMethodGroup
import com.kreait.slack.api.group.usergroups.users.UsergroupsUsersListMethod
import com.kreait.slack.api.test.MockMethod

/**
 * Testable implementation of [UsergroupsMethodGroup.listUsers]
 */
class MockUsergroupsUsersListMethod : UsergroupsUsersListMethod(),
    MockMethod<SuccessfulUsergroupsUsersListResponse, ErrorUsergroupsUsersListResponse, UsergroupsUsersListRequest> {
    
    override var successResponse: SuccessfulUsergroupsUsersListResponse? = null
    override var failureResponse: ErrorUsergroupsUsersListResponse? = null

    override fun request(): ApiCallResult<SuccessfulUsergroupsUsersListResponse, ErrorUsergroupsUsersListResponse> {

        this.successResponse?.let { this.onSuccess?.invoke(it) }
        this.failureResponse?.let { this.onFailure?.invoke(it) }
        return ApiCallResult(this.successResponse, this.failureResponse)
    }

    override fun params(): UsergroupsUsersListRequest = params
}
