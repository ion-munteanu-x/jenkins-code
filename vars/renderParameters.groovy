List call(values) {
    def handleMap = { Map inputData ->
        inputData.collectMany { k, v ->
            if (v == null) {
                []
            } else if (v instanceof Boolean) {
                [booleanParam(name: k, value: v)]
            } else if (v instanceof Number || v instanceof GString) {
                [string(name: k, value: v.toString())]
            } else if (v instanceof String) {
                [string(name: k, value: v)]
            } else {
                throw new IllegalArgumentException("Uknown value type $v for rendering paramter")
            }
        }
    }
    if (values instanceof Map) {
        handleMap(values)
    } else if (values instanceof List) {
        values.collectMany { handleMap(it) }
    } else {
        throw new IllegalArgumentException("Uknown value type $values for renderParameters method ")
    }
}
