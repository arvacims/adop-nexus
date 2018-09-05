import org.sonatype.nexus.repository.storage.WritePolicy

privateRepo = "gitlfs-private"


println "Try to get repo: $privateRepo"
if (repository.repositoryManager.get(privateRepo) == null) {
    println "Add repo: $privateRepo"
    repository.createGitLfsHosted(privateRepo)
}