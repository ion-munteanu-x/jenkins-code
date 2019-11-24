#!groovy

/**
 * Checks param and fails the build with msg if param is null or empty.
 *
 * @param param the parameter that needs to be verified
 * @param msg message to be displayed as reason for the build failure
 *
 * Example call:
 *
 * checkParam(variableToBeVerified, 'message to be displayed as reason for the build failure')
 */
def call(def param, String msg) {

  if (!param?.trim()) {
    error msg
  }
}
