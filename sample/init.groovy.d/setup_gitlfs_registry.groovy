privateRepo = "gitlfs-private"
println "Looking for repository '$privateRepo' ..."
if (repository.repositoryManager.get(privateRepo) == null) {
    println "Repository was not found. Adding it ..."
    repository.createGitLfsHosted(privateRepo)
}
