# rs-jenkins-code
Jenkins Jenkins Code based on DSL plugin and Configuration as Code.

## What is rs-jenkins-code?
<ul>
<li>This repo is dedicated for devops/developers who are developing jenkins pipelines and want to keep everything as code including Pipelines and Configuration of Jenkins.</li>
<li>This repo is an example of jenkins as code best practices. </li>
</ul>

## How it works?
<ul>
<li>If you have a clean instance of jenkins, first step would be to install required plugins, enumarated here: [Jenkins plugins required]</li>
<li>Second step is to create a project of type Pipeline named Seed and in the properties choose Pipeline script from scm specifying this repo.</li>
<li>Run</li>

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
