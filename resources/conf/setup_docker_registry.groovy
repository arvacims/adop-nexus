import org.sonatype.nexus.repository.storage.WritePolicy

repository.createDockerHosted("docker-private", 5000, null, "default", false, true, WritePolicy.ALLOW_ONCE)
