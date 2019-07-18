val dottyVersion = "0.16.0-RC3"

lazy val root = project
  .in(file("."))
  .settings(
      name                := "tarbigrada"
    , version             := "0.1.0"
    , scalaVersion        := dottyVersion
    , libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test"
    )
  )
