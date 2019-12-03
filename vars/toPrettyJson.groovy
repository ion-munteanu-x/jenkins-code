#!groovy

import static groovy.json.JsonOutput.prettyPrint
import static groovy.json.JsonOutput.toJson

/**
 * Converts the given object to pretty printed JSON.
 *
 * @param object , to be converted
 *
 * @return pretty printed JSON version of the object
 *
 * Example call:
 *
 * String ppJson = toPrettyJson(anyObject)
 */
String call(def object) {

    // ensure that all mandatory config parameters are set
    checkParam(object?.toString(), 'The \'object\' to be converted to pretty printed JSON must be set.')

    prettyPrint(toJson(object))
}