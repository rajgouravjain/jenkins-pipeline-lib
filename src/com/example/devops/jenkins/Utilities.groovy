package com.example.devops.jenkins


class Utilities implements Serializable {
  def steps
  Utilities(steps) {this.steps = steps}
  def mvn(args) {
    steps.sh "${steps.tool 'maven_3.6.0'}/bin/mvn  ${args}"
  }
}
