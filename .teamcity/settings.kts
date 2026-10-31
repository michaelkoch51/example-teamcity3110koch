import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

version = "2023.11"

project {
    vcsRoot(MyVcsRoot)
    buildType(Build)
}

object MyVcsRoot : GitVcsRoot({
    name = "example-teamcity3110koch"
    url = "https://github.com/michaelkoch51/example-teamcity3110koch.git"
    branchSpec = "+:refs/heads/*"
    authMethod = password {
        username = "admin"
        password = "credentialsJSON:put-your-token-here" // В реальности токен хранится в безопасном хранилище TeamCity
    }
})

object Build : BuildType({
    name = "Build"
    
    vcs {
        root(MyVcsRoot)
    }

    steps {
        // Шаг для master (Deploy)
        maven {
            name = "Maven Deploy"
            goals = "clean deploy"
            pomLocation = "pom.xml"
            userSettingsSelection = "Nexus Settings"
            conditions {
                equals("teamcity.build.branch", "master")
            }
        }
        // Шаг для остальных веток (Test)
        maven {
            name = "Maven Test"
            goals = "clean test"
            pomLocation = "pom.xml"
            userSettingsSelection = "Nexus Settings"
            conditions {
                doesNotEqual("teamcity.build.branch", "master")
            }
        }
    }

    triggers {
        vcs {
            branchFilter = "+:*"
        }
    }

    artifactRules = "target/*.jar"
})
