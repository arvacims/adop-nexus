import org.sonatype.nexus.repository.storage.WritePolicy

privateRepo = "docker-private"
println "Looking for repository '$privateRepo' ..."
if (repository.repositoryManager.get(privateRepo) == null) {
    println "Repository was not found. Adding it ..."
    repository.createDockerHosted(privateRepo, 5000, null, "default", false, true, WritePolicy.ALLOW_ONCE)
}

proxyRepo = "docker-hub"
println "Looking for repository '$proxyRepo' ..."
if (repository.repositoryManager.get(proxyRepo) == null) {
    println "Repository was not found. Adding it ..."
    repository.createDockerProxy(proxyRepo, "https://registry-1.docker.io", "HUB", null, null, null)
}

groupRepo = "docker-all"
println "Looking for repository '$groupRepo' ..."
if (repository.repositoryManager.get(groupRepo) == null) {
    println "Repository was not found. Adding it ..."
    repository.createDockerGroup(groupRepo, null, null, [proxyRepo, privateRepo])
}
