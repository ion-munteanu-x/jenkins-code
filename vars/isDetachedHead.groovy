#!groovy

boolean call() {
    echo "Checking if current checkouted revision is a detached HEAD."
    def magic = "(detached head and some magic string here just to ensure this function working well)"
    def checkResult = getShOutput("git describe --all HEAD 2>/dev/null || echo \"$magic\"")
    checkResult == magic
}
