import jenkins.model.Jenkins

def signatures = [
        'staticMethod jenkins.model.Jenkins get',
        'method jenkins.model.Jenkins getExtensionList java.lang.String',
        'method org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval approveSignature java.lang.String',
        'staticMethod jenkins.model.Jenkins getInstance',
        'method jenkins.model.Jenkins getExtensionList java.lang.Class',
        'method io.jenkins.plugins.casc.ConfigurationAsCode configure',
]

def scriptApproval = Jenkins.get().getExtensionList("org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval")[0]
signatures.each {
    scriptApproval.approveSignature(it)
}
