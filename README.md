# rs-jenkins-jobs
Jenkins Jobs.


## Jenkins plugins required:
<ul>
<li>Job DSL</li>
<li>AnsiColor</li>
<li>EnvInject API Plugin</li>
<li>Environment Injector Plugin</li>
<li>user build vars plugin</li>
<li>Pipeline Utility Steps</li>
</ul>

## Jenkins changes required:
<ul>
<li>Add SCM_CLONE_METHOD as Environment variable in Global Properties, can be either `ssh` or `https`</li>
<li>Add SCM_SERVER as Environment variable in Global Properties, the format should be `github.com`</li>
</ul>
