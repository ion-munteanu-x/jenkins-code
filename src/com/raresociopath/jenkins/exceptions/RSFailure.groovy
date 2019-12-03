package com.raresociopath.jenkins.exceptions

class RSFailure extends Exception {
    RSFailure(String msg, Throwable ce) {
        super(msg, ce)
    }

    static void raise(String message, Throwable cause = null) throws RSFailure {
        throw new RSFailure(message, cause)
    }
}