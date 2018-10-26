import org.sonatype.nexus.repository.storage.WritePolicy

privateRepo = "npm-private"
println "Looking for repository '$privateRepo' ..."
if (repository.repositoryManager.get(privateRepo) == null) {
    println "Repository was not found. Adding it ..."
    repository.createNpmHosted(privateRepo, "default", true, WritePolicy.ALLOW)
}

proxyRepo = "npmjs-org"
println "Looking for repository '$proxyRepo' ..."
if (repository.repositoryManager.get(proxyRepo) == null) {
    println "Repository was not found. Adding it ..."
    repository.createNpmProxy(proxyRepo, "https://registry.npmjs.org", "default")
}

groupRepo = "npm-all"
println "Looking for repository '$groupRepo' ..."
if (repository.repositoryManager.get(groupRepo) == null) {
    println "Repository was not found. Adding it ..."
    repository.createNpmGroup(groupRepo, [proxyRepo, privateRepo], "default")
}
