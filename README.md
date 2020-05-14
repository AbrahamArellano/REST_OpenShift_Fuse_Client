# REST_OpenShift_Fuse_Client
REST OpenShift Fuse client using Camel

## Create project
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate \
  -DarchetypeCatalog=https://maven.repository.redhat.com/ga/io/fabric8/archetypes/archetypes-catalog/2.2.0.fuse-sb2-760038-redhat-00001/archetypes-catalog-2.2.0.fuse-sb2-760038-redhat-00001-archetype-catalog.xml \
  -DarchetypeGroupId=org.jboss.fuse.fis.archetypes \
  -DarchetypeArtifactId=spring-boot-camel-rest-sql-archetype \
  -DarchetypeVersion=2.2.0.fuse-sb2-760038-redhat-00001
  
## Deploy OpenShift

### Endpoints
http://rest-server-redhat-router.192.168.42.179.nip.io
http://localhost:8080

<to id="netty1" pattern="InOut" uri="netty4-http:http:rest-server-redhat-router.192.168.42.179.nip.io:80/camel-rest/data/100?cookieHandler=#instanceCookieHandlerAcceptAll&amp;producerPoolEnabled=false&amp;producerPoolMaxActive=1&amp;producerPoolMaxIdle=1"/>