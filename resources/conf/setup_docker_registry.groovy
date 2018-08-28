import org.sonatype.nexus.repository.storage.WritePolicy

// https://github.com/sonatype/nexus-public/blob/master/plugins/nexus-script-plugin/src/main/java/org/sonatype/nexus/script/plugin/internal/provisioning/RepositoryApiImpl.groovy
// https://github.com/sonatype/nexus-public/blob/master/plugins/nexus-script-plugin/src/main/java/org/sonatype/nexus/script/plugin/RepositoryApi.java

privateRepo = "docker-private"
println "Try to get repo: $privateRepo"
if (repository.repositoryManager.get(privateRepo) == null) {
    println "Repo not found. Add repo: $privateRepo"
    repository.createDockerHosted(privateRepo, 5000, null, "default", false, true, WritePolicy.ALLOW_ONCE)
}

proxyRepo = "docker-hub"
println "Try to get repo: $proxyRepo"
if (repository.repositoryManager.get(proxyRepo) == null) {
    println "Repo not found. Add repo: $proxyRepo"
    repository.createDockerProxy(proxyRepo, "https://registry-1.docker.io", "HUB", null, null, null)
}

repoGroup = "docker-all"
println "Try to get repo: $repoGroup"
if (repository.repositoryManager.get(repoGroup) == null) {
    println "Repo not found. Add repo: $repoGroup"
    repository.createDockerGroup(repoGroup, null, null, [proxyRepo, privateRepo])
}
