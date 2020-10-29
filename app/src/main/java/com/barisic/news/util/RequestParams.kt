package com.barisic.news.util

class RequestParams {
    companion object {
        var pageSize: Int = 100
        var country: String = CC_USA
        var source_country: String = ""
        var sortBy: String = PUBLISHED_AT


        fun getHeadlinesRequestParams(): Map<String, String> {
            val paramsMap = HashMap<String, String>()
            paramsMap["country"] = country
            paramsMap["apiKey"] = KeyGenerator.getKey()
            return paramsMap
        }

        fun getEverythingRequestParams(): Map<String, String> {
            val paramsMap = HashMap<String, String>()
            paramsMap["sortBy"] = sortBy
            paramsMap["pageSize"] = pageSize.toString()
            paramsMap["apiKey"] = KeyGenerator.getKey()
            return paramsMap
        }

        fun getSourcesRequestParams(): Map<String, String> {
            val paramsMap = HashMap<String, String>()
            paramsMap["country"] = source_country
            paramsMap["apiKey"] = KeyGenerator.getKey()
            return paramsMap
        }
    }
}