import SonatypeKeys._

sonatypeSettings

profileName := "morgaroth"

name := "morgaroth-utils"

version := "1.0"

organization := "pl.morgaroth"

publishMavenStyle := true

pomExtra := <url>GIT_HTTP</url>
  <licenses>
    <license>
      <name>BSD-style</name>
      <url>http://www.opensource.org/licenses/bsd-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>GIT_SSH</url>
    <connection>scm:git:$GIT_SSH</connection>
  </scm>
  <developers>
    <developer>
      <id>$DEVELOPER_ID</id>
      <name>$DEVELOPER_FULL_NAME</name>
    </developer>
  </developers>