package com.raresociopath.jenkins.helpers

import net.sf.json.JSONArray
import net.sf.json.JSONNull
import net.sf.json.JSONObject

class PureJsonRead {
    def reworkJson(input) {
        if (input instanceof JSONNull || input == null) {
            null
        } else if (input instanceof JSONObject || input instanceof Map) {
            def result = [:]
            input.each { k, v -> result.put(k, reworkJson(v)) }
            result
        } else if (input instanceof JSONArray || input instanceof Collection) {
            def result = []
            input.each { result.add(reworkJson(it)) }
            result
        } else input
    }
}