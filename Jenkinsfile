node {
    def mvnHome
    stage('Get latest Changes') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/RanaHesham-Ultatel/Automation_Testing_Ecommercee.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'MAVEN_HOME'
    }
    stage('Clean old builds') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean/)
            }
        }
    }

       stage('Running tests') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean test'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean test/)
            }
        }
    }

   stage('Results') {
   allure includeProperties: false, jdk: 'JAVA_HOME', results: [[path: 'target/allure-results']]
    }
}
