package tasks

import contributors.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/*** Note that the results for different repositories are added to the channel as soon as they are ready.
At first, when all the requests are sent and no data is received, the receive call suspends.
In this case, the whole "load contributors" coroutine suspends.
Then, when the list of users is sent to the channel, the "load contributors" coroutine resumes,
the receive call returns this list, and the results are immediately updated.
*/

suspend fun loadContributorsChannels(
    service: GitHubService,
    req: RequestData,
    updateResults: suspend (List<User>, completed: Boolean) -> Unit
) {
    coroutineScope {
        val repos = service
                .getOrgRepos(req.org)
                .also { logRepos(req, it) }
                .bodyList()

        val channel = Channel<List<User>>()
        for (repo in repos) {
            launch {
                val users = service.getRepoContributors(req.org, repo.name)
                        .also { logUsers(repo, it) }
                        .bodyList()
                channel.send(users)
            }
        }
        var allUsers = emptyList<User>()
        repeat(repos.size) {
            val users = channel.receive()
            allUsers = (allUsers + users).aggregate()
            updateResults(allUsers, it == repos.lastIndex)
        }
    }
}
