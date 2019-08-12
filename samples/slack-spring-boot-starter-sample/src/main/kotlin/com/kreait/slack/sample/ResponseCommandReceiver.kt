package com.kreait.slack.sample

import com.kreait.slack.broker.receiver.SlashCommandReceiver
import com.kreait.slack.broker.store.Team
import com.kreait.slack.api.SlackClient
import com.kreait.slack.api.contract.jackson.SlackCommand
import com.kreait.slack.api.contract.jackson.group.respond.ResponseType
import com.kreait.slack.api.contract.jackson.group.respond.SlackRespondMessageRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component

@Component
class ResponseCommandReceiver @Autowired constructor(private val slackClient: SlackClient) : SlashCommandReceiver {
    override fun supportsCommand(slackCommand: SlackCommand): Boolean {
        return slackCommand.command.startsWith("/response")
    }

    override fun onReceiveSlashCommand(slackCommand: SlackCommand, headers: HttpHeaders, team: Team) {
        this.slackClient.respond().message(slackCommand.responseUrl)
                .with(SlackRespondMessageRequest(text = "lol", responseType = ResponseType.EPHEMERAL))
                .invoke()
    }
}