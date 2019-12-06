import jenkins.model.Jenkins

/**
 helper method for remove all jobs from jenkins except seed one
 to be executed in script console
 http://jenkinsurl/script
 */

Jenkins instance = Jenkins.get()

def items = instance.getItems()
items.each {
    if (it.name != 'Seed') {
        it.delete()
    }
}