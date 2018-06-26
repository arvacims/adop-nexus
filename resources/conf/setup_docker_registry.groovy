import org.sonatype.nexus.repository.storage.WritePolicy
import groovy.json.JsonSlurper

parsed_args = new JsonSlurper().parseText(args)

repository.createDockerHosted(parsed_args.name, parsed_args.http_port as Integer, parsed_args.https_port as Integer, "default", true, false, WritePolicy.ALLOW_ONCE)