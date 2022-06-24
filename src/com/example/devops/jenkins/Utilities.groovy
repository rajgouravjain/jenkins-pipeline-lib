package com.example.devops.jenkins
@Grab('org.yaml:snakeyaml:1.17')
    
import org.yaml.snakeyaml.Yaml
    
class Utilities implements Serializable {
    def steps
    Utilities(steps) {this.steps = steps}
    def hello(args) {
        steps.sh "echo Hello Jenkins ${args}"
    }
    def get_config(jenkins_config_yaml){
      println jenkins_config_yaml
      Yaml parser = new Yaml()
      def jconf = parser.load((jenkins_config_yaml as File).text)
      return jconf 
    }
    def build(jconf,workspace){
    if ( jconf.unittest == true ){
       steps.sh workspace + "/scripts/unittest.sh"
       }
    }

    def test(jconf,workspace){

      steps.sh "echo test utils"
    }

    def deploy(jconf,workspace){
      steps.sh "echo deploy utils"
    }

   def smoketest(jconf,workspace){
     steps.sh "echo smoketest utils"
   }
}
