import com.raresociopath.jenkins.helpers.PureJsonRead

def call(String filePath) {
    def pureJson = new PureJsonRead()
    pureJson.reworkJson(readJSON([file: filePath]))
}