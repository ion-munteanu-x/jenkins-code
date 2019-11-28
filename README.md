# rs-pipelines
Jenkins Pipelines based on DSL plugin.

## What is rs-pipelines?
<ul>
<li>This repo is dedicated for devops/developers who are developing jenkins pipelines and want to keep everything as code. </li>
<li>This repo is an example of jenkins pipeline development best practices. </li>
<li>This repo contains many things that you can already use in your project. See [pipelines] </li>
</ul>

## How it works?
<ul>
<li>If you have a clean instance of jenkins, first step would be to install required plugins, enumarated here: [Jenkins plugins required]</li>
<li>Second step is to import this repo as Global Library in Jenkins</li>
<li>Third step is to manually create a Freestyle job called Seed indicating dsl repo to this one and run the pipeline.</li>
<li>Voila, all your pipelines will be generated from this repo.</li>

## Jenkins plugins required:
<ul>
<li>Job DSL</li>
<li>AnsiColor</li>
<li>EnvInject API Plugin</li>
<li>Environment Injector Plugin</li>
<li>user build vars plugin</li>
<li>Pipeline Utility Steps</li>
<li>Simple Theme Plugin</li>
</ul>

## Jenkins changes required:
<ul>
<li>Add SCM_CLONE_METHOD as Environment variable in Global Properties, can be either `ssh` or `https`</li>
<li>Add SCM_SERVER as Environment variable in Global Properties, the format should be `github.com`</li>
</ul>
