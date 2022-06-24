package com.example.devops.jenkins

class Utilities implements Serializable {
    def steps
    Utilities(steps) {this.steps = steps}
    def hello(args) {
        steps.sh "echo Hello Jenkins ${args}"
    }
}
