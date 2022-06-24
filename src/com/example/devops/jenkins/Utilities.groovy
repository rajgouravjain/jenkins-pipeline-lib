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
