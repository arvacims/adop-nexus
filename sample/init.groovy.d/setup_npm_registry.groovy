import org.sonatype.nexus.repository.storage.WritePolicy

// https://github.com/sonatype/nexus-public/blob/master/plugins/nexus-script-plugin/src/main/java/org/sonatype/nexus/script/plugin/internal/provisioning/RepositoryApiImpl.groovy
// https://github.com/sonatype/nexus-public/blob/master/plugins/nexus-script-plugin/src/main/java/org/sonatype/nexus/script/plugin/RepositoryApi.java

privateRepo = "npm-private"
println "Try to get repo: $privateRepo"
if (repository.repositoryManager.get(privateRepo) == null) {
    println "Add repo: $privateRepo"
    repository.createNpmHosted(privateRepo, "default", true, WritePolicy.ALLOW)
}

proxyRepo = "npmjs-org"
println "Try to get repo: $proxyRepo"
if (repository.repositoryManager.get(proxyRepo) == null) {
    println "Add repo: $proxyRepo"
    repository.createNpmProxy(proxyRepo, "https://registry.npmjs.org", "default")
}

repoGroup = "npm-all"
println "Try to get repo-group: $repoGroup"
if (repository.repositoryManager.get(repoGroup) == null) {
    println "Add repo: $repoGroup"
    repository.createNpmGroup(repoGroup, [proxyRepo, privateRepo], "default")
}
