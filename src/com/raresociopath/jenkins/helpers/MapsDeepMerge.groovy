package com.raresociopath.jenkins.helpers

class MapsDeepMerge {
    private Map<String, Object> joinTwo(Map<String, Object> current, Map<String, Object> updates) {
        def keysInOnlyUpdates = updates.keySet().clone() as Set<String>
        keysInOnlyUpdates.removeAll(current.keySet())

        Map<String, Object> result = current.collectEntries { k, v ->
            if (updates.containsKey(k)) {
                def updateValue = updates.get(k)
                if (v instanceof Map && updateValue instanceof Map) {
                    [k, joinTwo(v, updateValue)]
                } else {
                    [k, updateValue]
                }
            } else [k, v]
        }
        keysInOnlyUpdates.each {
            result.put(it, updates.get(it))
        }
        return result
    }

    Map<String, Object> merge(Map<String, Object> current, List<Map<String, Object>> updates) {
        return updates.size() > 0 ? merge(joinTwo(current, updates.head()), updates.tail()) : current
    }

    Map<String, Object> merge(Map<String, Object> current, Map<String, Object>... updates) {
        merge(current, updates.toList())
    }
}
