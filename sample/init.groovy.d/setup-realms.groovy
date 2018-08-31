import org.sonatype.nexus.security.realm.RealmManager

realmManager = container.lookup(RealmManager.class.getName())

realmManager.enableRealm("NpmToken")
realmManager.enableRealm("LdapRealm")
realmManager.enableRealm("DockerToken")
