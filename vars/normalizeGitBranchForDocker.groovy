#!groovy

def call(String inputValue) {
    return inputValue
            .replaceAll(".*\\/", "")
            .replaceAll("/", "-")
            .replaceAll("^[-_]+", "")
            .replaceAll('[-_]+$', "")
            .toLowerCase()
}