# rs-jenkins-code
Jenkins Jenkins Code based on DSL plugin and Configuration as Code.

## What is rs-jenkins-code?
<ul>
<li>This repo is dedicated for devops/developers who are developing jenkins pipelines and want to keep everything as code including Pipelines and Configuration of Jenkins.</li>
<li>This repo is an example of jenkins as code best practices. </li>
</ul>

## How it works?
<ul>
<li>1) Install required plugins, enumarated here: [Jenkins plugins required]</li>
<li>2) Copy folder init.groovy.d inside your jenkins home. Restart Jenkins.
<li>3) Create a job of type Pipeline named Seed from Jenkins UI with Pipeline script from scm definition specifying this repo.</li>
<li>4) Run Seed job.</li>
</ul>

## Jenkins plugins required:
<ul>
<li>Job DSL</li>
<li>Configuration as Code</li>
<li>AnsiColor</li>
<li>EnvInject API Plugin</li>
<li>Environment Injector Plugin</li>
<li>user build vars plugin</li>
<li>Pipeline Utility Steps</li>
<li>Role-based Authorization Strategy</li>
<li>Simple Theme Plugin</li>
</ul>

## Jenkins changes required:
<ul>
<li>Add SCM_CLONE_METHOD as Environment variable in Global Properties, can be either `ssh` or `https`</li>
<li>Add SCM_SERVER as Environment variable in Global Properties, the format should be `github.com`</li>
</ul>

## Project Structure:
<ul>
<li>config/jenkins.yaml - Configuration of jenkins used by Jenkins Configuration as Code Plugin.</li>
<li>jobs - Folder that contains all job interfaces processed by the dsl plugin.</li>
<li>jenkinsfiles - Folder that contains all the jenkinsfiles to which job interfaces are delegating work.</li>
<li>src - groovy classes used as helpers for the pipelines.</li>
<li>vars - util functions. </li>
</ul>

