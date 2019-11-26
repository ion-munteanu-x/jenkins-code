import com.raresociopath.jenkins.exceptions.RSFailure

void call(nodeNameOrBody, Closure body = null) {
    Closure<Object> work = { bodyToExecute ->
        storeData([:], false)
        timestamps {
            ansiColor('xterm') {
                info(blue("Hi there!"))
                wrap([$class: 'BuildUser']) {
                    envInfo()
                    try {
                        bodyToExecute()
                    } catch (RSFailure e) {
                        storeData([
                                failureReason : e.message,
                                failureDetails: [
                                        exception: e.cause.getClass().toString(),
                                        message  : e.cause.message != null ? e.cause.message : 'no message',
                                ],
                        ])
//                        throw e
                        error e.message
                    } catch (Exception e) {
                        storeData([
                                unhandledFailure: e.message,
                                failureDetails  : [
                                        exception: e.getClass().toString(),
                                        message  : e.message != null ? e.message : 'no message',
                                ],
                        ])
                        throw e
                    }
                }
            }
        }
    }
    if (nodeNameOrBody instanceof String && body != null) {
        node(nodeNameOrBody) {
            work(body)
        }
    } else if (nodeNameOrBody instanceof Closure && body == null) {
        node {
            work(nodeNameOrBody)
        }
    } else {
        throw new IllegalArgumentException("invalid call $nodeNameOrBody | $body")
    }
}