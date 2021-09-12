pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "M3"
   }
    triggers {
        cron('0 8 * * *')
    }
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
        string name: 'USERNAME', description: 'Enter your login', defaultValue: ''
        string name: 'PASSWORD', description: 'Enter your password', defaultValue: ''
        string name: 'USERNAME1', description: 'Enter an invalid username', defaultValue: ''
        string name: 'PASSWORD1', description: 'Enter the wrong password', defaultValue: ''
        string name: 'ACCOUNTNAME', description: 'Enter your account name', defaultValue: ''
    }


   stages {
      stage('Testing') {
         steps {

            // Get some code from a GitHub repository
            git branch: "${params.BRANCH}", url: 'https://github.com/YuriShumanski1980/SalesForceProject.git'

            // Run Maven on a Unix agent.
            //sh "mvn clean test"

            // To run Maven on a Windows agent, use
            bat "mvn test -Dtest=LoginPageTest -Dusername=${params.USERNAME} -Dpassword=${params.PASSWORD} -Dusername1=${params.USERNAME1} -Dpassword1=${params.PASSWORD1} -Daccountname=${params.ACCOUNTNAME}"

         }

         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
            }
         }
      }

      stage('Reporting') {
         steps {
             script {
                     allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                     ])
             }
         }
      }
   }
}