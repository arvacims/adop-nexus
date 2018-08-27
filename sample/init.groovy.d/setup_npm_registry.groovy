import org.sonatype.nexus.repository.storage.WritePolicy

repoName = "npm-private"

repository.createNpmHosted(repoName, "default", true, WritePolicy.ALLOW)
repository.createNpmProxy("npmjs-org", "https://registry.npmjs.org", "default")
repository.createNpmGroup("npm-all", ["npmjs-org", repoName], "default")
