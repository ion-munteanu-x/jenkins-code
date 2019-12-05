import jenkins.model.Jenkins

def signatures = [
        'staticMethod jenkins.model.Jenkins get',
        'method jenkins.model.Jenkins getExtensionList java.lang.String',
        'method org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval approveSignature java.lang.String'
]

def scriptApproval = Jenkins.get().getExtensionList("org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval")[0]
signatures.each {
    scriptApproval.approveSignature(it)
}
