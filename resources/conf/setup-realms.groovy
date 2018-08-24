import org.sonatype.nexus.security.realm.RealmManager


realmManager = container.lookup(RealmManager.class.getName())

// enable/disable the NuGet API-Key Realm
//realmManager.enableRealm("NuGetApiKey")

// enable/disable the npm Bearer Token Realm
realmManager.enableRealm("NpmToken")

// enable/disable the Rut Auth Realm
//realmManager.enableRealm("rutauth-realm")

// enable/disable the LDAP Realm
realmManager.enableRealm("LdapRealm")

// enable/disable the Docker Bearer Token Realm
realmManager.enableRealm("DockerToken")