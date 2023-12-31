package fr.motoconnect.data.utils

import fr.motoconnect.data.model.JourneyObject

class ConverterGpxUtils {

    /**
     * Convert a journey to a gpx file
     * @param journey [JourneyObject]
     * @return String
     */
    fun convertGpxAndReturnString(journey: JourneyObject): String {
        val builder = StringBuilder()

        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
        builder.append("<gpx version=\"1.1\" xmlns=\"http://www.topografix.com/GPX/1/1\">\n")
        builder.append("  <metadata>\n")
        builder.append("    <name>${TimeUtils().toDateTimeString(journey.startDateTime!!)}</name>\n")
        builder.append("  </metadata>\n")
        builder.append("  <trk>\n")
        builder.append("    <trkseg>\n")

        for (point in journey.points) {
            builder.append("      <trkpt lat=\"${point.geoPoint.latitude}\" lon=\"${point.geoPoint.longitude}\">\n")
            builder.append("      </trkpt>\n")
            builder.append("      <time>${point.time.toDate()}</time>\n")
        }

        builder.append("    </trkseg>\n")
        builder.append("  </trk>\n")
        builder.append("</gpx>\n")

        return builder.toString()
    }
}