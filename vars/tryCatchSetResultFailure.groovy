#!groovy
import com.raresociopath.jenkins.exceptions.RSFailure

void call(String errorMessage, cfgOrClosureBody, Closure body = null) {
    if (cfgOrClosureBody instanceof Closure && body == null) {
        debug('tryCatchSetResultFailure used in the experimental way')
        try {
            cfgOrClosureBody()
        } catch (Throwable e) {
            err("Got to catch block, exception $e with ${e.message == null ? 'no message' : "message ${e.message}"}")
            RSFailure.raise(errorMessage, e)
        }
    } else {
        try {
            body()
        } catch (Throwable e) {
            err("Got to catch block, exception $e with ${e.message == null ? 'no message' : "message ${e.message}"}")
            cfgOrClosureBody.failureReason = errorMessage
            cfgOrClosureBody.failureDetails = [
                    exception: e.getClass().toString(),
                    message  : e.message != null ? e.message : 'no message',
            ]
            throw e
        }
    }
}
