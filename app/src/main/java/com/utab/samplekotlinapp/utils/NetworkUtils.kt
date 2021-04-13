package com.utab.samplekotlinapp.utils

class NetworkUtils {

    companion object {
        val URL = "https://www.flickr.com/services/rest/"
        val USER_ID_ONE="62294423@N02"
        val USER_ID_TWO="77151940@N03"
        val USER_ID_THREE="73422502@N08"
        val USER_ID_FOUR="71572571@N00"
        val USER_ID_FIVE="21692577@N02"

        fun queryMap(userId: String): Map<String, String> {
            val query = HashMap<String, String>()
            query["api_key"] = "acec98b624183786c6e026b9ea01d1e1"
            query["method"] = "flickr.photos.getPopular"
            query["format"] = "json"
            query["nojsoncallback"] = "1"
            query["extras"]="url_s"
            query["user_id"] = userId
            query["per_page"]="10"

            return query
        }
    }
}