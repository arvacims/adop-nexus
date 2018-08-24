import org.sonatype.nexus.repository.storage.WritePolicy

repository.createNpmHosted(args, 'default', true, WritePolicy.ALLOW); repository.createNpmProxy('npmjs-org','https://registry.npmjs.org', 'default'); repository.createNpmGroup('npm-all',['npmjs-org', args], 'default')