package com.kreait.slack.api.contract.jackson.group.team

fun SuccessfulTeamGetProfileResponse.Companion.sample(): SuccessfulTeamGetProfileResponse {
    return SuccessfulTeamGetProfileResponse(true, TeamProfile.sample())
}

fun TeamProfile.Companion.sample(): TeamProfile {
    return TeamProfile(listOf(Field.sample()))
}

fun Field.Companion.sample(): Field {
    return Field("", "", 0, "", "", 0, "", "")
}

fun ErrorTeamGetProfileResponse.Companion.sample(): ErrorTeamGetProfileResponse {
    return ErrorTeamGetProfileResponse(false, "")
}

fun TeamGetProfileRequest.Companion.sample(): TeamGetProfileRequest {
    return TeamGetProfileRequest(TeamVisibility.ALL)
}