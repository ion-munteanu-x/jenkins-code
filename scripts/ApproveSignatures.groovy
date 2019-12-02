import jenkins.model.Jenkins

def signatures = [
        'new java.util.ArrayList',
        'method io.jenkins.plugins.casc.ConfigurationAsCode configure',
        'method jenkins.model.Jenkins getExtensionList java.lang.Class',
        'staticMethod jenkins.model.Jenkins getInstance',
]
def scriptApproval = Jenkins.get().getExtensionList("org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval")[0]
signatures.each {
    if (it.length() > 0) scriptApproval.approveSignature(it)
}