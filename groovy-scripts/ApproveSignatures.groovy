import jenkins.model.Jenkins

def signatures = [
        'staticMethod jenkins.model.Jenkins getInstance',
        'method jenkins.model.Jenkins getExtensionList java.lang.Class',
        'method io.jenkins.plugins.casc.ConfigurationAsCode configure',
]
def scriptApproval = Jenkins.get().getExtensionList("org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval")[0]
signatures.each {
    if (it.length() > 0) scriptApproval.approveSignature(it)
}